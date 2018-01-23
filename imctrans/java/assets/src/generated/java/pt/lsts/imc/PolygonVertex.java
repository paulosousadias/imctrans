package pt.lsts.imc;

public class PolygonVertex extends IMCMessage {
    public static final int ID_STATIC = 474;


    public PolygonVertex() {
        super(ID_STATIC);
    }

    public PolygonVertex(IMCDefinition defs) {
        super(defs, ID_STATIC);
    }

    public PolygonVertex(IMCMessage msg) {
        super(ID_STATIC);
        try {
            copyFrom(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PolygonVertex create(Object... values) {
        PolygonVertex m = new PolygonVertex();
        for (int i = 0; i < values.length - 1; i += 2)
            m.setValue(values[i].toString(), values[i + 1]);
        return m;
    }

    public static PolygonVertex clone(IMCMessage msg) throws Exception {
        PolygonVertex m = new PolygonVertex();
        if (msg == null)
            return m;
        if (msg.definitions != m.definitions) {
            msg = msg.cloneMessage();
            IMCUtil.updateMessage(msg, m.definitions);
        } else if (msg.getMgid() != m.getMgid()) {
            throw new Exception("incompatible types: " + msg.getAbbrev() + " and " + m.getAbbrev());
        }
        m.getHeader().values.putAll(msg.getHeader().values);
        m.values.putAll(msg.values);
        return m;
    }

    public double getLat() {
        return getDouble("lat");
    }

    public PolygonVertex setLat(double lat) {
        values.put("lat", lat);
        return this;
    }

    public double getLon() {
        return getDouble("lon");
    }

    public PolygonVertex setLon(double lon) {
        values.put("lon", lon);
        return this;
    }

}
