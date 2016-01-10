package ionix.Utils;

import com.google.gson.Gson;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.*;

public final class Ser {

    public static String toBinary(Object obj) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(obj);
            so.flush();
            // This encoding induces a bijection between byte[] and String (unlike UTF-8)
            return bo.toString("ISO-8859-1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromBinary(String str, Class<T> cls) {
        // deserialize the object
        try {
            // This encoding induces a bijection between byte[] and String (unlike UTF-8)
            byte b[] = str.getBytes("ISO-8859-1");
            ByteArrayInputStream bi = new ByteArrayInputStream(b);
            ObjectInputStream si = new ObjectInputStream(bi);
            return cls.cast(si.readObject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final Gson gson = new Gson();
    public static String toJson(Object obj){
        if (null != obj){
            return gson.toJson(obj);
        }
        return "";
    }
    public static <T> T fromJson(String json, Class<T> cls){
        if (!Ext.isNullOrEmpty(json)){
            return gson.fromJson(json, cls);
        }
        return null;
    }


    public static String toXml(Object obj){
        if (null != obj){
            StringWriter writer = new StringWriter();
            Serializer serializer = new Persister();

            try
            {
                serializer.write(obj, writer);
                return writer.getBuffer().toString();
            }
            catch(Exception ex){
                throw new RuntimeException(ex);
            }

        }
        return "";
    }

    public static <T> T fromXml(String xml, Class<T> cls){
        if (!Ext.isNullOrEmpty(xml)) {
            Serializer serializer = new Persister();
            try
            {
                return serializer.read(cls, new StringReader(xml));
            }
            catch(Exception ex){
                throw new RuntimeException(ex);
            }
        }
        return null;
    }
}
