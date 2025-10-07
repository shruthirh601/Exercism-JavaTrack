import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class React {

    public static class Cell<T> {
        protected T value, previousValue;
        private List<Cell<T>> observers = new ArrayList<>();
        private boolean fresh = true;

        public void addObserver(Cell<T> observer) { observers.add(observer); }
        public void removeObserver(Cell<T> observer) { observers.remove(observer); }

        public boolean isFresh() { return fresh; }
        public T getValue() { return value; }
        
        public void setValue(T newValue) {
            if (value == newValue) return;
            for (Cell<T> observer : observers) ((ComputeCell<T>) observer).deprecate();            
            value = newValue;
            fresh = true;            
            for (Cell<T> observer : observers) ((ComputeCell<T>) observer).compute();
        }        

        public void deprecate() {
            fresh = false;
            for (Cell<T> observer : observers) ((ComputeCell<T>) observer).deprecate();
        }
    }

    public static class InputCell<T> extends Cell<T> {
        
    }

    public static class ComputeCell<T> extends Cell<T> {
        private List<Consumer<T>> callbacks = new ArrayList<>();
        private Function<List<T>, T> function;
        private List<Cell<T>> cells;
        
        public void addCallback(Consumer<T> callback) { callbacks.add(callback); }
        public void removeCallback(Consumer<T> callback) { callbacks.remove(callback); }

        public boolean hasChanged() {
            for (Cell<T> cell : cells) if (!cell.isFresh()) return false;
            return (value != previousValue) ? true : false;            
        }
        
        public void compute() {
            List<T> inputValues = new ArrayList<>();            
            for (Cell<T> cell : cells) inputValues.add(cell.getValue());            
            T newValue = function.apply(inputValues);
            if (newValue == value) { return; }            
            setValue(newValue);            
            if (!hasChanged()) { return; }            
            previousValue = newValue;            
            for (Consumer<T> callback : callbacks) callback.accept(value);
        }
    }

    public static <T> InputCell<T> inputCell(T initialValue) { 
        InputCell<T> inputCell = new InputCell<>();        
        inputCell.setValue(initialValue);        
        return inputCell;
    }

    public static <T> ComputeCell<T> computeCell(Function<List<T>, T> function, List<Cell<T>> cells) {
        ComputeCell<T> computeCell = new ComputeCell<>();        
        computeCell.function = function;
        computeCell.cells = cells;
        computeCell.compute();        
        for (Cell cell : cells) cell.addObserver(computeCell);        
        return computeCell;
    }
}