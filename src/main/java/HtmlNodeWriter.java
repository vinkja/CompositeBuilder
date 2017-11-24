import java.util.stream.Collectors;

public class HtmlNodeWriter {
  private static final String TAG_OPEN = "<";
  private static final String TAG_CLOSE = ">";
  private static final String CLOSING_TAG_OPEN = "</";
  private static final String BLANK = " ";

  public static String write(AttributedCompositeNode node){
    String attributes = writeAttributes(node);
    return new StringBuilder()
            .append(TAG_OPEN)
            .append(node.name)
            .append(attributes)
            .append(TAG_CLOSE)
            .append(CLOSING_TAG_OPEN)
            .append(node.name)
            .append(TAG_CLOSE)
            .toString();
  }

  private static String writeAttributes(AttributedCompositeNode node) {
    return node.attributes.entrySet().stream().map((e) ->
          new StringBuilder(BLANK)
            .append(e.getKey())
            .append("='")
            .append(e.getValue())
            .append("'").toString())
            .collect(Collectors.joining());
  }
}
