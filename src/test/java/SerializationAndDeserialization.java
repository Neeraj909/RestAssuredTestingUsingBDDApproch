
import java.io.*;

public class SerializationAndDeserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Test t1=new Test();

        //Serialization
        FileOutputStream fos =new FileOutputStream("test.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(t1);

        //Deserialization
        FileInputStream fis =new FileInputStream("test.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Test t2= (Test) ois.readObject();
        System.out.println(t2.a);
        System.out.println(t2.b);


    }



}
