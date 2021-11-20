package org.example.generator;

public class GenerateData<T> {
    private XmlSerializer xmlSerializer;

    public GenerateData() {
        this.xmlSerializer = new XmlSerializer<T>();
    }

    public void handleEntity(String entityType, String fileName) {
        xmlSerializer.serializeEntity(EntityMocker.mockEntity(entityType), fileName);
    }

    public T getEntity(Class entityClass, String fileName) {
        return (T) xmlSerializer.deserializeEntity(entityClass, fileName);
    }
}
