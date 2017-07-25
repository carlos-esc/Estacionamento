package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import mascarasentrada.EntradaDado;
import mascarasentrada.EntradaValor;
import validacao.VerificadorEntradaDado;
import calculo.RotativoCalculoSaida;
import modelo.Veiculo;
import modelo.Patio;
import service.VeiculoService;
import service.PatioService;
import service.RotativoService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import mascarasentrada.EntradaHora;
import modelo.Configuracoes;
import modelo.Mensalista;
import modelo.Pacote;
import modelo.Rotativo;
import service.ConfiguracoesService;
import service.MensalistaService;
import service.PacoteService;
import validacao.ValidaCPF;

public class TelaPrincipal extends javax.swing.JFrame {

    //VEÍCULO******************************************************************************************
    VeiculoService veiculoService = new VeiculoService();
    Veiculo veiculo = new Veiculo();

    //MENSALISTA***************************************************************************************
    String mensalistaStatus;
    String mensalistaNomePesquisa = "";
    MensalistaService mensalistaService = new MensalistaService();
    Mensalista mensalista = new Mensalista();
    List<Mensalista> mensalistaArrayList = new ArrayList<>();
    DefaultListModel mensalistaDefaultListModel = new DefaultListModel();
    DefaultTableModel mensalistaDefaultTableModel = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            /*try {
                MaskFormatter cpf = new MaskFormatter("###.###.###-##");
                JFormattedTextField jftf = new JFormattedTextField(cpf);
                TableColumn colunaCpf = jTableMensalista.getColumnModel().getColumn(1);
                colunaCpf.setCellEditor(new DefaultCellEditor(jftf));
            } catch (ParseException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            return false;
        }
    };

    //ROTATIVO*****************************************************************************************
    String rotativoNomeAnterior;
    RotativoService rotativoService = new RotativoService();
    Rotativo rotativo = new Rotativo();
    List<Rotativo> rotativoArrayList = new ArrayList<>();
    DefaultListModel rotativoDefaultListModel = new DefaultListModel(); //Carregar o jList com os tipos de rotativo EX: carro, moto, bicicleta ETC...
    DefaultTableModel rotativoDefaultTableModel = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //PACOTE*****************************************************************************************
    String pacoteNomeAnterior;
    PacoteService pacoteService = new PacoteService();
    Pacote pacote = new Pacote();
    List<Pacote> pacoteArrayList = new ArrayList<>();
    DefaultListModel pacoteDefaultListModel = new DefaultListModel(); //Carregar o jList com os tipos de rotativo EX: carro, moto, bicicleta ETC...
    DefaultTableModel pacoteDefaultTableModel = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //PÁTIO********************************************************************************************
    String patioOrdenarLista;
    PatioService patioService = new PatioService();
    Patio patio = new Patio();
    List<Patio> patioArrayList = new ArrayList<>();
    DefaultTableModel patioDefaultTableModel = new DefaultTableModel();

    //MOVIMENTO****************************************************************************************
    String movimentoData;
    List<Patio> movimentoArrayList = new ArrayList<>();
    DefaultTableModel movimentoDefaultTableModel = new DefaultTableModel();

    //CONGRAÇÕES***************************************************************************************
    ConfiguracoesService configuracoesService = new ConfiguracoesService();
    Configuracoes configuracoes = new Configuracoes();

    //OUTROS*******************************************************************************************
    VerificadorEntradaDado verificadorEntradaDado = new VerificadorEntradaDado();
    DefaultTableModel movimentacoesDefaultTableModel = new DefaultTableModel();
    private String ok, dadoEntrada, dadoRetornoTipo;
    SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
    SimpleDateFormat dataAtual = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat horaAtual = new SimpleDateFormat("HH:mm");

    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jDialogConfirmaSaidaVeiculo = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButtonSaidaVeiculoNao = new javax.swing.JButton();
        jButtonSaidaVeiculoSim = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldConfirmaSaidaPlaca = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldConfirmaSaidaPrisma = new javax.swing.JTextField();
        jDialogConfirmaEntradaVeiculo = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jButtonEntradaVeiculoNao = new javax.swing.JButton();
        jButtonEntradaVeiculoSim = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldConfirmaSaidaPlaca1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextFieldConfirmaSaidaPrisma1 = new javax.swing.JTextField();
        jDialogConfirmaSaidaSistema = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jButtonSaidaSistemaNao = new javax.swing.JButton();
        jButtonSaidaSistemaSim = new javax.swing.JButton();
        jPanelCabecalho = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelOpcoes = new javax.swing.JPanel();
        jTabbedPaneOpcoes = new javax.swing.JTabbedPane();
        jPanelEntradaSaida = new javax.swing.JPanel();
        jTabbedPaneEntradaSaida = new javax.swing.JTabbedPane();
        jPanelApresentacao = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableEntradaSaidaInformacoesRotativo = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtInformacoesToleranciaDesistencia = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtInformacoesToleranciaFracoes = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtInformacoesDiariaHora = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtInformacoesDiariaMinuto = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        txtInformacoesPernoiteInicio = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtInformacoesPernoiteTermino = new javax.swing.JTextField();
        jPanelVeiculoEntrada = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldEntradaPlaca = new javax.swing.JTextField();
        jTextFieldEntradaPrisma = new javax.swing.JTextField();
        jTextFieldRotativoTipo = new javax.swing.JTextField();
        jTextFieldEntradaData = new javax.swing.JTextField();
        jTextFieldEntradaHora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRotativoTipo = new javax.swing.JList<>();
        jPanelVeiculoSaida = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldSaidaPlaca = new javax.swing.JTextField();
        jTextFieldSaidaPrisma = new javax.swing.JTextField();
        jTextFieldSaidaTipo = new javax.swing.JTextField();
        jTextFieldSaidaDataEntrada = new javax.swing.JTextField();
        jTextFieldSaidaHoraEntrada = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldSaidaData = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldSaidaHora = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldSaidaPermanenciaTotal = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldSaidaControle = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldSaidaHMEntrada = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldSaidaDiarias = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldSaidaPernoites = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldSaidaHMSaida = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldSaidaValor = new javax.swing.JTextField();
        jLabelPlacaOuPrisma = new javax.swing.JLabel();
        txtEntradaPlacaOuPrisma = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPaneMovimentacoes = new javax.swing.JScrollPane();
        jTableEntradaSaidaMovimentacoesRotativo = new javax.swing.JTable();
        jPanelMensal = new javax.swing.JPanel();
        jTabbedPaneMensalista = new javax.swing.JTabbedPane();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMensalista = new javax.swing.JTable();
        jPanel40 = new javax.swing.JPanel();
        jButtonMensalistaPesquisaIncluir = new javax.swing.JButton();
        jButtonMensalistaPesquisaSair = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jTextFieldMensalistaNomePesquisa = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jButtonMensalistaPesquisaPerquisar = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        jButtonMensalistaPesquisaConsultar = new javax.swing.JButton();
        jButtonMensalistaPesquisaAlterar = new javax.swing.JButton();
        jButtonMensalistaPesquisaExcluir = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jTextFieldMensalistaEmail = new javax.swing.JTextField();
        jTextFieldMensalistaIdentidade = new javax.swing.JTextField();
        jTextFieldMensalistaComplementoResi = new javax.swing.JTextField();
        jTextFieldMensalistaNome = new javax.swing.JTextField();
        jTextFieldMensalistaRuaResi = new javax.swing.JTextField();
        jTextFieldMensalistaNumeroResi = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jTextFieldMensalistaBairroResi = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jTextFieldMensalistaCidadeResi = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jTextFieldMensalistaEstadoResi = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jFormattedTextFieldMensalistaDataNascimento = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMensalistaCelularResi = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMensalistaCepResi = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMensalistaTelefoneResi = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMensalistaCpf = new javax.swing.JFormattedTextField();
        jPanel36 = new javax.swing.JPanel();
        jTextFieldMensalistaEmpresa = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jTextFieldMensalistaRuaCome = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jTextFieldMensalistaNumeroCome = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jTextFieldMensalistaComplementoCome = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jTextFieldMensalistaBairroCome = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jTextFieldMensalistaCidadeCome = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jTextFieldMensalistaEstadoCome = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jFormattedTextFieldMensalistaCepCome = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMensalistaTelefoneCome = new javax.swing.JFormattedTextField();
        jPanel29 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jTextFieldMensalistaMontadora01 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jTextFieldMensalistaModelo01 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jTextFieldMensalistaCor01 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jTextFieldMensalistaAno01 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jTextFieldMensalistaMontadora02 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jTextFieldMensalistaModelo02 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jTextFieldMensalistaCor02 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jTextFieldMensalistaAno02 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jTextFieldMensalistaMontadora03 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jTextFieldMensalistaModelo03 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jTextFieldMensalistaCor03 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jTextFieldMensalistaAno03 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jTextFieldMensalistaMontadora04 = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jTextFieldMensalistaModelo04 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jTextFieldMensalistaCor04 = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jTextFieldMensalistaAno04 = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jFormattedTextFieldMensalistaPlaca01 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMensalistaPlaca02 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMensalistaPlaca03 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMensalistaPlaca04 = new javax.swing.JFormattedTextField();
        jPanel38 = new javax.swing.JPanel();
        jButtonMensalistaCadastroOk = new javax.swing.JButton();
        jButtonMensalistaCadastroCancelar = new javax.swing.JButton();
        jLabelMensalistaStatus = new javax.swing.JLabel();
        jButtonMensalistaCadastroAtivarInativar = new javax.swing.JButton();
        jButtonMensalistaCadastroAlterar = new javax.swing.JButton();
        jButtonMensalistaCadastroSair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel31 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jTextFieldMensalistaDiaVencimentoMensalidade = new javax.swing.JTextField();
        jTextFieldMensalistaStatus = new javax.swing.JTextField();
        jFormattedTextFieldMensalistaDataInclusao = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMensalistaDataUltimaAlteracao = new javax.swing.JFormattedTextField();
        jTextFieldMensalistaContratoNumero = new javax.swing.JTextField();
        jPanelPacote = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTablePacote = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabelPacoteQtdDiasOuUtilizacoes = new javax.swing.JLabel();
        jTextFieldPacoteQuantidade = new javax.swing.JTextField();
        jButtonPacoteAlterarOk = new javax.swing.JButton();
        jButtonPacoteSairCancelar = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jTextFieldPacoteValor = new javax.swing.JTextField();
        jButtonPacoteIncluirOk = new javax.swing.JButton();
        jButtonPacoteExcluirCancelar = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jRadioButtonDias = new javax.swing.JRadioButton();
        jRadioButtonUtilizacoes = new javax.swing.JRadioButton();
        jTextFieldPacoteIncluirAlterar = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtRotativoPreco30minutos = new javax.swing.JTextField();
        txtRotativoPreco60minutos = new javax.swing.JTextField();
        txtRotativoPrecoDemaisFracoes = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtRotativoPrecoDiaria = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtRotativoPrecoPernoite = new javax.swing.JTextField();
        jButtonRotativoIncluirOk = new javax.swing.JButton();
        jButtonRotativoExcluirCancelar = new javax.swing.JButton();
        jButtonRotativoAlterarOk = new javax.swing.JButton();
        jButtonRotativoSairCancelar = new javax.swing.JButton();
        jTextFieldRotativoIncluirAlterar = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableRotativo = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTablePatio = new javax.swing.JTable();
        jButtonPatioSair = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButtonPatioListaPlaca = new javax.swing.JButton();
        jButtonPatioListaPrisma = new javax.swing.JButton();
        jButtonPatioListaTipo = new javax.swing.JButton();
        jButtonPatioListaEntrada = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jButtonMovimentoSair = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableMovimento = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jButtonMovimentoListar = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jTabbedPaneConfiguracoesItemAlteracao = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtConfiguracoesToleranciaDesistencia = new javax.swing.JTextField();
        txtConfiguracoesToleranciaFracao = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        txtConfiguracoesDiariaHora = new javax.swing.JTextField();
        txtConfiguracoesDiariaMinuto = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtConfiguracoesPernoiteInicio = new javax.swing.JTextField();
        txtConfiguracoesPernoiteTermino = new javax.swing.JTextField();
        jButtonConfiguracoesAlterarOk = new javax.swing.JButton();
        jButtonConfiguracoesSairCancelar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListConfiguracoes = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButtonF1 = new javax.swing.JButton();
        jButtonF2 = new javax.swing.JButton();
        jButtonF3 = new javax.swing.JButton();
        jButtonF4 = new javax.swing.JButton();
        jButtonF5 = new javax.swing.JButton();
        jButtonF6 = new javax.swing.JButton();
        jButtonF8 = new javax.swing.JButton();
        jButtonF10 = new javax.swing.JButton();

        jDialogConfirmaSaidaVeiculo.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialogConfirmaSaidaVeiculo.setTitle("Estacionamento (Confirma a Saída do Veículo?)");
        jDialogConfirmaSaidaVeiculo.setAlwaysOnTop(true);
        jDialogConfirmaSaidaVeiculo.setResizable(false);
        jDialogConfirmaSaidaVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDialogConfirmaSaidaVeiculoMouseReleased(evt);
            }
        });
        jDialogConfirmaSaidaVeiculo.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                jDialogConfirmaSaidaVeiculoWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogConfirmaSaidaVeiculoWindowClosing(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Confirma saída do veiculo?");

        jButtonSaidaVeiculoNao.setMnemonic('N');
        jButtonSaidaVeiculoNao.setText("Não");
        jButtonSaidaVeiculoNao.setRequestFocusEnabled(false);
        jButtonSaidaVeiculoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaidaVeiculoNaoActionPerformed(evt);
            }
        });

        jButtonSaidaVeiculoSim.setMnemonic('S');
        jButtonSaidaVeiculoSim.setText("Sim");
        jButtonSaidaVeiculoSim.setRequestFocusEnabled(false);
        jButtonSaidaVeiculoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaidaVeiculoSimActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Placa");

        jTextFieldConfirmaSaidaPlaca.setEditable(false);
        jTextFieldConfirmaSaidaPlaca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldConfirmaSaidaPlaca.setFocusable(false);
        jTextFieldConfirmaSaidaPlaca.setRequestFocusEnabled(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTextFieldSaidaPlaca, org.jdesktop.beansbinding.ELProperty.create("${text}"), jTextFieldConfirmaSaidaPlaca, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Prisma");

        jTextFieldConfirmaSaidaPrisma.setEditable(false);
        jTextFieldConfirmaSaidaPrisma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldConfirmaSaidaPrisma.setFocusable(false);
        jTextFieldConfirmaSaidaPrisma.setRequestFocusEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTextFieldSaidaPrisma, org.jdesktop.beansbinding.ELProperty.create("${text}"), jTextFieldConfirmaSaidaPrisma, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConfirmaSaidaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldConfirmaSaidaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonSaidaVeiculoSim, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(jButtonSaidaVeiculoNao)
                        .addGap(207, 207, 207))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonSaidaVeiculoNao, jButtonSaidaVeiculoSim});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldConfirmaSaidaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldConfirmaSaidaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaidaVeiculoSim)
                    .addComponent(jButtonSaidaVeiculoNao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonSaidaVeiculoNao, jButtonSaidaVeiculoSim});

        javax.swing.GroupLayout jDialogConfirmaSaidaVeiculoLayout = new javax.swing.GroupLayout(jDialogConfirmaSaidaVeiculo.getContentPane());
        jDialogConfirmaSaidaVeiculo.getContentPane().setLayout(jDialogConfirmaSaidaVeiculoLayout);
        jDialogConfirmaSaidaVeiculoLayout.setHorizontalGroup(
            jDialogConfirmaSaidaVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogConfirmaSaidaVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogConfirmaSaidaVeiculoLayout.setVerticalGroup(
            jDialogConfirmaSaidaVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogConfirmaSaidaVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogConfirmaEntradaVeiculo.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialogConfirmaEntradaVeiculo.setTitle("Estacionamento (Confirma a Saída do Veículo?)");
        jDialogConfirmaEntradaVeiculo.setAlwaysOnTop(true);
        jDialogConfirmaEntradaVeiculo.setResizable(false);
        jDialogConfirmaEntradaVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDialogConfirmaEntradaVeiculoMouseReleased(evt);
            }
        });
        jDialogConfirmaEntradaVeiculo.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                jDialogConfirmaEntradaVeiculoWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogConfirmaEntradaVeiculoWindowClosing(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setText("Confirma entrada do veiculo?");

        jButtonEntradaVeiculoNao.setMnemonic('N');
        jButtonEntradaVeiculoNao.setText("Não");
        jButtonEntradaVeiculoNao.setRequestFocusEnabled(false);
        jButtonEntradaVeiculoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntradaVeiculoNaoActionPerformed(evt);
            }
        });

        jButtonEntradaVeiculoSim.setMnemonic('S');
        jButtonEntradaVeiculoSim.setText("Sim");
        jButtonEntradaVeiculoSim.setRequestFocusEnabled(false);
        jButtonEntradaVeiculoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntradaVeiculoSimActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Placa");

        jTextFieldConfirmaSaidaPlaca1.setEditable(false);
        jTextFieldConfirmaSaidaPlaca1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldConfirmaSaidaPlaca1.setFocusable(false);
        jTextFieldConfirmaSaidaPlaca1.setRequestFocusEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTextFieldEntradaPlaca, org.jdesktop.beansbinding.ELProperty.create("${text}"), jTextFieldConfirmaSaidaPlaca1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Prisma");

        jTextFieldConfirmaSaidaPrisma1.setEditable(false);
        jTextFieldConfirmaSaidaPrisma1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldConfirmaSaidaPrisma1.setFocusable(false);
        jTextFieldConfirmaSaidaPrisma1.setRequestFocusEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTextFieldEntradaPrisma, org.jdesktop.beansbinding.ELProperty.create("${text}"), jTextFieldConfirmaSaidaPrisma1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldConfirmaSaidaPlaca1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldConfirmaSaidaPrisma1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonEntradaVeiculoSim, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(jButtonEntradaVeiculoNao)
                        .addGap(207, 207, 207))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonEntradaVeiculoNao, jButtonEntradaVeiculoSim});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jTextFieldConfirmaSaidaPlaca1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jTextFieldConfirmaSaidaPrisma1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEntradaVeiculoSim)
                    .addComponent(jButtonEntradaVeiculoNao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonEntradaVeiculoNao, jButtonEntradaVeiculoSim});

        javax.swing.GroupLayout jDialogConfirmaEntradaVeiculoLayout = new javax.swing.GroupLayout(jDialogConfirmaEntradaVeiculo.getContentPane());
        jDialogConfirmaEntradaVeiculo.getContentPane().setLayout(jDialogConfirmaEntradaVeiculoLayout);
        jDialogConfirmaEntradaVeiculoLayout.setHorizontalGroup(
            jDialogConfirmaEntradaVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogConfirmaEntradaVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogConfirmaEntradaVeiculoLayout.setVerticalGroup(
            jDialogConfirmaEntradaVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogConfirmaEntradaVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogConfirmaSaidaSistema.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialogConfirmaSaidaSistema.setTitle("Coelho´s Parking (Confirma Saída do Sistema?)");
        jDialogConfirmaSaidaSistema.setAlwaysOnTop(true);
        jDialogConfirmaSaidaSistema.setResizable(false);
        jDialogConfirmaSaidaSistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDialogConfirmaSaidaSistemaMouseReleased(evt);
            }
        });
        jDialogConfirmaSaidaSistema.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                jDialogConfirmaSaidaSistemaWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialogConfirmaSaidaSistemaWindowClosing(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel39.setText("Confirma saída do sistema?");

        jButtonSaidaSistemaNao.setMnemonic('N');
        jButtonSaidaSistemaNao.setText("Não");
        jButtonSaidaSistemaNao.setPreferredSize(new java.awt.Dimension(110, 25));
        jButtonSaidaSistemaNao.setRequestFocusEnabled(false);
        jButtonSaidaSistemaNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaidaSistemaNaoActionPerformed(evt);
            }
        });

        jButtonSaidaSistemaSim.setMnemonic('S');
        jButtonSaidaSistemaSim.setText("Sim");
        jButtonSaidaSistemaSim.setPreferredSize(new java.awt.Dimension(110, 25));
        jButtonSaidaSistemaSim.setRequestFocusEnabled(false);
        jButtonSaidaSistemaSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaidaSistemaSimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButtonSaidaSistemaSim, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButtonSaidaSistemaNao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel39))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel39)
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSaidaSistemaNao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSaidaSistemaSim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogConfirmaSaidaSistemaLayout = new javax.swing.GroupLayout(jDialogConfirmaSaidaSistema.getContentPane());
        jDialogConfirmaSaidaSistema.getContentPane().setLayout(jDialogConfirmaSaidaSistemaLayout);
        jDialogConfirmaSaidaSistemaLayout.setHorizontalGroup(
            jDialogConfirmaSaidaSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogConfirmaSaidaSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialogConfirmaSaidaSistemaLayout.setVerticalGroup(
            jDialogConfirmaSaidaSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogConfirmaSaidaSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 1460, 910));
        setMaximumSize(new java.awt.Dimension(1460, 910));
        setMinimumSize(new java.awt.Dimension(1460, 910));
        setPreferredSize(new java.awt.Dimension(1460, 910));
        setSize(new java.awt.Dimension(1460, 910));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCabecalho.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelCabecalho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Coelho´S Parking");
        jPanelCabecalho.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, 30));

        getContentPane().add(jPanelCabecalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 1200, 100));

        jPanelOpcoes.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 0), null));
        jPanelOpcoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPaneOpcoes.setFocusable(false);
        jTabbedPaneOpcoes.setRequestFocusEnabled(false);

        jPanelEntradaSaida.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanelEntradaSaida.setPreferredSize(new java.awt.Dimension(1124, 650));
        jPanelEntradaSaida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPaneEntradaSaida.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPaneEntradaSaida.setFocusable(false);
        jTabbedPaneEntradaSaida.setRequestFocusEnabled(false);

        jPanelApresentacao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Coelho´s Parking Preços", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rotativo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N
        jPanel6.setPreferredSize(new java.awt.Dimension(280, 250));

        jTableEntradaSaidaInformacoesRotativo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableEntradaSaidaInformacoesRotativo.setFocusable(false);
        jScrollPane5.setViewportView(jTableEntradaSaidaInformacoesRotativo);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 585, 328));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configurações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tolerância", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Desistência:");

        txtInformacoesToleranciaDesistencia.setEditable(false);
        txtInformacoesToleranciaDesistencia.setFocusable(false);
        txtInformacoesToleranciaDesistencia.setRequestFocusEnabled(false);
        txtInformacoesToleranciaDesistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInformacoesToleranciaDesistenciaActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Entre frações:");

        txtInformacoesToleranciaFracoes.setEditable(false);
        txtInformacoesToleranciaFracoes.setFocusable(false);
        txtInformacoesToleranciaFracoes.setRequestFocusEnabled(false);
        txtInformacoesToleranciaFracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInformacoesToleranciaFracoesActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("min.");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("min.");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInformacoesToleranciaDesistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                .addGap(32, 32, 32)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInformacoesToleranciaFracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(txtInformacoesToleranciaFracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50))
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(txtInformacoesToleranciaDesistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel49)))
                .addContainerGap())
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diária", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Hora(s)");

        txtInformacoesDiariaHora.setEditable(false);
        txtInformacoesDiariaHora.setFocusable(false);
        txtInformacoesDiariaHora.setRequestFocusEnabled(false);
        txtInformacoesDiariaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInformacoesDiariaHoraActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Minuto(s)");

        txtInformacoesDiariaMinuto.setEditable(false);
        txtInformacoesDiariaMinuto.setFocusable(false);
        txtInformacoesDiariaMinuto.setRequestFocusEnabled(false);
        txtInformacoesDiariaMinuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInformacoesDiariaMinutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInformacoesDiariaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInformacoesDiariaMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtInformacoesDiariaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(txtInformacoesDiariaMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pernoite", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Início:");

        txtInformacoesPernoiteInicio.setEditable(false);
        txtInformacoesPernoiteInicio.setFocusable(false);
        txtInformacoesPernoiteInicio.setRequestFocusEnabled(false);
        txtInformacoesPernoiteInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInformacoesPernoiteInicioActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Término:");

        txtInformacoesPernoiteTermino.setEditable(false);
        txtInformacoesPernoiteTermino.setFocusable(false);
        txtInformacoesPernoiteTermino.setRequestFocusEnabled(false);
        txtInformacoesPernoiteTermino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInformacoesPernoiteTerminoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInformacoesPernoiteInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInformacoesPernoiteTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtInformacoesPernoiteInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(txtInformacoesPernoiteTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 40, -1, -1));

        jPanelApresentacao.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1140, 388));

        jTabbedPaneEntradaSaida.addTab("Informações", jPanelApresentacao);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Placa");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Prisma");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tipo");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Data Entrada");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Hora Entrada");

        jTextFieldEntradaPlaca.setEditable(false);
        jTextFieldEntradaPlaca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldEntradaPlaca.setFocusable(false);
        jTextFieldEntradaPlaca.setRequestFocusEnabled(false);

        jTextFieldEntradaPrisma.setEditable(false);
        jTextFieldEntradaPrisma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldEntradaPrisma.setFocusable(false);
        jTextFieldEntradaPrisma.setRequestFocusEnabled(false);

        jTextFieldRotativoTipo.setEditable(false);
        jTextFieldRotativoTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldRotativoTipo.setFocusable(false);
        jTextFieldRotativoTipo.setRequestFocusEnabled(false);

        jTextFieldEntradaData.setEditable(false);
        jTextFieldEntradaData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldEntradaData.setFocusable(false);
        jTextFieldEntradaData.setRequestFocusEnabled(false);

        jTextFieldEntradaHora.setEditable(false);
        jTextFieldEntradaHora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldEntradaHora.setFocusable(false);
        jTextFieldEntradaHora.setRequestFocusEnabled(false);
        jTextFieldEntradaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEntradaHoraActionPerformed(evt);
            }
        });

        jListRotativoTipo.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jListRotativoTipo.setEnabled(false);
        jListRotativoTipo.setFocusable(false);
        jListRotativoTipo.setRequestFocusEnabled(false);
        jListRotativoTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jListRotativoTipoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jListRotativoTipo);

        javax.swing.GroupLayout jPanelVeiculoEntradaLayout = new javax.swing.GroupLayout(jPanelVeiculoEntrada);
        jPanelVeiculoEntrada.setLayout(jPanelVeiculoEntradaLayout);
        jPanelVeiculoEntradaLayout.setHorizontalGroup(
            jPanelVeiculoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVeiculoEntradaLayout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addGroup(jPanelVeiculoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelVeiculoEntradaLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldEntradaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVeiculoEntradaLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldEntradaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVeiculoEntradaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldEntradaData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVeiculoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(jTextFieldRotativoTipo))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEntradaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanelVeiculoEntradaLayout.setVerticalGroup(
            jPanelVeiculoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVeiculoEntradaLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanelVeiculoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVeiculoEntradaLayout.createSequentialGroup()
                        .addGroup(jPanelVeiculoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldRotativoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldEntradaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVeiculoEntradaLayout.createSequentialGroup()
                        .addGroup(jPanelVeiculoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldEntradaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelVeiculoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldEntradaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelVeiculoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldEntradaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPaneEntradaSaida.addTab("Entrada", jPanelVeiculoEntrada);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Placa");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Prisma");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Tipo");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Data Entrada");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Hora Entrada");

        jTextFieldSaidaPlaca.setEditable(false);
        jTextFieldSaidaPlaca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaPlaca.setFocusable(false);
        jTextFieldSaidaPlaca.setRequestFocusEnabled(false);

        jTextFieldSaidaPrisma.setEditable(false);
        jTextFieldSaidaPrisma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaPrisma.setFocusable(false);
        jTextFieldSaidaPrisma.setRequestFocusEnabled(false);
        jTextFieldSaidaPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaPrismaActionPerformed(evt);
            }
        });

        jTextFieldSaidaTipo.setEditable(false);
        jTextFieldSaidaTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaTipo.setFocusable(false);
        jTextFieldSaidaTipo.setRequestFocusEnabled(false);

        jTextFieldSaidaDataEntrada.setEditable(false);
        jTextFieldSaidaDataEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaDataEntrada.setFocusable(false);
        jTextFieldSaidaDataEntrada.setRequestFocusEnabled(false);

        jTextFieldSaidaHoraEntrada.setEditable(false);
        jTextFieldSaidaHoraEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaHoraEntrada.setFocusable(false);
        jTextFieldSaidaHoraEntrada.setRequestFocusEnabled(false);
        jTextFieldSaidaHoraEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaHoraEntradaActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Data Saída");

        jTextFieldSaidaData.setEditable(false);
        jTextFieldSaidaData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaData.setFocusable(false);
        jTextFieldSaidaData.setRequestFocusEnabled(false);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Hora Saída");

        jTextFieldSaidaHora.setEditable(false);
        jTextFieldSaidaHora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaHora.setFocusable(false);
        jTextFieldSaidaHora.setRequestFocusEnabled(false);
        jTextFieldSaidaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaHoraActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Permanência Total");

        jTextFieldSaidaPermanenciaTotal.setEditable(false);
        jTextFieldSaidaPermanenciaTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaPermanenciaTotal.setFocusable(false);
        jTextFieldSaidaPermanenciaTotal.setRequestFocusEnabled(false);
        jTextFieldSaidaPermanenciaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaPermanenciaTotalActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Nº. Controle");

        jTextFieldSaidaControle.setEditable(false);
        jTextFieldSaidaControle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaControle.setFocusable(false);
        jTextFieldSaidaControle.setRequestFocusEnabled(false);
        jTextFieldSaidaControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaControleActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("h/m dia Entrada");

        jTextFieldSaidaHMEntrada.setEditable(false);
        jTextFieldSaidaHMEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaHMEntrada.setFocusable(false);
        jTextFieldSaidaHMEntrada.setRequestFocusEnabled(false);
        jTextFieldSaidaHMEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaHMEntradaActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Diárias");

        jTextFieldSaidaDiarias.setEditable(false);
        jTextFieldSaidaDiarias.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaDiarias.setFocusable(false);
        jTextFieldSaidaDiarias.setRequestFocusEnabled(false);
        jTextFieldSaidaDiarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaDiariasActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Pernoites");

        jTextFieldSaidaPernoites.setEditable(false);
        jTextFieldSaidaPernoites.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaPernoites.setFocusable(false);
        jTextFieldSaidaPernoites.setRequestFocusEnabled(false);
        jTextFieldSaidaPernoites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaPernoitesActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("h/m dia Saída");

        jTextFieldSaidaHMSaida.setEditable(false);
        jTextFieldSaidaHMSaida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaHMSaida.setFocusable(false);
        jTextFieldSaidaHMSaida.setRequestFocusEnabled(false);
        jTextFieldSaidaHMSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaHMSaidaActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Valor Total R$");

        jTextFieldSaidaValor.setEditable(false);
        jTextFieldSaidaValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSaidaValor.setFocusable(false);
        jTextFieldSaidaValor.setRequestFocusEnabled(false);
        jTextFieldSaidaValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaidaValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVeiculoSaidaLayout = new javax.swing.GroupLayout(jPanelVeiculoSaida);
        jPanelVeiculoSaida.setLayout(jPanelVeiculoSaidaLayout);
        jPanelVeiculoSaidaLayout.setHorizontalGroup(
            jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSaidaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldSaidaDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldSaidaHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldSaidaData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldSaidaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVeiculoSaidaLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSaidaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldSaidaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSaidaControle, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)))
                        .addGap(266, 266, 266))
                    .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSaidaPermanenciaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSaidaHMEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSaidaDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSaidaPernoites, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSaidaHMSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSaidaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanelVeiculoSaidaLayout.setVerticalGroup(
            jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextFieldSaidaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jTextFieldSaidaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVeiculoSaidaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextFieldSaidaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(jTextFieldSaidaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(jTextFieldSaidaControle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jTextFieldSaidaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelVeiculoSaidaLayout.createSequentialGroup()
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jTextFieldSaidaDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTextFieldSaidaHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(jTextFieldSaidaHMSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(jTextFieldSaidaPernoites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(jTextFieldSaidaDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(jTextFieldSaidaHMEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jTextFieldSaidaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVeiculoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jTextFieldSaidaPermanenciaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPaneEntradaSaida.addTab("Saída", jPanelVeiculoSaida);

        jPanelEntradaSaida.add(jTabbedPaneEntradaSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 74, 1160, -1));

        jLabelPlacaOuPrisma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPlacaOuPrisma.setText("Placa ou Prisma");
        jPanelEntradaSaida.add(jLabelPlacaOuPrisma, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 6, -1, -1));

        txtEntradaPlacaOuPrisma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEntradaPlacaOuPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaPlacaOuPrismaActionPerformed(evt);
            }
        });
        txtEntradaPlacaOuPrisma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntradaPlacaOuPrismaKeyPressed(evt);
            }
        });
        jPanelEntradaSaida.add(txtEntradaPlacaOuPrisma, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 34, 169, -1));

        jLabel9.setText("Ultimas movimentações (Entrada/Saída)");
        jPanelEntradaSaida.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 514, -1, -1));

        jTableEntradaSaidaMovimentacoesRotativo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableEntradaSaidaMovimentacoesRotativo.setFocusable(false);
        jScrollPaneMovimentacoes.setViewportView(jTableEntradaSaidaMovimentacoesRotativo);

        jPanelEntradaSaida.add(jScrollPaneMovimentacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 536, 1160, 163));

        jTabbedPaneOpcoes.addTab("ENTRADA/SAÍDA", jPanelEntradaSaida);

        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableMensalista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableMensalista.setIntercellSpacing(new java.awt.Dimension(1, 3));
        jTableMensalista.setRowHeight(30);
        jTableMensalista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableMensalistaKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableMensalista);

        jPanel41.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1154, 545));

        jPanel40.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel40.setPreferredSize(new java.awt.Dimension(280, 250));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonMensalistaPesquisaIncluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaPesquisaIncluir.setMnemonic('I');
        jButtonMensalistaPesquisaIncluir.setText("Incluir");
        jButtonMensalistaPesquisaIncluir.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaPesquisaIncluir.setRequestFocusEnabled(false);
        jButtonMensalistaPesquisaIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaPesquisaIncluirActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonMensalistaPesquisaIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 17, -1, -1));

        jButtonMensalistaPesquisaSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaPesquisaSair.setMnemonic('S');
        jButtonMensalistaPesquisaSair.setText("Sair");
        jButtonMensalistaPesquisaSair.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaPesquisaSair.setRequestFocusEnabled(false);
        jButtonMensalistaPesquisaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaPesquisaSairActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonMensalistaPesquisaSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(956, 65, -1, -1));

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar mensalista", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldMensalistaNomePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaNomePesquisaActionPerformed(evt);
            }
        });
        jPanel39.add(jTextFieldMensalistaNomePesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 54, 295, -1));

        jLabel72.setText("Nome");
        jPanel39.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jButtonMensalistaPesquisaPerquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaPesquisaPerquisar.setMnemonic('I');
        jButtonMensalistaPesquisaPerquisar.setText("Pesquisar");
        jButtonMensalistaPesquisaPerquisar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaPesquisaPerquisar.setRequestFocusEnabled(false);
        jButtonMensalistaPesquisaPerquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaPesquisaPerquisarActionPerformed(evt);
            }
        });
        jPanel39.add(jButtonMensalistaPesquisaPerquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 52, -1, -1));

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel105.setText("Para exibir a lista completa deixe o campo Nome em braco e clique em pesquisar.");
        jPanel39.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 29, -1, -1));

        jPanel40.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 2, 480, 100));

        jButtonMensalistaPesquisaConsultar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaPesquisaConsultar.setMnemonic('I');
        jButtonMensalistaPesquisaConsultar.setText("Consultar");
        jButtonMensalistaPesquisaConsultar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaPesquisaConsultar.setRequestFocusEnabled(false);
        jButtonMensalistaPesquisaConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaPesquisaConsultarActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonMensalistaPesquisaConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 39, -1, -1));

        jButtonMensalistaPesquisaAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaPesquisaAlterar.setMnemonic('I');
        jButtonMensalistaPesquisaAlterar.setText("Alterar");
        jButtonMensalistaPesquisaAlterar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaPesquisaAlterar.setRequestFocusEnabled(false);
        jButtonMensalistaPesquisaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaPesquisaAlterarActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonMensalistaPesquisaAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(839, 65, -1, -1));

        jButtonMensalistaPesquisaExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaPesquisaExcluir.setMnemonic('I');
        jButtonMensalistaPesquisaExcluir.setText("Ativar/Inativar");
        jButtonMensalistaPesquisaExcluir.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaPesquisaExcluir.setRequestFocusEnabled(false);
        jButtonMensalistaPesquisaExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaPesquisaExcluirActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonMensalistaPesquisaExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(956, 17, 110, -1));

        jPanel41.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 560, 1150, 105));

        jTabbedPaneMensalista.addTab("Pesquisa", jPanel41);

        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados pessoais"));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setText("Nome");
        jPanel37.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setText("CPF");
        jPanel37.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setText("Identidade");
        jPanel37.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, 20));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setText("D. Nascimento");
        jPanel37.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, 20));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setText("Telefone");
        jPanel37.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setText("Celular");
        jPanel37.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, 20));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setText("E-Mail");
        jPanel37.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));
        jPanel37.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 600, 10));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setText("CEP");
        jPanel37.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setText("Rua");
        jPanel37.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setText("Nº");
        jPanel37.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, -1, 20));

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setText("Comp.");
        jPanel37.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 50, 20));

        jTextFieldMensalistaEmail.setEditable(false);
        jTextFieldMensalistaEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaEmailActionPerformed(evt);
            }
        });
        jPanel37.add(jTextFieldMensalistaEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 350, 30));

        jTextFieldMensalistaIdentidade.setEditable(false);
        jTextFieldMensalistaIdentidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaIdentidadeActionPerformed(evt);
            }
        });
        jPanel37.add(jTextFieldMensalistaIdentidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 140, 30));

        jTextFieldMensalistaComplementoResi.setEditable(false);
        jTextFieldMensalistaComplementoResi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaComplementoResiActionPerformed(evt);
            }
        });
        jPanel37.add(jTextFieldMensalistaComplementoResi, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 70, 30));

        jTextFieldMensalistaNome.setEditable(false);
        jTextFieldMensalistaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaNomeActionPerformed(evt);
            }
        });
        jPanel37.add(jTextFieldMensalistaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 570, 30));

        jTextFieldMensalistaRuaResi.setEditable(false);
        jTextFieldMensalistaRuaResi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaRuaResiActionPerformed(evt);
            }
        });
        jPanel37.add(jTextFieldMensalistaRuaResi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 330, 30));

        jTextFieldMensalistaNumeroResi.setEditable(false);
        jTextFieldMensalistaNumeroResi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaNumeroResiActionPerformed(evt);
            }
        });
        jPanel37.add(jTextFieldMensalistaNumeroResi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 60, 30));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setText("Bairro");
        jPanel37.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 20));

        jTextFieldMensalistaBairroResi.setEditable(false);
        jTextFieldMensalistaBairroResi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaBairroResiActionPerformed(evt);
            }
        });
        jPanel37.add(jTextFieldMensalistaBairroResi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 200, 30));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setText("Cidade");
        jPanel37.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, 20));

        jTextFieldMensalistaCidadeResi.setEditable(false);
        jTextFieldMensalistaCidadeResi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaCidadeResiActionPerformed(evt);
            }
        });
        jPanel37.add(jTextFieldMensalistaCidadeResi, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 160, 30));

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setText("Estado");
        jPanel37.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 50, 20));

        jTextFieldMensalistaEstadoResi.setEditable(false);
        jTextFieldMensalistaEstadoResi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaEstadoResiActionPerformed(evt);
            }
        });
        jPanel37.add(jTextFieldMensalistaEstadoResi, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 70, 30));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel79.setText("CEP");
        jPanel37.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        jFormattedTextFieldMensalistaDataNascimento.setEditable(false);
        try {
            jFormattedTextFieldMensalistaDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaDataNascimento.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel37.add(jFormattedTextFieldMensalistaDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 80, 30));

        jFormattedTextFieldMensalistaCelularResi.setEditable(false);
        try {
            jFormattedTextFieldMensalistaCelularResi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#.####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaCelularResi.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel37.add(jFormattedTextFieldMensalistaCelularResi, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 120, 30));

        jFormattedTextFieldMensalistaCepResi.setEditable(false);
        try {
            jFormattedTextFieldMensalistaCepResi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaCepResi.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel37.add(jFormattedTextFieldMensalistaCepResi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 130, 30));

        jFormattedTextFieldMensalistaTelefoneResi.setEditable(false);
        try {
            jFormattedTextFieldMensalistaTelefoneResi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaTelefoneResi.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel37.add(jFormattedTextFieldMensalistaTelefoneResi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 120, 30));

        jFormattedTextFieldMensalistaCpf.setEditable(false);
        try {
            jFormattedTextFieldMensalistaCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaCpf.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel37.add(jFormattedTextFieldMensalistaCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 130, 30));

        jPanel33.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 640, 310));

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados profissionais"));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldMensalistaEmpresa.setEditable(false);
        jTextFieldMensalistaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaEmpresaActionPerformed(evt);
            }
        });
        jPanel36.add(jTextFieldMensalistaEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 330, 30));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setText("Empresa");
        jPanel36.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel70.setText("CEP");
        jPanel36.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 20));

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel73.setText("Rua");
        jPanel36.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 20));

        jTextFieldMensalistaRuaCome.setEditable(false);
        jTextFieldMensalistaRuaCome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaRuaComeActionPerformed(evt);
            }
        });
        jPanel36.add(jTextFieldMensalistaRuaCome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 330, 30));

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel74.setText("Nº");
        jPanel36.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 20));

        jTextFieldMensalistaNumeroCome.setEditable(false);
        jTextFieldMensalistaNumeroCome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaNumeroComeActionPerformed(evt);
            }
        });
        jPanel36.add(jTextFieldMensalistaNumeroCome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 60, 30));

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel75.setText("Comp.");
        jPanel36.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 50, 20));

        jTextFieldMensalistaComplementoCome.setEditable(false);
        jTextFieldMensalistaComplementoCome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaComplementoComeActionPerformed(evt);
            }
        });
        jPanel36.add(jTextFieldMensalistaComplementoCome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 70, 30));

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel76.setText("Bairro");
        jPanel36.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        jTextFieldMensalistaBairroCome.setEditable(false);
        jTextFieldMensalistaBairroCome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaBairroComeActionPerformed(evt);
            }
        });
        jPanel36.add(jTextFieldMensalistaBairroCome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 200, 30));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setText("Cidade");
        jPanel36.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));

        jTextFieldMensalistaCidadeCome.setEditable(false);
        jTextFieldMensalistaCidadeCome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaCidadeComeActionPerformed(evt);
            }
        });
        jPanel36.add(jTextFieldMensalistaCidadeCome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 150, 30));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setText("Estado");
        jPanel36.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 50, 20));

        jTextFieldMensalistaEstadoCome.setEditable(false);
        jTextFieldMensalistaEstadoCome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaEstadoComeActionPerformed(evt);
            }
        });
        jPanel36.add(jTextFieldMensalistaEstadoCome, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 70, 30));

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel104.setText("Telefone");
        jPanel36.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, 20));

        jFormattedTextFieldMensalistaCepCome.setEditable(false);
        try {
            jFormattedTextFieldMensalistaCepCome.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaCepCome.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel36.add(jFormattedTextFieldMensalistaCepCome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, 30));

        jFormattedTextFieldMensalistaTelefoneCome.setEditable(false);
        try {
            jFormattedTextFieldMensalistaTelefoneCome.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaTelefoneCome.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel36.add(jFormattedTextFieldMensalistaTelefoneCome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 120, 30));

        jPanel33.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 450, 310));

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Veículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel80.setText("04");
        jPanel29.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 20, 20));

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setText("Montadora");
        jPanel29.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 70, 20));

        jTextFieldMensalistaMontadora01.setEditable(false);
        jTextFieldMensalistaMontadora01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaMontadora01ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaMontadora01, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 120, 30));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("Modelo");
        jPanel29.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 50, 20));

        jTextFieldMensalistaModelo01.setEditable(false);
        jTextFieldMensalistaModelo01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaModelo01ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaModelo01, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 120, 30));

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel83.setText("Cor");
        jPanel29.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 30, 20));

        jTextFieldMensalistaCor01.setEditable(false);
        jTextFieldMensalistaCor01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaCor01ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaCor01, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 120, 30));

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel84.setText("Ano");
        jPanel29.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 30, 20));

        jTextFieldMensalistaAno01.setEditable(false);
        jTextFieldMensalistaAno01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaAno01ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaAno01, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 120, 30));

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel85.setText("Placa");
        jPanel29.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 40, 20));

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel86.setText("Montadora");
        jPanel29.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 70, 20));

        jTextFieldMensalistaMontadora02.setEditable(false);
        jTextFieldMensalistaMontadora02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaMontadora02ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaMontadora02, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 120, 30));

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel87.setText("Modelo");
        jPanel29.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 50, 20));

        jTextFieldMensalistaModelo02.setEditable(false);
        jTextFieldMensalistaModelo02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaModelo02ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaModelo02, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 120, 30));

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel88.setText("Cor");
        jPanel29.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 30, 20));

        jTextFieldMensalistaCor02.setEditable(false);
        jTextFieldMensalistaCor02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaCor02ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaCor02, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 120, 30));

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel89.setText("Ano");
        jPanel29.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 30, 20));

        jTextFieldMensalistaAno02.setEditable(false);
        jTextFieldMensalistaAno02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaAno02ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaAno02, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 120, 30));

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel90.setText("Placa");
        jPanel29.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 40, 20));

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel91.setText("Montadora");
        jPanel29.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 70, 20));

        jTextFieldMensalistaMontadora03.setEditable(false);
        jTextFieldMensalistaMontadora03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaMontadora03ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaMontadora03, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 120, 30));

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel92.setText("Modelo");
        jPanel29.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 50, 20));

        jTextFieldMensalistaModelo03.setEditable(false);
        jTextFieldMensalistaModelo03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaModelo03ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaModelo03, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 120, 30));

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel93.setText("Cor");
        jPanel29.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 30, 20));

        jTextFieldMensalistaCor03.setEditable(false);
        jTextFieldMensalistaCor03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaCor03ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaCor03, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 120, 30));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel94.setText("Ano");
        jPanel29.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 110, 30, 20));

        jTextFieldMensalistaAno03.setEditable(false);
        jTextFieldMensalistaAno03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaAno03ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaAno03, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 120, 30));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel95.setText("Placa");
        jPanel29.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 40, 20));

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel96.setText("Montadora");
        jPanel29.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 70, 20));

        jTextFieldMensalistaMontadora04.setEditable(false);
        jTextFieldMensalistaMontadora04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaMontadora04ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaMontadora04, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 120, 30));

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel97.setText("Modelo");
        jPanel29.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 50, 20));

        jTextFieldMensalistaModelo04.setEditable(false);
        jTextFieldMensalistaModelo04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaModelo04ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaModelo04, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 120, 30));

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel98.setText("Cor");
        jPanel29.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 30, 20));

        jTextFieldMensalistaCor04.setEditable(false);
        jTextFieldMensalistaCor04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaCor04ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaCor04, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 120, 30));

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel99.setText("Ano");
        jPanel29.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, 30, 20));

        jTextFieldMensalistaAno04.setEditable(false);
        jTextFieldMensalistaAno04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMensalistaAno04ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextFieldMensalistaAno04, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 120, 30));

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel100.setText("Placa");
        jPanel29.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 40, 20));

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel101.setText("01");
        jPanel29.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 20, 20));

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel102.setText("02");
        jPanel29.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 20, 20));

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel103.setText("03");
        jPanel29.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 20, 20));

        jFormattedTextFieldMensalistaPlaca01.setEditable(false);
        try {
            jFormattedTextFieldMensalistaPlaca01.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaPlaca01.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel29.add(jFormattedTextFieldMensalistaPlaca01, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, 30));

        jFormattedTextFieldMensalistaPlaca02.setEditable(false);
        try {
            jFormattedTextFieldMensalistaPlaca02.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaPlaca02.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel29.add(jFormattedTextFieldMensalistaPlaca02, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 120, 30));

        jFormattedTextFieldMensalistaPlaca03.setEditable(false);
        try {
            jFormattedTextFieldMensalistaPlaca03.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaPlaca03.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel29.add(jFormattedTextFieldMensalistaPlaca03, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 120, 30));

        jFormattedTextFieldMensalistaPlaca04.setEditable(false);
        try {
            jFormattedTextFieldMensalistaPlaca04.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaPlaca04.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel29.add(jFormattedTextFieldMensalistaPlaca04, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 120, 30));

        jPanel33.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 980, 180));

        jPanel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonMensalistaCadastroOk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaCadastroOk.setMnemonic('I');
        jButtonMensalistaCadastroOk.setText("Ok");
        jButtonMensalistaCadastroOk.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaCadastroOk.setRequestFocusEnabled(false);
        jButtonMensalistaCadastroOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaCadastroOkActionPerformed(evt);
            }
        });
        jPanel38.add(jButtonMensalistaCadastroOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 15, -1, -1));

        jButtonMensalistaCadastroCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaCadastroCancelar.setMnemonic('I');
        jButtonMensalistaCadastroCancelar.setText("Cancelar");
        jButtonMensalistaCadastroCancelar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaCadastroCancelar.setRequestFocusEnabled(false);
        jButtonMensalistaCadastroCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaCadastroCancelarActionPerformed(evt);
            }
        });
        jPanel38.add(jButtonMensalistaCadastroCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 15, -1, -1));

        jLabelMensalistaStatus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMensalistaStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMensalistaStatus.setText("Status");
        jPanel38.add(jLabelMensalistaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 15, 370, -1));

        jButtonMensalistaCadastroAtivarInativar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaCadastroAtivarInativar.setMnemonic('E');
        jButtonMensalistaCadastroAtivarInativar.setText("Ativar");
        jButtonMensalistaCadastroAtivarInativar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaCadastroAtivarInativar.setRequestFocusEnabled(false);
        jButtonMensalistaCadastroAtivarInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaCadastroAtivarInativarActionPerformed(evt);
            }
        });
        jPanel38.add(jButtonMensalistaCadastroAtivarInativar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 15, -1, -1));

        jButtonMensalistaCadastroAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaCadastroAlterar.setMnemonic('A');
        jButtonMensalistaCadastroAlterar.setText("Alterar");
        jButtonMensalistaCadastroAlterar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaCadastroAlterar.setRequestFocusEnabled(false);
        jButtonMensalistaCadastroAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaCadastroAlterarActionPerformed(evt);
            }
        });
        jPanel38.add(jButtonMensalistaCadastroAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 15, -1, -1));

        jButtonMensalistaCadastroSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMensalistaCadastroSair.setMnemonic('E');
        jButtonMensalistaCadastroSair.setText("Sair");
        jButtonMensalistaCadastroSair.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMensalistaCadastroSair.setRequestFocusEnabled(false);
        jButtonMensalistaCadastroSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensalistaCadastroSairActionPerformed(evt);
            }
        });
        jPanel38.add(jButtonMensalistaCadastroSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 15, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel38.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 10, 40));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel38.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 10, 40));

        jPanel33.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 1140, 60));

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contrato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Número do contrato");
        jPanel31.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setText("Data inclusão");
        jPanel31.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel106.setText("Data ultima alteração");
        jPanel31.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, -1, -1));

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel107.setText("Status");
        jPanel31.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, -1, -1));

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel108.setText("Dia vencimento mensalidade");
        jPanel31.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));
        jPanel31.add(jTextFieldMensalistaDiaVencimentoMensalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 50, -1));

        jTextFieldMensalistaStatus.setEditable(false);
        jPanel31.add(jTextFieldMensalistaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 40, 70, -1));

        jFormattedTextFieldMensalistaDataInclusao.setEditable(false);
        try {
            jFormattedTextFieldMensalistaDataInclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaDataInclusao.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel31.add(jFormattedTextFieldMensalistaDataInclusao, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 100, -1));

        jFormattedTextFieldMensalistaDataUltimaAlteracao.setEditable(false);
        try {
            jFormattedTextFieldMensalistaDataUltimaAlteracao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMensalistaDataUltimaAlteracao.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel31.add(jFormattedTextFieldMensalistaDataUltimaAlteracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 90, -1));

        jTextFieldMensalistaContratoNumero.setEditable(false);
        jPanel31.add(jTextFieldMensalistaContratoNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 120, -1));

        jPanel33.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1170, 90));

        jTabbedPaneMensalista.addTab("Cadastro", jPanel33);

        javax.swing.GroupLayout jPanelMensalLayout = new javax.swing.GroupLayout(jPanelMensal);
        jPanelMensal.setLayout(jPanelMensalLayout);
        jPanelMensalLayout.setHorizontalGroup(
            jPanelMensalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMensalLayout.createSequentialGroup()
                .addComponent(jTabbedPaneMensalista, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanelMensalLayout.setVerticalGroup(
            jPanelMensalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneMensalista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPaneOpcoes.addTab("MENSALISTA", jPanelMensal);

        jPanelPacote.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pacotes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N
        jPanel26.setFocusable(false);
        jPanel26.setPreferredSize(new java.awt.Dimension(280, 250));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablePacote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePacote.setRequestFocusEnabled(false);
        jTablePacote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePacoteMousePressed(evt);
            }
        });
        jTablePacote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablePacoteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTablePacoteKeyTyped(evt);
            }
        });
        jScrollPane13.setViewportView(jTablePacote);

        jPanel26.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 32, 592, 437));

        jPanelPacote.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 49, 620, 483));

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inclusão, Exclusão e Alteração", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N
        jPanel27.setFocusCycleRoot(true);
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pacote", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N
        jPanel28.setPreferredSize(new java.awt.Dimension(280, 250));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPacoteQtdDiasOuUtilizacoes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelPacoteQtdDiasOuUtilizacoes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPacoteQtdDiasOuUtilizacoes.setText("Quant. de dias");
        jPanel28.add(jLabelPacoteQtdDiasOuUtilizacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 171, -1, -1));

        jTextFieldPacoteQuantidade.setEditable(false);
        jTextFieldPacoteQuantidade.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldPacoteQuantidade.setFocusable(false);
        jTextFieldPacoteQuantidade.setRequestFocusEnabled(false);
        jTextFieldPacoteQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPacoteQuantidadeActionPerformed(evt);
            }
        });
        jPanel28.add(jTextFieldPacoteQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 165, 83, -1));

        jButtonPacoteAlterarOk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPacoteAlterarOk.setMnemonic('A');
        jButtonPacoteAlterarOk.setText("Alterar");
        jButtonPacoteAlterarOk.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonPacoteAlterarOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPacoteAlterarOkActionPerformed(evt);
            }
        });
        jPanel28.add(jButtonPacoteAlterarOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jButtonPacoteSairCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPacoteSairCancelar.setMnemonic('S');
        jButtonPacoteSairCancelar.setText("Sair");
        jButtonPacoteSairCancelar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonPacoteSairCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPacoteSairCancelarActionPerformed(evt);
            }
        });
        jPanel28.add(jButtonPacoteSairCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel54.setText("Valor R$");
        jPanel28.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 221, -1, -1));

        jTextFieldPacoteValor.setEditable(false);
        jTextFieldPacoteValor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldPacoteValor.setFocusable(false);
        jTextFieldPacoteValor.setRequestFocusEnabled(false);
        jTextFieldPacoteValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPacoteValorActionPerformed(evt);
            }
        });
        jPanel28.add(jTextFieldPacoteValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 215, 129, -1));

        jButtonPacoteIncluirOk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPacoteIncluirOk.setMnemonic('I');
        jButtonPacoteIncluirOk.setText("Incluir");
        jButtonPacoteIncluirOk.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonPacoteIncluirOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPacoteIncluirOkActionPerformed(evt);
            }
        });
        jPanel28.add(jButtonPacoteIncluirOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jButtonPacoteExcluirCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPacoteExcluirCancelar.setMnemonic('E');
        jButtonPacoteExcluirCancelar.setText("Excluir");
        jButtonPacoteExcluirCancelar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonPacoteExcluirCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPacoteExcluirCancelarActionPerformed(evt);
            }
        });
        jPanel28.add(jButtonPacoteExcluirCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, -1));

        jPanel34.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jRadioButtonDias.setText(" Dias");
        jRadioButtonDias.setEnabled(false);
        jRadioButtonDias.setFocusable(false);
        jRadioButtonDias.setRequestFocusEnabled(false);
        jRadioButtonDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDiasActionPerformed(evt);
            }
        });

        jRadioButtonUtilizacoes.setText("Utilizações");
        jRadioButtonUtilizacoes.setEnabled(false);
        jRadioButtonUtilizacoes.setFocusable(false);
        jRadioButtonUtilizacoes.setRequestFocusEnabled(false);
        jRadioButtonUtilizacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUtilizacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jRadioButtonDias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonUtilizacoes)
                .addGap(25, 25, 25))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jRadioButtonDias)
                .addComponent(jRadioButtonUtilizacoes))
        );

        jPanel28.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 125, 223, -1));

        jTextFieldPacoteIncluirAlterar.setEditable(false);
        jTextFieldPacoteIncluirAlterar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldPacoteIncluirAlterar.setFocusable(false);
        jTextFieldPacoteIncluirAlterar.setRequestFocusEnabled(false);
        jTextFieldPacoteIncluirAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPacoteIncluirAlterarActionPerformed(evt);
            }
        });
        jPanel28.add(jTextFieldPacoteIncluirAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 75, 223, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel55.setText("Nome");
        jPanel28.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 49, -1, -1));

        jPanel27.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 38, 290, 420));

        jPanelPacote.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 49, 330, 480));

        jTabbedPaneOpcoes.addTab("PACOTE", jPanelPacote);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inclusão, Exclusão e Alteração", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N
        jPanel12.setFocusCycleRoot(true);
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rotativo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N
        jPanel13.setPreferredSize(new java.awt.Dimension(280, 250));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel44.setText("30 minutos R$");
        jPanel13.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel45.setText("60 minutos R$");
        jPanel13.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel46.setText("Demais frações R$");
        jPanel13.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        txtRotativoPreco30minutos.setEditable(false);
        txtRotativoPreco30minutos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRotativoPreco30minutos.setFocusable(false);
        txtRotativoPreco30minutos.setRequestFocusEnabled(false);
        txtRotativoPreco30minutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRotativoPreco30minutosActionPerformed(evt);
            }
        });
        jPanel13.add(txtRotativoPreco30minutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 83, -1));

        txtRotativoPreco60minutos.setEditable(false);
        txtRotativoPreco60minutos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRotativoPreco60minutos.setFocusable(false);
        txtRotativoPreco60minutos.setRequestFocusEnabled(false);
        jPanel13.add(txtRotativoPreco60minutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 83, -1));

        txtRotativoPrecoDemaisFracoes.setEditable(false);
        txtRotativoPrecoDemaisFracoes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRotativoPrecoDemaisFracoes.setFocusable(false);
        txtRotativoPrecoDemaisFracoes.setRequestFocusEnabled(false);
        jPanel13.add(txtRotativoPrecoDemaisFracoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 83, -1));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel47.setText("Diária R$");
        jPanel13.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        txtRotativoPrecoDiaria.setEditable(false);
        txtRotativoPrecoDiaria.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRotativoPrecoDiaria.setFocusable(false);
        txtRotativoPrecoDiaria.setRequestFocusEnabled(false);
        jPanel13.add(txtRotativoPrecoDiaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 121, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel48.setText("Pernoite R$");
        jPanel13.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        txtRotativoPrecoPernoite.setEditable(false);
        txtRotativoPrecoPernoite.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRotativoPrecoPernoite.setFocusable(false);
        txtRotativoPrecoPernoite.setRequestFocusEnabled(false);
        jPanel13.add(txtRotativoPrecoPernoite, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 121, -1));

        jButtonRotativoIncluirOk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonRotativoIncluirOk.setMnemonic('I');
        jButtonRotativoIncluirOk.setText("Incluir");
        jButtonRotativoIncluirOk.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonRotativoIncluirOk.setRequestFocusEnabled(false);
        jButtonRotativoIncluirOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRotativoIncluirOkActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonRotativoIncluirOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jButtonRotativoExcluirCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonRotativoExcluirCancelar.setMnemonic('E');
        jButtonRotativoExcluirCancelar.setText("Excluir");
        jButtonRotativoExcluirCancelar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonRotativoExcluirCancelar.setRequestFocusEnabled(false);
        jButtonRotativoExcluirCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRotativoExcluirCancelarActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonRotativoExcluirCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        jButtonRotativoAlterarOk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonRotativoAlterarOk.setMnemonic('A');
        jButtonRotativoAlterarOk.setText("Alterar");
        jButtonRotativoAlterarOk.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonRotativoAlterarOk.setRequestFocusEnabled(false);
        jButtonRotativoAlterarOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRotativoAlterarOkActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonRotativoAlterarOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jButtonRotativoSairCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonRotativoSairCancelar.setMnemonic('S');
        jButtonRotativoSairCancelar.setText("Sair");
        jButtonRotativoSairCancelar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonRotativoSairCancelar.setRequestFocusEnabled(false);
        jButtonRotativoSairCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRotativoSairCancelarActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonRotativoSairCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        jTextFieldRotativoIncluirAlterar.setEditable(false);
        jTextFieldRotativoIncluirAlterar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldRotativoIncluirAlterar.setFocusable(false);
        jTextFieldRotativoIncluirAlterar.setRequestFocusEnabled(false);
        jTextFieldRotativoIncluirAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRotativoIncluirAlterarActionPerformed(evt);
            }
        });
        jPanel13.add(jTextFieldRotativoIncluirAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 230, -1));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel56.setText("Nome");
        jPanel13.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 440));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(812, 50, 320, 490));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rotativo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N
        jPanel8.setFocusable(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(280, 250));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableRotativo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableRotativo.setRequestFocusEnabled(false);
        jTableRotativo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRotativoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableRotativoMousePressed(evt);
            }
        });
        jTableRotativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableRotativoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableRotativoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTableRotativoKeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(jTableRotativo);

        jPanel8.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 32, 592, 444));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 50, 620, 490));

        jTabbedPaneOpcoes.addTab("ROTATIVO", jPanel1);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Veículos no pátio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16))); // NOI18N
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablePatio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTablePatio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTablePatio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePatio.setIntercellSpacing(new java.awt.Dimension(0, 1));
        jTablePatio.setRowHeight(25);
        jTablePatio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTablePatioKeyPressed(evt);
            }
        });
        jScrollPane11.setViewportView(jTablePatio);

        jPanel23.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 38, 1118, 550));

        jButtonPatioSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPatioSair.setText("Sair");
        jButtonPatioSair.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonPatioSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPatioSairActionPerformed(evt);
            }
        });
        jPanel23.add(jButtonPatioSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 630, -1, -1));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordenar por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonPatioListaPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPatioListaPlaca.setText("Placa");
        jButtonPatioListaPlaca.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonPatioListaPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPatioListaPlacaActionPerformed(evt);
            }
        });
        jPanel10.add(jButtonPatioListaPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 29, -1, -1));

        jButtonPatioListaPrisma.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPatioListaPrisma.setText("Prisma");
        jButtonPatioListaPrisma.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonPatioListaPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPatioListaPrismaActionPerformed(evt);
            }
        });
        jPanel10.add(jButtonPatioListaPrisma, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 29, -1, -1));

        jButtonPatioListaTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPatioListaTipo.setText("Tipo");
        jButtonPatioListaTipo.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonPatioListaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPatioListaTipoActionPerformed(evt);
            }
        });
        jPanel10.add(jButtonPatioListaTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 29, -1, -1));

        jButtonPatioListaEntrada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPatioListaEntrada.setText("Entrada");
        jButtonPatioListaEntrada.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonPatioListaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPatioListaEntradaActionPerformed(evt);
            }
        });
        jPanel10.add(jButtonPatioListaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 29, -1, -1));

        jPanel23.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, 450, 70));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneOpcoes.addTab("PÁTIO", jPanel22);

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Movimento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N
        jPanel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonMovimentoSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonMovimentoSair.setText("Sair");
        jButtonMovimentoSair.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMovimentoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMovimentoSairActionPerformed(evt);
            }
        });
        jPanel25.add(jButtonMovimentoSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 630, -1, -1));

        jTableMovimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableMovimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableMovimento.setIntercellSpacing(new java.awt.Dimension(0, 1));
        jTableMovimento.setRowHeight(25);
        jScrollPane12.setViewportView(jTableMovimento);

        jPanel25.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1118, 537));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digite a data do movimento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonMovimentoListar.setText("Listar");
        jButtonMovimentoListar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMovimentoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMovimentoListarActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonMovimentoListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 29, 93, -1));

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel11.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 29, 110, 30));

        jPanel25.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 595, 290, 80));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneOpcoes.addTab("MOVIMENTO", jPanel24);

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPaneConfiguracoesItemAlteracao.setFocusable(false);
        jTabbedPaneConfiguracoesItemAlteracao.setRequestFocusEnabled(false);

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Tolerância para desistência:");
        jPanel16.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 96, -1, -1));

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(3);
        jTextArea3.setText("\tEscolha  quantos  minutos o cliente terá para desistência após o registro  do  veiculo sem que haja cobrança de valor.\nExemplo: Minutos(s): 3");
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.setFocusable(false);
        jTextArea3.setRequestFocusEnabled(false);
        jScrollPane9.setViewportView(jTextArea3);

        jPanel16.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 438, 78));

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(3);
        jTextArea4.setText("\tEscolha  quantos  minutos  de  tolerância vão existir entre a cobraça das frações.\nExemplo: Minutos(s): 5");
        jTextArea4.setWrapStyleWord(true);
        jTextArea4.setFocusable(false);
        jTextArea4.setRequestFocusEnabled(false);
        jScrollPane10.setViewportView(jTextArea4);

        jPanel16.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 154, 438, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel34.setText("Tolerância entre as frações:");
        jPanel16.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 232, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel35.setText("minuto(s)");
        jPanel16.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 96, -1, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel36.setText("minuto(s)");
        jPanel16.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 232, -1, -1));

        txtConfiguracoesToleranciaDesistencia.setEditable(false);
        txtConfiguracoesToleranciaDesistencia.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtConfiguracoesToleranciaDesistencia.setFocusable(false);
        txtConfiguracoesToleranciaDesistencia.setRequestFocusEnabled(false);
        txtConfiguracoesToleranciaDesistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfiguracoesToleranciaDesistenciaActionPerformed(evt);
            }
        });
        jPanel16.add(txtConfiguracoesToleranciaDesistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 90, 67, -1));

        txtConfiguracoesToleranciaFracao.setEditable(false);
        txtConfiguracoesToleranciaFracao.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtConfiguracoesToleranciaFracao.setFocusable(false);
        txtConfiguracoesToleranciaFracao.setRequestFocusEnabled(false);
        txtConfiguracoesToleranciaFracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfiguracoesToleranciaFracaoActionPerformed(evt);
            }
        });
        jPanel16.add(txtConfiguracoesToleranciaFracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 226, 67, -1));

        jTabbedPaneConfiguracoesItemAlteracao.addTab("Tolerância", jPanel16);

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Hora(s):");
        jPanel17.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 147, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Minuto(s):");
        jPanel17.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 197, -1, -1));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("\tEscolha o tempo necessário para iniciar uma diária.\nExemplo: Hora(s): 3 | Minutos(s): 31\nNeste exemplo quando a permanência for igual ou maior a 3h:31m irá gerar uma diária.");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setFocusable(false);
        jTextArea2.setRequestFocusEnabled(false);
        jScrollPane8.setViewportView(jTextArea2);

        jPanel17.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 438, -1));

        txtConfiguracoesDiariaHora.setEditable(false);
        txtConfiguracoesDiariaHora.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtConfiguracoesDiariaHora.setFocusable(false);
        txtConfiguracoesDiariaHora.setRequestFocusEnabled(false);
        txtConfiguracoesDiariaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfiguracoesDiariaHoraActionPerformed(evt);
            }
        });
        jPanel17.add(txtConfiguracoesDiariaHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 141, 67, -1));

        txtConfiguracoesDiariaMinuto.setEditable(false);
        txtConfiguracoesDiariaMinuto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtConfiguracoesDiariaMinuto.setFocusable(false);
        txtConfiguracoesDiariaMinuto.setRequestFocusEnabled(false);
        txtConfiguracoesDiariaMinuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfiguracoesDiariaMinutoActionPerformed(evt);
            }
        });
        jPanel17.add(txtConfiguracoesDiariaMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 191, 67, -1));

        jTabbedPaneConfiguracoesItemAlteracao.addTab("Diária", jPanel17);

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("Início do pernoite:");
        jPanel18.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 147, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel33.setText("Término do pernoite:");
        jPanel18.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 197, -1, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(3);
        jTextArea1.setText("\tEscolha a hora inicial e final que compreende o período do pernoite.\nExemplo: Hora inicial: 21:00 | Hora final: 09:00");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setFocusable(false);
        jTextArea1.setRequestFocusEnabled(false);
        jScrollPane7.setViewportView(jTextArea1);

        jPanel18.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 438, -1));

        txtConfiguracoesPernoiteInicio.setEditable(false);
        txtConfiguracoesPernoiteInicio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtConfiguracoesPernoiteInicio.setFocusable(false);
        txtConfiguracoesPernoiteInicio.setRequestFocusEnabled(false);
        txtConfiguracoesPernoiteInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfiguracoesPernoiteInicioActionPerformed(evt);
            }
        });
        jPanel18.add(txtConfiguracoesPernoiteInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 141, 67, -1));

        txtConfiguracoesPernoiteTermino.setEditable(false);
        txtConfiguracoesPernoiteTermino.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtConfiguracoesPernoiteTermino.setFocusable(false);
        txtConfiguracoesPernoiteTermino.setRequestFocusEnabled(false);
        txtConfiguracoesPernoiteTermino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfiguracoesPernoiteTerminoActionPerformed(evt);
            }
        });
        jPanel18.add(txtConfiguracoesPernoiteTermino, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 191, 67, -1));

        jTabbedPaneConfiguracoesItemAlteracao.addTab("Pernoite", jPanel18);

        jPanel15.add(jTabbedPaneConfiguracoesItemAlteracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 172, 460, 301));

        jButtonConfiguracoesAlterarOk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonConfiguracoesAlterarOk.setMnemonic('A');
        jButtonConfiguracoesAlterarOk.setText("Alterar");
        jButtonConfiguracoesAlterarOk.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonConfiguracoesAlterarOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracoesAlterarOkActionPerformed(evt);
            }
        });
        jPanel15.add(jButtonConfiguracoesAlterarOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, -1, -1));

        jButtonConfiguracoesSairCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonConfiguracoesSairCancelar.setMnemonic('S');
        jButtonConfiguracoesSairCancelar.setText("Sair");
        jButtonConfiguracoesSairCancelar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonConfiguracoesSairCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracoesSairCancelarActionPerformed(evt);
            }
        });
        jPanel15.add(jButtonConfiguracoesSairCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, -1, -1));

        jListConfiguracoes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jListConfiguracoes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Tolerância", "Diária", "Pernoite" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListConfiguracoes.setFocusable(false);
        jListConfiguracoes.setRequestFocusEnabled(false);
        jListConfiguracoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListConfiguracoesKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jListConfiguracoes);

        jPanel15.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 34, 204, 120));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Escolha o item para alteração");
        jPanel15.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 8, -1, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 29, 480, 520));

        jTabbedPaneOpcoes.addTab("CONFIGURAÇÕES", jPanel14);

        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPaneOpcoes.addTab("tab8", jPanel30);

        jPanelOpcoes.add(jTabbedPaneOpcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 1170, 730));

        getContentPane().add(jPanelOpcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 1200, 750));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 18))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonF1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF1.setText("F1 (Entrada/Saída)");
        jButtonF1.setFocusable(false);
        jButtonF1.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF1.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF1.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF1.setRequestFocusEnabled(false);
        jButtonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 57, -1, -1));

        jButtonF2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF2.setText("F2 (Mensalista)");
        jButtonF2.setFocusable(false);
        jButtonF2.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF2.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF2.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF2.setRequestFocusEnabled(false);
        jButtonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 135, -1, -1));

        jButtonF3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF3.setText("F3 (Pacote)");
        jButtonF3.setFocusable(false);
        jButtonF3.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF3.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF3.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF3.setRequestFocusEnabled(false);
        jButtonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 193, -1, -1));

        jButtonF4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF4.setText("F4 (Rotativo)");
        jButtonF4.setFocusable(false);
        jButtonF4.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF4.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF4.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF4.setRequestFocusEnabled(false);
        jButtonF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 251, -1, -1));

        jButtonF5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF5.setText("F5 (Pátio)");
        jButtonF5.setFocusable(false);
        jButtonF5.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF5.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF5.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF5.setRequestFocusEnabled(false);
        jButtonF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 327, -1, -1));

        jButtonF6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF6.setText("F6 (Movimento)");
        jButtonF6.setFocusable(false);
        jButtonF6.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF6.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF6.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF6.setRequestFocusEnabled(false);
        jButtonF6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 385, -1, -1));

        jButtonF8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF8.setText("F8 (Configurações)");
        jButtonF8.setFocusable(false);
        jButtonF8.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF8.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF8.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF8.setRequestFocusEnabled(false);
        jButtonF8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF8ActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 461, -1, -1));

        jButtonF10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF10.setText("F10 (Sair)");
        jButtonF10.setFocusable(false);
        jButtonF10.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF10.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF10.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF10.setRequestFocusEnabled(false);
        jButtonF10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 519, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 865));

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEntradaPlacaOuPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaPlacaOuPrismaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaPlacaOuPrismaActionPerformed

    private void jTextFieldEntradaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEntradaHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEntradaHoraActionPerformed

    private void txtEntradaPlacaOuPrismaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaPlacaOuPrismaKeyPressed
        dadoEntrada = txtEntradaPlacaOuPrisma.getText();
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                verificaDadoDigitado(dadoEntrada);
                break;
            case KeyEvent.VK_F2:
                menuPrincipal("mensalista");
                break;
            case KeyEvent.VK_F3:
                menuPrincipal("pacote");
                break;
            case KeyEvent.VK_F4:
                menuPrincipal("rotativo");
                break;
            case KeyEvent.VK_F5:
                menuPrincipal("patio");
                break;
            case KeyEvent.VK_F8:
                menuPrincipal("configuracoes");
                break;
            case KeyEvent.VK_F10:
                confirmaSaidaSistema();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_txtEntradaPlacaOuPrismaKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        configuracaoMascaraEntradaJTextField();
        configuracaoJDialog();
        configuracaoJTabbedPane();
        configuracaoJTable();
        configuracaoJTextField();
        limparObjetosPatio();
    }//GEN-LAST:event_formWindowOpened

    private void jListRotativoTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListRotativoTipoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTextFieldRotativoTipo.setText(jListRotativoTipo.getSelectedValue());
            jListRotativoTipo.setFocusable(false);
            jListRotativoTipo.setEnabled(false);
            jLabelPlacaOuPrisma.setText("Digite o prisma");
            txtEntradaPlacaOuPrisma.setEditable(true);
            txtEntradaPlacaOuPrisma.setFocusable(true);
            txtEntradaPlacaOuPrisma.requestFocus();
            txtEntradaPlacaOuPrisma.setText(null);
            txtEntradaPlacaOuPrisma.setDocument(new EntradaDado(4, "[^0-9]"));
        }
    }//GEN-LAST:event_jListRotativoTipoKeyPressed

    private void jTextFieldSaidaHoraEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaHoraEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaidaHoraEntradaActionPerformed

    private void jTextFieldSaidaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaidaHoraActionPerformed

    private void jTextFieldSaidaPermanenciaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaPermanenciaTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaidaPermanenciaTotalActionPerformed

    private void jTextFieldSaidaControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaControleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaidaControleActionPerformed

    private void jTextFieldSaidaHMEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaHMEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaidaHMEntradaActionPerformed

    private void jTextFieldSaidaDiariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaDiariasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaidaDiariasActionPerformed

    private void jTextFieldSaidaPernoitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaPernoitesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaidaPernoitesActionPerformed

    private void jTextFieldSaidaHMSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaHMSaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaidaHMSaidaActionPerformed

    private void jTextFieldSaidaValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaValorActionPerformed

    }//GEN-LAST:event_jTextFieldSaidaValorActionPerformed

    private void jDialogConfirmaSaidaVeiculoWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogConfirmaSaidaVeiculoWindowActivated

    }//GEN-LAST:event_jDialogConfirmaSaidaVeiculoWindowActivated

    private void jButtonSaidaVeiculoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaidaVeiculoSimActionPerformed
        saidaVeiculoSim();
    }//GEN-LAST:event_jButtonSaidaVeiculoSimActionPerformed

    private void jButtonSaidaVeiculoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaidaVeiculoNaoActionPerformed
        saidaVeiculoNao();
    }//GEN-LAST:event_jButtonSaidaVeiculoNaoActionPerformed

    private void jDialogConfirmaSaidaVeiculoWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogConfirmaSaidaVeiculoWindowClosing
        saidaVeiculoNao();
    }//GEN-LAST:event_jDialogConfirmaSaidaVeiculoWindowClosing

    private void jDialogConfirmaSaidaVeiculoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDialogConfirmaSaidaVeiculoMouseReleased

    }//GEN-LAST:event_jDialogConfirmaSaidaVeiculoMouseReleased

    private void jButtonEntradaVeiculoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntradaVeiculoNaoActionPerformed
        entradaVeiculoNao();
    }//GEN-LAST:event_jButtonEntradaVeiculoNaoActionPerformed

    private void jButtonEntradaVeiculoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntradaVeiculoSimActionPerformed
        entradaVeiculoSim();
    }//GEN-LAST:event_jButtonEntradaVeiculoSimActionPerformed

    private void jDialogConfirmaEntradaVeiculoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDialogConfirmaEntradaVeiculoMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDialogConfirmaEntradaVeiculoMouseReleased

    private void jDialogConfirmaEntradaVeiculoWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogConfirmaEntradaVeiculoWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_jDialogConfirmaEntradaVeiculoWindowActivated

    private void jDialogConfirmaEntradaVeiculoWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogConfirmaEntradaVeiculoWindowClosing
        entradaVeiculoNao();
    }//GEN-LAST:event_jDialogConfirmaEntradaVeiculoWindowClosing

    private void jDialogConfirmaSaidaSistemaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDialogConfirmaSaidaSistemaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDialogConfirmaSaidaSistemaMouseReleased

    private void jDialogConfirmaSaidaSistemaWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogConfirmaSaidaSistemaWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_jDialogConfirmaSaidaSistemaWindowActivated

    private void jDialogConfirmaSaidaSistemaWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogConfirmaSaidaSistemaWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_jDialogConfirmaSaidaSistemaWindowClosing

    private void jButtonSaidaSistemaSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaidaSistemaSimActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSaidaSistemaSimActionPerformed

    private void jButtonSaidaSistemaNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaidaSistemaNaoActionPerformed
        jDialogConfirmaSaidaSistema.dispose();
    }//GEN-LAST:event_jButtonSaidaSistemaNaoActionPerformed

    private void txtRotativoPreco30minutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRotativoPreco30minutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRotativoPreco30minutosActionPerformed

    private void jButtonRotativoSairCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRotativoSairCancelarActionPerformed
        switch (jButtonRotativoSairCancelar.getText()) {
            case "Sair":
                menuPrincipal("entradasaida");
                rotativoTabelaRotativo();
                break;
            case "Cancelar":
                jButtonRotativoIncluirOk.setEnabled(true);
                jButtonRotativoExcluirCancelar.setEnabled(true);
                jButtonRotativoAlterarOk.setText("Alterar");
                jButtonRotativoSairCancelar.setText("Sair");
                jButtonRotativoAlterarOk.setMnemonic('A');
                jButtonRotativoSairCancelar.setMnemonic('S');
                rotativoCamposStatus(false);
                JOptionPane.showMessageDialog(this, "Alterações canceladas!!!");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonRotativoSairCancelarActionPerformed

    private void jButtonRotativoAlterarOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRotativoAlterarOkActionPerformed
        switch (jButtonRotativoAlterarOk.getText()) {
            case "Alterar":
                if (jTableRotativo.getRowCount() != 0 && jTableRotativo.getSelectedRowCount() != 0) {
                    jButtonRotativoIncluirOk.setEnabled(false);
                    jButtonRotativoExcluirCancelar.setEnabled(false);
                    jButtonRotativoAlterarOk.setText("Ok");
                    jButtonRotativoAlterarOk.setMnemonic('O');
                    jButtonRotativoSairCancelar.setText("Cancelar");
                    jButtonRotativoSairCancelar.setMnemonic('C');
                    rotativoNomeAnterior = jTextFieldRotativoIncluirAlterar.getText();
                    rotativoCamposStatus(true);
                    rotativoExibirAtributos();
                } else {
                    JOptionPane.showMessageDialog(this, "Selecione um dos rotativos da tabela para alteração!!!");
                }
                break;
            case "Ok":
                rotativo.setNome(jTextFieldRotativoIncluirAlterar.getText());
                rotativo.setIdRotativo(0);
                rotativo = rotativoService.rotativoVerificaExistencia(rotativo);
                if (rotativo.getIdRotativo() != 0) {
                    JOptionPane.showMessageDialog(this, "Já existe um rotativo chamado:" + rotativo.getNome() + "\n Escolha outro nome para este rotativo!!!");
                    jTextFieldRotativoIncluirAlterar.requestFocus();
                    break;
                } else {
                    jButtonRotativoIncluirOk.setEnabled(true);
                    jButtonRotativoExcluirCancelar.setEnabled(true);
                    jButtonRotativoAlterarOk.setText("Alterar");
                    jButtonRotativoAlterarOk.setMnemonic('A');
                    jButtonRotativoSairCancelar.setText("Sair");
                    jButtonRotativoSairCancelar.setMnemonic('S');
                    rotativo.setNome(jTextFieldRotativoIncluirAlterar.getText());
                    rotativo.setPreco30Minutos(Float.parseFloat(txtRotativoPreco30minutos.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                    rotativo.setPreco60Minutos(Float.parseFloat(txtRotativoPreco60minutos.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                    rotativo.setPrecoDemaisFracoes(Float.parseFloat(txtRotativoPrecoDemaisFracoes.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                    rotativo.setPrecoDiaria(Float.parseFloat(txtRotativoPrecoDiaria.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                    rotativo.setPrecoPernoite(Float.parseFloat(txtRotativoPrecoPernoite.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                    rotativoService.rotativoAlterarPrecos(rotativoNomeAnterior, rotativo);
                    rotativoCamposStatus(false);
                    rotativoTabelaRotativo();
                    JOptionPane.showMessageDialog(this, "Alterações efetuadas com sucesso!!!");
                }
            default:
                break;
        }
    }//GEN-LAST:event_jButtonRotativoAlterarOkActionPerformed

    private void jButtonRotativoIncluirOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRotativoIncluirOkActionPerformed
        switch (jButtonRotativoIncluirOk.getText()) {
            case "Incluir":
                ok = "Incluir";
                jButtonRotativoAlterarOk.setEnabled(false);
                jButtonRotativoSairCancelar.setEnabled(false);
                jButtonRotativoIncluirOk.setText("Ok");
                jButtonRotativoIncluirOk.setMnemonic('O');
                jButtonRotativoExcluirCancelar.setText("Cancelar");
                jButtonRotativoExcluirCancelar.setMnemonic('C');
                rotativoCamposStatus(true);
                break;
            case "Ok":
                if (ok.equalsIgnoreCase("Excluir")) { //Ok para exclusão
                    jTableRotativo.setEnabled(true);
                    rotativo.setNome(String.valueOf(jTableRotativo.getValueAt(jTableRotativo.getSelectedRow(), 0)));
                    rotativoService.rotativoExcluirTipoPrecos(rotativo);
                    JOptionPane.showMessageDialog(this, "Exclusão efetuadas com sucesso!!!");
                } else { //Ok para Inclusão
                    rotativo.setNome(jTextFieldRotativoIncluirAlterar.getText());
                    rotativo.setIdRotativo(0);
                    rotativo = rotativoService.rotativoVerificaExistencia(rotativo);
                    if (rotativo.getIdRotativo() != 0) {
                        JOptionPane.showMessageDialog(this, "Já existe um rotativo chamado:" + rotativo.getNome() + "\n Escolha outro nome para este rotativo!!!");
                        jTextFieldRotativoIncluirAlterar.requestFocus();
                        break;
                    } else {
                        rotativo.setNome(jTextFieldRotativoIncluirAlterar.getText());
                        rotativo.setPreco30Minutos(Float.parseFloat(txtRotativoPreco30minutos.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                        rotativo.setPreco60Minutos(Float.parseFloat(txtRotativoPreco60minutos.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                        rotativo.setPrecoDemaisFracoes(Float.parseFloat(txtRotativoPrecoDemaisFracoes.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                        rotativo.setPrecoDiaria(Float.parseFloat(txtRotativoPrecoDiaria.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                        rotativo.setPrecoPernoite(Float.parseFloat(txtRotativoPrecoPernoite.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                        rotativoService.rotativoIncluirTipoPrecos(rotativo);
                        JOptionPane.showMessageDialog(this, "Inclusão efetuada com sucesso!!!");
                    }
                }
                jButtonRotativoAlterarOk.setEnabled(true);
                jButtonRotativoSairCancelar.setEnabled(true);
                jButtonRotativoIncluirOk.setText("Incluir");
                jButtonRotativoIncluirOk.setMnemonic('I');
                jButtonRotativoExcluirCancelar.setText("Excluir");
                jButtonRotativoExcluirCancelar.setMnemonic('E');
                rotativoTabelaRotativo();
            default:
                break;
        }
    }//GEN-LAST:event_jButtonRotativoIncluirOkActionPerformed

    private void jButtonRotativoExcluirCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRotativoExcluirCancelarActionPerformed
        switch (jButtonRotativoExcluirCancelar.getText()) {
            case "Excluir":
                if (jTableRotativo.getRowCount() != 0 && jTableRotativo.getSelectedRowCount() != 0) {
                    ok = "Excluir";
                    jTableRotativo.setEnabled(false);
                    jButtonRotativoAlterarOk.setEnabled(false);
                    jButtonRotativoSairCancelar.setEnabled(false);
                    jButtonRotativoIncluirOk.setText("Ok");
                    jButtonRotativoIncluirOk.setMnemonic('O');
                    jButtonRotativoExcluirCancelar.setText("Cancelar");
                    jButtonRotativoExcluirCancelar.setMnemonic('C');
                } else {
                    JOptionPane.showMessageDialog(this, "Selecione um dos rotativos da tabela para exclusão!!!");
                }
                break;
            case "Cancelar":
                jTableRotativo.setEnabled(true);
                jButtonRotativoAlterarOk.setEnabled(true);
                jButtonRotativoSairCancelar.setEnabled(true);
                jButtonRotativoIncluirOk.setText("Incluir");
                jButtonRotativoIncluirOk.setMnemonic('I');
                jButtonRotativoExcluirCancelar.setText("Excluir");
                jButtonRotativoExcluirCancelar.setMnemonic('E');
                rotativoCamposStatus(false);
                JOptionPane.showMessageDialog(this, "Modificação cancelada!!!");
            default:
                break;
        }
    }//GEN-LAST:event_jButtonRotativoExcluirCancelarActionPerformed

    private void jTextFieldRotativoIncluirAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRotativoIncluirAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRotativoIncluirAlterarActionPerformed

    private void jButtonConfiguracoesAlterarOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracoesAlterarOkActionPerformed
        configuracoesAlterarOk();
    }//GEN-LAST:event_jButtonConfiguracoesAlterarOkActionPerformed

    private void jButtonConfiguracoesSairCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracoesSairCancelarActionPerformed
        configuracoesSairCancelar();
    }//GEN-LAST:event_jButtonConfiguracoesSairCancelarActionPerformed

    private void jListConfiguracoesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListConfiguracoesKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (jListConfiguracoes.getModel().getSize() != 0) {
                switch (jListConfiguracoes.getSelectedValue()) {
                    case "Tolerância":
                        configuracoesEscolhaTolerancia();
                        break;
                    case "Diária":
                        configuracoesEscolhaDiaria();
                        break;
                    case "Pernoite":
                        configuracoesEscolhaPernoite();
                        break;
                    default:
                        break;
                }
            }
        }
    }//GEN-LAST:event_jListConfiguracoesKeyReleased

    private void txtConfiguracoesToleranciaDesistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfiguracoesToleranciaDesistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfiguracoesToleranciaDesistenciaActionPerformed

    private void txtConfiguracoesToleranciaFracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfiguracoesToleranciaFracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfiguracoesToleranciaFracaoActionPerformed

    private void txtConfiguracoesDiariaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfiguracoesDiariaHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfiguracoesDiariaHoraActionPerformed

    private void txtConfiguracoesDiariaMinutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfiguracoesDiariaMinutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfiguracoesDiariaMinutoActionPerformed

    private void txtConfiguracoesPernoiteInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfiguracoesPernoiteInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfiguracoesPernoiteInicioActionPerformed

    private void txtConfiguracoesPernoiteTerminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfiguracoesPernoiteTerminoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfiguracoesPernoiteTerminoActionPerformed

    private void txtInformacoesToleranciaDesistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInformacoesToleranciaDesistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInformacoesToleranciaDesistenciaActionPerformed

    private void txtInformacoesToleranciaFracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInformacoesToleranciaFracoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInformacoesToleranciaFracoesActionPerformed

    private void txtInformacoesDiariaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInformacoesDiariaHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInformacoesDiariaHoraActionPerformed

    private void txtInformacoesDiariaMinutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInformacoesDiariaMinutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInformacoesDiariaMinutoActionPerformed

    private void txtInformacoesPernoiteInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInformacoesPernoiteInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInformacoesPernoiteInicioActionPerformed

    private void txtInformacoesPernoiteTerminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInformacoesPernoiteTerminoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInformacoesPernoiteTerminoActionPerformed

    private void jButtonPatioSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatioSairActionPerformed
        menuPrincipal("entradasaida");
    }//GEN-LAST:event_jButtonPatioSairActionPerformed

    private void jButtonMovimentoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMovimentoSairActionPerformed
        menuPrincipal("entradasaida");
    }//GEN-LAST:event_jButtonMovimentoSairActionPerformed

    private void jButtonMovimentoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMovimentoListarActionPerformed
        if (jFormattedTextField1.getText().matches("[0-9]{2,2}/[0-9]{2,2}/[0-9]{4,4}")) {
            movimentoData = jFormattedTextField1.getText();
            menuPrincipal("movimento");
        } else {
            JOptionPane.showMessageDialog(this, "A data informada não tem um formato válido!!!");
        }

    }//GEN-LAST:event_jButtonMovimentoListarActionPerformed

    private void jTablePatioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablePatioKeyPressed

    }//GEN-LAST:event_jTablePatioKeyPressed

    private void jTableRotativoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableRotativoKeyPressed

    }//GEN-LAST:event_jTableRotativoKeyPressed

    private void jTableRotativoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRotativoMouseClicked

    }//GEN-LAST:event_jTableRotativoMouseClicked

    private void jTableRotativoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRotativoMousePressed
        rotativoExibirAtributos();
    }//GEN-LAST:event_jTableRotativoMousePressed

    private void jTableRotativoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableRotativoKeyTyped

    }//GEN-LAST:event_jTableRotativoKeyTyped

    private void jTableRotativoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableRotativoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            rotativoExibirAtributos();
        }
    }//GEN-LAST:event_jTableRotativoKeyReleased

    private void jTextFieldSaidaPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaidaPrismaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaidaPrismaActionPerformed

    private void jTablePacoteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacoteMousePressed
        pacoteExibirAtributos();
    }//GEN-LAST:event_jTablePacoteMousePressed

    private void jTextFieldPacoteIncluirAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPacoteIncluirAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPacoteIncluirAlterarActionPerformed

    private void jRadioButtonUtilizacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUtilizacoesActionPerformed
        if (jRadioButtonUtilizacoes.isSelected());
        jRadioButtonUtilizacoes.setSelected(true);
        jRadioButtonDias.setSelected(false);
        jLabelPacoteQtdDiasOuUtilizacoes.setText("Quant. de utilizações");
    }//GEN-LAST:event_jRadioButtonUtilizacoesActionPerformed

    private void jRadioButtonDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDiasActionPerformed
        if (jRadioButtonDias.isSelected());
        jRadioButtonDias.setSelected(true);
        jRadioButtonUtilizacoes.setSelected(false);
        jLabelPacoteQtdDiasOuUtilizacoes.setText("Quant. de dias");
    }//GEN-LAST:event_jRadioButtonDiasActionPerformed

    private void jButtonPacoteExcluirCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPacoteExcluirCancelarActionPerformed
        switch (jButtonPacoteExcluirCancelar.getText()) {
            case "Excluir":
                if (jTablePacote.getRowCount() != 0 && jTablePacote.getSelectedRowCount() != 0) {
                    ok = "Excluir";
                    jTablePacote.setEnabled(false);
                    jButtonPacoteIncluirOk.setText("Ok");
                    jButtonPacoteIncluirOk.setMnemonic('O');
                    jButtonPacoteExcluirCancelar.setText("Cancelar");
                    jButtonPacoteExcluirCancelar.setMnemonic('C');
                    jButtonPacoteAlterarOk.setEnabled(false);
                    jButtonPacoteSairCancelar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Selecione um dos pacotes da tabela para exclusão!!!");
                }
                break;
            case "Cancelar":
                jTablePacote.setEnabled(true);
                jButtonPacoteIncluirOk.setText("Incluir");
                jButtonPacoteIncluirOk.setMnemonic('I');
                jButtonPacoteExcluirCancelar.setText("Excluir");
                jButtonPacoteExcluirCancelar.setMnemonic('E');
                jButtonPacoteAlterarOk.setEnabled(true);
                jButtonPacoteSairCancelar.setEnabled(true);
                pacoteCamposStatus(false);
                JOptionPane.showMessageDialog(this, "Modificação cancelada!!!");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonPacoteExcluirCancelarActionPerformed

    private void jButtonPacoteIncluirOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPacoteIncluirOkActionPerformed
        switch (jButtonPacoteIncluirOk.getText()) {
            case "Incluir":
                ok = "Incluir";
                jButtonPacoteIncluirOk.setText("Ok");
                jButtonPacoteIncluirOk.setMnemonic('O');
                jButtonPacoteExcluirCancelar.setText("Cancelar");
                jButtonPacoteExcluirCancelar.setMnemonic('C');
                jButtonPacoteAlterarOk.setEnabled(false);
                jButtonPacoteSairCancelar.setEnabled(false);
                pacoteCamposStatus(true);
                break;
            case "Ok":
                if (ok.equalsIgnoreCase("Excluir")) {
                    jTablePacote.setEnabled(true);
                    pacote.setNome(String.valueOf(jTablePacote.getValueAt(jTablePacote.getSelectedRow(), 0)));
                    pacoteService.pacoteExcluir(pacote);
                    JOptionPane.showMessageDialog(this, "Exclusão efetuadas com sucesso!!!");
                } else if (ok.equalsIgnoreCase("Incluir")) { //ok para Incluir
                    pacote.setNome(jTextFieldPacoteIncluirAlterar.getText());
                    pacote.setIdPacote(0);
                    pacote = pacoteService.pacoteVerificaExistencia(pacote);
                    if (pacote.getIdPacote() != 0) {
                        JOptionPane.showMessageDialog(this, "Já existe um pacote chamado:" + pacote.getNome() + "\n Escolha outro nome para este pacote!!!");
                        jTextFieldPacoteIncluirAlterar.requestFocus();
                        break;
                    } else {
                        if (jRadioButtonDias.isSelected()) {
                            pacote.setUtilizacoesOuDias("Dias");
                        } else if (jRadioButtonUtilizacoes.isSelected()) {
                            pacote.setUtilizacoesOuDias("Utilizações");
                        }
                        pacote.setQuantidade(Integer.valueOf(jTextFieldPacoteQuantidade.getText()));
                        pacote.setValor(Float.valueOf(jTextFieldPacoteValor.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                        jTextFieldPacoteIncluirAlterar.setEditable(false);
                        jRadioButtonDias.setEnabled(false);
                        jRadioButtonUtilizacoes.setEnabled(false);
                        jTextFieldPacoteQuantidade.setEditable(false);
                        jTextFieldPacoteValor.setEditable(false);
                        pacoteService.pacoteIncluir(pacote);
                        JOptionPane.showMessageDialog(this, "Inclusão efetuada com sucesso!!!");
                    }
                }
                jButtonPacoteAlterarOk.setEnabled(true);
                jButtonPacoteSairCancelar.setEnabled(true);
                jButtonPacoteIncluirOk.setText("Incluir");
                jButtonPacoteIncluirOk.setMnemonic('I');
                jButtonPacoteExcluirCancelar.setText("Excluir");
                jButtonPacoteExcluirCancelar.setMnemonic('E');
                pacoteTabelaPacote();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonPacoteIncluirOkActionPerformed

    private void jTextFieldPacoteValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPacoteValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPacoteValorActionPerformed

    private void jButtonPacoteSairCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPacoteSairCancelarActionPerformed
        switch (jButtonPacoteSairCancelar.getText()) {
            case "Sair":
                menuPrincipal("entradasaida");
                break;
            case "Cancelar":
                jButtonPacoteAlterarOk.setText("Alterar");
                jButtonPacoteAlterarOk.setMnemonic('A');
                jButtonPacoteSairCancelar.setText("Sair");
                jButtonPacoteSairCancelar.setMnemonic('S');
                jButtonPacoteIncluirOk.setEnabled(true);
                jButtonPacoteExcluirCancelar.setEnabled(true);
                pacoteCamposStatus(false);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonPacoteSairCancelarActionPerformed

    private void jButtonPacoteAlterarOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPacoteAlterarOkActionPerformed
        switch (jButtonPacoteAlterarOk.getText()) {
            case "Alterar":
                if (jTablePacote.getRowCount() != 0 && jTablePacote.getSelectedRowCount() != 0) {
                    jButtonPacoteAlterarOk.setText("Ok");
                    jButtonPacoteAlterarOk.setMnemonic('O');
                    jButtonPacoteSairCancelar.setText("Cancelar");
                    jButtonPacoteSairCancelar.setMnemonic('C');
                    jButtonPacoteIncluirOk.setEnabled(false);
                    jButtonPacoteExcluirCancelar.setEnabled(false);
                    pacoteNomeAnterior = jTextFieldPacoteIncluirAlterar.getText();
                    pacoteCamposStatus(true);
                    pacoteExibirAtributos();
                } else {
                    JOptionPane.showMessageDialog(this, "Selecione um dos pacotes da tabela para alteração!!!");
                }
                break;
            case "Ok":
                pacote.setNome(jTextFieldPacoteIncluirAlterar.getText());
                pacote.setIdPacote(0);
                pacote = pacoteService.pacoteVerificaExistencia(pacote);
                if (pacote.getIdPacote() != 0) {
                    JOptionPane.showMessageDialog(this, "Já existe um pacote chamado:" + pacote.getNome() + "\n Escolha outro nome para este pacote!!!");
                    jTextFieldPacoteIncluirAlterar.requestFocus();
                    break;
                } else {
                    jButtonPacoteAlterarOk.setText("Alterar");
                    jButtonPacoteAlterarOk.setMnemonic('A');
                    jButtonPacoteSairCancelar.setText("Sair");
                    jButtonPacoteSairCancelar.setMnemonic('S');
                    jButtonPacoteIncluirOk.setEnabled(true);
                    jButtonPacoteExcluirCancelar.setEnabled(true);
                    pacote.setNome(jTextFieldPacoteIncluirAlterar.getText());
                    if (jRadioButtonDias.isSelected()) {
                        pacote.setUtilizacoesOuDias("Dias");
                    } else if (jRadioButtonUtilizacoes.isSelected()) {
                        pacote.setUtilizacoesOuDias("Utilizações");
                    }
                    pacote.setQuantidade(Integer.valueOf(jTextFieldPacoteQuantidade.getText()));
                    pacote.setValor(Float.valueOf(jTextFieldPacoteValor.getText().replaceAll("\\.", "").replaceAll(",", ".")));
                    pacoteService.pacoteAlterar(pacoteNomeAnterior, pacote);
                    pacoteCamposStatus(false);
                    pacoteTabelaPacote();
                    JOptionPane.showMessageDialog(this, "Alteração efetuada com sucesso!!!");
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonPacoteAlterarOkActionPerformed

    private void jTextFieldPacoteQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPacoteQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPacoteQuantidadeActionPerformed

    private void jTablePacoteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablePacoteKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            pacoteExibirAtributos();
        }
    }//GEN-LAST:event_jTablePacoteKeyReleased

    private void jTablePacoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablePacoteKeyTyped
        pacoteExibirAtributos();
    }//GEN-LAST:event_jTablePacoteKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        confirmaSaidaSistema();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonPatioListaPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatioListaPlacaActionPerformed
        patioOrdenarLista = "placa";
        menuPrincipal("patio");
    }//GEN-LAST:event_jButtonPatioListaPlacaActionPerformed

    private void jButtonPatioListaPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatioListaPrismaActionPerformed
        patioOrdenarLista = "prisma";
        menuPrincipal("patio");
    }//GEN-LAST:event_jButtonPatioListaPrismaActionPerformed

    private void jButtonPatioListaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatioListaTipoActionPerformed
        patioOrdenarLista = "tipo";
        menuPrincipal("patio");
    }//GEN-LAST:event_jButtonPatioListaTipoActionPerformed

    private void jButtonPatioListaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatioListaEntradaActionPerformed
        patioOrdenarLista = "entrada";
        menuPrincipal("patio");
    }//GEN-LAST:event_jButtonPatioListaEntradaActionPerformed

    private void jButtonMensalistaCadastroSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaCadastroSairActionPerformed
        jTabbedPaneMensalista.setEnabledAt(0, true);
        jTabbedPaneMensalista.setEnabledAt(1, false);
        jTabbedPaneMensalista.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonMensalistaCadastroSairActionPerformed

    private void jButtonMensalistaCadastroAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaCadastroAlterarActionPerformed
        jButtonMensalistaCadastroAlterar.setEnabled(false);
        jButtonMensalistaCadastroAtivarInativar.setEnabled(false);
        jButtonMensalistaCadastroOk.setEnabled(true);
        jButtonMensalistaCadastroCancelar.setEnabled(true);
        mensalistaStatus = "Alteração";
        jLabelMensalistaStatus.setText("Alteração de MENSALISTA!");
        mensalistaJTextStatus(true);
    }//GEN-LAST:event_jButtonMensalistaCadastroAlterarActionPerformed

    private void jButtonMensalistaCadastroAtivarInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaCadastroAtivarInativarActionPerformed
        if (jTextFieldMensalistaStatus.getText().equalsIgnoreCase("Ativo")) {
            jTextFieldMensalistaStatus.setText("Inativo");
            jButtonMensalistaCadastroAtivarInativar.setText("Ativar");
        } else if (jTextFieldMensalistaStatus.getText().equalsIgnoreCase("Inativo")) {
            jTextFieldMensalistaStatus.setText("Ativo");
            jButtonMensalistaCadastroAtivarInativar.setText("Inativar");
        }
    }//GEN-LAST:event_jButtonMensalistaCadastroAtivarInativarActionPerformed

    private void jButtonMensalistaCadastroCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaCadastroCancelarActionPerformed

    }//GEN-LAST:event_jButtonMensalistaCadastroCancelarActionPerformed

    private void jButtonMensalistaCadastroOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaCadastroOkActionPerformed
        switch (mensalistaStatus) {
            case "Inclusão":
                if (mensalistaVerificaCamposValidos()) {
                    mensalista = mensalistaService.mensalistaIncluir(mensalistaPopularObjeto());
                    jTextFieldMensalistaContratoNumero.setText(String.valueOf(mensalista.getNumeroDoContrato()));
                    JOptionPane.showMessageDialog(this, "Inclusão de mensalista efetuada com sucesso!!!\n\n"
                            + "NOME[ " + mensalista.getNome() + " ]\n"
                            + "N. CONTRATO[ " + mensalista.getNumeroDoContrato() + " ]");
                }
                break;
            case "Alteração":
                if (mensalistaVerificaCamposValidos()) {
                    SimpleDateFormat dataAlteracao = new SimpleDateFormat("ddMMyyyy");
                    jFormattedTextFieldMensalistaDataUltimaAlteracao.setText(dataAlteracao.format(new Date()));
                    mensalista = mensalistaService.mensalistaAlterar(mensalistaPopularObjeto());
                    JOptionPane.showMessageDialog(this, "Alteração efetuada com sucesso!!!\n\n"
                            + "NOME[ " + mensalista.getNome() + " ]\n"
                            + "N. CONTRATO[ " + mensalista.getNumeroDoContrato() + " ]\n\n"
                            + "Ultima alteração realizada em[ " + jFormattedTextFieldMensalistaDataUltimaAlteracao.getText() + " ]");
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonMensalistaCadastroOkActionPerformed

    private void jTextFieldMensalistaAno04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaAno04ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaAno04ActionPerformed

    private void jTextFieldMensalistaCor04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaCor04ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaCor04ActionPerformed

    private void jTextFieldMensalistaModelo04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaModelo04ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaModelo04ActionPerformed

    private void jTextFieldMensalistaMontadora04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaMontadora04ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaMontadora04ActionPerformed

    private void jTextFieldMensalistaAno03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaAno03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaAno03ActionPerformed

    private void jTextFieldMensalistaCor03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaCor03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaCor03ActionPerformed

    private void jTextFieldMensalistaModelo03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaModelo03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaModelo03ActionPerformed

    private void jTextFieldMensalistaMontadora03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaMontadora03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaMontadora03ActionPerformed

    private void jTextFieldMensalistaAno02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaAno02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaAno02ActionPerformed

    private void jTextFieldMensalistaCor02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaCor02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaCor02ActionPerformed

    private void jTextFieldMensalistaModelo02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaModelo02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaModelo02ActionPerformed

    private void jTextFieldMensalistaMontadora02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaMontadora02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaMontadora02ActionPerformed

    private void jTextFieldMensalistaAno01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaAno01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaAno01ActionPerformed

    private void jTextFieldMensalistaCor01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaCor01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaCor01ActionPerformed

    private void jTextFieldMensalistaModelo01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaModelo01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaModelo01ActionPerformed

    private void jTextFieldMensalistaMontadora01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaMontadora01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaMontadora01ActionPerformed

    private void jTextFieldMensalistaEstadoComeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaEstadoComeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaEstadoComeActionPerformed

    private void jTextFieldMensalistaCidadeComeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaCidadeComeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaCidadeComeActionPerformed

    private void jTextFieldMensalistaBairroComeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaBairroComeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaBairroComeActionPerformed

    private void jTextFieldMensalistaComplementoComeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaComplementoComeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaComplementoComeActionPerformed

    private void jTextFieldMensalistaNumeroComeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaNumeroComeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaNumeroComeActionPerformed

    private void jTextFieldMensalistaRuaComeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaRuaComeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaRuaComeActionPerformed

    private void jTextFieldMensalistaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaEmpresaActionPerformed

    private void jTextFieldMensalistaEstadoResiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaEstadoResiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaEstadoResiActionPerformed

    private void jTextFieldMensalistaCidadeResiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaCidadeResiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaCidadeResiActionPerformed

    private void jTextFieldMensalistaBairroResiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaBairroResiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaBairroResiActionPerformed

    private void jTextFieldMensalistaNumeroResiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaNumeroResiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaNumeroResiActionPerformed

    private void jTextFieldMensalistaRuaResiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaRuaResiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaRuaResiActionPerformed

    private void jTextFieldMensalistaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaNomeActionPerformed

    private void jTextFieldMensalistaComplementoResiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaComplementoResiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaComplementoResiActionPerformed

    private void jTextFieldMensalistaIdentidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaIdentidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaIdentidadeActionPerformed

    private void jTextFieldMensalistaEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaEmailActionPerformed

    private void jButtonMensalistaPesquisaExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaPesquisaExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMensalistaPesquisaExcluirActionPerformed

    private void jButtonMensalistaPesquisaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaPesquisaAlterarActionPerformed
        if (mensalistaPesquisaConsultar()) {
            jTabbedPaneMensalista.setEnabledAt(0, false);
            jTabbedPaneMensalista.setEnabledAt(1, true);
            jTabbedPaneMensalista.setSelectedIndex(1);
            jButtonMensalistaCadastroAlterar.setEnabled(false);
            jButtonMensalistaCadastroAtivarInativar.setEnabled(false);
            jButtonMensalistaCadastroOk.setEnabled(true);
            jButtonMensalistaCadastroCancelar.setEnabled(true);
            mensalistaStatus = "Alteração";
            jLabelMensalistaStatus.setText("Alteração de MENSALISTA!");
            mensalistaJTextStatus(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um mensalista!");
        }
    }//GEN-LAST:event_jButtonMensalistaPesquisaAlterarActionPerformed

    private void jButtonMensalistaPesquisaConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaPesquisaConsultarActionPerformed
        jTabbedPaneMensalista.setEnabledAt(0, false);
        jTabbedPaneMensalista.setEnabledAt(1, true);
        jTabbedPaneMensalista.setSelectedIndex(1);
        jButtonMensalistaCadastroAlterar.setEnabled(true);
        jButtonMensalistaCadastroAtivarInativar.setEnabled(true);
        jButtonMensalistaCadastroOk.setEnabled(false);
        jButtonMensalistaCadastroCancelar.setEnabled(false);
        mensalistaStatus = "Consulta";
        jLabelMensalistaStatus.setText("Consulta dados mensalista!");
        mensalistaJTextStatus(false);
        mensalistaPesquisaConsultar();
    }//GEN-LAST:event_jButtonMensalistaPesquisaConsultarActionPerformed

    private void jButtonMensalistaPesquisaPerquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaPesquisaPerquisarActionPerformed
        mensalistaNomePesquisa = jTextFieldMensalistaNomePesquisa.getText();
        mensalistaCarregarPesquisa();
    }//GEN-LAST:event_jButtonMensalistaPesquisaPerquisarActionPerformed

    private void jTextFieldMensalistaNomePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMensalistaNomePesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMensalistaNomePesquisaActionPerformed

    private void jButtonMensalistaPesquisaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaPesquisaSairActionPerformed
        menuPrincipal("entradasaida");
    }//GEN-LAST:event_jButtonMensalistaPesquisaSairActionPerformed

    private void jButtonMensalistaPesquisaIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensalistaPesquisaIncluirActionPerformed
        jTabbedPaneMensalista.setEnabledAt(0, false);
        jTabbedPaneMensalista.setEnabledAt(1, true);
        jTabbedPaneMensalista.setSelectedIndex(1);
        jButtonMensalistaCadastroAlterar.setEnabled(false);
        jButtonMensalistaCadastroAtivarInativar.setEnabled(false);
        jButtonMensalistaCadastroAtivarInativar.setText("Inativar");
        jButtonMensalistaCadastroOk.setEnabled(true);
        jButtonMensalistaCadastroCancelar.setEnabled(true);
        mensalistaStatus = "Inclusão";
        jLabelMensalistaStatus.setText("Inclusão de MENSALISTA!");
        mensalistaJTextStatus(true);
        mensalistaJTextConteudo(null);
        SimpleDateFormat dataInclusao = new SimpleDateFormat("ddMMyyyy");
        jFormattedTextFieldMensalistaDataInclusao.setText(dataInclusao.format(new Date()));
        jTextFieldMensalistaStatus.setText("Ativo");
    }//GEN-LAST:event_jButtonMensalistaPesquisaIncluirActionPerformed

    private void jTableMensalistaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableMensalistaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableMensalistaKeyPressed

    private void jButtonF10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF10ActionPerformed
        confirmaSaidaSistema();
    }//GEN-LAST:event_jButtonF10ActionPerformed

    private void jButtonF8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF8ActionPerformed
        menuPrincipal("configuracoes");
    }//GEN-LAST:event_jButtonF8ActionPerformed

    private void jButtonF6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF6ActionPerformed
        patioOrdenarLista = "movimento";
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        jFormattedTextField1.setText(sdf.format(new Date()));
        movimentoData = jFormattedTextField1.getText();
        jPanel25.setBorder(BorderFactory.createTitledBorder("Movimento do dia: " + jFormattedTextField1.getText()));
        menuPrincipal("movimento");
    }//GEN-LAST:event_jButtonF6ActionPerformed

    private void jButtonF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF5ActionPerformed
        patioOrdenarLista = "entrada";
        menuPrincipal("patio");
    }//GEN-LAST:event_jButtonF5ActionPerformed

    private void jButtonF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF4ActionPerformed
        menuPrincipal("rotativo");
    }//GEN-LAST:event_jButtonF4ActionPerformed

    private void jButtonF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF3ActionPerformed
        menuPrincipal("pacote");
    }//GEN-LAST:event_jButtonF3ActionPerformed

    private void jButtonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF2ActionPerformed
        jTabbedPaneMensalista.setEnabledAt(0, true);
        jTabbedPaneMensalista.setEnabledAt(1, false);
        jTabbedPaneMensalista.setSelectedIndex(0);
        mensalistaNomePesquisa = "";
        menuPrincipal("mensalista");
    }//GEN-LAST:event_jButtonF2ActionPerformed

    private void jButtonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF1ActionPerformed
        //menuPrincipal("entradasaida");
    }//GEN-LAST:event_jButtonF1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfiguracoesAlterarOk;
    private javax.swing.JButton jButtonConfiguracoesSairCancelar;
    private javax.swing.JButton jButtonEntradaVeiculoNao;
    private javax.swing.JButton jButtonEntradaVeiculoSim;
    private javax.swing.JButton jButtonF1;
    private javax.swing.JButton jButtonF10;
    private javax.swing.JButton jButtonF2;
    private javax.swing.JButton jButtonF3;
    private javax.swing.JButton jButtonF4;
    private javax.swing.JButton jButtonF5;
    private javax.swing.JButton jButtonF6;
    private javax.swing.JButton jButtonF8;
    private javax.swing.JButton jButtonMensalistaCadastroAlterar;
    private javax.swing.JButton jButtonMensalistaCadastroAtivarInativar;
    private javax.swing.JButton jButtonMensalistaCadastroCancelar;
    private javax.swing.JButton jButtonMensalistaCadastroOk;
    private javax.swing.JButton jButtonMensalistaCadastroSair;
    private javax.swing.JButton jButtonMensalistaPesquisaAlterar;
    private javax.swing.JButton jButtonMensalistaPesquisaConsultar;
    private javax.swing.JButton jButtonMensalistaPesquisaExcluir;
    private javax.swing.JButton jButtonMensalistaPesquisaIncluir;
    private javax.swing.JButton jButtonMensalistaPesquisaPerquisar;
    private javax.swing.JButton jButtonMensalistaPesquisaSair;
    private javax.swing.JButton jButtonMovimentoListar;
    private javax.swing.JButton jButtonMovimentoSair;
    private javax.swing.JButton jButtonPacoteAlterarOk;
    private javax.swing.JButton jButtonPacoteExcluirCancelar;
    private javax.swing.JButton jButtonPacoteIncluirOk;
    private javax.swing.JButton jButtonPacoteSairCancelar;
    private javax.swing.JButton jButtonPatioListaEntrada;
    private javax.swing.JButton jButtonPatioListaPlaca;
    private javax.swing.JButton jButtonPatioListaPrisma;
    private javax.swing.JButton jButtonPatioListaTipo;
    private javax.swing.JButton jButtonPatioSair;
    private javax.swing.JButton jButtonRotativoAlterarOk;
    private javax.swing.JButton jButtonRotativoExcluirCancelar;
    private javax.swing.JButton jButtonRotativoIncluirOk;
    private javax.swing.JButton jButtonRotativoSairCancelar;
    private javax.swing.JButton jButtonSaidaSistemaNao;
    private javax.swing.JButton jButtonSaidaSistemaSim;
    private javax.swing.JButton jButtonSaidaVeiculoNao;
    private javax.swing.JButton jButtonSaidaVeiculoSim;
    private javax.swing.JDialog jDialogConfirmaEntradaVeiculo;
    private javax.swing.JDialog jDialogConfirmaSaidaSistema;
    private javax.swing.JDialog jDialogConfirmaSaidaVeiculo;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaCelularResi;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaCepCome;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaCepResi;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaCpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaDataInclusao;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaDataNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaDataUltimaAlteracao;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaPlaca01;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaPlaca02;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaPlaca03;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaPlaca04;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaTelefoneCome;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaTelefoneResi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabelMensalistaStatus;
    private javax.swing.JLabel jLabelPacoteQtdDiasOuUtilizacoes;
    private javax.swing.JLabel jLabelPlacaOuPrisma;
    private javax.swing.JList<String> jListConfiguracoes;
    private javax.swing.JList<String> jListRotativoTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelApresentacao;
    private javax.swing.JPanel jPanelCabecalho;
    private javax.swing.JPanel jPanelEntradaSaida;
    private javax.swing.JPanel jPanelMensal;
    private javax.swing.JPanel jPanelOpcoes;
    private javax.swing.JPanel jPanelPacote;
    private javax.swing.JPanel jPanelVeiculoEntrada;
    private javax.swing.JPanel jPanelVeiculoSaida;
    private javax.swing.JRadioButton jRadioButtonDias;
    private javax.swing.JRadioButton jRadioButtonUtilizacoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JScrollPane jScrollPaneMovimentacoes;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPaneConfiguracoesItemAlteracao;
    private javax.swing.JTabbedPane jTabbedPaneEntradaSaida;
    private javax.swing.JTabbedPane jTabbedPaneMensalista;
    private javax.swing.JTabbedPane jTabbedPaneOpcoes;
    private javax.swing.JTable jTableEntradaSaidaInformacoesRotativo;
    private javax.swing.JTable jTableEntradaSaidaMovimentacoesRotativo;
    private javax.swing.JTable jTableMensalista;
    private javax.swing.JTable jTableMovimento;
    private javax.swing.JTable jTablePacote;
    private javax.swing.JTable jTablePatio;
    private javax.swing.JTable jTableRotativo;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextFieldConfirmaSaidaPlaca;
    private javax.swing.JTextField jTextFieldConfirmaSaidaPlaca1;
    private javax.swing.JTextField jTextFieldConfirmaSaidaPrisma;
    private javax.swing.JTextField jTextFieldConfirmaSaidaPrisma1;
    private javax.swing.JTextField jTextFieldEntradaData;
    private javax.swing.JTextField jTextFieldEntradaHora;
    private javax.swing.JTextField jTextFieldEntradaPlaca;
    private javax.swing.JTextField jTextFieldEntradaPrisma;
    private javax.swing.JTextField jTextFieldMensalistaAno01;
    private javax.swing.JTextField jTextFieldMensalistaAno02;
    private javax.swing.JTextField jTextFieldMensalistaAno03;
    private javax.swing.JTextField jTextFieldMensalistaAno04;
    private javax.swing.JTextField jTextFieldMensalistaBairroCome;
    private javax.swing.JTextField jTextFieldMensalistaBairroResi;
    private javax.swing.JTextField jTextFieldMensalistaCidadeCome;
    private javax.swing.JTextField jTextFieldMensalistaCidadeResi;
    private javax.swing.JTextField jTextFieldMensalistaComplementoCome;
    private javax.swing.JTextField jTextFieldMensalistaComplementoResi;
    private javax.swing.JTextField jTextFieldMensalistaContratoNumero;
    private javax.swing.JTextField jTextFieldMensalistaCor01;
    private javax.swing.JTextField jTextFieldMensalistaCor02;
    private javax.swing.JTextField jTextFieldMensalistaCor03;
    private javax.swing.JTextField jTextFieldMensalistaCor04;
    private javax.swing.JTextField jTextFieldMensalistaDiaVencimentoMensalidade;
    private javax.swing.JTextField jTextFieldMensalistaEmail;
    private javax.swing.JTextField jTextFieldMensalistaEmpresa;
    private javax.swing.JTextField jTextFieldMensalistaEstadoCome;
    private javax.swing.JTextField jTextFieldMensalistaEstadoResi;
    private javax.swing.JTextField jTextFieldMensalistaIdentidade;
    private javax.swing.JTextField jTextFieldMensalistaModelo01;
    private javax.swing.JTextField jTextFieldMensalistaModelo02;
    private javax.swing.JTextField jTextFieldMensalistaModelo03;
    private javax.swing.JTextField jTextFieldMensalistaModelo04;
    private javax.swing.JTextField jTextFieldMensalistaMontadora01;
    private javax.swing.JTextField jTextFieldMensalistaMontadora02;
    private javax.swing.JTextField jTextFieldMensalistaMontadora03;
    private javax.swing.JTextField jTextFieldMensalistaMontadora04;
    private javax.swing.JTextField jTextFieldMensalistaNome;
    private javax.swing.JTextField jTextFieldMensalistaNomePesquisa;
    private javax.swing.JTextField jTextFieldMensalistaNumeroCome;
    private javax.swing.JTextField jTextFieldMensalistaNumeroResi;
    private javax.swing.JTextField jTextFieldMensalistaRuaCome;
    private javax.swing.JTextField jTextFieldMensalistaRuaResi;
    private javax.swing.JTextField jTextFieldMensalistaStatus;
    private javax.swing.JTextField jTextFieldPacoteIncluirAlterar;
    private javax.swing.JTextField jTextFieldPacoteQuantidade;
    private javax.swing.JTextField jTextFieldPacoteValor;
    private javax.swing.JTextField jTextFieldRotativoIncluirAlterar;
    private javax.swing.JTextField jTextFieldRotativoTipo;
    private javax.swing.JTextField jTextFieldSaidaControle;
    private javax.swing.JTextField jTextFieldSaidaData;
    private javax.swing.JTextField jTextFieldSaidaDataEntrada;
    private javax.swing.JTextField jTextFieldSaidaDiarias;
    private javax.swing.JTextField jTextFieldSaidaHMEntrada;
    private javax.swing.JTextField jTextFieldSaidaHMSaida;
    private javax.swing.JTextField jTextFieldSaidaHora;
    private javax.swing.JTextField jTextFieldSaidaHoraEntrada;
    private javax.swing.JTextField jTextFieldSaidaPermanenciaTotal;
    private javax.swing.JTextField jTextFieldSaidaPernoites;
    private javax.swing.JTextField jTextFieldSaidaPlaca;
    private javax.swing.JTextField jTextFieldSaidaPrisma;
    private javax.swing.JTextField jTextFieldSaidaTipo;
    private javax.swing.JTextField jTextFieldSaidaValor;
    private javax.swing.JTextField txtConfiguracoesDiariaHora;
    private javax.swing.JTextField txtConfiguracoesDiariaMinuto;
    private javax.swing.JTextField txtConfiguracoesPernoiteInicio;
    private javax.swing.JTextField txtConfiguracoesPernoiteTermino;
    private javax.swing.JTextField txtConfiguracoesToleranciaDesistencia;
    private javax.swing.JTextField txtConfiguracoesToleranciaFracao;
    private javax.swing.JTextField txtEntradaPlacaOuPrisma;
    private javax.swing.JTextField txtInformacoesDiariaHora;
    private javax.swing.JTextField txtInformacoesDiariaMinuto;
    private javax.swing.JTextField txtInformacoesPernoiteInicio;
    private javax.swing.JTextField txtInformacoesPernoiteTermino;
    private javax.swing.JTextField txtInformacoesToleranciaDesistencia;
    private javax.swing.JTextField txtInformacoesToleranciaFracoes;
    private javax.swing.JTextField txtRotativoPreco30minutos;
    private javax.swing.JTextField txtRotativoPreco60minutos;
    private javax.swing.JTextField txtRotativoPrecoDemaisFracoes;
    private javax.swing.JTextField txtRotativoPrecoDiaria;
    private javax.swing.JTextField txtRotativoPrecoPernoite;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private void verificaDadoDigitado(String dadoEntrada) {
        dadoRetornoTipo = verificadorEntradaDado.verificaDadoTipo(dadoEntrada);
        switch (dadoRetornoTipo) {
            case "placa":
                veiculo.setPlaca(dadoEntrada);
                veiculoEstaCadastrado(veiculo);
                break;
            case "prisma":
                patio.setPrisma(dadoEntrada);
                prismaNoPatio(patio);
                break;
            default:
                JOptionPane.showMessageDialog(this, "É um dado inválido!!!");
                txtEntradaPlacaOuPrisma.setText(null);
                break;
        }
    }

    private void confirmaSaidaSistema() {
        jDialogConfirmaSaidaSistema.setVisible(true);
    }

    private void veiculoEstaCadastrado(Veiculo veiculo) {
        veiculo = veiculoService.verificarCadastroVeiculo(veiculo);
        if (veiculo.getIdVeiculo() != 0) {
            System.out.println("O veiculo ID:[" + veiculo.getIdVeiculo() + "] Placa:" + veiculo.getPlaca() + " Esta cadastrado!!!");
            patio.setIdVeiculoFk(veiculo.getIdVeiculo());
            patio.setPlacaFk(veiculo.getPlaca());
            veiculoNoPatio(patio);
        } else {
            System.out.println("O veiculo ID:[Nulo] Placa:" + veiculo.getPlaca() + " NÃO esta cadastrado!!!");
            escolhaRotativoTipo();
        }
    }

    private void prismaNoPatio(Patio patio) {
        patio = patioService.verificarPrisma(patio);
        if (jLabelPlacaOuPrisma.getText().equalsIgnoreCase("Placa ou Prisma")) {
            if (patio.getEstacionado().equalsIgnoreCase("sim")) {
                prepararSaidaVeiculoDoPatio();
            } else {
                JOptionPane.showMessageDialog(this, "O prisma: " + patio.getPrisma() + " Não está registrado!!! \nPara estacionar o veiculo no pátio digite a placa...");
                txtEntradaPlacaOuPrisma.setText(null);
            }
        } else if (jLabelPlacaOuPrisma.getText().equalsIgnoreCase("Digite o prisma")) {
            if (patio.getEstacionado().equalsIgnoreCase("sim")) {
                JOptionPane.showMessageDialog(this, "O Prisma[" + patio.getPrisma() + "]  Já esta sendo utilizado pelo veiculo de Placa: " + patio.getPlacaFk());
                txtEntradaPlacaOuPrisma.setText(null);
            } else {
                System.out.println("prepararEntradaVeiculoNoPatio");
                prepararEntradaVeiculoNoPatio();
            }
        }
    }

    private void limparObjetosPatio() {

        veiculo.setIdVeiculo(0);
        veiculo.setPlaca("");
        veiculo.setMarca("");
        veiculo.setModelo("");
        veiculo.setAnoFabricacao("");
        veiculo.setAnoModelo("");
        veiculo.setCor("");

        patio.setIdPatio(0);
        patio.setIdVeiculoFk(0);
        patio.setRps("");
        patio.setPlacaFk("");
        patio.setPrisma("");
        patio.setEstacionado("");
        patio.setTipo("");
        patio.setDataEntrada("");
        patio.setDataEntradaHoraMinuto("");
        patio.setHoraEntrada("");
        patio.setDataSaida("");
        patio.setDataSaidaHoraMinuto("");
        patio.setHoraSaida("");
        patio.setDiariaQuantidade(0);
        patio.setDiariaValorTotal(0);
        patio.setPernoiteQuantidade(0);
        patio.setPernoiteValorTotal(0);
        patio.setPermanencia("");
        patio.setDataEntradaValor(0);
        patio.setDataSaidaValor(0);
        patio.setValorTotal(0);

        txtEntradaPlacaOuPrisma.setText("");
        jTextFieldEntradaPlaca.setText("");
        jTextFieldEntradaPrisma.setText("");
        jTextFieldRotativoTipo.setText("");
        jTextFieldEntradaData.setText("");
        jTextFieldEntradaHora.setText("");
        jTextFieldSaidaPlaca.setText("");
        jTextFieldSaidaPrisma.setText("");
        jTextFieldSaidaTipo.setText("");
        jTextFieldSaidaDataEntrada.setText("");
        jTextFieldSaidaHoraEntrada.setText("");
        jTextFieldSaidaControle.setText("");
        jTextFieldSaidaData.setText("");
        jTextFieldSaidaHora.setText("");
        jTextFieldSaidaHMEntrada.setText("");
        jTextFieldSaidaHMSaida.setText("");
        jTextFieldSaidaDiarias.setText("");
        jTextFieldSaidaPernoites.setText("");
        jTextFieldSaidaPermanenciaTotal.setText("");
        jTextFieldSaidaValor.setText("");
        jLabelPlacaOuPrisma.setText("Placa ou Prisma");

        jTabbedPaneEntradaSaida.setEnabledAt(0, true);
        jTabbedPaneEntradaSaida.setEnabledAt(1, false);
        jTabbedPaneEntradaSaida.setEnabledAt(2, false);
        jTabbedPaneEntradaSaida.setSelectedIndex(0);
        txtEntradaPlacaOuPrisma.setDocument(new EntradaDado(7, "[^A-Z|^0-9]"));
    }

    private void entradaVeiculoSim() {
        if (patio.getIdVeiculoFk() == 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            veiculo.setDataHoraRegistro(sdf.format(new Date()));
            veiculo = veiculoService.cadastrarVeiculo(veiculo);
            patio.setIdVeiculoFk(veiculo.getIdVeiculo());
            patio.setPlacaFk(veiculo.getPlaca());
        }
        patioService.estacionarVeiculo(patio);
        movimentacoesEntrada();
        limparObjetosPatio();
        jDialogConfirmaEntradaVeiculo.dispose();
    }

    private void entradaVeiculoNao() {
        limparObjetosPatio();
        jDialogConfirmaEntradaVeiculo.dispose();
    }

    private void saidaVeiculoSim() {
        patioService.retiraVeiculo(patio);
        movimentacoesSaida();
        limparObjetosPatio();
        jDialogConfirmaSaidaVeiculo.dispose();
    }

    private void saidaVeiculoNao() {
        limparObjetosPatio();
        jDialogConfirmaSaidaVeiculo.dispose();
    }

    private void prepararEntradaVeiculoNoPatio() {
        SimpleDateFormat rps = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        jTextFieldEntradaData.setText(dataAtual.format(new Date()));
        jTextFieldEntradaHora.setText(horaAtual.format(new Date()));
        jTextFieldEntradaPrisma.setText(patio.getPrisma());

        patio.setRps(rps.format(new Date()));
        patio.setRps(patio.getRps().replaceAll("[^0-9]", ""));
        rotativo.setNome(jTextFieldRotativoTipo.getText());
        rotativo = buscaRotativoPreco(rotativo);
        patio.setTipo(rotativo.getTipo());
        patio.setPreco30Minutos(rotativo.getPreco30Minutos());
        patio.setPreco60Minutos(rotativo.getPreco60Minutos());
        patio.setPrecoDemaisFracoes(rotativo.getPrecoDemaisFracoes());
        patio.setPrecoDiaria(rotativo.getPrecoDiaria());
        patio.setPrecoPernoite(rotativo.getPrecoPernoite());
        patio.setPrisma(jTextFieldEntradaPrisma.getText());
        patio.setEstacionado("sim");
        patio.setDataEntrada(jTextFieldEntradaData.getText());
        patio.setHoraEntrada(jTextFieldEntradaHora.getText());
        patio.setToleranciaDesistencia(configuracoes.getToleranciaDesistencia());
        patio.setToleranciaEntreFracoes(configuracoes.getToleranciaFracoes());
        patio.setDiariaHoras(configuracoes.getDiariaHora());
        patio.setDiariaMinutos(configuracoes.getDiariaMinuto());
        patio.setPernoiteInicio(configuracoes.getPernoiteInicio());
        patio.setPernoiteTermino(configuracoes.getPernoiteTermino());

        jDialogConfirmaEntradaVeiculo.setVisible(true);
    }

    private void prepararSaidaVeiculoDoPatio() {
        patio.setDataSaida(dataAtual.format(new Date()));
        patio.setHoraSaida(horaAtual.format(new Date()));
        jTextFieldSaidaData.setText(patio.getDataSaida());
        jTextFieldSaidaHora.setText(patio.getHoraSaida());
        jTabbedPaneEntradaSaida.setEnabledAt(0, false);
        jTabbedPaneEntradaSaida.setEnabledAt(1, false);
        jTabbedPaneEntradaSaida.setEnabledAt(2, true);
        jTabbedPaneEntradaSaida.setSelectedIndex(2);
        jTextFieldSaidaPlaca.setText(patio.getPlacaFk());
        jTextFieldSaidaPrisma.setText(patio.getPrisma());
        jTextFieldSaidaTipo.setText(patio.getTipo());
        jTextFieldSaidaDataEntrada.setText(patio.getDataEntrada());
        jTextFieldSaidaHoraEntrada.setText(patio.getHoraEntrada());
        jTextFieldSaidaControle.setText(patio.getRps());

        RotativoCalculoSaida rotativoCalculoSaida = new RotativoCalculoSaida();
        patio = rotativoCalculoSaida.calcularPermanenciaValor(patio);

        jTextFieldSaidaHMEntrada.setText(patio.getDataEntradaHoraMinuto());
        jTextFieldSaidaDiarias.setText(String.valueOf(patio.getDiariaQuantidade()));
        jTextFieldSaidaPernoites.setText(String.valueOf(patio.getPernoiteQuantidade()));
        jTextFieldSaidaHMSaida.setText(patio.getDataSaidaHoraMinuto());
        jTextFieldSaidaValor.setText(new DecimalFormat("#,##0.00").format(patio.getValorTotal()));
        jTextFieldSaidaPermanenciaTotal.setText(patio.getPermanencia());

        jDialogConfirmaSaidaVeiculo.setVisible(true);
    }

    private void veiculoNoPatio(Patio patio) {
        patio = patioService.verificarVeiculo(patio);
        switch (patio.getEstacionado()) {
            case "sim":
                JOptionPane.showMessageDialog(this, "O Veiculo placa: " + patio.getPlacaFk() + " Já está no pátio! O número do prisma é: " + patio.getPrisma());
                limparObjetosPatio();
                break;
            default:
                System.out.println("O veiculo ID:[" + patio.getIdVeiculoFk() + "] Placa:" + patio.getPlacaFk() + " Não esta no Pátio!!!");
                System.out.println("Registrar no Pátio");
                escolhaRotativoTipo();
                break;
        }
    }

    private void escolhaRotativoTipo() {
        jTabbedPaneEntradaSaida.setEnabledAt(0, false);
        jTabbedPaneEntradaSaida.setEnabledAt(1, true);
        jTabbedPaneEntradaSaida.setSelectedIndex(1);
        jTextFieldEntradaPlaca.setText(veiculo.getPlaca());
        txtEntradaPlacaOuPrisma.setEditable(false);
        txtEntradaPlacaOuPrisma.setFocusable(false);
        jListRotativoTipo.setEnabled(true);
        jListRotativoTipo.setFocusable(true);
        jListRotativoTipo.requestFocus();
        rotativoDefaultListModel.clear();
        rotativoDefaultListModel = rotativoService.rotativoCarregarLista(rotativoDefaultListModel);
        jListRotativoTipo.setModel(rotativoDefaultListModel);
        jListRotativoTipo.setSelectedIndex(0);
    }

    private void movimentacoesEntrada() {
        movimentacoesDefaultTableModel.addRow(new String[]{
            "ENTRADA",
            patio.getPlacaFk(),
            patio.getPrisma(),
            patio.getTipo(),
            patio.getDataEntrada(),
            patio.getHoraEntrada(),
            "-------------",
            "-------------",
            patio.getRps()
        });
        jTableEntradaSaidaMovimentacoesRotativo.changeSelection(jTableEntradaSaidaMovimentacoesRotativo.getRowCount() - 1, jTableEntradaSaidaMovimentacoesRotativo.getRowCount(), false, false);
    }

    private void movimentacoesSaida() {
        movimentacoesDefaultTableModel.addRow(new String[]{
            "SAÍDA",
            patio.getPlacaFk(),
            patio.getPrisma(),
            patio.getTipo(),
            patio.getDataEntrada(),
            patio.getHoraEntrada(),
            patio.getDataSaida(),
            patio.getHoraSaida(),
            patio.getRps()
        });
        jTableEntradaSaidaMovimentacoesRotativo.changeSelection(jTableEntradaSaidaMovimentacoesRotativo.getRowCount() - 1, jTableEntradaSaidaMovimentacoesRotativo.getRowCount(), false, false);
    }

    private void patioListaVeiculo() {
        patioArrayList.clear();
        ((DefaultTableModel) jTablePatio.getModel()).setRowCount(0);
        ((DefaultTableModel) jTablePatio.getModel()).setColumnCount(0);
        patioArrayList = patioService.patioLista(patioArrayList, patioOrdenarLista);
        patioDefaultTableModel.addColumn("Placa");
        patioDefaultTableModel.addColumn("Prisma");
        patioDefaultTableModel.addColumn("Tipo");
        patioDefaultTableModel.addColumn("Data Entrada");
        patioDefaultTableModel.addColumn("Hora Entrada");
        patioDefaultTableModel.addColumn("RPS");
        patioDefaultTableModel.addColumn("Permanência");
        patioDefaultTableModel.addColumn("Valor Atual");

        for (int i = 0; i < patioArrayList.size(); i++) {
            patioDefaultTableModel.addRow(new String[]{
                patioArrayList.get(i).getPlacaFk(),
                patioArrayList.get(i).getPrisma(),
                patioArrayList.get(i).getTipo(),
                patioArrayList.get(i).getDataEntrada(),
                patioArrayList.get(i).getHoraEntrada(),
                patioArrayList.get(i).getRps(),
                patioArrayList.get(i).getPermanencia(),
                new DecimalFormat("R$ #,##0.00").format(patioArrayList.get(i).getValorTotal())
            });
        }

        jTablePatio.setModel(patioDefaultTableModel);
        jTablePatio.getColumnModel().getColumn(0).setPreferredWidth(8);
        jTablePatio.getColumnModel().getColumn(1).setPreferredWidth(8);
        jTablePatio.getColumnModel().getColumn(2).setPreferredWidth(15);
        jTablePatio.getColumnModel().getColumn(3).setPreferredWidth(22);
        jTablePatio.getColumnModel().getColumn(4).setPreferredWidth(22);
        jTablePatio.getColumnModel().getColumn(5).setPreferredWidth(65);
        jTablePatio.getColumnModel().getColumn(6).setPreferredWidth(65);
        jTablePatio.getColumnModel().getColumn(7).setPreferredWidth(40);
        jTablePatio.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Object colunaTipo = table.getValueAt(row, 2);//Coluna Status

                if (row % 2 == 0) {
                    setBackground(new Color(255, 255, 255));
                } else {
                    setBackground(new Color(230, 230, 230));
                }
                setFont(new Font("", Font.PLAIN, 16));//("Nome da fonte", estilo da fonte, tamanho da fonte)
                if (colunaTipo != null) {//Se existir a celula Tipo
                    if (colunaTipo.equals("Rotativo")) {
                        setForeground(new Color(0, 150, 0));//Fonte
                    } else if (colunaTipo.equals("Pacote")) {
                        setForeground(new Color(0, 0, 200));//Fonte
                    } else if (colunaTipo.equals("Mensalista")) {
                        setForeground(new Color(180, 140, 140));//Fonte
                    }
                }

                if (isSelected) {
                    setBackground(new Color(205, 179, 139));
                }
                return this;
            }
        });
    }

    private void rotativoTabelaRotativo() {
        rotativoArrayList.clear();
        ((DefaultTableModel) jTableRotativo.getModel()).setRowCount(0);
        ((DefaultTableModel) jTableRotativo.getModel()).setColumnCount(0);
        rotativoArrayList = rotativoService.rotativoCarregarTipoPrecoLista(rotativoArrayList);
        rotativoDefaultTableModel.addColumn("Tipo");
        rotativoDefaultTableModel.addColumn("Preço 30 min.");
        rotativoDefaultTableModel.addColumn("Preço 60 min.");
        rotativoDefaultTableModel.addColumn("Demais Frações");
        rotativoDefaultTableModel.addColumn("Diária");
        rotativoDefaultTableModel.addColumn("Pernoite");

        for (int i = 0; i < rotativoArrayList.size(); i++) {
            rotativoDefaultTableModel.addRow(new String[]{rotativoArrayList.get(i).getNome(),
                new DecimalFormat("R$ #,##0.00").format(rotativoArrayList.get(i).getPreco30Minutos()),
                new DecimalFormat("R$ #,##0.00").format(rotativoArrayList.get(i).getPreco60Minutos()),
                new DecimalFormat("R$ #,##0.00").format(rotativoArrayList.get(i).getPrecoDemaisFracoes()),
                new DecimalFormat("R$ #,##0.00").format(rotativoArrayList.get(i).getPrecoDiaria()),
                new DecimalFormat("R$ #,##0.00").format(rotativoArrayList.get(i).getPrecoPernoite())
            });
        }
        jTableRotativo.setModel(rotativoDefaultTableModel);
        jTableRotativo.getColumnModel().getColumn(0).setPreferredWidth(65);
        jTableRotativo.getColumnModel().getColumn(1).setPreferredWidth(33);
        jTableRotativo.getColumnModel().getColumn(2).setPreferredWidth(33);
        jTableRotativo.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableRotativo.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTableRotativo.getColumnModel().getColumn(5).setPreferredWidth(20);
        jTableEntradaSaidaInformacoesRotativo.setModel(jTableRotativo.getModel());
        jTableEntradaSaidaInformacoesRotativo.setColumnModel(jTableRotativo.getColumnModel());
    }

    private void pacoteTabelaPacote() {
        pacoteArrayList.clear();
        ((DefaultTableModel) jTablePacote.getModel()).setRowCount(0);
        ((DefaultTableModel) jTablePacote.getModel()).setColumnCount(0);
        pacoteArrayList = pacoteService.pacoteCarregarLista(pacoteArrayList);
        pacoteDefaultTableModel.addColumn("Nome");
        pacoteDefaultTableModel.addColumn("Dias Ou Utilização");
        pacoteDefaultTableModel.addColumn("Quantidade");
        pacoteDefaultTableModel.addColumn("Data Início");
        pacoteDefaultTableModel.addColumn("Data Término");
        pacoteDefaultTableModel.addColumn("Valor R$");

        for (int i = 0; i < pacoteArrayList.size(); i++) {
            pacoteDefaultTableModel.addRow(new String[]{
                pacoteArrayList.get(i).getNome(),
                pacoteArrayList.get(i).getUtilizacoesOuDias(),
                Integer.toString(pacoteArrayList.get(i).getQuantidade()),
                pacoteArrayList.get(i).getDataInicio(),
                pacoteArrayList.get(i).getDataTermino(),
                new DecimalFormat("R$ #,##0.00").format(pacoteArrayList.get(i).getValor())
            });
        }
        jTablePacote.setModel(pacoteDefaultTableModel);
        jTablePacote.getColumnModel().getColumn(0).setPreferredWidth(65);
        jTablePacote.getColumnModel().getColumn(1).setPreferredWidth(33);
        jTablePacote.getColumnModel().getColumn(2).setPreferredWidth(33);
        jTablePacote.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTablePacote.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTablePacote.getColumnModel().getColumn(5).setPreferredWidth(20);
    }

    private Rotativo buscaRotativoPreco(Rotativo rotativo) {
        rotativo = rotativoService.rotativoCarregarAtributos(rotativo);
        return rotativo;
    }

    private void configuracoesEscolhaTolerancia() {
        jTabbedPaneConfiguracoesItemAlteracao.setEnabledAt(0, true);
        jTabbedPaneConfiguracoesItemAlteracao.setEnabledAt(1, false);
        jTabbedPaneConfiguracoesItemAlteracao.setEnabledAt(2, false);
        jTabbedPaneConfiguracoesItemAlteracao.setSelectedIndex(0);
        configuracoes = configuracoesService.configuracoesCarregarTolerancia(configuracoes);
        txtConfiguracoesToleranciaDesistencia.setText(String.valueOf(configuracoes.getToleranciaDesistencia()));
        txtConfiguracoesToleranciaFracao.setText(String.valueOf(configuracoes.getToleranciaFracoes()));
    }

    private void configuracoesEscolhaDiaria() {
        jTabbedPaneConfiguracoesItemAlteracao.setEnabledAt(0, false);
        jTabbedPaneConfiguracoesItemAlteracao.setEnabledAt(1, true);
        jTabbedPaneConfiguracoesItemAlteracao.setEnabledAt(2, false);
        jTabbedPaneConfiguracoesItemAlteracao.setSelectedIndex(1);
        configuracoes = configuracoesService.configuracoesCarregarDiaria(configuracoes);
        txtConfiguracoesDiariaHora.setText(String.valueOf(configuracoes.getDiariaHora()));
        txtConfiguracoesDiariaMinuto.setText(String.valueOf(configuracoes.getDiariaMinuto()));
    }

    private void configuracoesEscolhaPernoite() {
        jTabbedPaneConfiguracoesItemAlteracao.setEnabledAt(0, false);
        jTabbedPaneConfiguracoesItemAlteracao.setEnabledAt(1, false);
        jTabbedPaneConfiguracoesItemAlteracao.setEnabledAt(2, true);
        jTabbedPaneConfiguracoesItemAlteracao.setSelectedIndex(2);
        configuracoes = configuracoesService.configuracoesCarregarPernoite(configuracoes);
        txtConfiguracoesPernoiteInicio.setText(configuracoes.getPernoiteInicio());
        txtConfiguracoesPernoiteTermino.setText(configuracoes.getPernoiteTermino());
        System.out.println(txtConfiguracoesPernoiteInicio.getText());
        System.out.println(txtConfiguracoesPernoiteTermino.getText());
    }

    private void configuracoesAlterarOk() {
        switch (jButtonConfiguracoesAlterarOk.getText()) {
            case "Alterar":
                jListConfiguracoes.setEnabled(false);
                jButtonConfiguracoesAlterarOk.setText("Ok");
                jButtonConfiguracoesSairCancelar.setText("Cancelar");
                switch (jTabbedPaneConfiguracoesItemAlteracao.getSelectedIndex()) {
                    case 0: //Tolerância
                        txtConfiguracoesToleranciaDesistencia.setEditable(true);
                        txtConfiguracoesToleranciaDesistencia.setFocusable(true);
                        txtConfiguracoesToleranciaFracao.setEditable(true);
                        txtConfiguracoesToleranciaFracao.setFocusable(true);
                        txtConfiguracoesToleranciaDesistencia.requestFocus();
                        break;
                    case 1: //Diária
                        txtConfiguracoesDiariaHora.setEditable(true);
                        txtConfiguracoesDiariaHora.setFocusable(true);
                        txtConfiguracoesDiariaMinuto.setEditable(true);
                        txtConfiguracoesDiariaMinuto.setFocusable(true);
                        txtConfiguracoesDiariaHora.requestFocus();
                        break;
                    case 2: //Pernoite
                        txtConfiguracoesPernoiteInicio.setEditable(true);
                        txtConfiguracoesPernoiteInicio.setFocusable(true);
                        txtConfiguracoesPernoiteTermino.setEditable(true);
                        txtConfiguracoesPernoiteTermino.setFocusable(true);
                        txtConfiguracoesPernoiteInicio.requestFocus();
                        break;
                    default:
                        break;
                }
                break;
            case "Ok":
                jListConfiguracoes.setEnabled(true);
                jListConfiguracoes.requestFocus();
                jButtonConfiguracoesAlterarOk.setText("Alterar");
                jButtonConfiguracoesSairCancelar.setText("Sair");
                switch (jTabbedPaneConfiguracoesItemAlteracao.getSelectedIndex()) {
                    case 0: //Tolerância
                        txtConfiguracoesToleranciaDesistencia.setEditable(false);
                        txtConfiguracoesToleranciaDesistencia.setFocusable(false);
                        txtConfiguracoesToleranciaFracao.setEditable(false);
                        txtConfiguracoesToleranciaFracao.setFocusable(false);

                        configuracoes.setToleranciaDesistencia(Integer.valueOf(txtConfiguracoesToleranciaDesistencia.getText()));
                        configuracoes.setToleranciaFracoes(Integer.valueOf(txtConfiguracoesToleranciaFracao.getText()));
                        configuracoesService.configuracoesAlterarTolerancia(configuracoes);
                        JOptionPane.showMessageDialog(this, "Alterações na tolerância efetuadas com sucesso!!!");
                        break;
                    case 1: //Diária
                        txtConfiguracoesDiariaHora.setEditable(false);
                        txtConfiguracoesDiariaHora.setFocusable(false);
                        txtConfiguracoesDiariaMinuto.setEditable(false);
                        txtConfiguracoesDiariaMinuto.setFocusable(false);
                        configuracoes.setDiariaHora(Integer.valueOf(txtConfiguracoesDiariaHora.getText()));
                        configuracoes.setDiariaMinuto(Integer.valueOf(txtConfiguracoesDiariaMinuto.getText()));
                        configuracoesService.configuracoesAlterarDiaria(configuracoes);
                        JOptionPane.showMessageDialog(this, "Alteração na diária efetuada com sucesso!!!");
                        break;
                    case 2: //Pernoite
                        txtConfiguracoesPernoiteInicio.setEditable(false);
                        txtConfiguracoesPernoiteInicio.setFocusable(false);
                        txtConfiguracoesPernoiteTermino.setEditable(false);
                        txtConfiguracoesPernoiteTermino.setFocusable(false);

                        configuracoes.setPernoiteInicio(txtConfiguracoesPernoiteInicio.getText());
                        configuracoes.setPernoiteTermino(txtConfiguracoesPernoiteTermino.getText());
                        configuracoesService.configuracoesAlterarPernoite(configuracoes);
                        JOptionPane.showMessageDialog(this, "Alteração no pernoite efetuado com sucesso!!!");
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    private void configuracoesSairCancelar() {
        switch (jButtonConfiguracoesSairCancelar.getText()) {
            case "Sair":
                menuPrincipal("entradasaida");
                break;
            case "Cancelar":
                jListConfiguracoes.setEnabled(true);
                jListConfiguracoes.requestFocus();
                jButtonConfiguracoesSairCancelar.setText("Sair");
                jButtonConfiguracoesAlterarOk.setText("Alterar");
                menuPrincipal("configuracoes");
                JOptionPane.showMessageDialog(this, "Alterações canceladas!!!");
                break;
            default:
                break;
        }
        configuracaoJTextField();
    }

    private void configuracaoJTextField() {
        configuracoes = configuracoesService.configuracoesCarregarTodos(configuracoes);
        txtInformacoesToleranciaDesistencia.setText(String.valueOf(configuracoes.getToleranciaDesistencia()));
        txtInformacoesToleranciaFracoes.setText(String.valueOf(configuracoes.getToleranciaFracoes()));
        txtInformacoesDiariaHora.setText(String.valueOf(configuracoes.getDiariaHora()));
        txtInformacoesDiariaMinuto.setText(String.valueOf(configuracoes.getDiariaMinuto()));
        txtInformacoesPernoiteInicio.setText(configuracoes.getPernoiteInicio());
        txtInformacoesPernoiteTermino.setText(configuracoes.getPernoiteTermino());
    }

    private void menuPrincipal(String menu) {
        jTabbedPaneOpcoes.setEnabledAt(0, false);
        jTabbedPaneOpcoes.setEnabledAt(1, false);
        jTabbedPaneOpcoes.setEnabledAt(2, false);
        jTabbedPaneOpcoes.setEnabledAt(3, false);
        jTabbedPaneOpcoes.setEnabledAt(4, false);
        jTabbedPaneOpcoes.setEnabledAt(5, false);
        jTabbedPaneOpcoes.setEnabledAt(6, false);
        menuPrincipalBotoesStatus(false);
        switch (menu) {
            case "entradasaida":
                jTabbedPaneOpcoes.setEnabledAt(0, true);
                jTabbedPaneOpcoes.setSelectedIndex(0);
                menuPrincipalBotoesStatus(true);
                break;
            case "mensalista":
                jTabbedPaneOpcoes.setEnabledAt(1, true);
                jTabbedPaneOpcoes.setSelectedIndex(1);
                mensalistaCarregarPesquisa();
                break;
            case "pacote":
                jTabbedPaneOpcoes.setEnabledAt(2, true);
                jTabbedPaneOpcoes.setSelectedIndex(2);
                break;
            case "rotativo":
                jTabbedPaneOpcoes.setEnabledAt(3, true);
                jTabbedPaneOpcoes.setSelectedIndex(3);
                break;
            case "patio":
                jTabbedPaneOpcoes.setEnabledAt(4, true);
                jTabbedPaneOpcoes.setSelectedIndex(4);
                patioListaVeiculo();
                break;
            case "movimento":
                jTabbedPaneOpcoes.setEnabledAt(5, true);
                jTabbedPaneOpcoes.setSelectedIndex(5);
                movimentoListaVeiculo();
                break;
            case "configuracoes":
                jTabbedPaneOpcoes.setEnabledAt(6, true);
                jTabbedPaneOpcoes.setSelectedIndex(6);
                jListConfiguracoes.setFocusable(true);
                jListConfiguracoes.requestFocus();
                jListConfiguracoes.setSelectedIndex(0);
                configuracoesEscolhaTolerancia();
                break;
            default:
                break;
        }
    }

    private void menuPrincipalBotoesStatus(boolean status) {
        jButtonF1.setEnabled(status);
        jButtonF2.setEnabled(status);
        jButtonF3.setEnabled(status);
        jButtonF4.setEnabled(status);
        jButtonF5.setEnabled(status);
        jButtonF6.setEnabled(status);
        jButtonF8.setEnabled(status);
        jButtonF10.setEnabled(status);
    }

    private void entradaSaidaMovimentacoesTabelaRotativo() {
        ((DefaultTableModel) jTableEntradaSaidaMovimentacoesRotativo.getModel()).setRowCount(0);
        ((DefaultTableModel) jTableEntradaSaidaMovimentacoesRotativo.getModel()).setColumnCount(0);
        movimentacoesDefaultTableModel.addColumn("Ação");
        movimentacoesDefaultTableModel.addColumn("Placa");
        movimentacoesDefaultTableModel.addColumn("Prisma");
        movimentacoesDefaultTableModel.addColumn("Tipo");
        movimentacoesDefaultTableModel.addColumn("Data Entrada");
        movimentacoesDefaultTableModel.addColumn("Hora Entrada");
        movimentacoesDefaultTableModel.addColumn("Data Saída");
        movimentacoesDefaultTableModel.addColumn("Hora Saída");
        movimentacoesDefaultTableModel.addColumn("Nº Controle");
        jTableEntradaSaidaMovimentacoesRotativo.setModel(movimentacoesDefaultTableModel);
        jTableEntradaSaidaMovimentacoesRotativo.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableEntradaSaidaMovimentacoesRotativo.getColumnModel().getColumn(1).setPreferredWidth(40);
        jTableEntradaSaidaMovimentacoesRotativo.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTableEntradaSaidaMovimentacoesRotativo.getColumnModel().getColumn(3).setPreferredWidth(200);
        jTableEntradaSaidaMovimentacoesRotativo.getColumnModel().getColumn(4).setPreferredWidth(45);
        jTableEntradaSaidaMovimentacoesRotativo.getColumnModel().getColumn(5).setPreferredWidth(45);
        jTableEntradaSaidaMovimentacoesRotativo.getColumnModel().getColumn(6).setPreferredWidth(45);
        jTableEntradaSaidaMovimentacoesRotativo.getColumnModel().getColumn(7).setPreferredWidth(45);
        jTableEntradaSaidaMovimentacoesRotativo.getColumnModel().getColumn(8).setPreferredWidth(150);
        jTableEntradaSaidaMovimentacoesRotativo.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //A coluna do status é 1
                Object ref = table.getValueAt(row, 0);//Coluna Status
                //Coloca cor em todas as linhas em que a COLUNA(1) tiver valor "Escolha aqui o valor"

                if (row % 2 == 0) {
                    setBackground(null);
                    setForeground(null);
                } else {
                    setBackground(null);
                    setForeground(null);
                }

                if (ref != null && ref.equals("ENTRADA")) {//Se Status for igual a ""
                    setBackground(new Color(46, 139, 87));//Preenche a linha de verde
                    setForeground(new Color(255, 255, 255));//E a fonte de branco
                    setFont(new Font("", Font.BOLD, 15));//("Nome da fonte", estilo da fonte, tamanho da fonte)
                } else {
                    setBackground(new Color(205, 51, 51));//Preenche a linha de vermelho
                    setForeground(new Color(255, 255, 255));//E a fonte de branco
                    setFont(new Font("", Font.BOLD, 15));//("Nome da fonte", estilo da fonte, tamanho da fonte)
                }

                if (isSelected) {
                    setBackground(new Color(205, 179, 139));
                }
                return this;
            }
        });
    }

    private void rotativoExibirAtributos() {
        if (jTableRotativo.getRowCount() != 0 && jTableRotativo.getSelectedRowCount() != 0) {
            //jTableRotativo.addRowSelectionInterval(0, 0); SELECIONA A PRIMEIRA CELULA DA PRIMEIRA LINHA
            rotativo.setNome(String.valueOf(jTableRotativo.getValueAt(jTableRotativo.getSelectedRow(), 0)));
            rotativo = rotativoService.rotativoCarregarAtributos(rotativo);
            jTextFieldRotativoIncluirAlterar.setText(rotativo.getNome());
            txtRotativoPreco30minutos.setText(new DecimalFormat("#,##0.00").format(rotativo.getPreco30Minutos()));
            txtRotativoPreco60minutos.setText(new DecimalFormat("#,##0.00").format(rotativo.getPreco60Minutos()));
            txtRotativoPrecoDemaisFracoes.setText(new DecimalFormat("#,##0.00").format(rotativo.getPrecoDemaisFracoes()));
            txtRotativoPrecoDiaria.setText(new DecimalFormat("#,##0.00").format(rotativo.getPrecoDiaria()));
            txtRotativoPrecoPernoite.setText(new DecimalFormat("#,##0.00").format(rotativo.getPrecoPernoite()));
        }
    }

    private void rotativoCamposStatus(boolean status) {
        jTextFieldRotativoIncluirAlterar.setEditable(status);
        jTextFieldRotativoIncluirAlterar.setFocusable(status);
        jTextFieldRotativoIncluirAlterar.requestFocus();
        txtRotativoPreco30minutos.setFocusable(status);
        txtRotativoPreco30minutos.setEditable(status);
        txtRotativoPreco60minutos.setFocusable(status);
        txtRotativoPreco60minutos.setEditable(status);
        txtRotativoPrecoDemaisFracoes.setFocusable(status);
        txtRotativoPrecoDemaisFracoes.setEditable(status);
        txtRotativoPrecoDiaria.setFocusable(status);
        txtRotativoPrecoDiaria.setEditable(status);
        txtRotativoPrecoPernoite.setFocusable(status);
        txtRotativoPrecoPernoite.setEditable(status);
        if (status = true) {
            jTextFieldRotativoIncluirAlterar.setText(null);
            txtRotativoPreco30minutos.setText(null);
            txtRotativoPreco60minutos.setText(null);
            txtRotativoPrecoDemaisFracoes.setText(null);
            txtRotativoPrecoDiaria.setText(null);
            txtRotativoPrecoPernoite.setText(null);
        }
    }

    private void pacoteExibirAtributos() {
        if (jTablePacote.getRowCount() != 0 && jTablePacote.getSelectedRowCount() != 0) {
            pacote.setNome(String.valueOf(jTablePacote.getValueAt(jTablePacote.getSelectedRow(), 0)));
            pacote = pacoteService.pacoteCarregarAtributos(pacote);
            jTextFieldPacoteIncluirAlterar.setText(pacote.getNome());
            if (pacote.getUtilizacoesOuDias().equalsIgnoreCase("Dias")) {
                jRadioButtonDias.setSelected(true);
                jRadioButtonUtilizacoes.setSelected(false);
                jLabelPacoteQtdDiasOuUtilizacoes.setText("Quant. de dias");
            } else {
                jRadioButtonDias.setSelected(false);
                jRadioButtonUtilizacoes.setSelected(true);
                jLabelPacoteQtdDiasOuUtilizacoes.setText("Quant. de utilizações");
            }
            jTextFieldPacoteQuantidade.setText(String.valueOf(pacote.getQuantidade()));
            jTextFieldPacoteValor.setText(new DecimalFormat("#,##0.00").format(pacote.getValor()));
        }
    }

    private void configuracaoMascaraEntradaJTextField() {
        //ROTATIVO**********************************************************************************
        txtRotativoPreco30minutos.setDocument(new EntradaValor(7, 2));
        txtRotativoPreco60minutos.setDocument(new EntradaValor(7, 2));
        txtRotativoPrecoDemaisFracoes.setDocument(new EntradaValor(7, 2));
        txtRotativoPrecoDiaria.setDocument(new EntradaValor(7, 2));
        txtRotativoPrecoPernoite.setDocument(new EntradaValor(7, 2));
        //PACOTE************************************************************************************
        jTextFieldPacoteValor.setDocument(new EntradaValor(7, 2));
        jTextFieldPacoteQuantidade.setDocument(new EntradaDado(2, "[^0-9]"));
        //CONFIGURAÇÕES*****************************************************************************
        txtConfiguracoesDiariaHora.setDocument(new EntradaDado(2, "[^0-9]"));
        txtConfiguracoesDiariaMinuto.setDocument(new EntradaDado(2, "[^0-9]"));
        txtConfiguracoesToleranciaDesistencia.setDocument(new EntradaDado(2, "[^0-9]"));
        txtConfiguracoesToleranciaFracao.setDocument(new EntradaDado(2, "[^0-9]"));
        txtConfiguracoesPernoiteInicio.setDocument(new EntradaHora());
        txtConfiguracoesPernoiteTermino.setDocument(new EntradaHora());
        //PLACA ou PRISMA***************************************************************************
        txtEntradaPlacaOuPrisma.setHorizontalAlignment(JTextField.CENTER);
        txtEntradaPlacaOuPrisma.setDocument(new EntradaDado(7, "[^A-Z|^0-9]"));
    }

    private void configuracaoJDialog() {
        jDialogConfirmaEntradaVeiculo.setResizable(false);
        jDialogConfirmaEntradaVeiculo.setModal(true);
        jDialogConfirmaEntradaVeiculo.setBounds(530, 230, 823, 164);

        jDialogConfirmaSaidaVeiculo.setResizable(false);
        jDialogConfirmaSaidaVeiculo.setModal(true);
        jDialogConfirmaSaidaVeiculo.setBounds(530, 230, 823, 164);

        jDialogConfirmaSaidaSistema.setSize(823, 164);
        jDialogConfirmaSaidaSistema.setLocationRelativeTo(null);
        jDialogConfirmaSaidaSistema.setResizable(false);
        jDialogConfirmaSaidaSistema.setModal(true);
    }

    private void configuracaoJTabbedPane() {
        jTabbedPaneOpcoes.setEnabledAt(0, true);
        jTabbedPaneOpcoes.setEnabledAt(1, false);
        jTabbedPaneOpcoes.setEnabledAt(2, false);
        jTabbedPaneOpcoes.setEnabledAt(3, false);
        jTabbedPaneOpcoes.setEnabledAt(4, false);
        jTabbedPaneOpcoes.setEnabledAt(5, false);
        jTabbedPaneOpcoes.setEnabledAt(6, false);
        jTabbedPaneEntradaSaida.setEnabledAt(1, false);
        jTabbedPaneEntradaSaida.setEnabledAt(2, false);
    }

    private void configuracaoJTable() {
        entradaSaidaMovimentacoesTabelaRotativo();
        rotativoTabelaRotativo();
        pacoteTabelaPacote();
        jTableEntradaSaidaInformacoesRotativo.setFocusable(false);
        jTableEntradaSaidaInformacoesRotativo.setEnabled(false);
    }

    private void pacoteCamposStatus(boolean status) {
        jTextFieldPacoteIncluirAlterar.setEditable(status);
        jTextFieldPacoteIncluirAlterar.setFocusable(status);
        jTextFieldPacoteIncluirAlterar.requestFocus();
        jRadioButtonDias.setSelected(status);
        jRadioButtonDias.setEnabled(status);
        jRadioButtonDias.setFocusable(status);
        jRadioButtonUtilizacoes.setSelected(!status);
        jRadioButtonUtilizacoes.setEnabled(status);
        jRadioButtonUtilizacoes.setFocusable(status);
        jTextFieldPacoteQuantidade.setEditable(status);
        jTextFieldPacoteQuantidade.setFocusable(status);
        jTextFieldPacoteValor.setEditable(status);
        jTextFieldPacoteValor.setFocusable(status);
        if (status = true) {
            jTextFieldPacoteIncluirAlterar.setText(null);
            jTextFieldPacoteQuantidade.setText(null);
            jTextFieldPacoteValor.setText(null);
        }
    }

    private void movimentoListaVeiculo() {

        movimentoArrayList.clear();
        movimentoArrayList = patioService.movimentoLista(movimentoArrayList, movimentoData);
        if (movimentoArrayList.size() == 0) {
            JOptionPane.showMessageDialog(this, "Não foi encontrado movimento para data pesquisada!!!");
        } else {
            jPanel25.setBorder(BorderFactory.createTitledBorder("Movimento do dia: " + jFormattedTextField1.getText()));
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            ((DefaultTableModel) jTableMovimento.getModel()).setRowCount(0);
            ((DefaultTableModel) jTableMovimento.getModel()).setColumnCount(0);
            movimentoDefaultTableModel.addColumn("Placa");
            movimentoDefaultTableModel.addColumn("Prisma");
            movimentoDefaultTableModel.addColumn("Tipo");
            movimentoDefaultTableModel.addColumn("RPS");
            movimentoDefaultTableModel.addColumn("Data Entrada");
            movimentoDefaultTableModel.addColumn("Hora Entrada");
            movimentoDefaultTableModel.addColumn("Data Saída");
            movimentoDefaultTableModel.addColumn("Hora Saída");
            movimentoDefaultTableModel.addColumn("Permanência Atual/Total");
            movimentoDefaultTableModel.addColumn("Valor Atual/Pago");
            String valorTotal = "";
            for (int i = 0; i < movimentoArrayList.size(); i++) {
                valorTotal = new DecimalFormat("R$ #,##0.00").format(movimentoArrayList.get(i).getValorTotal());
                if (!movimentoArrayList.get(i).getDataSaida().equalsIgnoreCase("Veículo no")) {
                    valorTotal += "PG";
                }
                movimentoDefaultTableModel.addRow(new String[]{
                    movimentoArrayList.get(i).getPlacaFk(),
                    movimentoArrayList.get(i).getPrisma(),
                    movimentoArrayList.get(i).getTipo(),
                    movimentoArrayList.get(i).getRps(),
                    movimentoArrayList.get(i).getDataEntrada(),
                    movimentoArrayList.get(i).getHoraEntrada(),
                    movimentoArrayList.get(i).getDataSaida(),
                    movimentoArrayList.get(i).getHoraSaida(),
                    movimentoArrayList.get(i).getPermanencia(),
                    valorTotal
                });
            }

            jTableMovimento.setModel(movimentoDefaultTableModel);
            jTableMovimento.getColumnModel().getColumn(0).setPreferredWidth(8);
            jTableMovimento.getColumnModel().getColumn(1).setPreferredWidth(8);
            jTableMovimento.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTableMovimento.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableMovimento.getColumnModel().getColumn(4).setPreferredWidth(22);
            jTableMovimento.getColumnModel().getColumn(5).setPreferredWidth(20);
            jTableMovimento.getColumnModel().getColumn(6).setPreferredWidth(22);
            jTableMovimento.getColumnModel().getColumn(7).setPreferredWidth(20);
            jTableMovimento.getColumnModel().getColumn(8).setPreferredWidth(65);
            jTableMovimento.getColumnModel().getColumn(9).setPreferredWidth(50);
            jTableMovimento.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(
                        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    Object colunaTipo = table.getValueAt(row, 2);//Coluna
                    Object colunaDataSaida = table.getValueAt(row, 6);//Coluna

                    if (row % 2 == 0) {
                        setBackground(new Color(255, 255, 255));
                    } else {
                        setBackground(new Color(230, 230, 230));
                    }
                    setFont(new Font("", Font.PLAIN, 16));//("Nome da fonte", estilo da fonte, tamanho da fonte)
                    if (colunaTipo != null) {//Se existir a celula Tipo
                        if (colunaTipo.equals("Rotativo")) {
                            setForeground(new Color(0, 150, 0));//Fonte
                        } else if (colunaTipo.equals("Pacote")) {
                            setForeground(new Color(0, 0, 200));//Fonte
                        } else if (colunaTipo.equals("Mensalista")) {
                            setForeground(new Color(180, 140, 140));//Fonte
                        }
                    }

                    if (colunaDataSaida != null && !colunaDataSaida.equals("Veículo no")) {//Se existir a celula Data Saída
                        setForeground(new Color(200, 0, 0));//Fonte
                    }
                    if (isSelected) {
                        setBackground(new Color(205, 179, 139));
                    }
                    return this;
                }
            });
        }
    }

    private void mensalistaCarregarPesquisa() {
        mensalistaArrayList.clear();
        ((DefaultTableModel) jTableMensalista.getModel()).setRowCount(0);
        ((DefaultTableModel) jTableMensalista.getModel()).setColumnCount(0);
        mensalistaArrayList = mensalistaService.mensalistaCarregarPesquisa(mensalistaArrayList, mensalistaNomePesquisa);
        mensalistaDefaultTableModel.addColumn("N. Contrato");
        mensalistaDefaultTableModel.addColumn("Nome");
        mensalistaDefaultTableModel.addColumn("CPF");
        mensalistaDefaultTableModel.addColumn("Telefone");
        mensalistaDefaultTableModel.addColumn("Celular");
        mensalistaDefaultTableModel.addColumn("E-mail");

        for (int i = 0; i < mensalistaArrayList.size(); i++) {
            if (mensalistaArrayList.get(i).getCpf() == null || mensalistaArrayList.get(i).getCpf().equalsIgnoreCase("")) {
                mensalistaArrayList.get(i).setCpf("0");
            }
            mensalistaArrayList.get(i).setCpf(String.format("%011d", Long.parseLong(mensalistaArrayList.get(i).getCpf())));
            if (mensalistaArrayList.get(i).getIdentidade() == null || mensalistaArrayList.get(i).getIdentidade().equalsIgnoreCase("")) {
                mensalistaArrayList.get(i).setIdentidade("0");
            }
            mensalistaArrayList.get(i).setIdentidade(String.format("%010d", Long.parseLong(mensalistaArrayList.get(i).getIdentidade())));
            if (mensalistaArrayList.get(i).getTelefone() == null || mensalistaArrayList.get(i).getTelefone().equalsIgnoreCase("")) {
                mensalistaArrayList.get(i).setTelefone("0");
            }
            mensalistaArrayList.get(i).setTelefone(String.format("%010d", Long.parseLong(mensalistaArrayList.get(i).getTelefone())));
            if (mensalistaArrayList.get(i).getCelular() == null || mensalistaArrayList.get(i).getCelular().equalsIgnoreCase("")) {
                mensalistaArrayList.get(i).setCelular("0");
            }
            mensalistaArrayList.get(i).setCelular(String.format("%011d", Long.parseLong(mensalistaArrayList.get(i).getCelular())));
            if (mensalistaArrayList.get(i).getCepResi() == null || mensalistaArrayList.get(i).getCepResi().equalsIgnoreCase("")) {
                mensalistaArrayList.get(i).setCepResi("0");
            }
            mensalistaArrayList.get(i).setCepResi(String.format("%08d", Long.parseLong(mensalistaArrayList.get(i).getCepResi())));
            if (mensalistaArrayList.get(i).getCepCome() == null || mensalistaArrayList.get(i).getCepCome().equalsIgnoreCase("")) {
                mensalistaArrayList.get(i).setCepCome("0");
            }
            mensalistaArrayList.get(i).setCepCome(String.format("%08d", Long.parseLong(mensalistaArrayList.get(i).getCepCome())));
            if (mensalistaArrayList.get(i).getTelefoneCome() == null || mensalistaArrayList.get(i).getTelefoneCome().equalsIgnoreCase("")) {
                mensalistaArrayList.get(i).setTelefoneCome("0");
            }
            mensalistaArrayList.get(i).setTelefoneCome(String.format("%010d", Long.parseLong(mensalistaArrayList.get(i).getTelefoneCome())));

            mensalistaDefaultTableModel.addRow(new String[]{
                String.valueOf(mensalistaArrayList.get(i).getNumeroDoContrato()),
                mensalistaArrayList.get(i).getNome(),
                mensalistaArrayList.get(i).getCpf().substring(0, 3) + "." + mensalistaArrayList.get(i).getCpf().substring(3, 6) + "." + mensalistaArrayList.get(i).getCpf().substring(6, 9) + "-" + mensalistaArrayList.get(i).getCpf().substring(9, 11),
                "(" + mensalistaArrayList.get(i).getTelefone().substring(0, 2) + ")" + mensalistaArrayList.get(i).getTelefone().substring(2, 6) + "-" + mensalistaArrayList.get(i).getTelefone().substring(6, 10),
                "(" + mensalistaArrayList.get(i).getCelular().substring(0, 2) + ")" + mensalistaArrayList.get(i).getCelular().substring(2, 3) + "." + mensalistaArrayList.get(i).getCelular().substring(3, 7) + "-" + mensalistaArrayList.get(i).getCelular().substring(7, 11),
                mensalistaArrayList.get(i).getEmail()
            });
        }

        jTableMensalista.setModel(mensalistaDefaultTableModel);
        jTableMensalista.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableMensalista.getColumnModel().getColumn(1).setPreferredWidth(350);
        jTableMensalista.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableMensalista.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableMensalista.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableMensalista.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTableMensalista.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Object colunaTipo = table.getValueAt(row, 2);//Coluna Status

                if (row % 2 == 0) {
                    setBackground(new Color(255, 255, 255));
                } else {
                    setBackground(new Color(230, 230, 230));
                }
                setFont(new Font("", Font.PLAIN, 16));//("Nome da fonte", estilo da fonte, tamanho da fonte)
                if (colunaTipo != null) {//Se existir a celula Tipo
                    if (colunaTipo.equals("Rotativo")) {
                        setForeground(new Color(0, 150, 0));//Fonte
                    } else if (colunaTipo.equals("Pacote")) {
                        setForeground(new Color(0, 0, 200));//Fonte
                    } else if (colunaTipo.equals("Mensalista")) {
                        setForeground(new Color(180, 140, 140));//Fonte
                    }
                }

                if (isSelected) {
                    setBackground(new Color(205, 179, 139));
                }
                return this;
            }
        });
    }

    private boolean mensalistaVerificaCamposValidos() {
        if (jTextFieldMensalistaNome.getText().replaceAll(" ", "").equalsIgnoreCase("")
                || jFormattedTextFieldMensalistaCpf.getText().replaceAll(" ", "").equalsIgnoreCase("")
                || (jFormattedTextFieldMensalistaPlaca01.getText().replaceAll(" ", "").equalsIgnoreCase("")
                && jFormattedTextFieldMensalistaPlaca02.getText().replaceAll(" ", "").equalsIgnoreCase("")
                && jFormattedTextFieldMensalistaPlaca03.getText().replaceAll(" ", "").equalsIgnoreCase("")
                && jFormattedTextFieldMensalistaPlaca04.getText().replaceAll(" ", "").equalsIgnoreCase(""))) {
            JOptionPane.showMessageDialog(this, "Os campos Nome, CPF e pelo menos uma Placa válida são necessários!!!\n\n"
                    + "No mínimo estes três campos precisam estar preenchidos...");
            return (false);
        } else if (ValidaCPF.validarCPF(jFormattedTextFieldMensalistaCpf.getText().replaceAll("\\.", "").replaceAll("-", "")) == true) {
            if (jFormattedTextFieldMensalistaPlaca01.getText().replaceAll(" ", "").equalsIgnoreCase("") || verificadorEntradaDado.verificaDadoTipo(jFormattedTextFieldMensalistaPlaca01.getText()).equalsIgnoreCase("placa")) {
                if (jFormattedTextFieldMensalistaPlaca02.getText().replaceAll(" ", "").equalsIgnoreCase("") || verificadorEntradaDado.verificaDadoTipo(jFormattedTextFieldMensalistaPlaca02.getText()).equalsIgnoreCase("placa")) {
                    if (jFormattedTextFieldMensalistaPlaca03.getText().replaceAll(" ", "").equalsIgnoreCase("") || verificadorEntradaDado.verificaDadoTipo(jFormattedTextFieldMensalistaPlaca03.getText()).equalsIgnoreCase("placa")) {
                        if (jFormattedTextFieldMensalistaPlaca04.getText().replaceAll(" ", "").equalsIgnoreCase("") || verificadorEntradaDado.verificaDadoTipo(jFormattedTextFieldMensalistaPlaca04.getText()).equalsIgnoreCase("placa")) {
                            jButtonMensalistaCadastroAlterar.setEnabled(true);
                            jButtonMensalistaCadastroAtivarInativar.setEnabled(true);
                            jButtonMensalistaCadastroOk.setEnabled(false);
                            jButtonMensalistaCadastroCancelar.setEnabled(false);
                            mensalistaJTextStatus(false);
                            return (true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Formato da placa do veículo 04 inválido!!!");
                            return (false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Formato da placa do veículo 03 inválido!!!");
                        return (false);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Formato da placa do veículo 02 inválido!!!");
                    return (false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Formato da placa do veículo 01 inválido!!!");
                return (false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "O CPF digitado é inválido!!! \n\n"
                    + "Verifique o número digitado...");
            return (false);
        }
    }

    private Mensalista mensalistaPopularObjeto() {
        //Populando Objeto Mensalista (contrato)
        mensalista.setDataInclusao(jFormattedTextFieldMensalistaDataInclusao.getText().replaceAll("/", "").replaceAll(" ", ""));
        mensalista.setDiaVencimentoMensalidade(jTextFieldMensalistaDiaVencimentoMensalidade.getText().replaceAll(" ", ""));
        mensalista.setDataUltimaAlteracao(jFormattedTextFieldMensalistaDataUltimaAlteracao.getText().replaceAll("/", "").replaceAll(" ", ""));
        mensalista.setStatus(jTextFieldMensalistaStatus.getText().replaceAll(" ", ""));
        //Populando Objeto Mensalista (Dados Pessoais)
        mensalista.setNome(jTextFieldMensalistaNome.getText());
        mensalista.setCpf(jFormattedTextFieldMensalistaCpf.getText().replaceAll("\\.", "").replaceAll("-", "").replaceAll(" ", ""));
        mensalista.setDataNascimento(jFormattedTextFieldMensalistaDataNascimento.getText().replaceAll("/", "").replaceAll(" ", ""));
        mensalista.setIdentidade(jTextFieldMensalistaIdentidade.getText());
        mensalista.setTelefone(jFormattedTextFieldMensalistaTelefoneResi.getText().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "").replaceAll(" ", ""));
        mensalista.setCelular(jFormattedTextFieldMensalistaCelularResi.getText().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\.", "").replaceAll("-", "").replaceAll(" ", ""));
        mensalista.setEmail(jTextFieldMensalistaEmail.getText());
        mensalista.setCepResi(jFormattedTextFieldMensalistaCepResi.getText().replaceAll("\\.", "").replaceAll("-", "").replaceAll(" ", ""));
        mensalista.setRuaResi(jTextFieldMensalistaRuaResi.getText());
        mensalista.setNumeroResi(jTextFieldMensalistaNumeroResi.getText());
        mensalista.setComplementoResi(jTextFieldMensalistaComplementoResi.getText());
        mensalista.setBairroResi(jTextFieldMensalistaBairroResi.getText());
        mensalista.setCidadeResi(jTextFieldMensalistaCidadeResi.getText());
        mensalista.setEstadoResi(jTextFieldMensalistaEstadoResi.getText());
        //Populando Objeto Mensalista (Dados Profissionais)
        mensalista.setEmpresa(jTextFieldMensalistaEmpresa.getText());
        mensalista.setCepCome(jFormattedTextFieldMensalistaCepCome.getText().replaceAll("\\.", "").replaceAll("-", "").replaceAll(" ", ""));
        mensalista.setRuaCome(jTextFieldMensalistaRuaCome.getText());
        mensalista.setNumeroCome(jTextFieldMensalistaNumeroCome.getText());
        mensalista.setComplementoCome(jTextFieldMensalistaComplementoCome.getText());
        mensalista.setBairroCome(jTextFieldMensalistaBairroCome.getText());
        mensalista.setCidadeCome(jTextFieldMensalistaCidadeCome.getText());
        mensalista.setEstadoCome(jTextFieldMensalistaEstadoCome.getText());
        mensalista.setTelefoneCome(jFormattedTextFieldMensalistaTelefoneCome.getText().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "").replaceAll(" ", ""));
        //Populando Objeto Mensalista (Veículos)
        mensalista.setPlaca01(jFormattedTextFieldMensalistaPlaca01.getText());
        mensalista.setMontadora01(jTextFieldMensalistaMontadora01.getText());
        mensalista.setModelo01(jTextFieldMensalistaModelo01.getText());
        mensalista.setCor01(jTextFieldMensalistaCor01.getText());
        mensalista.setAno01(jTextFieldMensalistaAno01.getText());

        mensalista.setPlaca02(jFormattedTextFieldMensalistaPlaca02.getText());
        mensalista.setMontadora02(jTextFieldMensalistaMontadora02.getText());
        mensalista.setModelo02(jTextFieldMensalistaModelo02.getText());
        mensalista.setCor02(jTextFieldMensalistaCor02.getText());
        mensalista.setAno02(jTextFieldMensalistaAno02.getText());

        mensalista.setPlaca03(jFormattedTextFieldMensalistaPlaca03.getText());
        mensalista.setMontadora03(jTextFieldMensalistaMontadora03.getText());
        mensalista.setModelo03(jTextFieldMensalistaModelo03.getText());
        mensalista.setCor03(jTextFieldMensalistaCor03.getText());
        mensalista.setAno03(jTextFieldMensalistaAno03.getText());

        mensalista.setPlaca04(jFormattedTextFieldMensalistaPlaca04.getText());
        mensalista.setMontadora04(jTextFieldMensalistaMontadora04.getText());
        mensalista.setModelo04(jTextFieldMensalistaModelo04.getText());
        mensalista.setCor04(jTextFieldMensalistaCor04.getText());
        mensalista.setAno04(jTextFieldMensalistaAno04.getText());
        return mensalista;
    }

    private void mensalistaJTextConteudo(String conteudo) {
        //Preenchendo JTextField dados contrato
        jTextFieldMensalistaContratoNumero.setText(conteudo);
        jFormattedTextFieldMensalistaDataInclusao.setText(conteudo);
        jTextFieldMensalistaDiaVencimentoMensalidade.setText(conteudo);
        jFormattedTextFieldMensalistaDataUltimaAlteracao.setText(conteudo);
        jTextFieldMensalistaStatus.setText(conteudo);
        //(Dados Pessoais)
        jTextFieldMensalistaNome.setText(conteudo);
        jFormattedTextFieldMensalistaCpf.setText(conteudo);
        jTextFieldMensalistaIdentidade.setText(conteudo);
        jFormattedTextFieldMensalistaDataNascimento.setText(conteudo);
        jFormattedTextFieldMensalistaTelefoneResi.setText(conteudo);
        jFormattedTextFieldMensalistaCelularResi.setText(conteudo);
        jTextFieldMensalistaEmail.setText(conteudo);
        jFormattedTextFieldMensalistaCepResi.setText(conteudo);
        jTextFieldMensalistaRuaResi.setText(conteudo);
        jTextFieldMensalistaNumeroResi.setText(conteudo);
        jTextFieldMensalistaComplementoResi.setText(conteudo);
        jTextFieldMensalistaBairroResi.setText(conteudo);
        jTextFieldMensalistaCidadeResi.setText(conteudo);
        jTextFieldMensalistaEstadoResi.setText(conteudo);
        //(Dados Profissionais)
        jTextFieldMensalistaEmpresa.setText(conteudo);
        jFormattedTextFieldMensalistaCepCome.setText(conteudo);
        jTextFieldMensalistaRuaCome.setText(conteudo);
        jTextFieldMensalistaNumeroCome.setText(conteudo);
        jTextFieldMensalistaComplementoCome.setText(conteudo);
        jTextFieldMensalistaBairroCome.setText(conteudo);
        jTextFieldMensalistaCidadeCome.setText(conteudo);
        jTextFieldMensalistaEstadoCome.setText(conteudo);
        jFormattedTextFieldMensalistaTelefoneCome.setText(conteudo);
        //(Veículos)
        jFormattedTextFieldMensalistaPlaca01.setText(conteudo);
        jTextFieldMensalistaMontadora01.setText(conteudo);
        jTextFieldMensalistaModelo01.setText(conteudo);
        jTextFieldMensalistaCor01.setText(conteudo);
        jTextFieldMensalistaAno01.setText(conteudo);

        jFormattedTextFieldMensalistaPlaca02.setText(conteudo);
        jTextFieldMensalistaMontadora02.setText(conteudo);
        jTextFieldMensalistaModelo02.setText(conteudo);
        jTextFieldMensalistaCor02.setText(conteudo);
        jTextFieldMensalistaAno02.setText(conteudo);

        jFormattedTextFieldMensalistaPlaca03.setText(conteudo);
        jTextFieldMensalistaMontadora03.setText(conteudo);
        jTextFieldMensalistaModelo03.setText(conteudo);
        jTextFieldMensalistaCor03.setText(conteudo);
        jTextFieldMensalistaAno03.setText(conteudo);

        jFormattedTextFieldMensalistaPlaca04.setText(conteudo);
        jTextFieldMensalistaMontadora04.setText(conteudo);
        jTextFieldMensalistaModelo04.setText(conteudo);
        jTextFieldMensalistaCor04.setText(conteudo);
        jTextFieldMensalistaAno04.setText(conteudo);
    }

    private void mensalistaJTextStatus(boolean status) {
        //JTextField dados contrato
        //jTextFieldMensalistaContratoNumero.setEditable(status);
        //jFormattedTextFieldMensalistaDataInclusao.setEditable(status);
        jTextFieldMensalistaDiaVencimentoMensalidade.setEditable(status);
        //jFormattedTextFieldMensalistaDataUltimaAlteracao.setEditable(status);
        //jTextFieldMensalistaStatus.setEditable(status);
        //(Dados Pessoais)
        jTextFieldMensalistaNome.setEditable(status);
        jFormattedTextFieldMensalistaCpf.setEditable(status);
        jTextFieldMensalistaIdentidade.setEditable(status);
        jFormattedTextFieldMensalistaDataNascimento.setEditable(status);
        jFormattedTextFieldMensalistaTelefoneResi.setEditable(status);
        jFormattedTextFieldMensalistaCelularResi.setEditable(status);
        jTextFieldMensalistaEmail.setEditable(status);
        jFormattedTextFieldMensalistaCepResi.setEditable(status);
        jTextFieldMensalistaRuaResi.setEditable(status);
        jTextFieldMensalistaNumeroResi.setEditable(status);
        jTextFieldMensalistaComplementoResi.setEditable(status);
        jTextFieldMensalistaBairroResi.setEditable(status);
        jTextFieldMensalistaCidadeResi.setEditable(status);
        jTextFieldMensalistaEstadoResi.setEditable(status);
        //(Dados Profissionais)
        jTextFieldMensalistaEmpresa.setEditable(status);
        jFormattedTextFieldMensalistaCepCome.setEditable(status);
        jTextFieldMensalistaRuaCome.setEditable(status);
        jTextFieldMensalistaNumeroCome.setEditable(status);
        jTextFieldMensalistaComplementoCome.setEditable(status);
        jTextFieldMensalistaBairroCome.setEditable(status);
        jTextFieldMensalistaCidadeCome.setEditable(status);
        jTextFieldMensalistaEstadoCome.setEditable(status);
        jFormattedTextFieldMensalistaTelefoneCome.setEditable(status);
        //(Veículos)
        jFormattedTextFieldMensalistaPlaca01.setEditable(status);
        jTextFieldMensalistaMontadora01.setEditable(status);
        jTextFieldMensalistaModelo01.setEditable(status);
        jTextFieldMensalistaCor01.setEditable(status);
        jTextFieldMensalistaAno01.setEditable(status);

        jFormattedTextFieldMensalistaPlaca02.setEditable(status);
        jTextFieldMensalistaMontadora02.setEditable(status);
        jTextFieldMensalistaModelo02.setEditable(status);
        jTextFieldMensalistaCor02.setEditable(status);
        jTextFieldMensalistaAno02.setEditable(status);

        jFormattedTextFieldMensalistaPlaca03.setEditable(status);
        jTextFieldMensalistaMontadora03.setEditable(status);
        jTextFieldMensalistaModelo03.setEditable(status);
        jTextFieldMensalistaCor03.setEditable(status);
        jTextFieldMensalistaAno03.setEditable(status);

        jFormattedTextFieldMensalistaPlaca04.setEditable(status);
        jTextFieldMensalistaMontadora04.setEditable(status);
        jTextFieldMensalistaModelo04.setEditable(status);
        jTextFieldMensalistaCor04.setEditable(status);
        jTextFieldMensalistaAno04.setEditable(status);
    }

    private boolean mensalistaPesquisaConsultar() {
        if (jTableMensalista.getRowCount() != 0 && jTableMensalista.getSelectedRowCount() != 0) {
            mensalista.setNumeroDoContrato(Integer.parseInt((String) jTableMensalista.getValueAt(jTableMensalista.getSelectedRow(), 0)));
            mensalista = mensalistaService.mensalistaCarregarAtributos(mensalista);
            if (mensalista.getNumeroDoContrato() != 0) {
                //Preenchendo JTextField dados contrato
                jTextFieldMensalistaContratoNumero.setText(String.valueOf(mensalista.getNumeroDoContrato()));
                jFormattedTextFieldMensalistaDataInclusao.setText(mensalista.getDataInclusao());
                jTextFieldMensalistaDiaVencimentoMensalidade.setText(mensalista.getDiaVencimentoMensalidade());
                jFormattedTextFieldMensalistaDataUltimaAlteracao.setText(mensalista.getDataUltimaAlteracao());
                jTextFieldMensalistaStatus.setText(mensalista.getStatus());
                //Preenchendo JTextField com dados cadastrais Pessoais
                jTextFieldMensalistaNome.setText(mensalista.getNome());
                jFormattedTextFieldMensalistaCpf.setText(mensalista.getCpf());
                jTextFieldMensalistaIdentidade.setText(mensalista.getIdentidade());
                jFormattedTextFieldMensalistaTelefoneResi.setText(mensalista.getTelefone());
                jFormattedTextFieldMensalistaCelularResi.setText(mensalista.getCelular());
                jTextFieldMensalistaEmail.setText(mensalista.getEmail());
                jFormattedTextFieldMensalistaCepResi.setText(mensalista.getCepResi());
                jTextFieldMensalistaRuaResi.setText(mensalista.getRuaResi());
                jTextFieldMensalistaNumeroResi.setText(mensalista.getNumeroResi());
                jTextFieldMensalistaComplementoResi.setText(mensalista.getComplementoResi());
                jTextFieldMensalistaBairroResi.setText(mensalista.getBairroResi());
                jTextFieldMensalistaCidadeResi.setText(mensalista.getCidadeResi());
                jTextFieldMensalistaEstadoResi.setText(mensalista.getEstadoResi());
                //Preenchendo JTextField com dados cadastrais Profissionais
                jTextFieldMensalistaEmpresa.setText(mensalista.getEmpresa());
                jFormattedTextFieldMensalistaCepCome.setText(mensalista.getCepCome());
                jTextFieldMensalistaRuaCome.setText(mensalista.getRuaCome());
                jTextFieldMensalistaNumeroCome.setText(mensalista.getNumeroCome());
                jTextFieldMensalistaComplementoCome.setText(mensalista.getComplementoCome());
                jTextFieldMensalistaBairroCome.setText(mensalista.getBairroCome());
                jTextFieldMensalistaCidadeCome.setText(mensalista.getCidadeCome());
                jTextFieldMensalistaEstadoCome.setText(mensalista.getEstadoCome());
                jFormattedTextFieldMensalistaTelefoneCome.setText(mensalista.getTelefoneCome());
                //Preenchendo JTextField com dados cadastrais Veículos
                jFormattedTextFieldMensalistaPlaca01.setText(mensalista.getPlaca01());
                jTextFieldMensalistaMontadora01.setText(mensalista.getMontadora01());
                jTextFieldMensalistaModelo01.setText(mensalista.getModelo01());
                jTextFieldMensalistaCor01.setText(mensalista.getCor01());
                jTextFieldMensalistaAno01.setText(mensalista.getAno01());
                jFormattedTextFieldMensalistaPlaca02.setText(mensalista.getPlaca02());
                jTextFieldMensalistaMontadora02.setText(mensalista.getMontadora02());
                jTextFieldMensalistaModelo02.setText(mensalista.getModelo02());
                jTextFieldMensalistaCor02.setText(mensalista.getCor02());
                jTextFieldMensalistaAno02.setText(mensalista.getAno02());
                jFormattedTextFieldMensalistaPlaca03.setText(mensalista.getPlaca03());
                jTextFieldMensalistaMontadora03.setText(mensalista.getMontadora03());
                jTextFieldMensalistaModelo03.setText(mensalista.getModelo03());
                jTextFieldMensalistaCor03.setText(mensalista.getCor03());
                jTextFieldMensalistaAno03.setText(mensalista.getAno03());
                jFormattedTextFieldMensalistaPlaca04.setText(mensalista.getPlaca04());
                jTextFieldMensalistaMontadora04.setText(mensalista.getMontadora04());
                jTextFieldMensalistaModelo04.setText(mensalista.getModelo04());
                jTextFieldMensalistaCor04.setText(mensalista.getCor04());
                jTextFieldMensalistaAno04.setText(mensalista.getAno04());
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Mensalista não encontrado!!!");
                return false;
            }
        } else {
            return false;
        }
    }

    private void mensalistaAlterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
