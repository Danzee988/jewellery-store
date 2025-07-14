# 💎 Jewellery Store Manager

A JavaFX-based desktop application that manages a jewellery store's inventory using an object-oriented design and custom data structures. 
It supports dynamic creation and display of cases, trays, jewellery items, and materials, all backed by a custom-built LinkedList.

## ✨ Features
- 🧳 Display Cases: Organize your inventory in cases with customizable lighting and types.
- 🧺 Trays in Cases: Trays are color-coded, sized, and uniquely identified within each case.
- 💍 Jewellery Items: Add items with detailed attributes—type, gender, price, and description.
- 🧬 Materials: Each jewellery item can contain one or more materials, each with type, quality, weight, and description.
- 🧾 Nested Inventory: Each level (Case → Tray → Item → Material) is displayed in full detail with structured listings.
- 🪵 Custom Linked List: All entities are stored in a manually implemented singly linked list structure.
- 💾 Data Persistence: Save and load inventory data to and from an XML file using XStream.

## 📁 Data Model Overview
- Case → contains multiple Tray objects
- Tray → contains multiple Jewellery objects
- Jewellery → contains multiple Material objects
- Material → detailed info about composition (e.g., gold, silver)
All of the above are managed using a custom generic LinkedList<T> and Node.

## 🛠️ Technologies Used
- Java 17+
- JavaFX for GUI
- XStream for XML-based serialization and persistence
- OOP Principles: Abstraction, Encapsulation, Composition
- Custom Data Structures (Singly Linked List)

## 💾 Save/Load System
Data can be saved to and loaded from an .xml file.

**🔹 Save System**

```
void saveSystem(MouseEvent event) throws Exception {
    // Uses XStream to serialize current state of cases
}
```

**🔹 Load System**
```
void loadSystem(MouseEvent event) throws Exception {
    Class<?>[] classes = new Class[]{Case.class, Jewellery.class, Material.class,
        Tray.class, LinkedList.class, Node.class};

    XStream xstream = new XStream(new DomDriver());
    XStream.setupDefaultSecurity(xstream);
    xstream.allowTypes(classes);

    ObjectInputStream in = xstream.createObjectInputStream(new FileReader("output.xml"));
    caseList = (LinkedList<Case>) in.readObject();
    in.close();
}
```

## 🚀 How to Run
1. Open in your preferred Java IDE (e.g., IntelliJ, Eclipse).
2. Ensure JavaFX is configured.
3. Run the StoreApplication class.
4. Use the GUI to add/display cases, trays, items, and materials.
5. Save or load the system using menu actions.

## 📌 Future Improvements
- 🧩 Add search & filtering by item type, price, or material.
- 🖼️ Show item images or icons.
- ☁️ Migrate to database storage (e.g., SQLite).
- 📈 Include analytics: most expensive item, total material weight, etc.

