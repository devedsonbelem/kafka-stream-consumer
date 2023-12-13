package br.com.kafkaconsumer.config;

import java.io.IOException;
import java.util.List;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.kafkaconsumer.entity.Users;

public class UsersDeserializer implements Deserializer<List<Users>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Users> deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, objectMapper.getTypeFactory().constructCollectionType(List.class, Users.class));
        } catch (JsonParseException | JsonMappingException e) {
            throw new SerializationException("Erro ao deserializar", e);
        } catch (IOException e) {
            throw new SerializationException("Erro de E/S durante a desserialização", e);
        }
    }
}
