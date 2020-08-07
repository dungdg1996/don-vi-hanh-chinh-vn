package data;

import entity.DVHC;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DVHCDao {
    private final List<DVHC> datas;

    public DVHCDao() {
        datas = new ArrayList<>();
        try {
            JAXBContext jc = JAXBContext.newInstance(DVHC.class);
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xsr = xif.createXMLStreamReader(DVHCDao.class.getResource("dvhc_data.xml").openStream());
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            while (xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
                if (xsr.isStartElement() && "DVHC".equals(xsr.getLocalName())) {
                    DVHC user = (DVHC) unmarshaller.unmarshal(xsr);
                    datas.add(user);
                }
                xsr.next();
            }
        } catch (JAXBException | IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public List<DVHC> findAll() {
        return datas;
    }
    public DVHC findById(int id) {
        return datas.stream().filter(dvhc -> dvhc.getId() == id )
                .findAny().get();
    }
    public List<DVHC> findByNameLike(String key){
        return datas.stream()
                .filter(dvhc -> dvhc.getName().contains(key))
                .collect(Collectors.toList());
    }
    public List<DVHC> findByLevelAndNameLike(String level, String key){
        return datas.stream()
                .filter(dvhc -> dvhc.getName().contains(key) &&dvhc.getLevel().equals(level))
                .collect(Collectors.toList());
    }
    public List<DVHC> findByLevel(String level){
        return datas.stream()
                .filter(dvhc -> dvhc.getLevel().equals(level))
                .collect(Collectors.toList());
    }
    private List<String> words(){
        return new ArrayList<>();
    }
}
