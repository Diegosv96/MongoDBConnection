package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Alumno;
import model.Profesor;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoDBConnection {
    private String connectionString = "mongodb+srv://%s:%s@cluster0.94gls.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private MongoClient mongoClient;
    private CodecProvider codecProvider;
    private CodecRegistry codecRegistry;
    public MongoDBConnection(){
        codecProvider = PojoCodecProvider.builder().automatic(true).build();
        codecRegistry = CodecRegistries.fromRegistries(
                MongoClients.create().getCodecRegistry(),
                CodecRegistries.fromProviders(codecProvider)
        );
        mongoClient = MongoClients.create(String.format(connectionString, SchemaDB.USER, SchemaDB.PASS));
    }

    public MongoCollection getAlumnosCollection(){
        MongoDatabase database = mongoClient.getDatabase(SchemaDB.DATABASE).withCodecRegistry(codecRegistry);
        return database.getCollection(SchemaDB.COLL_ALUM, Alumno.class);
    }
    public MongoCollection getProfesoresCollection(){
        MongoDatabase database = mongoClient.getDatabase(SchemaDB.DATABASE).withCodecRegistry(codecRegistry);
        return database.getCollection(SchemaDB.COLL_PROF, Profesor.class);
    }
}
