import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.Parent;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDomTest {

	public static Document doc = null;
	static Element root = null;
	static Namespace ns;
	static String key;
	static String NAME;
	static HashMap<String, String> hashMap;
	static int zaehler = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hashMap = new HashMap<String, String>();

		hashMap.put("has_EVC", "sdcsdc");
		hashMap.put("has_Servicelevel", "wedw");
		hashMap.put("has_Endpunkt1", "egerrg");
		hashMap.put("has_Endpunkt2", "666ww6");
		hashMap.put("has_CoS_Profil", "scsdcc");

		try {
			String filename = "test10.xml";
			doc = new SAXBuilder().build(filename);
			root = doc.getRootElement();

			ns = Namespace.getNamespace("typ1");

			// PARENT.has_EVC: 514da96a-0767-440b-ad63-97eaa1c2322a

			// List<Element> childs = root.getChild("relotioon",
			// ns).getChildren();
			Element child = root.getChild("myroot", ns);
			// System.out.println(childs.size());

			// new JDomTest().rekursiveMethod(childs, null);
			new JDomTest().rekursiveMethod3(child,"5fd6dc92-f803-4689-86c5-721f46e6c488");

			// Element wein = new Element( "getraenk" );
			// wein.addContent( "Wein" );
			//
			// addNewValueAtAttributByName(wein, "Martina Mutig");
			// wein = new Element( "getraenk" );
			// wein.addContent( "Wein" );
			// addNewValueAtAttributByName(wein, "Martina Mutig");
			//
			// wein = new Element( "bungalow" );
			// wein.addContent( "ggaga" );
			// addNewValueAtAttributByName(wein, "Martina Mutig");
			//
			// // Write
			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			// out.output( doc, System.out );
			out.output(doc, new FileOutputStream("test8-out.xml"));

		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param elx
	 * @return
	 */
	private void rekursiveMethod3(Element elx, String ID) {
		String textCh = "";
		String textPar = "";
		String namePar2 = "";

		if (!elx.getText().isEmpty())
			textCh = elx.getText().trim();
		if (!elx.getParentElement().getText().isEmpty())
			textPar = elx.getParentElement().getText().trim();
		if (elx.getParentElement().getParentElement() != null) {
			namePar2 = elx.getParentElement().getParentElement().getName();
		}

		// AUswertung
		if (elx.getName().equals("name")) {
			NAME = textCh;
		}
		boolean containsKey = hashMap.containsKey(NAME);
		if (NAME != null && containsKey && elx.getName().equals("ID")) {
//			elx.setText(hashMap.get(NAME));
			ID=textCh;
			NAME = null;
		}

		System.out.println("ParName: " + namePar2 + "/" + elx.getParentElement().getName() + " - ParText: " + textPar);
		System.out.println("ChName: " + elx.getName() + " - ChText: " + textCh);
		System.out.println("NAME: " + NAME);

		List<Element> children = elx.getChildren();
		System.out.println("Size: " + children.size());
		for (Element el : children) {
			if (el != null) {
				String name = el.getName();
				String text = el.getText();
				Element parentElement = el.getParentElement();
				// System.out.println("REKURSIVER AUFRUF: Parentelement: " +
				// parentElement.getName() + name + " - Text: " + text);
				System.out.println("ID=>>>>>>>>>>>>"+ID);
					rekursiveMethod3(el, text);
				 
			}
		}
	}

	/**
	 * @param elx
	 * @return
	 */
	private void rekursiveMethod2(Element elx) {
		String textCh = "";
		String textPar = "";
		String namePar2 = "";

		if (!elx.getText().isEmpty())
			textCh = elx.getText().trim();
		if (!elx.getParentElement().getText().isEmpty())
			textPar = elx.getParentElement().getText().trim();
		if (elx.getParentElement().getParentElement() != null) {
			namePar2 = elx.getParentElement().getParentElement().getName();
		}

		// AUswertung
		if (elx.getName().equals("name")) {
			NAME = textCh;
		}
		boolean containsKey = hashMap.containsKey(NAME);
		if (NAME != null && containsKey && elx.getName().equals("ID")) {
			elx.setText(hashMap.get(NAME));
			NAME = null;
		}

		System.out.println("ParName: " + namePar2 + "/" + elx.getParentElement().getName() + " - ParText: " + textPar);
		System.out.println("ChName: " + elx.getName() + " - ChText: " + textCh);
		System.out.println("NAME: " + NAME);

		List<Element> children = elx.getChildren();
		System.out.println("Size: " + children.size());
		for (Element el : children) {
			if (el != null) {
				String name = el.getName();
				String text = el.getText();
				Element parentElement = el.getParentElement();
				// System.out.println("REKURSIVER AUFRUF: Parentelement: " +
				// parentElement.getName() + name + " - Text: " + text);
				rekursiveMethod2(el);
			}
		}
	}

	/**
	 * @param childs
	 * @return
	 */
	private List<Element> rekursiveMethod(List<Element> childs, Element elx) {
		System.out.println("Size: " + childs.size());
		for (Element el : childs) {
			// if (!el.getName().isEmpty()) {
			// String name = el.getName();
			// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
			// name);
			List<Element> childs2 = el.getChildren();
			if (!childs2.isEmpty()) {
				String name = el.getName();
				System.out.println("============== REKURSIVER AUFRUF: " + name);
				childs = rekursiveMethod(childs2, el);
			} else {
				// key="";
			}
			// }
		}

		if (elx != null) {
			String name = elx.getName();
			System.out.println(
					"----------------------------------------------------------------------------------------------------");
			System.out.println("ElxName: " + name);

			List<Element> children = elx.getChildren();
			int i = 0;
			for (Element element : children) {
				String name2 = element.getName();
				String text = element.getText();
				i++;
				System.out.println(i + ") ChildName2: " + name2 + " - Text: " + text);
				String key = name + "." + text;
				if (key.contains("relation.has_EVC")) {

					System.out.println(key);
				}
			}
		}
		// Parent parent = elx.getParent();
		// List<Content> content = parent.getContent();
		// for (Content content2 : content) {
		// String val = content2.getValue();
		// System.out.println("val: " + val);
		// }

		return childs;
	}

	/**
	 * @param elementValue
	 * @param attribut
	 * @param personName
	 */
	private static void addNewValueAtAttributByName(Element elementValue, String personName) {
		Iterator gaesteListe = root.getChildren("gast").iterator();
		while (gaesteListe.hasNext()) {
			Element gast = (Element) gaesteListe.next();

			if (personName.equals(gast.getAttribute("name").getValue()))
				gast.addContent(elementValue);
		}
	}

	private static void searchForValue(Element elementValue, String personName) {
		// PARENT.has_EVC: 514da96a-0767-440b-ad63-97eaa1c2322a

		Iterator gaesteListe = root.getChildren("gast").iterator();
		while (gaesteListe.hasNext()) {
			Element gast = (Element) gaesteListe.next();

			if (personName.equals(gast.getAttribute("name").getValue()))
				gast.addContent(elementValue);
		}
	}

}
