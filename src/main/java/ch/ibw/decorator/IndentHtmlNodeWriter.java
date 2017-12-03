package ch.ibw.decorator;

import ch.ibw.HtmlNode;

import java.util.Collections;

public class IndentHtmlNodeWriter extends HtmlNodeWriterDecorator {
  public static final String BLANK = " ";
  private Integer level = 0;

  private IndentHtmlNodeWriter(Integer level, HtmlNodeWriterBase nested) {
    super(nested);
    this.level = level;
  }

  public static IndentHtmlNodeWriter create(Integer level, HtmlNodeWriterBase nested){
    return new IndentHtmlNodeWriter(level, nested);
  }

  public static IndentHtmlNodeWriter create(Integer level){
    return new IndentHtmlNodeWriter(level, HtmlNodeWriter.create());
  }

  @Override
  protected HtmlNodeWriterBase getWriter() {
    return IndentHtmlNodeWriter.create(level, nested);
  }

  @Override
  protected StringBuilder writeChildren(HtmlNode node) {
    level += 1;
    StringBuilder children = super.writeChildren(node);
    level -= 1;
    return children;
  }

  @Override
  protected StringBuilder writeStartTag(HtmlNode node) {
    StringBuilder startTag = super.writeStartTag(node);
    if(level == 0){
      return startTag;
    }
    return new StringBuilder().append("\n").append(generateIndentSpaces(level)).append(startTag);
  }

  @Override
  protected StringBuilder writeEndTag(HtmlNode node) {
    StringBuilder endTag = super.writeEndTag(node);
    if(node.isLastChild()){
      return endTag.append("\n");
    }
    boolean closeTagIsOnSameLineAsOpenTag = node.children.size() == 0;
    if(closeTagIsOnSameLineAsOpenTag){
      return endTag;
    }
    return new StringBuilder().append(generateIndentSpaces(level)).append(endTag);
  }

  private String generateIndentSpaces(Integer level){
    return String.join("", Collections.nCopies(level, BLANK));
  }
}
