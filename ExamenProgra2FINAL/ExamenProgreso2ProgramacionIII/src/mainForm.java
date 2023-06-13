import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarPlatoButton;
    private JTextArea textAIngresoPlatos;
    private JButton QuemarDatosButton;
    private JTextField textIngresoPrecio;
    private JTextField textIngresoCalorias;
    private JTextField textIngresoPreparacion;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;
    private JTextArea textArea1;
    private JButton ordenarBurbujaNombreButton;
    Plato platoNew;
    Menu menuNew= new Menu();
    Ordenamiento ordenamientoNew= new Ordenamiento();
    Plato platoA=new Plato("Papa",2.0,100,30);
    Plato platoB=new Plato("Pure",2.75,60,50);
    Plato platoC=new Plato("Lasagna",2.5,40,20);
    Plato platoD=new Plato("Hongos",2.90,50,10);

    public mainForm() {

        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textIngresoNombre.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo de nombre está vacío");
                } else if (textIngresoPrecio.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo de precio está vacío");
                } else if (textIngresoCalorias.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo de calorias está vacío");
                } else if (Integer.valueOf(textIngresoPreparacion.getText())<0) {
                    JOptionPane.showMessageDialog(null, "El campo del calorias debe ser positivo");
                } else {
                    String nombrePlato=textIngresoNombre.getText();
                    double precioPlato=Double.valueOf(textIngresoPrecio.getText());
                    double calorias=Double.valueOf(textIngresoCalorias.getText());
                    int timepoPreparacion=Integer.valueOf(textIngresoPreparacion.getText());
                    //if (menuNew.searchByTrackingNameLineal(menuNew.platosMenu, nombrePlato) == -1) {
                    if (menuNew.searchBinary(menuNew.platosMenu, textIngresoNombre.getText()) == null) {
                        if (!textIngresoNombre.getText().isEmpty() && !textIngresoPrecio.getText().isEmpty() && !textIngresoCalorias.getText().isEmpty()&& !textIngresoPreparacion.getText().isEmpty()) {
                            platoNew = new Plato(nombrePlato,precioPlato,calorias,timepoPreparacion);
                            menuNew.addPlatos(platoNew);
                            JOptionPane.showMessageDialog(null, "Se ha creado con éxito el plato");
                            menuNew.BurbujaA();
                            System.out.println(menuNew.getPlatosMenu().toString());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya existe un plato con ese nombre ");
                    }
                }


            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuNew.platosMenu.add(platoA);
                menuNew.platosMenu.add(platoB);
                menuNew.platosMenu.add(platoC);
                menuNew.platosMenu.add(platoD);
                menuNew.BurbujaA();
                for (int i=0;i<menuNew.platosMenu.size();i++){
                    textAIngresoPlatos.append(menuNew.platosMenu.get(i) + "\n");
                }
            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textoModifNombre.getText().isEmpty() && menuNew.searchBinary(menuNew.platosMenu,textoModifNombre.getText()) !=null) {

                    activarModificar();
                    Plato platoBuscar=menuNew.searchBinary(menuNew.platosMenu,textoModifNombre.getText());
                    textoModifPrecio.setText(String.valueOf(platoBuscar.getPrecioPlato()));
                    textoModifCalorias.setText(String.valueOf(platoBuscar.getCalorias()));
                    textoModifPreparacion.setText(String.valueOf(platoBuscar.getTimepoPreparacion()));
                }else {
                    JOptionPane.showMessageDialog(null, "No existe ese plato o el campo esta vacio");
                }
            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double precioNuevo=Double.parseDouble(textoModifPrecio.getText());
                double caloriasNuevo=Double.parseDouble(textoModifCalorias.getText());
                int tiempoPNuevo=Integer.parseInt(textoModifPreparacion.getText());
                Plato platoAuxiliar=menuNew.searchBinary(menuNew.platosMenu,textoModifNombre.getText());
                if(platoAuxiliar!=null) {
                    if (!textoModifPrecio.getText().isEmpty()) {
                        modificarPrecio(platoAuxiliar,precioNuevo);
                    }if (!textoModifCalorias.getText().isEmpty()){
                        modificarCalorias(platoAuxiliar,caloriasNuevo);
                    }if (!textoModifPreparacion.getText().isEmpty()) {
                        modificarTiempoPreparacion(platoAuxiliar,tiempoPNuevo);
                    }

                    textAModif.setText(platoAuxiliar.toString());
                }else{
                    JOptionPane.showMessageDialog(null,"Verifique el nombre porfavor");
                }
            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textNombreEliminar.getText().isEmpty() && menuNew.searchBinary(menuNew.platosMenu,textNombreEliminar.getText()) !=null) {

                    activarModificar();
                    Plato platoBuscar=menuNew.searchBinary(menuNew.platosMenu,textNombreEliminar.getText());
                    textAEliminar.setText(" "+platoBuscar.toString());
                }else {
                    JOptionPane.showMessageDialog(null, "No existe ese plato o el campo esta vacio");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuNew.removePackage(menuNew.platosMenu,textNombreEliminar.getText());
                JOptionPane.showMessageDialog(null,"Se ha elimiado correctamente");
                textAEliminar.setText(" ");
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxOrder.getSelectedIndex()== 0){
                    menuNew.BurbujaxNombre();
                    textAMostrar.setText(" ");
                    for (int i=0;i<menuNew.getArregloBurbuja().size();i++){
                        textAMostrar.append(menuNew.getArregloBurbuja().get(i) + "\n");
                    }
                }if (comboBoxOrder.getSelectedIndex() ==1){
                    menuNew.BurbujaxPrecio();
                    textAMostrar.setText(" ");
                    for (int i=0;i<menuNew.getArregloBurbuja().size();i++){
                        textAMostrar.append(menuNew.getArregloBurbuja().get(i) + "\n");
                    }
                }if (comboBoxOrder.getSelectedIndex() ==2){
                    menuNew.BurbujaxCalorias();
                    textAMostrar.setText(" ");
                    for (int i=0;i<menuNew.getArregloBurbuja().size();i++){
                        textAMostrar.append(menuNew.getArregloBurbuja().get(i) + "\n");
                    }
                }if (comboBoxOrder.getSelectedIndex() ==3){
                    menuNew.BurbujaxTiempo();
                    textAMostrar.setText(" ");
                    for (int i=0;i<menuNew.getArregloBurbuja().size();i++){
                        textAMostrar.append(menuNew.getArregloBurbuja().get(i) + "\n");
                    }
                }

            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
    public void activarModificar(){
        textoModifPrecio.setEditable(true);
        textoModifCalorias.setEditable(true);
        textoModifPreparacion.setEditable(true);
    }public void desActivarModificar(){
        textoModifPrecio.setEditable(false);
        textoModifCalorias.setEditable(false);
        textoModifPreparacion.setEditable(false);
    }
    public void modificarPrecio(Plato empleadoModificar,double precio){
        empleadoModificar.setPrecioPlato(precio);
        JOptionPane.showMessageDialog(null,"Se ha modificado con exito el precio");
    }
    public void modificarCalorias(Plato empleadoModificar,double calorias){

        empleadoModificar.setCalorias(calorias);
        JOptionPane.showMessageDialog(null, "Se ha modificado con exito las calorias");

    }
    public void modificarTiempoPreparacion(Plato empleadoModificar,int tiempoP){

        empleadoModificar.setTimepoPreparacion(tiempoP);
        JOptionPane.showMessageDialog(null,"Se ha modificado con exito el tiempo");
    }
}
