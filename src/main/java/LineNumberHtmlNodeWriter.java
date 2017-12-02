import java.util.Arrays;
import java.util.stream.Collectors;

public class LineNumberHtmlNodeWriter extends HtmlNodeWriterDecorator {

  private LineNumberHtmlNodeWriter(HtmlNodeWriterBase nested) {
    super(nested);
  }

  public static LineNumberHtmlNodeWriter create(HtmlNodeWriterBase nested){
    return new LineNumberHtmlNodeWriter(nested);
  }

  public static LineNumberHtmlNodeWriter create(){
    return new LineNumberHtmlNodeWriter(HtmlNodeWriter.create());
  }

  @Override
  protected HtmlNodeWriterBase getWriter() {
    return LineNumberHtmlNodeWriter.create(nested);
  }

  @Override
  public String write(HtmlNode node) {
    String html = nested.write(node);
    final Integer[] line = {1};
    return Arrays.stream(html
            .split("\\n"))
            .map(l -> (line[0]++) + " " + l)
            .collect(Collectors.joining("\n"));
  }
}
