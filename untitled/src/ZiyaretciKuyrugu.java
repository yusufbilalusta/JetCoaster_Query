import java.util.concurrent.TimeUnit;

public class ZiyaretciKuyrugu {
    Ziyaretci front;
    Ziyaretci rear;


    public ZiyaretciKuyrugu() {
        this.front = null;
        this.rear = null;
    }

    public void enequeue(String isim){
        Ziyaretci yeniZiyaretci = new Ziyaretci(isim);
        if (front==null){
            front = yeniZiyaretci;
            System.out.println("The first visitor was successfully added...");
            rear = front;
        }
        else{
            rear.next = yeniZiyaretci;
            rear = rear.next;
            System.out.println(isim +" was successfully added...");

        }
    }
    public void dequeue(){
        if (front==null){
            System.out.println("WARNING!There is no one to remove.");
        }
        else if (front.next==null){
            try {
                System.out.println("There is only one person and you are removing "+front.isim+"\nLoading...");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("DONE");
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        else {
            System.out.println(front.isim+" kuyruktan cikti.");
            front = front.next;
            if (front==null){
                rear=null;
                System.out.println("Diziyi Boşaltiniz..");
            }
        }

    }
    public void writedownVisitors(){
        Ziyaretci temporary;
        temporary= front;
        if (temporary == null){
            System.out.println("There is no one on the queue");
        }
        else {
            while (temporary.next!=null){
                System.out.println("-> "+temporary.isim);
                temporary = temporary.next;
            }
            System.out.println("->"+temporary.isim);
        }
    }

    public boolean checkNames(String name){
        //This function checks if the visitors name are the same.
        boolean degisken=true;
        Ziyaretci temporary;
        temporary = front;
        if (temporary==null) return degisken;
        while (temporary.next!=null){
            if (temporary.isim.equalsIgnoreCase(name)){
                degisken=false;
            }
            temporary = temporary.next;
        }
        if (rear.isim.equalsIgnoreCase(name)) degisken=false;
        return degisken;
    }

}
