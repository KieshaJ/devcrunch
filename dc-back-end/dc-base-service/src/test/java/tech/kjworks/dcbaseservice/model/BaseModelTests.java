package tech.kjworks.dcbaseservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

public class BaseModelTests {
    @Test
    public void baseModel_constructor_success() {
        ObjectId id = new ObjectId();
        BaseModel model = new BaseModel(id.toString());

        assertEquals(id.toString(), model.getId());
    }

    @Test
    public void baseModel_getters() {
        ObjectId id = new ObjectId();
        BaseModel model = new BaseModel(id.toString());

        assertEquals(id.toString(), model.getId());
        assertEquals(null, model.getCreatedAt());
        assertEquals(null, model.getUpdatedAt());
    }

    @Test
    public void baseModel_setters() {
        ObjectId id = new ObjectId();
        ObjectId newId = new ObjectId();
        BaseModel model = new BaseModel(id.toString());
        Date now = new Date();

        model.setId(newId.toString());
        model.setCreatedAt(now);
        model.setUpdatedAt(now);

        assertEquals(newId.toString(), model.getId());
        assertEquals(now, model.getCreatedAt());
        assertEquals(now, model.getUpdatedAt());
    }
}
