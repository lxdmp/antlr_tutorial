package com.lxdmp.interpretor;

import java.util.*;
import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class StructedTextApp
{
	private final static String grammerFileEncoding = "UTF-8";

    public static void main(String[] args)
    {
		try{
			ANTLRInputStream input = new ANTLRInputStream(
				new StructedTextApp().loadFileFromPackage("test")
			); // 建立输入流
			TestLexer lexer = new TestLexer(input); // 建立词法分析器
			CommonTokenStream tokens = new CommonTokenStream(lexer); // 建立词法符号流
			TestParser parser = new TestParser(tokens); // 建立语法分析器
			ParseTree tree = parser.init(); // 针对init规则进行语法分析
			
			System.out.println(tree.toStringTree(parser));
		}catch(Exception e){
			e.printStackTrace();
		}
    }

	// 获取il的语法文件内容
	/*
	public String getIlGrammarText() throws Exception
	{
		return this.getIlGrammarText(grammerFileEncoding);
	}

	public String getIlGrammarText(String fileEncoding) throws Exception
	{
		return this.loadFileFromPackage("il.g4", fileEncoding);
	}
	*/

	// 获取st的语法文件内容
	/*
	public String getStGrammarText() throws Exception
	{
		return this.getStGrammarText(grammerFileEncoding);
	}

	public String getStGrammarText(String fileEncoding) throws Exception
	{
		return this.loadFileFromPackage("st.g4", fileEncoding);
	}
	*/

	// 载入包中的数据文件
	protected InputStream loadFileFromPackage(String fileName)
	{
		return this.getClass().getResourceAsStream("/"+fileName);
	}

	protected String loadFileFromPackage(String fileName, String fileEncoding) throws Exception
	{
		InputStream istream = this.getClass().getResourceAsStream("/"+fileName);
		byte[] read_buf = new byte[128<<10];
		int readed_count = 0;
		StringBuilder builder = new StringBuilder();
		while((readed_count=istream.read(read_buf))!=-1)
		{
			String decodedString = new String(read_buf, 0, readed_count, fileEncoding);
			builder.append(decodedString);
		}
		istream.close();
		return builder.toString();
	}
}
