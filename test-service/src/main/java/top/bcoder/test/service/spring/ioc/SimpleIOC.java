package top.bcoder.test.service.spring.ioc;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.Field;
import java.util.Map;

public class SimpleIOC {

    private Map<String, Object> beanMap = Maps.newHashMap();

    public SimpleIOC(String location) throws Exception {
        loadBeans(location);
    }

    private void loadBeans(String location) throws Exception {
        //加载配置文件
        File file = new File(System.getProperty("user.dir")+"/" + location);
        if (!file.exists()) {
            throw new IOException("bean配置文件不存在");
        }


        InputStream inputStream = new FileInputStream(file);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        NodeList childNodes = document.getDocumentElement().getChildNodes();

        if (childNodes.getLength() < 1) {
            throw new Exception("xml not exist child nodes");
        }

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                Element element = (Element) item;
                String id = element.getAttribute("id");
                String className = element.getAttribute("class");

                //加载beanclass并创建bean
                Class beanClass = Class.forName(className);
                Object bean = beanClass.newInstance();

                //遍历property标签
                NodeList propertyNodes = element.getElementsByTagName("property");

                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");

                        Field field = bean.getClass().getDeclaredField(name);
                        field.setAccessible(true);
                        if (!StringUtils.isEmpty(value)) {
                            field.set(bean, value);
                        } else {
                            String ref = propertyElement.getAttribute("ref");
                            if (StringUtils.isEmpty(ref)) {
                                throw new IllegalAccessException("ref not exist");
                            }
                            //填充引用字段
                            field.set(bean, getBean(ref));

                        }
                    }

                }
                //将实例注册到容器中
                registerBean(id, bean);
            }
        }
    }

    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }

    public Object getBean(String ref) throws IllegalAccessException {
        Object o = beanMap.get(ref);
        if (o == null) {
            throw new IllegalAccessException("there is no bean with name :" + ref);
        }
        return o;
    }
}
