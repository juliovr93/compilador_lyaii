/**
 * @author Ramirez García Juana Rubi
 * @author Valle Rodriguez Julio Cesar
 */

package compilador;

//Componentes para la interfaz
import javax.swing.JFrame;                                                      
import javax.swing.ImageIcon;                                                   

//Componentes para Look And Feel
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import javax.swing.UIManager;

//Componentes para Abrir Documento
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

//Componente para usar ArrayList
import java.util.ArrayList;

//Componente para Mensajes
import javax.swing.JOptionPane;

//Componente para mostrar tablas de simbolos
import javax.swing.table.DefaultTableModel;

public class main_compiler extends JFrame{
    
    private File a_Archivo;                                                     // Archivo que se usara para guardar y abrir el codigo fuente
    private int a_Linea=1;                                                      // Contador de numero de linea donde se encuentra el lexema
    private ArrayList <Token> a_TablaDeSimbolos = new ArrayList <Token>();      // ArrayList para Tabla de Simbolos
    private boolean a_bnGuardaArchivo;                                          // Bandera para Guardar Archivo

    public main_compiler() {
        initComponents();                                                       // Inicialización de componentes
        ImageIcon img = new ImageIcon("src/compilador/resource/compiler.png");  // Carga un icono para la aplicación
        setIconImage(img.getImage());                                           // Asigna ícono al proyecto
        setLocationRelativeTo(null);                                            // Centra la ventana
        TextLineNumber tln_contador=new TextLineNumber(a_txtpCodigo);           // Carga la libreria TextLineNumber para numerar las lineas de codigo
        a_scrllCodigo.setRowHeaderView(tln_contador);                           // Agregar la libreria al scroll del codigo
        setExtendedState(this.MAXIMIZED_BOTH);                                  // Maximiza la ventana
        setVisible(true);                                                       // Hace visible la ventana al usuario
    }
    
    //Generacion de Componente
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        a_ToolBar = new javax.swing.JToolBar();
        a_btnNuevo = new javax.swing.JButton();
        a_btnAbrir = new javax.swing.JButton();
        a_btnGuardar = new javax.swing.JButton();
        a_btnGuardarComo = new javax.swing.JButton();
        a_btnCompilar = new javax.swing.JButton();
        a_pnlCodigo = new javax.swing.JPanel();
        a_scrllCodigo = new javax.swing.JScrollPane();
        a_txtpCodigo = new javax.swing.JTextPane();
        a_pnlSimbolos = new javax.swing.JPanel();
        a_scrllSimbolos = new javax.swing.JScrollPane();
        a_tblSimbolos = new javax.swing.JTable();
        a_pnlConsola = new javax.swing.JPanel();
        a_scrllConsola = new javax.swing.JScrollPane();
        a_txtaConsola = new javax.swing.JTextArea();
        a_MenuBar = new javax.swing.JMenuBar();
        a_mnuArchivo = new javax.swing.JMenu();
        a_mniNuevo = new javax.swing.JMenuItem();
        a_mniAbrir = new javax.swing.JMenuItem();
        a_mniGuardar = new javax.swing.JMenuItem();
        a_mniGuardarComo = new javax.swing.JMenuItem();
        a_mniSalir = new javax.swing.JMenuItem();
        a_mnuHerramientas = new javax.swing.JMenu();
        a_mniCompilar = new javax.swing.JMenuItem();
        a_mnuAyuda = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");

        a_ToolBar.setFloatable(false);
        a_ToolBar.setRollover(true);

