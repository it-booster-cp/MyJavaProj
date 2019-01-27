import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import java.util.UUID;

import org.jdom2.*;

public class DomParserDemo3 {
	static List child2ParentList = new ArrayList();
	static List listParents = new ArrayList();
	static private Map<String, String> mapUUID = new HashMap<String, String>();

	public static void main(String[] args) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			factory.setValidating(false);
			DocumentBuilder loader = factory.newDocumentBuilder();
			Document document = loader.parse("test6.xml");
			NodeList childNodes = document.getChildNodes();

			for (int i = 0; i < childNodes.getLength(); i++) {
				order(childNodes.item(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param nList
	 */
	public static void order(Node node) {
		if (node == null)
			return;
		NodeList childNodes = node.getChildNodes();
		
		Node firstChild = node.getFirstChild();
		
		for (int i = 1; i < childNodes.getLength(); i++) {
			node=childNodes.item(i);
			if(node != null && !node.getNodeName().contains("text")) order(node);
		}
		String nodeName = node.getNodeName();
		String nodeValue = node.getNodeValue();

		System.out.println("Node: " + nodeName + " Value: " + nodeValue);
	}// meth
}