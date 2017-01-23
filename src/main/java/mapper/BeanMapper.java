package mapper;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;


public final class BeanMapper {

    private static BeanMapper beanMapper = new BeanMapper();
    private static DozerBeanMapper mapper;
    private BeanMapper() {
        List<String> mappingFiles = new ArrayList();

        mappingFiles.add(BeanMapper.class.getClassLoader().getResource("dozerJdk8Converters.xml").toString());
        mappingFiles.add(BeanMapper.class.getClassLoader().getResource("doserMapping.xml").toString());

        mapper = new DozerBeanMapper();
        mapper.setMappingFiles(mappingFiles);
    }
    public static synchronized BeanMapper getInstance() {
        if (beanMapper == null) {
            beanMapper = new BeanMapper();
        }
        return beanMapper;
    }
    public static <T> T singleMapper(Object from, Class<T> toClass) {
        T map = null;
        if(from!=null) {
            map = mapper.map(from, toClass);
        }
        return map;
    }
    public static <E, T> List<T> listMapToList(Iterable<E> iterable, Class<T> toClass) {
        List<T> list = new ArrayList<T>();
        for (E e : iterable) {
            list.add(mapper.map(e, toClass));
        }
        return list;
    }


}
