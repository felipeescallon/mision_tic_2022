public class MotoAcuatica {
    private String Id;
    private String Modelo;
    private String Marca;

    public MotoAcuatica(String id, String modelo, String marca) {
        Id = id;
        Modelo = modelo;
        Marca = marca;
    }
    
    
    public String getId() {
        return Id;
    }
    public String getModelo() {
        return Modelo;
    }

    public String getMarca() {
        return Marca;
    }
    
    
}
