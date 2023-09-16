package tech.kjworks.dcbaseservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseModelTests {
    private ObjectId id;
    private BaseModel model;

    @BeforeEach
    void init() {
        id = new ObjectId();
        model = new BaseModel(id.toString());
    }

    @Test
    void baseModelConstructor() {
        assertEquals(id.toString(), model.getId());
    }

    @Test
    void baseModelGetters() {
        assertEquals(id.toString(), model.getId());
        assertEquals(null, model.getCreatedAt());
        assertEquals(null, model.getUpdatedAt());
    }

    @Test
    void baseModelSetters() {
        ObjectId newId = new ObjectId();
        Date now = new Date();

        model.setId(newId.toString());
        model.setCreatedAt(now);
        model.setUpdatedAt(now);

        assertEquals(newId.toString(), model.getId());
        assertEquals(now, model.getCreatedAt());
        assertEquals(now, model.getUpdatedAt());
    }
}
