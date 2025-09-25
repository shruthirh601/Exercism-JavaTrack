import java.util.*;

class BinarySearch {

    List<Integer> items = new ArrayList<>();
    BinarySearch(List<Integer> items) {
        this.items = items;
    }

    int indexOf(int item) throws ValueNotFoundException {
        if(items.size() == 0)
            throw new ValueNotFoundException("Value not in array");
        
        int mid=0, low=0, high= items.size()-1;
        while(low<=high){
            mid = (low+high)/2;
            if(item == items.get(mid))
                return mid;
            else if(item > items.get(mid))
                low = mid+1;
            else
                high = mid-1;
        }
        if(low >= high)
            throw new ValueNotFoundException("Value not in array");
        return -1;
    }
}
