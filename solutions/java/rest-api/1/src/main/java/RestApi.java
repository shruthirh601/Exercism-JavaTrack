import org.json.JSONObject;
import org.json.JSONArray;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
import java.util.Arrays;
import java.util.stream.Collectors;

class RestApi {

    private List<User> users;

    RestApi(User... users) {
        this.users = new ArrayList<User>(Arrays.asList(users));
    }

    RestApi(){
        this.users = new ArrayList();
    }

    String get(String url) {
        return getUsers();
    }

    String get(String url, JSONObject payload) {
        JSONArray payloadArray = payload.getJSONArray("users");
        JSONArray users = new JSONArray();
        for (Object object : payloadArray){
            User u = addUser(object.toString());
            users.put(userToJson(u));
        }
        return new JSONObject().put("users", users).toString();
    }

    String post(String url, JSONObject payload) {
        if (url.equals("/add")){
            return userToJsonString(addUser(payload));
        }
        else if (url.equals("/iou")){
            return addIou(payload);
        }
        return new JSONObject().toString();
    }

    private String addIou(JSONObject payload){ 
        User newLenderUser = putUser(payload, true);
        User newBorrowerUser = putUser(payload, false);   
        List<JSONObject> userJsons = Arrays.asList(
            userToJson(newLenderUser),
            userToJson(newBorrowerUser)
        );
        userJsons.sort((a, b) -> a.getString("name").compareTo(b.getString("name")));
        return new JSONObject()
            .put("users", new JSONArray(userJsons))
            .toString();
    }

    private User putUser(JSONObject payload, boolean lender){
        String borrowerName = payload.getString("borrower");
        String lenderName = payload.getString("lender");
        double amount = payload.getDouble("amount");
        String userName = lender ? lenderName : borrowerName;
        String otherName = lender ? borrowerName : lenderName;
        User.Builder builder = User.builder().setName(userName);
        boolean userExists = false;
        boolean borrower = !lender;
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).name().equals(userName)){
                userExists = true;
                List<Iou> owes = users.get(i).owes();
                List<Iou> owedBy = users.get(i).owedBy();
                users.remove(i);
                double debt = amount;
                List<Iou> firstList = new ArrayList(lender ? owes : owedBy);
                for (Iou o : firstList){
                    debt = o.amount;
                    if (o.name.equals(otherName)){
                        debt -= amount; 
                        if (debt > 0.0){
                            if (lender) builder.owes(o.name, debt);
                            else if (borrower) builder.owedBy(o.name, debt);
                            debt = 0;
                        }
                    } else {
                        if (lender) builder.owes(o.name, o.amount);
                        else if (borrower) builder.owedBy(o.name, o.amount);
                    }  
                }
                debt = Math.abs(debt);
                List<Iou> secondList = new ArrayList(lender ? owedBy : owes);
                for (Iou o : secondList){
                    if (!o.name.equals(userName)){
                        if (lender) builder.owedBy(o.name, o.amount);
                        else if (borrower) builder.owes(o.name, o.amount);
                    } 
                }                    
                if (debt > 0) {
                    if (lender) builder.owedBy(otherName, debt); 
                    else if (borrower) builder.owes(otherName, debt);
                }
            }       
        }
        if (!userExists){
            if (lender) builder.owedBy(otherName, amount);   
            else if (borrower) builder.owes(otherName, amount);
        }          
        User user = builder.build();
        users.add(user);
        return user; 
    }
    
   
    private String getUsers(){
        return new JSONObject().put("users", new JSONArray(users.stream().map(this::userToJson).collect(Collectors.toList()))).toString();
    }

    private User addUser(String name){
        return addUser(new JSONObject().put("user", name));        
    }
    
    private User addUser(JSONObject payload){
        String name = payload.getString("user");
        User newUser = new User.Builder().setName(name).build();
        return newUser;    
    }

    String userToJsonString(User user){
        return userToJson(user).toString();
    }
    
    JSONObject userToJson(User user){
        JSONObject owes = new JSONObject();
        JSONObject owedBy = new JSONObject();
        user.owes().forEach(iou -> owes.put(iou.name, iou.amount));
        user.owedBy().forEach(iou -> owedBy.put(iou.name, iou.amount));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", user.name());
        jsonObject.put("owedBy", owedBy);
        jsonObject.put("owes", owes);
        jsonObject.put("balance", getBalance(user));
        return jsonObject;
    }

    private double getBalance(User user){
        double owesSum = 0;
        for (Iou o : user.owes()){
            owesSum += o.amount;
        } 
        double owedSum = 0;
        for (Iou o : user.owedBy()) owedSum += o.amount;
        return owedSum - owesSum;      
    }
}

