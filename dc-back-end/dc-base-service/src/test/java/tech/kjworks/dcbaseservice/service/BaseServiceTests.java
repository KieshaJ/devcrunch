package tech.kjworks.dcbaseservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import tech.kjworks.dcbaseservice.model.BaseModel;
import tech.kjworks.dcbaseservice.repository.BaseRepository;
import tech.kjworks.dcbaseservice.service.impl.BaseServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BaseServiceTests {
    @Mock
    private BaseRepository<BaseModel> baseRepository;

    @Autowired
    @InjectMocks
    private BaseServiceImpl<BaseModel> baseService;

    private ObjectId id1;
    private ObjectId id2;
    private BaseModel model1;
    private BaseModel model2;
    private List<BaseModel> modelList;

    @BeforeEach
    public void setUp() {
        this.id1 = new ObjectId();
        this.model1 = new BaseModel(id1.toString());
        this.id2 = new ObjectId();
        this.model2 = new BaseModel(id2.toString());
        this.modelList = List.of(model1, model2);
    }

    @Test
    public void baseService_list() {
        when(baseRepository.findAll()).thenReturn(modelList);

        List<BaseModel> models = baseService.list();
        verify(baseRepository, times(1)).findAll();
        assertEquals(2, models.size());
        assertEquals(model1.getId().toString(), models.get(0).getId());
        assertEquals(model2.getId().toString(), models.get(1).getId());
    }

    @Test
    public void baseService_create() {
        ObjectId id = new ObjectId();
        BaseModel model = new BaseModel(id.toString());
        when(baseRepository.insert(model)).thenReturn(model);

        BaseModel newModel = baseService.create(model);
        verify(baseRepository, times(1)).insert(model);
        assertNotNull(newModel.getId());
    }

    @Test
    public void baseService_update() {
        Date now = new Date();
        this.model1.setUpdatedAt(now);
        when(baseRepository.save(model1)).thenReturn(model1);

        BaseModel updatedModel = baseService.update(id1.toString(), model1);
        verify(baseRepository, times(1)).save(model1);
        assertEquals(id1.toString(), updatedModel.getId());
        assertEquals(now, updatedModel.getUpdatedAt());
    }

    @Test
    public void baseService_get() {
        when(baseRepository.findById(id1.toString())).thenReturn(Optional.of(model1));
        when(baseRepository.findById(id2.toString())).thenReturn(Optional.of(model2));

        Optional<BaseModel> modelOptional1 = baseService.get(id1.toString());
        Optional<BaseModel> modelOptional2 = baseService.get(id2.toString());
        verify(baseRepository, times(2)).findById(any());
        assertEquals(id1.toString(), modelOptional1.get().getId());
        assertEquals(id2.toString(), modelOptional2.get().getId());
    }

    @Test
    public void baseService_delete() {
        doNothing().when(baseRepository).deleteById(any());

        Boolean deleted1 = baseService.delete(id1.toString());
        Boolean deleted2 = baseService.delete(id2.toString());
        verify(baseRepository, times(2)).deleteById(any());
        assertEquals(true, deleted1);
        assertEquals(true, deleted2);
    }
}