        a_btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/resource/new.png"))); // NOI18N
        a_btnNuevo.setText("Nuevo");
        a_btnNuevo.setFocusable(false);
        a_btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        a_btnNuevo.setMaximumSize(new java.awt.Dimension(100, 47));
        a_btnNuevo.setMinimumSize(new java.awt.Dimension(100, 47));
        a_btnNuevo.setPreferredSize(new java.awt.Dimension(100, 47));
        a_btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_btnNuevoActionPerformed(evt);
            }
        });
        a_ToolBar.add(a_btnNuevo);

        a_btnAbrir.setText("Abrir");
        a_btnAbrir.setFocusable(false);
        a_btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        a_btnAbrir.setMaximumSize(new java.awt.Dimension(100, 47));
        a_btnAbrir.setMinimumSize(new java.awt.Dimension(100, 47));
        a_btnAbrir.setPreferredSize(new java.awt.Dimension(100, 47));
        a_btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_btnAbrirActionPerformed(evt);
            }
        });
        a_ToolBar.add(a_btnAbrir);

        a_btnGuardar.setText("Guardar");
        a_btnGuardar.setEnabled(false);
        a_btnGuardar.setFocusable(false);
        a_btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        a_btnGuardar.setMaximumSize(new java.awt.Dimension(100, 47));
        a_btnGuardar.setMinimumSize(new java.awt.Dimension(100, 47));
        a_btnGuardar.setPreferredSize(new java.awt.Dimension(100, 47));
        a_btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_btnGuardarActionPerformed(evt);
            }
        });
        a_ToolBar.add(a_btnGuardar);

        a_btnGuardarComo.setText("Guardar como...");
        a_btnGuardarComo.setEnabled(false);
        a_btnGuardarComo.setFocusable(false);
        a_btnGuardarComo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        a_btnGuardarComo.setMaximumSize(new java.awt.Dimension(200, 47));
        a_btnGuardarComo.setMinimumSize(new java.awt.Dimension(200, 47));
        a_btnGuardarComo.setPreferredSize(new java.awt.Dimension(200, 47));
        a_btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_btnGuardarComoActionPerformed(evt);
            }
        });
        a_ToolBar.add(a_btnGuardarComo);

        a_btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/resource/build.png"))); // NOI18N
        a_btnCompilar.setText("Compilar");
        a_btnCompilar.setToolTipText("Compilar");
        a_btnCompilar.setEnabled(false);
        a_btnCompilar.setFocusable(false);
        a_btnCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        a_btnCompilar.setMaximumSize(new java.awt.Dimension(120, 47));
        a_btnCompilar.setMinimumSize(new java.awt.Dimension(120, 47));
        a_btnCompilar.setPreferredSize(new java.awt.Dimension(120, 47));
        a_btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_btnCompilarActionPerformed(evt);
            }
        });
        a_ToolBar.add(a_btnCompilar);

        a_pnlCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder("Codígo"));

        a_txtpCodigo.setEnabled(false);
        a_scrllCodigo.setViewportView(a_txtpCodigo);

        javax.swing.GroupLayout a_pnlCodigoLayout = new javax.swing.GroupLayout(a_pnlCodigo);
        a_pnlCodigo.setLayout(a_pnlCodigoLayout);
        a_pnlCodigoLayout.setHorizontalGroup(
            a_pnlCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a_pnlCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(a_scrllCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                .addContainerGap())
        );
        a_pnlCodigoLayout.setVerticalGroup(
            a_pnlCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a_pnlCodigoLayout.createSequentialGroup()
                .addComponent(a_scrllCodigo)
                .addContainerGap())
        );

        a_pnlSimbolos.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla de Simbolos"));

        a_tblSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        a_scrllSimbolos.setViewportView(a_tblSimbolos);

        javax.swing.GroupLayout a_pnlSimbolosLayout = new javax.swing.GroupLayout(a_pnlSimbolos);
        a_pnlSimbolos.setLayout(a_pnlSimbolosLayout);
        a_pnlSimbolosLayout.setHorizontalGroup(
            a_pnlSimbolosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a_pnlSimbolosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(a_scrllSimbolos, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );
        a_pnlSimbolosLayout.setVerticalGroup(
            a_pnlSimbolosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(a_pnlSimbolosLayout.createSequentialGroup()
                .addComponent(a_scrllSimbolos, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        a_pnlConsola.setBorder(javax.swing.BorderFactory.createTitledBorder("Consola"));

        a_txtaConsola.setEditable(false);
        a_txtaConsola.setColumns(20);
        a_txtaConsola.setRows(5);
        a_scrllConsola.setViewportView(a_txtaConsola);

        javax.swing.GroupLayout a_pnlConsolaLayout = new javax.swing.GroupLayout(a_pnlConsola);
        a_pnlConsola.setLayout(a_pnlConsolaLayout);
        a_pnlConsolaLayout.setHorizontalGroup(
            a_pnlConsolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a_pnlConsolaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(a_scrllConsola)
                .addContainerGap())
        );
        a_pnlConsolaLayout.setVerticalGroup(
            a_pnlConsolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, a_pnlConsolaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(a_scrllConsola)
                .addContainerGap())
        );

        a_mnuArchivo.setText("Archivo");

        a_mniNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        a_mniNuevo.setText("Nuevo");
        a_mniNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_mniNuevoActionPerformed(evt);
            }
        });
        a_mnuArchivo.add(a_mniNuevo);

        a_mniAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        a_mniAbrir.setText("Abrir");
        a_mniAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_mniAbrirActionPerformed(evt);
            }
        });
        a_mnuArchivo.add(a_mniAbrir);

        a_mniGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        a_mniGuardar.setText("Guardar");
        a_mniGuardar.setEnabled(false);
        a_mniGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_mniGuardarActionPerformed(evt);
            }
        });
        a_mnuArchivo.add(a_mniGuardar);

        a_mniGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        a_mniGuardarComo.setText("Guardar como...");
        a_mniGuardarComo.setEnabled(false);
        a_mniGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_mniGuardarComoActionPerformed(evt);
            }
        });
        a_mnuArchivo.add(a_mniGuardarComo);

        a_mniSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        a_mniSalir.setText("Salir");
        a_mnuArchivo.add(a_mniSalir);

        a_MenuBar.add(a_mnuArchivo);

        a_mnuHerramientas.setText("Herramientas");

        a_mniCompilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.CTRL_MASK));
        a_mniCompilar.setText("Compilar");
        a_mnuHerramientas.add(a_mniCompilar);

        a_MenuBar.add(a_mnuHerramientas);

        a_mnuAyuda.setText("Ayuda");
        a_MenuBar.add(a_mnuAyuda);

        setJMenuBar(a_MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a_ToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_pnlConsola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(a_pnlCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a_pnlSimbolos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(a_ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_pnlCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a_pnlSimbolos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_pnlConsola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_NuevoArchivo(){
        int  v_opcion;                                                          // Variable para captura de opciones
        if(!a_txtpCodigo.getText().equals("")){                                 // Analiza si el textpane se encuentra vacio
            // Si el documento no se ecuentra vacio pregunta si se desea guardar el documento
            v_opcion=JOptionPane.showConfirmDialog(this,"¿Desea guardar el documento?");
            if(v_opcion==0)                                                     // Si la opcion es "si"
                m_Guardar();                                                    // Llama el metodo para guardar el documento
                a_txtpCodigo.setText("");                                       // Limpia el textpane para generar un nuevo codigo fuente
                a_txtpCodigo.setEnabled(true);                                  // Habilita el textpane para editarlo
                a_mniGuardar.setEnabled(true);                                  // Habilita el JMenuItem Guardar
                a_mniGuardarComo.setEnabled(true);                              // Habilita el JMenuItem Guardar como
                a_btnGuardar.setEnabled(true);                                  // Habilita el JButton Guardar del JToolBar
                a_btnGuardarComo.setEnabled(true);                              // Habilita el JButton Guardar como del JToolBar
                a_btnCompilar.setEnabled(true);                                 // Habilita el JButton Compilar del JToolBar
                a_bnGuardaArchivo=true;                                         // Cambia el estado de la bandera bnGuardarArchivo a verdadero
            if(v_opcion==1){                                                    // Si la opcion es "no"
                a_txtpCodigo.setText("");                                       // Limpia el textpane para generar un nuevo codigo fuente
                a_txtpCodigo.setEnabled(true);                                  // Habilita el textpane para editarlo
                a_mniGuardar.setEnabled(true);                                  // Habilita el JMenuItem Guardar
                a_mniGuardarComo.setEnabled(true);                              // Habilita el JMenuItem Guardar como
                a_btnGuardar.setEnabled(true);                                  // Habilita el JButton Guardar del JToolBar
                a_btnGuardarComo.setEnabled(true);                              // Habilita el JButton Guardar como del JToolBar
                a_btnCompilar.setEnabled(true);                                 // Habilita el JButton Compilar del JToolBar
                a_bnGuardaArchivo=true;                                         // Cambia el estado de la bandera bnGuardarArchivo a verdadero
            }
        }else{                                                                  // Si el documento se encuentra vacio
            a_txtpCodigo.setText("");                                           // Limpia el textpane para generar un nuevo codigo fuente
            a_txtpCodigo.setEnabled(true);                                      // Habilita el textpane para editarlo
            a_mniGuardar.setEnabled(true);                                      // Habilita el JMenuItem Guardar
            a_mniGuardarComo.setEnabled(true);                                  // Habilita el JMenuItem Guardar como
            a_btnGuardar.setEnabled(true);                                      // Habilita el JButton Guardar del JToolBar
            a_btnGuardarComo.setEnabled(true);                                  // Habilita el JButton Guardar como del JToolBar
            a_btnCompilar.setEnabled(true);                                     // Habilita el JButton Compilar del JToolBar
            a_bnGuardaArchivo=true;                                             // Cambia el estado de la bandera bnGuardarArchivo a verdadero
        }
    }
    
    private void m_AbrirArchivo(){
                               
        JFileChooser v_AbrirArchivo=new JFileChooser();                         // Genera un nuevo JFileChooser para abrir el archivo
        // Filtro para mostrar solo los archivos con extension *.lya
        v_AbrirArchivo.setFileFilter(new FileNameExtensionFilter("Todos los archivos *.lya","lya","LYA"));
        int v_Seleccion =v_AbrirArchivo.showDialog(null,"Abrir");               // Se comprueba si ha aceptado abrir el archivo
        if(v_Seleccion==JFileChooser.APPROVE_OPTION){                           // Si la opcion fue aceptar
            try{            
                a_Archivo = v_AbrirArchivo.getSelectedFile();                   // Se abre el documento en un JFile (a_Archivo)
                String v_Linea;                                                 // Se crea una variable para leer el documento linea por linea (v_Linea)
                String v_codigoFuente="";                                       // Se crea una variable que contendra todo el texto del documento (v_codigoFuente)
                FileReader v_frArchivo=new FileReader(a_Archivo);               // Se usa un FileReader para leer el archivo almacenado en a_Archivo (v_frArchivo)
                BufferedReader v_brArchivo=new BufferedReader(v_frArchivo);     // Se usa un BufferedReader para leer el archivo contenido en v_frArchivo de manera más optima (v_brArchivo)
                while((v_Linea=v_brArchivo.readLine())!=null){                  // Se lee la linea actual del BufferedReader (v_brArchivo) y se compara que sea diferente a nulo
                    v_codigoFuente+=v_Linea+"\n";                               // Si la linea es diferente de nulo añade la linea a la variable que contendra el texto del codigo fuente
                }
                a_txtpCodigo.setText(v_codigoFuente);                           // Inserta el texto del documento en el JTextPane (a_txtpCodigo)
                a_txtpCodigo.setEnabled(true);                                  // Habilita el JTextPane para editar el documento
                a_mniGuardar.setEnabled(true);                                  // Habilita el MenuItem para Guardar
                a_mniGuardarComo.setEnabled(true);                              // Habilita el MenuItem para Guardar Como...
                a_btnGuardar.setEnabled(true);                                  // Habilita el Button para Guardar
                a_btnGuardarComo.setEnabled(true);                              // Habilita el Button para Guardar Como...
                a_btnCompilar.setEnabled(true);                                 // Habilita el Button para Compilar
                v_brArchivo.close();                                            // Cierra el BufferedReader (v_brArchivo)
                v_frArchivo.close();                                            // Cierra el FileReader (v_frArchivo)
            }catch(Exception Ex){
                JOptionPane.showMessageDialog(this,"Error al abrir el archivo");//Mensaje de error al abrir el archivo
            }
        }
    }
    
    private void m_Guardar(){
        if(!a_bnGuardaArchivo){                                                 // Revisa la bandera para guardar el documento
            try{                                
                BufferedWriter v_bwArchivo;                                     // Crea un BufferedWriter para escribir el codigo fuente (v_bwArchivo)
                v_bwArchivo = new BufferedWriter(new FileWriter(a_Archivo));    // Inicializa el BufferedWriter para escribir el codigo fuente
                v_bwArchivo.write(a_txtpCodigo.getText());                      // Escribe nuestro codigo fuente almacenado en a_txtpCodigo
                v_bwArchivo.close();                                            // Cierra el BufferedWriter para guardar los cambios en el archivo
            }catch(Exception Ex){
                JOptionPane.showMessageDialog(this,"Error al guardar el archivo");//Mensaje de error al guardar el archivo
            }
        }else
            m_GuardarComo();                                                    // Llama el método para guardar un nuevo documento
    }
    
    private void m_GuardarComo(){
        JFileChooser v_GuardarArchivo=new JFileChooser();                       // Genera un nuevo JFileChooser para guardar el archivo
        //Filtro para mostrar solo los archivos con extension *.lya
        v_GuardarArchivo.addChoosableFileFilter(new FileNameExtensionFilter("Todos los archivos *.lya","lya","LYA"));
        int v_Seleccion = v_GuardarArchivo.showSaveDialog(null);                // Comprueba que haya presionado aceptar
        if(v_Seleccion==JFileChooser.APPROVE_OPTION){                           // Si acepto guardar el archivo
            try{
                a_Archivo = v_GuardarArchivo.getSelectedFile();                 // Se genera el archivo en un File (a_Archivo)
                String v_path= a_Archivo.getAbsolutePath();                     // Obtenemos el path del archivo a guardar
                PrintWriter v_pwArchivo = new PrintWriter(a_Archivo);           // Se genera un PrintWriter para escribir nuestro archivo en el disco duro
                v_pwArchivo.print(a_txtpCodigo.getText());                      // Se escribe el codigo fuente almacenado en a_txtpCodigo
                v_pwArchivo.close();                                            // Se cierra el archivo para escribirlo
                if(!v_path.endsWith(".lya")){                                   // Se comprueba que el archivo se haya guardado en la ruta correcta
                    File v_tempArchivo = new File(v_path+".lya");               // Si no genera un nuevo archivo para renombrarlo
                    a_Archivo.renameTo(v_tempArchivo);                          // Renombra el nuevo archivo
                }
                a_bnGuardaArchivo=false;                                        // Cambia la bandera a_bnGuardaArchivo a falso
            }catch(Exception Ex){
                JOptionPane.showMessageDialog(this,"Error al guardar el archivo");//Mensaje en caso de error al guardar el archivo
            }
        }
    }
    
    private void m_Lexico(){
        try{
            String v_Linea;                                                     // Se crea una variable para leer el documento linea por linea
            String v_codigoFuente="";                                           // Se crea una variable que contendra todo el texto del archivo
            FileReader v_frArchivo=new FileReader(a_Archivo);                   // Se usa un FileReader para leer el documento (v_frArchivo)
            BufferedReader v_brArchivo=new BufferedReader(v_frArchivo);         // Se usa un BufferedReader para leer el archivo contenido en v_frArchivo de manera más optima (v_brArchivo)
            while((v_Linea=v_brArchivo.readLine())!=null){                      // Se lee la linea actual del BufferedReader (v_brArchivo) y se compara que sea diferente a nulo
                v_codigoFuente+=v_Linea+"\n";                                   // Si la linea es diferente de nulo añade la linea a la variable que contendra el texto del documento
            }
            v_brArchivo.close();                                                // Cierra el BufferedReader (v_brArchivo)
            v_frArchivo.close();                                                // Cierra el FileReader (v_brArchivo)
            while(v_codigoFuente!=""){                                          // Analiza el codigo fuente mientras sea difernte de ""
                v_codigoFuente=m_anaLexico(v_codigoFuente);                     // Llama al método del ánalisis léxico y envía el código fuente como parámetro
            }
        }catch(Exception Ex){
            JOptionPane.showMessageDialog(this,"Error al abrir el archivo");    // Mensaje en caso de error al abrir el archivo
        }
    }
    
    private String m_anaLexico(String p_Palabra){
        int v_Recorrido=0,v_Indice=0;                                           // Variables de control para el recorrido del codigo fuente
        boolean v_Inserta=false;                                                // Bandera para control de insercion de token
        boolean v_errLexema=false;                                              // Bandera para control de error de lexemas
        /*********************  Saltos de Linea  ******************************/
        while(p_Palabra.charAt(0)==10){                                         // Compara el carácter con el numero 10 (Salto de Linea)
            p_Palabra=p_Palabra.substring(1,p_Palabra.length());                // Mientras encuentre saltos de lineas omite dichos carácteres y reduce el tamaño del string en 
            a_Linea++;                                                          // Aumenta en uno el contador de lineas
        }
        /*********************  Espacios  *************************************/
        while(p_Palabra.charAt(0)==' '){                                        // Compara el carácter con un espacio 
            p_Palabra=p_Palabra.substring(1,p_Palabra.length());                // Mientras encuentre saltos de lineas omite dichos carácteres y reduce el tamaño del string en 1
        }
        /*********************  Palabras Reservadas ***************************/
        PalabrasReservadas v_PalabrasReserv=new PalabrasReservadas();           // Llama a la clase PalabrasReservadas para detectar palabras reservadas en el código fuente
        v_Recorrido = v_PalabrasReserv.getPalabrasReservadas(p_Palabra);        // Manda llamar el metodo getPalabrasReservadas para regresar el numero de caracteres que componen a la palabra reservada
        if(0!=v_Recorrido){                                                     // Compara si recorrido del codigo fuente es diferente de 0
            m_AddToken(p_Palabra.substring(0,v_Recorrido),3);                   // Si el recorrido es diferente de 0 encontro una palabra reservada y añade el token a la tabla de simbolos
            v_Inserta=true;                                                     // Cambia la bandera de control de insercion a cierto
            v_Indice=v_Recorrido;                                               // Sustrae el recorrigo del codigo fuente y lo guarda en v_Indice
        }
        /********************  Operadores  ************************************/
        Operadores v_Operadores=new Operadores();                               // Llama a la clase Operadores para detectar operadores en el código fuente
        v_Recorrido = v_Operadores.getOperadores(p_Palabra);                    // Manda llamar el método getOperadores para regresar el número de caráceres que componen al operador
        if(0!=v_Recorrido){                                                     // Compara si recorrido del codigo fuente es diferente de 0
            m_AddToken(p_Palabra.substring(0,v_Recorrido),2);                   // Si el recorrido es diferente de 0 encontro un operador y añade el token a la tabla de simbolos
            v_Inserta=true;                                                     // Cambia la bandera de control de insercion a cierto
            v_Indice=v_Recorrido;                                               // Sustrae el recorrigo del codigo fuente y lo guarda en v_Indice
        }
        /*********************  Delimitadores  ********************************/
        Delimitadores v_Delimitadores=new Delimitadores();                      // Llama a la clase Delimitadores para detectar delimitadores en el código fuente
        v_Recorrido = v_Delimitadores.getDelimitadores(p_Palabra);              // Manda llamar el método getDelimitadores para regresar el número de carácteres que componen al delimitador
        if(0!=v_Recorrido){                                                     // Compara si recorrido del codigo fuente es diferente de 0
            m_AddToken(p_Palabra.substring(0,v_Recorrido),1);                   // Si el recorrido es diferente de 0 encontro un delimitador y añade el token a la tabla de simbolos
            v_Inserta=true;                                                     // Cambia la bandera de control de insercion a cierto
            v_Indice=v_Recorrido;                                               // Sustrae el recorrigo del codigo fuente y lo guarda en v_Indice
        }        
        /********************  Datos  *****************************************/
        Datos v_Datos=new Datos();                                              // Llama a la clase Datos para detectar los tipos de datos en el código fuente
        v_Recorrido = v_Datos.getDatos(p_Palabra);                              // Manda llamar el método getDatos para regresar el número de carácteres que componen al tipo de dato
        if(0!=v_Recorrido){                                                     // Compara si recorrido del código fuente es diferente de 0
            if(v_Recorrido>0){                                                  // Compara si el recorrido del código fue mayor a 0
                m_AddToken(p_Palabra.substring(0,v_Recorrido),5);               // Si el recorrido es mayor de 0 encontro un tipo de datos y añade el token a la tabla de simbolos
                v_Inserta=true;                                                 // Cambia la bandera de control de insercion a cierto
                v_Indice=v_Recorrido;                                           // Sustrae el recorrigo del codigo fuente y lo guarda en v_Indice
                v_Recorrido=0;                                                  // Reinicia el valor del reco rrido a 0
            }
            else{
                p_Palabra=p_Palabra.substring(0,v_Recorrido);                   // Si el recorrido es menor de 0 indica un error en los tipos de datos cadena
                v_errLexema=true;                                               // Cambia la bandera v_errLexema a cierto
            }
        }              
        /********************  Identificadores  *******************************/
        Identificadores v_Ident=new Identificadores();                          // Llama a la clase Identificadores para detectar los tipos de datos en el código fuente
        v_Recorrido = v_Ident.getIndentificador(p_Palabra);                     // Manda llamar el método getIdentificadores para regresar el número de carácteres que componen al tipo de dato
        if(0!=v_Recorrido){                                                     // Compara si el recorrido del código fuente es diferente de 0
            m_AddToken(p_Palabra.substring(0,v_Recorrido),4);                   // Si el recorrido es mayor de 0 encontro un identificador y añade el token a la tabla de simbolos
            v_Inserta=true;                                                     // Cambia la bandera de control de insercion a cierto
            v_Indice=v_Recorrido;                                               // Sustrae el recorrigo del codigo fuente y lo guarda en v_Indice
        }
        /********************  Verificacion de Inserción   ********************/        
        if(v_Inserta){                                                          // Verifica que el simbolo se haya insertado
            if(v_Indice!=p_Palabra.length())                                    // Verifica que la palabra a analizar se haya termiando
                p_Palabra=p_Palabra.substring(v_Indice,p_Palabra.length());
            else
                p_Palabra="";
        }
        else{
            if(v_Indice!=p_Palabra.length()-1){
                if(v_errLexema){
                    a_txtaConsola.setText(a_txtaConsola.getText()+"Error [180]: No se encuentra simbolo: '"+p_Palabra.charAt(0)+"'\n");
                    a_txtaConsola.setText(a_txtaConsola.getText()+"Error en la linea: "+a_Linea+"\n");
                    p_Palabra=p_Palabra.substring(1,p_Palabra.length());
                }else{
                    a_txtaConsola.setText(a_txtaConsola.getText()+"Error [182]: Cadena no completada: '"+p_Palabra.charAt(0)+"'\n");
                    a_txtaConsola.setText(a_txtaConsola.getText()+"Error en la linea: "+a_Linea+"\n");
                }
            }else{
                p_Palabra="";
            }
        }
        return p_Palabra;
    }
    
    private boolean m_BuscaToken(String p_Palabra){
        boolean v_Bandera=false;
        for(int v_indice=0;v_indice<a_TablaDeSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaDeSimbolos.get(v_indice);
            if(v_Temporal.m_getPalabra().equals(p_Palabra))
                v_Bandera=true;
        }
        return v_Bandera;
    }
    
    private void m_AddToken(String p_Palabra,int p_Tipo){
        if(!m_BuscaToken(p_Palabra)){
            int v_ID = a_TablaDeSimbolos.size()+1;
            Token v_newSimbolo = new Token(v_ID,p_Palabra,p_Tipo);
            a_TablaDeSimbolos.add(v_newSimbolo);
        }        
    }
    
    void m_creaTabla(){
        String[] v_tblModel=new String[]{"ID","Lexema","Tipo"};
        DefaultTableModel v_Modelo=new DefaultTableModel(null,v_tblModel);
        a_tblSimbolos.setModel(v_Modelo);
        String[] v_Datos={"","",""};
        for(int v_indice=0;v_indice<a_TablaDeSimbolos.size();v_indice++){
            Token v_Temporal=a_TablaDeSimbolos.get(v_indice);
            v_Datos[0]=v_Temporal.m_getID()+"";
            v_Datos[1]=v_Temporal.m_getPalabra();
            v_Datos[2]=v_Temporal.m_getTipo()+"";
            v_Modelo.addRow(v_Datos);
        }
    }
    
    
    private void a_mniNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_mniNuevoActionPerformed
        m_NuevoArchivo();
    }//GEN-LAST:event_a_mniNuevoActionPerformed

    private void a_mniAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_mniAbrirActionPerformed
        m_AbrirArchivo();
    }//GEN-LAST:event_a_mniAbrirActionPerformed

    private void a_btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_btnCompilarActionPerformed
        m_Guardar();
        a_TablaDeSimbolos = new ArrayList<Token>();
        m_Lexico();
        m_creaTabla();
        System.out.println("Termino Analizador Lexico");
    }//GEN-LAST:event_a_btnCompilarActionPerformed

    private void a_mniGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_mniGuardarActionPerformed
        m_Guardar();
    }//GEN-LAST:event_a_mniGuardarActionPerformed

    private void a_btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_btnNuevoActionPerformed
        m_NuevoArchivo();
    }//GEN-LAST:event_a_btnNuevoActionPerformed

    private void a_btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_btnGuardarActionPerformed
        m_Guardar();
    }//GEN-LAST:event_a_btnGuardarActionPerformed

    private void a_btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_btnAbrirActionPerformed
        m_AbrirArchivo();
    }//GEN-LAST:event_a_btnAbrirActionPerformed

    private void a_btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_btnGuardarComoActionPerformed
        m_GuardarComo();
    }//GEN-LAST:event_a_btnGuardarComoActionPerformed

    private void a_mniGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_mniGuardarComoActionPerformed
        m_GuardarComo();
    }//GEN-LAST:event_a_mniGuardarComoActionPerformed

    public static void main(String args[]) {
        try{
            UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());         //Carga el tema look and feel
        }catch (Exception e){
            e.printStackTrace();
        }
        main_compiler o_compiler=new main_compiler();                           //Generación del Objeto
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar a_MenuBar;
    private javax.swing.JToolBar a_ToolBar;
    private javax.swing.JButton a_btnAbrir;
    private javax.swing.JButton a_btnCompilar;
    private javax.swing.JButton a_btnGuardar;
    private javax.swing.JButton a_btnGuardarComo;
    private javax.swing.JButton a_btnNuevo;
    private javax.swing.JMenuItem a_mniAbrir;
    private javax.swing.JMenuItem a_mniCompilar;
    private javax.swing.JMenuItem a_mniGuardar;
    private javax.swing.JMenuItem a_mniGuardarComo;
    private javax.swing.JMenuItem a_mniNuevo;
    private javax.swing.JMenuItem a_mniSalir;
    private javax.swing.JMenu a_mnuArchivo;
    private javax.swing.JMenu a_mnuAyuda;
    private javax.swing.JMenu a_mnuHerramientas;
    private javax.swing.JPanel a_pnlCodigo;
    private javax.swing.JPanel a_pnlConsola;
    private javax.swing.JPanel a_pnlSimbolos;
    private javax.swing.JScrollPane a_scrllCodigo;
    private javax.swing.JScrollPane a_scrllConsola;
    private javax.swing.JScrollPane a_scrllSimbolos;
    private javax.swing.JTable a_tblSimbolos;
    private javax.swing.JTextArea a_txtaConsola;
    private javax.swing.JTextPane a_txtpCodigo;
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables
}
