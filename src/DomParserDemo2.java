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

public class DomParserDemo2 {
	static List child2ParentList = new ArrayList();
	static List listParents = new ArrayList();
	static private Map<String, String> mapUUID=new HashMap<String, String>();

	public static void main(String[] args) {
		boolean ok = ("Hallo".toUpperCase().contains("HALLO") ? true : false);
		// System.out.println("=======================================> "+ok);

		String[] namen = { "Gustaf", "Hans", "Klaus", "Maria", "Gustaf" };
		ArrayList newList = new ArrayList();
		newList.addAll(Arrays.asList(namen));

		// String [] knItems= {"KUNDENNETZ", "Hans", "Klaus", "Maria",
		// "Gustaf"};
		// String [] ansItems= {"ANSCHLUSS", "Hans", "Klaus", "Maria",
		// "Gustaf"};
		// String [] verbItems= {"Gustaf", "Hans", "Klaus", "Maria", "Gustaf"};
		// ArrayList kunetzList = new ArrayList();
		// ArrayList ansList = new ArrayList();
		// ArrayList verbList = new ArrayList();
		// kunetzList.addAll(Arrays.asList(knItems));
		// ansList.addAll(Arrays.asList(ansItems));
		// verbList.addAll(Arrays.asList(verbItems));

		boolean equals = newList.contains("Maria");

//		System.out.println("=======================================> " + equals);

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			factory.setValidating(false);

			DocumentBuilder loader = factory.newDocumentBuilder();
			Document document = loader.parse("test3.xml");

			NodeList childNodes = document.getChildNodes();
			// for (int i = 0; i < childNodes.getLength(); i++) {
//			System.out.println("=================XXXXXXXXXXXXXXXXX======================> ");
			Node node = childNodes.item(0);
			String nodeName = node.getLocalName();
//			System.out.println(nodeName);

			if (node != null) {
				preOrder(childNodes);
			}
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// 1. Setze einen neuen Schluessel
		for(String key : mapUUID.keySet())
		{
			String newID = UUID.randomUUID().toString();
			mapUUID.put(key,newID);
			
//			System.out.print("Key: " + key + " - ");
//			System.out.print("Value: " + mapUUID.get(key) + "\n");
		}
		
		// 2. Lese XML und tausche IDs aus
		File file = new File("test3.xml");
		String path = file.getPath();
		String readSimResponseData = readSimResponseData(path, "UTF-8");
		
//		System.out.println(readSimResponseData);
		
		// 3. Replace IDs
		for(String key : mapUUID.keySet())
		{
			String newValue = mapUUID.get(key);
			if(readSimResponseData.contains(key)){
				readSimResponseData=readSimResponseData.replace(key.trim(), newValue.trim());	
			}
			
		}
		
//		System.out.println("\n\n Manipulierte XML");
		System.out.println(readSimResponseData);

//		for (Object item : child2ParentList) {
//			System.out.println("child2ParentList " + item.toString());
//		}
	}
	
    private static String readSimResponseData(String filename, String encoding) {
        byte[] encoded = null;
        try {
            encoded = Files.readAllBytes(Paths.get(filename));
        } catch (FileNotFoundException fnfE) {
            System.out.println("Fehler!");
        } catch (IOException ioE) {
        	System.out.println("Fehler!");
        }
        return new String(encoded, Charset.forName(encoding));
    }

	// Call the procedure using the TreeView.
	/**
	 * @param nList
	 */

	public static void preOrder(NodeList nList) {
		if (nList == null)
			return;
		for (int i = 0; i < nList.getLength(); i++) {
			Node item = nList.item(i);

			String nodeName = item.getNodeName();
			Node parentNode = item.getParentNode();
			String parentName = parentNode.getNodeName();
			NodeList childNodes = item.getChildNodes();

			if (nodeName.contains("nummer")) {
				NodeList childNodes2 = item.getChildNodes();
				Node item2 = childNodes2.item(0);
				if (item2 != null) {
					String nodeValue23 = item2.getNodeValue();
					if (parentName.contains("productSpecificationID")) {
//						System.out.println(i + " ===========> : " + parentName + " " + nodeValue23);
					}
				}
			}

			if (nodeName.contains("relationType")) {
				NodeList childNodes2 = item.getChildNodes();
				Node item2 = childNodes2.item(0);

				if (item2 != null) {
					String nodeName2 = item2.getNodeName();
					String nodeValue23 = item2.getNodeValue();

					if (parentName.contains("relation")) {
//						System.out.println(i + " =====RELATION======> : " + parentName + " " + nodeValue23);
					}
				}

			}

			if (nodeName.contains("name")) {

				NodeList childNodes2 = item.getChildNodes();
				Node item2 = childNodes2.item(0);

//				System.out.println("NAME: " + item2.getNodeValue());
				if (item2 != null) {
					String nodeValue23 = item2.getNodeValue();
					if (parentName.contains("productSpecificationID")) {
//						System.out.println(i + " ===========> : " + parentName + " " + nodeValue23);
					}
				}
			}

			if (parentName.contains("productInstanceID") || parentName.contains("parentProductInstanceID")) {
				NodeList childNodes2 = item.getChildNodes();
				Node item2 = childNodes2.item(0);
				if (item2 != null) {
					String nodeName2 = item2.getNodeName();
					String nodeValue23 = item2.getNodeValue();
					
					
					if(nodeValue23!=null) mapUUID.put(nodeValue23, "");
					
					
//					System.out.println(
//							i + " Parentnode: " + parentName + " Nodename: " + nodeName + " ===> " + nodeValue23);

					if (parentName.contains("productInstanceID")) {
						listParents.add(nodeValue23);
					}

					if (parentName.contains("parentProductInstanceID")) {
						if (!listParents.contains(nodeValue23)) {
							System.out.println(
									"## FEHLER! bei der Referenzierung zum Parent-Objekt (Child hat kein Elternteil)");
						}
					}
				}
			}

			preOrder(childNodes);
		} // for
	}// meth

}