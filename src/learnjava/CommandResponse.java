package learnjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface ICommand {
    String performSend();

}

interface IResponce {
    void onResponce(String result);

    void onError(String result);
}

class DataHolder {
    public Object date;

    public DataHolder(Object data) {
        this.date = data;


    }
}

class PointCommand implements ICommand, IResponce {

    private DataHolder dataHolder;

    public PointCommand(DataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @Override
    public String performSend() {
        System.out.println("send data == " + dataHolder);
        String a = " " + dataHolder;
        return a;
    }

    @Override
    public void onResponce(String result) {
        System.out.println(result);
    }

    @Override
    public void onError(String result) {
        System.out.println(result);

    }
}

class TaskCarrier implements Runnable {
    ICommand command;
    IResponce responce;

    TaskCarrier(IResponce responce, ICommand command) {
        this.command = command;
        this.responce = responce;
    }


    @Override
    public void run() {
        String a = command.performSend();
        responce.onResponce(a);

    }
}

public class CommandResponse {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        PointCommand a = new PointCommand(new DataHolder("haha"));
        service.execute(new TaskCarrier(a, a));
    }
}