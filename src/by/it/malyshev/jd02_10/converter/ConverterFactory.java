package by.it.malyshev.jd02_10.converter;

public class ConverterFactory<T> {
    private enum Direction{
        XML_TO_JSON, JSON_TO_XML
    }

    public AbstractConverter<T> getConverter(String typeParser, Class<T> beanClass){
        Direction direction= Direction.valueOf(typeParser.toUpperCase());
        switch (direction) {
            case XML_TO_JSON:
            {
                return new ConverterXmlToJsonBuilder<>(beanClass);
            }
            case JSON_TO_XML:
            {
                return new ConverterJsonToXmlBuilder<>(beanClass);
            }
            default: throw new EnumConstantNotPresentException(
                    direction.getDeclaringClass(),direction.name()
            );
        }
    }


}
