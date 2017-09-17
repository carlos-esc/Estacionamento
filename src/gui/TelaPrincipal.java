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
import java.text.ParseException;
import modelo.Veiculo;
import modelo.Patio;
import service.VeiculoService;
import service.PatioService;
import service.RotativoService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import mascarasentrada.EntradaHora;
import modelo.Configuracoes;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Fatura;
import modelo.Rotativo;
import service.ConfiguracoesService;
import service.ClienteService;
import service.ContratoService;
import service.FaturaService;
import validacao.ValidaCPF;

public class TelaPrincipal extends javax.swing.JFrame {

    Veiculo veiculo = new Veiculo();
    Patio patio = new Patio();
    Contrato contrato = new Contrato();
    PatioService patioService = new PatioService();

    //VEÍCULO******************************************************************************************
    VeiculoService veiculoService = new VeiculoService();

    //CONTRATO***************************************************************************************
    String contratoStatus;
    ContratoService contratoService = new ContratoService();
    List<Contrato> contratoArrayList = new ArrayList<>();
    DefaultListModel contratoDefaultListModel = new DefaultListModel();
    DefaultTableModel contratoDefaultTableModel = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //CLIENTE***************************************************************************************
    Cliente cliente = new Cliente();
    ClienteService clienteService = new ClienteService();
    List<Cliente> clienteArrayList = new ArrayList<>();
    DefaultListModel clienteDefaultListModel = new DefaultListModel();
    DefaultTableModel clienteDefaultTableModel = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //FATURA****************************************************************************************
    Fatura fatura = new Fatura();
    FaturaService faturaService = new FaturaService();
    List<Fatura> faturaArrayList = new ArrayList<>();
    DefaultListModel faturaDefaultListModel = new DefaultListModel();
    DefaultTableModel faturaDefaultTableModel = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
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

    //PÁTIO********************************************************************************************
    List<Patio> patioArrayList = new ArrayList<>();
    DefaultTableModel patioDefaultTableModel = new DefaultTableModel();

    //MOVIMENTO****************************************************************************************
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
        //UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("SanSerif", Font.BOLD, 22))); // Aqui você muda o nome e tamanho da fonte.
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

        jDialogConfirmaSaidaSistema = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jButtonSaidaSistemaNao = new javax.swing.JButton();
        jButtonSaidaSistemaSim = new javax.swing.JButton();
        buttonGroupClienteAtivoInativo = new javax.swing.ButtonGroup();
        buttonGroupClienteMensalistaPacote = new javax.swing.ButtonGroup();
        buttonGroupContratoDiasUtilizacoes = new javax.swing.ButtonGroup();
        buttonGroupContratoMensalistaPacote = new javax.swing.ButtonGroup();
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
        jTabbedPaneClienteContrato = new javax.swing.JTabbedPane();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableClienteContrato = new javax.swing.JTable();
        jPanel40 = new javax.swing.JPanel();
        jButtonClientePesquisaIncluir = new javax.swing.JButton();
        jButtonClientePesquisaSair = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jTextFieldClienteNomePesquisa = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jButtonClientePesquisaLocalizar = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        jButtonClientePesquisaExibir = new javax.swing.JButton();
        jButtonClientePesquisaAlterar = new javax.swing.JButton();
        jButtonClientePesquisaCancelar = new javax.swing.JButton();
        jRadioButtonAtivos = new javax.swing.JRadioButton();
        jRadioButtonInativos = new javax.swing.JRadioButton();
        jRadioButtonAtiInaTodos = new javax.swing.JRadioButton();
        jLabel109 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jButtonClientePesquisaFaturas = new javax.swing.JButton();
        jLabel111 = new javax.swing.JLabel();
        jRadioButtonMensalista = new javax.swing.JRadioButton();
        jRadioButtonPacote = new javax.swing.JRadioButton();
        jRadioButtonMenPacTodos = new javax.swing.JRadioButton();
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
        jLabel55 = new javax.swing.JLabel();
        jTextFieldClienteIdCliente = new javax.swing.JTextField();
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
        jButtonClienteCadastroSim = new javax.swing.JButton();
        jButtonClienteCadastroNao = new javax.swing.JButton();
        jLabelMensalistaStatus = new javax.swing.JLabel();
        jButtonClienteCadastroCancelar = new javax.swing.JButton();
        jButtonClienteCadastroAlterar = new javax.swing.JButton();
        jButtonClienteCadastroSair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel31 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jTextFieldContratoDiaVencimento = new javax.swing.JTextField();
        jTextFieldContratoStatus = new javax.swing.JTextField();
        jFormattedTextFieldContratoDataInicio = new javax.swing.JFormattedTextField();
        jFormattedTextFieldContratoDataCancelamento = new javax.swing.JFormattedTextField();
        jTextFieldContratoNumero = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jFormattedTextFieldContratoDataTermino = new javax.swing.JFormattedTextField();
        jRadioButtonContratoDias = new javax.swing.JRadioButton();
        jRadioButtonContratoUtilizacoes = new javax.swing.JRadioButton();
        jLabel114 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jRadioButtonContratoMensalista = new javax.swing.JRadioButton();
        jRadioButtonContratoPacote = new javax.swing.JRadioButton();
        jFormattedTextFieldContratoQuantidade = new javax.swing.JFormattedTextField();
        jLabel112 = new javax.swing.JLabel();
        jTextFieldContratoValor = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jButtonContratoConsultaFatura = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel110 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableContratoFatura = new javax.swing.JTable();
        jLabel113 = new javax.swing.JLabel();
        jButtonContratoFaturaSair = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        jTextFieldContratoFaturaCliente = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jFormattedTextFieldContratoFaturaCPF = new javax.swing.JFormattedTextField();
        jPanel34 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jTextFieldContratoFaturaDiaVencimento = new javax.swing.JTextField();
        jTextFieldContratoFaturaStatus = new javax.swing.JTextField();
        jFormattedTextFieldContratoFaturaDataInicio = new javax.swing.JFormattedTextField();
        jFormattedTextFieldContratoFaturaUltimaAlteracao = new javax.swing.JFormattedTextField();
        jTextFieldContratoFaturaNumero = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jFormattedTextFieldContratoFaturaDataTermino = new javax.swing.JFormattedTextField();
        jRadioButtonContratoFaturaDias = new javax.swing.JRadioButton();
        jRadioButtonContratoFaturaUtilizacoes = new javax.swing.JRadioButton();
        jLabel122 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jRadioButtonContratoFaturaMensalista = new javax.swing.JRadioButton();
        jRadioButtonContratoFaturaPacote = new javax.swing.JRadioButton();
        jFormattedTextFieldContratoFaturaQuantidade = new javax.swing.JFormattedTextField();
        jLabel123 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jTextFieldContratoFaturaValor = new javax.swing.JTextField();
        jButtonContratoFaturaPagarFatura = new javax.swing.JButton();
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
        jScrollPane13 = new javax.swing.JScrollPane();
        jTablePatioResumo = new javax.swing.JTable();
        jLabel125 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jButtonMovimentoSair = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableMovimentoRecebimentoRotativoAtualFuturo = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jButtonMovimentoListar = new javax.swing.JButton();
        jFormattedTextFieldMovimentoData = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMovimentoHora = new javax.swing.JFormattedTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTableMovimentoResumo = new javax.swing.JTable();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTableMovimentoRecebimentoMensalidadePacote = new javax.swing.JTable();
        jLabel128 = new javax.swing.JLabel();
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
        jButtonF5Contrato = new javax.swing.JButton();
        jButtonF4Rotativo = new javax.swing.JButton();
        jButtonF1Patio = new javax.swing.JButton();
        jButtonF2Movimento = new javax.swing.JButton();
        jButtonF8Configuracoes = new javax.swing.JButton();
        jButtonF10Sair = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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

        jTableClienteContrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableClienteContrato.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableClienteContrato.setIntercellSpacing(new java.awt.Dimension(1, 3));
        jTableClienteContrato.setRowHeight(30);
        jTableClienteContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableClienteContratoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableClienteContrato);

        jPanel41.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1154, 545));

        jPanel40.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel40.setPreferredSize(new java.awt.Dimension(280, 250));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonClientePesquisaIncluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClientePesquisaIncluir.setMnemonic('I');
        jButtonClientePesquisaIncluir.setText("Incluir");
        jButtonClientePesquisaIncluir.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClientePesquisaIncluir.setRequestFocusEnabled(false);
        jButtonClientePesquisaIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientePesquisaIncluirActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonClientePesquisaIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, -1));

        jButtonClientePesquisaSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClientePesquisaSair.setMnemonic('S');
        jButtonClientePesquisaSair.setText("Sair");
        jButtonClientePesquisaSair.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClientePesquisaSair.setRequestFocusEnabled(false);
        jButtonClientePesquisaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientePesquisaSairActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonClientePesquisaSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, -1, -1));

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldClienteNomePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldClienteNomePesquisaActionPerformed(evt);
            }
        });
        jPanel39.add(jTextFieldClienteNomePesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 54, 295, -1));

        jLabel72.setText("Nome");
        jPanel39.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jButtonClientePesquisaLocalizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClientePesquisaLocalizar.setMnemonic('I');
        jButtonClientePesquisaLocalizar.setText("Localizar");
        jButtonClientePesquisaLocalizar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClientePesquisaLocalizar.setRequestFocusEnabled(false);
        jButtonClientePesquisaLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientePesquisaLocalizarActionPerformed(evt);
            }
        });
        jPanel39.add(jButtonClientePesquisaLocalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 52, -1, -1));

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel105.setText("Para exibir a lista completa deixe o campo Nome em braco e clique em localizar.");
        jPanel39.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 29, -1, -1));

        jPanel40.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 5, 480, 90));

        jButtonClientePesquisaExibir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClientePesquisaExibir.setMnemonic('I');
        jButtonClientePesquisaExibir.setText("Exibir");
        jButtonClientePesquisaExibir.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClientePesquisaExibir.setRequestFocusEnabled(false);
        jButtonClientePesquisaExibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientePesquisaExibirActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonClientePesquisaExibir, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, -1, -1));

        jButtonClientePesquisaAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClientePesquisaAlterar.setMnemonic('I');
        jButtonClientePesquisaAlterar.setText("Alterar");
        jButtonClientePesquisaAlterar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClientePesquisaAlterar.setRequestFocusEnabled(false);
        jButtonClientePesquisaAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientePesquisaAlterarActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonClientePesquisaAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, -1, -1));

        jButtonClientePesquisaCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClientePesquisaCancelar.setMnemonic('I');
        jButtonClientePesquisaCancelar.setText("Cancelar");
        jButtonClientePesquisaCancelar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClientePesquisaCancelar.setRequestFocusEnabled(false);
        jButtonClientePesquisaCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientePesquisaCancelarActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonClientePesquisaCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        buttonGroupClienteAtivoInativo.add(jRadioButtonAtivos);
        jRadioButtonAtivos.setSelected(true);
        jRadioButtonAtivos.setText("Ativo");
        jRadioButtonAtivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonAtivosMouseClicked(evt);
            }
        });
        jRadioButtonAtivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonAtivosActionPerformed(evt);
            }
        });
        jPanel40.add(jRadioButtonAtivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        buttonGroupClienteAtivoInativo.add(jRadioButtonInativos);
        jRadioButtonInativos.setText("Cancelado");
        jRadioButtonInativos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonInativosMouseClicked(evt);
            }
        });
        jRadioButtonInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonInativosActionPerformed(evt);
            }
        });
        jPanel40.add(jRadioButtonInativos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        buttonGroupClienteAtivoInativo.add(jRadioButtonAtiInaTodos);
        jRadioButtonAtiInaTodos.setText("Todos");
        jRadioButtonAtiInaTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonAtiInaTodosMouseClicked(evt);
            }
        });
        jPanel40.add(jRadioButtonAtiInaTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel109.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel109.setText("Exibir clientes");
        jPanel40.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel40.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 20, 70));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel40.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 10, 90));

        jButtonClientePesquisaFaturas.setText("Fatura");
        jButtonClientePesquisaFaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientePesquisaFaturasActionPerformed(evt);
            }
        });
        jPanel40.add(jButtonClientePesquisaFaturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, 92, 30));

        jLabel111.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel111.setText("Consulta");
        jPanel40.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, -1, -1));

        buttonGroupClienteMensalistaPacote.add(jRadioButtonMensalista);
        jRadioButtonMensalista.setSelected(true);
        jRadioButtonMensalista.setText("Mensalista");
        jRadioButtonMensalista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMensalistaMouseClicked(evt);
            }
        });
        jRadioButtonMensalista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMensalistaActionPerformed(evt);
            }
        });
        jPanel40.add(jRadioButtonMensalista, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, -1, -1));

        buttonGroupClienteMensalistaPacote.add(jRadioButtonPacote);
        jRadioButtonPacote.setText("Pacote");
        jRadioButtonPacote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPacoteMouseClicked(evt);
            }
        });
        jPanel40.add(jRadioButtonPacote, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, -1, -1));

        buttonGroupClienteMensalistaPacote.add(jRadioButtonMenPacTodos);
        jRadioButtonMenPacTodos.setText("Todos");
        jRadioButtonMenPacTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMenPacTodosMouseClicked(evt);
            }
        });
        jPanel40.add(jRadioButtonMenPacTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, -1, -1));

        jPanel41.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 560, 1150, 105));

        jTabbedPaneClienteContrato.addTab("Pesquisa", jPanel41);

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
        jPanel37.add(jTextFieldMensalistaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 370, 30));

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

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("Número do cliente");
        jPanel37.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        jTextFieldClienteIdCliente.setEditable(false);
        jPanel37.add(jTextFieldClienteIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 25, 60, 20));

        jPanel33.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 630, 310));

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

        jPanel33.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 450, 310));

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

        jPanel33.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 980, 180));

        jPanel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonClienteCadastroSim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClienteCadastroSim.setMnemonic('I');
        jButtonClienteCadastroSim.setText("Sim");
        jButtonClienteCadastroSim.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClienteCadastroSim.setRequestFocusEnabled(false);
        jButtonClienteCadastroSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteCadastroSimActionPerformed(evt);
            }
        });
        jPanel38.add(jButtonClienteCadastroSim, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 15, -1, -1));

        jButtonClienteCadastroNao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClienteCadastroNao.setMnemonic('I');
        jButtonClienteCadastroNao.setText("Não");
        jButtonClienteCadastroNao.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClienteCadastroNao.setRequestFocusEnabled(false);
        jButtonClienteCadastroNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteCadastroNaoActionPerformed(evt);
            }
        });
        jPanel38.add(jButtonClienteCadastroNao, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 15, -1, -1));

        jLabelMensalistaStatus.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabelMensalistaStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMensalistaStatus.setText("Status");
        jPanel38.add(jLabelMensalistaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 550, -1));

        jButtonClienteCadastroCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClienteCadastroCancelar.setMnemonic('E');
        jButtonClienteCadastroCancelar.setText("Cancelar");
        jButtonClienteCadastroCancelar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClienteCadastroCancelar.setRequestFocusEnabled(false);
        jButtonClienteCadastroCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteCadastroCancelarActionPerformed(evt);
            }
        });
        jPanel38.add(jButtonClienteCadastroCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 15, 110, -1));

        jButtonClienteCadastroAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClienteCadastroAlterar.setMnemonic('A');
        jButtonClienteCadastroAlterar.setText("Alterar");
        jButtonClienteCadastroAlterar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClienteCadastroAlterar.setRequestFocusEnabled(false);
        jButtonClienteCadastroAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteCadastroAlterarActionPerformed(evt);
            }
        });
        jPanel38.add(jButtonClienteCadastroAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 15, -1, -1));

        jButtonClienteCadastroSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonClienteCadastroSair.setMnemonic('E');
        jButtonClienteCadastroSair.setText("Sair");
        jButtonClienteCadastroSair.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonClienteCadastroSair.setRequestFocusEnabled(false);
        jButtonClienteCadastroSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClienteCadastroSairActionPerformed(evt);
            }
        });
        jPanel38.add(jButtonClienteCadastroSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 15, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel38.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 10, 40));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel38.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 10, 40));

        jPanel33.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 1165, 60));

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contrato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Número do contrato");
        jPanel31.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, -1, -1));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setText("Data início");
        jPanel31.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel106.setText("Data Cancelamento");
        jPanel31.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, 20));

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel107.setText("Status");
        jPanel31.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, -1, -1));

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel108.setText("Valor R$");
        jPanel31.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        jTextFieldContratoDiaVencimento.setEditable(false);
        jTextFieldContratoDiaVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldContratoDiaVencimentoActionPerformed(evt);
            }
        });
        jPanel31.add(jTextFieldContratoDiaVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 30, -1));

        jTextFieldContratoStatus.setEditable(false);
        jPanel31.add(jTextFieldContratoStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 60, 70, -1));

        jFormattedTextFieldContratoDataInicio.setEditable(false);
        try {
            jFormattedTextFieldContratoDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldContratoDataInicio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel31.add(jFormattedTextFieldContratoDataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 70, -1));

        jFormattedTextFieldContratoDataCancelamento.setEditable(false);
        try {
            jFormattedTextFieldContratoDataCancelamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldContratoDataCancelamento.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel31.add(jFormattedTextFieldContratoDataCancelamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 70, 20));

        jTextFieldContratoNumero.setEditable(false);
        jPanel31.add(jTextFieldContratoNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 35, 60, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Data término");
        jPanel31.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        jFormattedTextFieldContratoDataTermino.setEditable(false);
        try {
            jFormattedTextFieldContratoDataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldContratoDataTermino.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel31.add(jFormattedTextFieldContratoDataTermino, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 70, -1));

        buttonGroupContratoDiasUtilizacoes.add(jRadioButtonContratoDias);
        jRadioButtonContratoDias.setText("Dias");
        jRadioButtonContratoDias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonContratoDiasMouseClicked(evt);
            }
        });
        jPanel31.add(jRadioButtonContratoDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        buttonGroupContratoDiasUtilizacoes.add(jRadioButtonContratoUtilizacoes);
        jRadioButtonContratoUtilizacoes.setText("Utilizações");
        jRadioButtonContratoUtilizacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonContratoUtilizacoesMouseClicked(evt);
            }
        });
        jPanel31.add(jRadioButtonContratoUtilizacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        jLabel114.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel114.setText("Quantidade");
        jPanel31.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel31.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 20, 10, 60));

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel31.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 20, 10, 60));

        buttonGroupContratoMensalistaPacote.add(jRadioButtonContratoMensalista);
        jRadioButtonContratoMensalista.setText("Mensalista");
        jRadioButtonContratoMensalista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonContratoMensalistaMouseClicked(evt);
            }
        });
        jPanel31.add(jRadioButtonContratoMensalista, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        buttonGroupContratoMensalistaPacote.add(jRadioButtonContratoPacote);
        jRadioButtonContratoPacote.setText("Pacote");
        jRadioButtonContratoPacote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonContratoPacoteMouseClicked(evt);
            }
        });
        jPanel31.add(jRadioButtonContratoPacote, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        try {
            jFormattedTextFieldContratoQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldContratoQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFormattedTextFieldContratoQuantidade.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextFieldContratoQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldContratoQuantidadeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldContratoQuantidadeKeyReleased(evt);
            }
        });
        jPanel31.add(jFormattedTextFieldContratoQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 30, -1));

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel112.setText("Dia vencimento");
        jPanel31.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, -1, -1));

        jTextFieldContratoValor.setEditable(false);
        jPanel31.add(jTextFieldContratoValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 70, -1));

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel31.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 20, 10, 60));

        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel31.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 20, 10, 60));

        jPanel33.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1160, 90));

        jButtonContratoConsultaFatura.setText("Fatura");
        jButtonContratoConsultaFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContratoConsultaFaturaActionPerformed(evt);
            }
        });
        jPanel33.add(jButtonContratoConsultaFatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(1057, 500, 92, 30));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel33.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1161, 430, 10, 170));

        jLabel110.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel110.setText("Consulta");
        jPanel33.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 480, -1, -1));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel33.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 430, 10, 170));

        jTabbedPaneClienteContrato.addTab("Consulta", jPanel33);

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableContratoFatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableContratoFatura.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableContratoFatura.setRowHeight(30);
        jScrollPane2.setViewportView(jTableContratoFatura);

        jPanel32.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1170, 480));

        jLabel113.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel113.setText("Histórico de faturas:");
        jPanel32.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, 20));

        jButtonContratoFaturaSair.setText("Sair");
        jButtonContratoFaturaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContratoFaturaSairActionPerformed(evt);
            }
        });
        jPanel32.add(jButtonContratoFaturaSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 630, 90, 30));

        jLabel124.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel124.setText("Cliente");
        jPanel32.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 115, -1, -1));

        jTextFieldContratoFaturaCliente.setEditable(false);
        jTextFieldContratoFaturaCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel32.add(jTextFieldContratoFaturaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 360, -1));

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel117.setText("CPF");
        jPanel32.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 115, -1, -1));

        jFormattedTextFieldContratoFaturaCPF.setEditable(false);
        try {
            jFormattedTextFieldContratoFaturaCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldContratoFaturaCPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel32.add(jFormattedTextFieldContratoFaturaCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 160, -1));

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contrato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel115.setText("Número do contrato");
        jPanel34.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, -1, -1));

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel116.setText("Data início");
        jPanel34.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel118.setText("Data Cancelamento");
        jPanel34.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, 20));

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel119.setText("Status");
        jPanel34.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, -1, -1));

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel120.setText("Valor R$");
        jPanel34.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        jTextFieldContratoFaturaDiaVencimento.setEditable(false);
        jTextFieldContratoFaturaDiaVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldContratoFaturaDiaVencimentoActionPerformed(evt);
            }
        });
        jPanel34.add(jTextFieldContratoFaturaDiaVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 30, -1));

        jTextFieldContratoFaturaStatus.setEditable(false);
        jPanel34.add(jTextFieldContratoFaturaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 60, 70, -1));

        jFormattedTextFieldContratoFaturaDataInicio.setEditable(false);
        try {
            jFormattedTextFieldContratoFaturaDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldContratoFaturaDataInicio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel34.add(jFormattedTextFieldContratoFaturaDataInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 70, -1));

        jFormattedTextFieldContratoFaturaUltimaAlteracao.setEditable(false);
        try {
            jFormattedTextFieldContratoFaturaUltimaAlteracao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldContratoFaturaUltimaAlteracao.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel34.add(jFormattedTextFieldContratoFaturaUltimaAlteracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 70, 20));

        jTextFieldContratoFaturaNumero.setEditable(false);
        jPanel34.add(jTextFieldContratoFaturaNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 35, 60, -1));

        jLabel121.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel121.setText("Data término");
        jPanel34.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        jFormattedTextFieldContratoFaturaDataTermino.setEditable(false);
        try {
            jFormattedTextFieldContratoFaturaDataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldContratoFaturaDataTermino.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel34.add(jFormattedTextFieldContratoFaturaDataTermino, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 70, -1));

        buttonGroupContratoDiasUtilizacoes.add(jRadioButtonContratoFaturaDias);
        jRadioButtonContratoFaturaDias.setText("Dias");
        jRadioButtonContratoFaturaDias.setEnabled(false);
        jRadioButtonContratoFaturaDias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonContratoFaturaDiasMouseClicked(evt);
            }
        });
        jPanel34.add(jRadioButtonContratoFaturaDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        buttonGroupContratoDiasUtilizacoes.add(jRadioButtonContratoFaturaUtilizacoes);
        jRadioButtonContratoFaturaUtilizacoes.setText("Utilizações");
        jRadioButtonContratoFaturaUtilizacoes.setEnabled(false);
        jRadioButtonContratoFaturaUtilizacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonContratoFaturaUtilizacoesMouseClicked(evt);
            }
        });
        jPanel34.add(jRadioButtonContratoFaturaUtilizacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        jLabel122.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel122.setText("Quantidade");
        jPanel34.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel34.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 20, 10, 60));

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel34.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 20, 10, 60));

        buttonGroupContratoMensalistaPacote.add(jRadioButtonContratoFaturaMensalista);
        jRadioButtonContratoFaturaMensalista.setText("Mensalista");
        jRadioButtonContratoFaturaMensalista.setEnabled(false);
        jRadioButtonContratoFaturaMensalista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonContratoFaturaMensalistaMouseClicked(evt);
            }
        });
        jPanel34.add(jRadioButtonContratoFaturaMensalista, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        buttonGroupContratoMensalistaPacote.add(jRadioButtonContratoFaturaPacote);
        jRadioButtonContratoFaturaPacote.setText("Pacote");
        jRadioButtonContratoFaturaPacote.setEnabled(false);
        jRadioButtonContratoFaturaPacote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonContratoFaturaPacoteMouseClicked(evt);
            }
        });
        jPanel34.add(jRadioButtonContratoFaturaPacote, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        jFormattedTextFieldContratoFaturaQuantidade.setEditable(false);
        try {
            jFormattedTextFieldContratoFaturaQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldContratoFaturaQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFormattedTextFieldContratoFaturaQuantidade.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextFieldContratoFaturaQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldContratoFaturaQuantidadeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldContratoFaturaQuantidadeKeyReleased(evt);
            }
        });
        jPanel34.add(jFormattedTextFieldContratoFaturaQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 30, -1));

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel123.setText("Dia vencimento");
        jPanel34.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, -1, -1));

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel34.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 20, 10, 60));

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel34.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 20, 10, 60));

        jTextFieldContratoFaturaValor.setEditable(false);
        jPanel34.add(jTextFieldContratoFaturaValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 70, -1));

        jPanel32.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1160, 90));

        jButtonContratoFaturaPagarFatura.setText("Pagar Fatura");
        jButtonContratoFaturaPagarFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContratoFaturaPagarFaturaActionPerformed(evt);
            }
        });
        jPanel32.add(jButtonContratoFaturaPagarFatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 630, 110, 30));

        jTabbedPaneClienteContrato.addTab("Fatura", jPanel32);

        javax.swing.GroupLayout jPanelMensalLayout = new javax.swing.GroupLayout(jPanelMensal);
        jPanelMensal.setLayout(jPanelMensalLayout);
        jPanelMensalLayout.setHorizontalGroup(
            jPanelMensalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneClienteContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, Short.MAX_VALUE)
        );
        jPanelMensalLayout.setVerticalGroup(
            jPanelMensalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneClienteContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPaneOpcoes.addTab("CONTRATO", jPanelMensal);

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

        jTablePatio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTablePatio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTablePatio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePatio.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTablePatio.setRowHeight(30);
        jTablePatio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTablePatioKeyPressed(evt);
            }
        });
        jScrollPane11.setViewportView(jTablePatio);

        jPanel23.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 38, 1118, 360));

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

        jTablePatioResumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePatioResumo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTablePatioResumo.setRowHeight(25);
        jScrollPane13.setViewportView(jTablePatioResumo);

        jPanel23.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 1120, 170));

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel125.setText("Resumo do pátio");
        jPanel23.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

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
        jPanel25.add(jButtonMovimentoSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 630, -1, -1));

        jTableMovimentoRecebimentoRotativoAtualFuturo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableMovimentoRecebimentoRotativoAtualFuturo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableMovimentoRecebimentoRotativoAtualFuturo.setIntercellSpacing(new java.awt.Dimension(0, 1));
        jTableMovimentoRecebimentoRotativoAtualFuturo.setRowHeight(30);
        jScrollPane12.setViewportView(jTableMovimentoRecebimentoRotativoAtualFuturo);

        jPanel25.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1118, 350));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digite a data e hora do movimento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonMovimentoListar.setText("Listar");
        jButtonMovimentoListar.setPreferredSize(new java.awt.Dimension(90, 30));
        jButtonMovimentoListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMovimentoListarActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonMovimentoListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 93, -1));

        try {
            jFormattedTextFieldMovimentoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMovimentoData.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextFieldMovimentoData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel11.add(jFormattedTextFieldMovimentoData, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 30));

        try {
            jFormattedTextFieldMovimentoHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldMovimentoHora.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextFieldMovimentoHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel11.add(jFormattedTextFieldMovimentoHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 70, 30));

        jPanel25.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 430, 60));

        jTableMovimentoResumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableMovimentoResumo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableMovimentoResumo.setRowHeight(20);
        jScrollPane14.setViewportView(jTableMovimentoResumo);

        jPanel25.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 360, 240));

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel126.setText("Resumo do movimento");
        jPanel25.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, -1, -1));

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel127.setText("Recebimento de Rotativo atual e futuro");
        jPanel25.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jTableMovimentoRecebimentoMensalidadePacote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableMovimentoRecebimentoMensalidadePacote.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableMovimentoRecebimentoMensalidadePacote.setRowHeight(25);
        jScrollPane15.setViewportView(jTableMovimentoRecebimentoMensalidadePacote);

        jPanel25.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 740, 180));

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel128.setText("Recebimento de Mensalidade e Pacote");
        jPanel25.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

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

        jPanelOpcoes.add(jTabbedPaneOpcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 1180, 730));

        getContentPane().add(jPanelOpcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 1200, 750));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 18))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonF5Contrato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF5Contrato.setText("F5 (Contrato)");
        jButtonF5Contrato.setFocusable(false);
        jButtonF5Contrato.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF5Contrato.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF5Contrato.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF5Contrato.setRequestFocusEnabled(false);
        jButtonF5Contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF5ContratoActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF5Contrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 190, -1));

        jButtonF4Rotativo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF4Rotativo.setText("F4 (Rotativo)");
        jButtonF4Rotativo.setFocusable(false);
        jButtonF4Rotativo.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF4Rotativo.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF4Rotativo.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF4Rotativo.setRequestFocusEnabled(false);
        jButtonF4Rotativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF4RotativoActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF4Rotativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 190, -1));

        jButtonF1Patio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF1Patio.setText("F1 (Pátio)");
        jButtonF1Patio.setFocusable(false);
        jButtonF1Patio.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF1Patio.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF1Patio.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF1Patio.setRequestFocusEnabled(false);
        jButtonF1Patio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF1PatioActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF1Patio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 190, -1));

        jButtonF2Movimento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF2Movimento.setText("F2 (Movimento)");
        jButtonF2Movimento.setFocusable(false);
        jButtonF2Movimento.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF2Movimento.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF2Movimento.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF2Movimento.setRequestFocusEnabled(false);
        jButtonF2Movimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF2MovimentoActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF2Movimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 190, -1));

        jButtonF8Configuracoes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF8Configuracoes.setText("F8 (Configurações)");
        jButtonF8Configuracoes.setFocusable(false);
        jButtonF8Configuracoes.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF8Configuracoes.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF8Configuracoes.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF8Configuracoes.setRequestFocusEnabled(false);
        jButtonF8Configuracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF8ConfiguracoesActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF8Configuracoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 461, 190, -1));

        jButtonF10Sair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonF10Sair.setText("F10 (Sair)");
        jButtonF10Sair.setFocusable(false);
        jButtonF10Sair.setMaximumSize(new java.awt.Dimension(165, 40));
        jButtonF10Sair.setMinimumSize(new java.awt.Dimension(165, 40));
        jButtonF10Sair.setPreferredSize(new java.awt.Dimension(165, 40));
        jButtonF10Sair.setRequestFocusEnabled(false);
        jButtonF10Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonF10SairActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonF10Sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 519, 190, -1));

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 670, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 865));

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
            case KeyEvent.VK_F1:
                patioListaVeiculo("entrada");
                break;
            case KeyEvent.VK_F2:
                movimentoListaVeiculo(jFormattedTextFieldMovimentoData.getText(), jFormattedTextFieldMovimentoHora.getText());
                break;
            case KeyEvent.VK_F4:
                menuPrincipal("rotativo");
                break;
            case KeyEvent.VK_F5:
                menuPrincipal("contrato");
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
            if (jListRotativoTipo.getSelectedValue().equalsIgnoreCase("Cancelar entrada do veículo")) {
                limparObjetosPatio();
            } else {
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
                menuPrincipalBotaoEnabledPainelEnabledAt(true);
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
                rotativo.setIdRotativo(0);
                rotativo = rotativoService.rotativoVerificaExistencia(jTextFieldRotativoIncluirAlterar.getText());
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
                    rotativo.setIdRotativo(0);
                    rotativo = rotativoService.rotativoVerificaExistencia(jTextFieldRotativoIncluirAlterar.getText());
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
        menuPrincipalBotaoEnabledPainelEnabledAt(true);
    }//GEN-LAST:event_jButtonPatioSairActionPerformed

    private void jButtonMovimentoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMovimentoSairActionPerformed
        menuPrincipalBotaoEnabledPainelEnabledAt(true);
    }//GEN-LAST:event_jButtonMovimentoSairActionPerformed

    private void jButtonMovimentoListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMovimentoListarActionPerformed
        if (jFormattedTextFieldMovimentoData.getText().matches("[0-9]{2,2}/[0-9]{2,2}/[0-9]{4,4}")) {
            movimentoListaVeiculo(jFormattedTextFieldMovimentoData.getText(), jFormattedTextFieldMovimentoHora.getText());
            movimentoListaFaturaPaga("%", "%", "%", jFormattedTextFieldMovimentoData.getText(), "%", "%");
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        confirmaSaidaSistema();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonPatioListaPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatioListaPlacaActionPerformed
        patioListaVeiculo("placa");
    }//GEN-LAST:event_jButtonPatioListaPlacaActionPerformed

    private void jButtonPatioListaPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatioListaPrismaActionPerformed
        patioListaVeiculo("prisma");
    }//GEN-LAST:event_jButtonPatioListaPrismaActionPerformed

    private void jButtonPatioListaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatioListaTipoActionPerformed
        patioListaVeiculo("tipo");
    }//GEN-LAST:event_jButtonPatioListaTipoActionPerformed

    private void jButtonPatioListaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPatioListaEntradaActionPerformed
        patioListaVeiculo("entrada");
    }//GEN-LAST:event_jButtonPatioListaEntradaActionPerformed

    private void jButtonClienteCadastroSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteCadastroSairActionPerformed
        jTabbedPaneClienteContrato.setEnabledAt(0, true);
        jTabbedPaneClienteContrato.setEnabledAt(1, false);
        jTabbedPaneClienteContrato.setEnabledAt(2, false);
        jTabbedPaneClienteContrato.setSelectedIndex(0);
        clienteContratoLista();
    }//GEN-LAST:event_jButtonClienteCadastroSairActionPerformed

    private void jButtonClienteCadastroAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteCadastroAlterarActionPerformed
        jButtonContratoConsultaFatura.setEnabled(false);
        jButtonClienteCadastroAlterar.setEnabled(false);
        jButtonClienteCadastroCancelar.setEnabled(false);
        jButtonClienteCadastroSim.setEnabled(true);
        jButtonClienteCadastroNao.setEnabled(true);
        contratoStatus = "Alteração";
        jLabelMensalistaStatus.setText("Alteração de CONTRATO!");
        clienteJTextFieldEditable(true);
        contratoJTextFieldEditable(true);
    }//GEN-LAST:event_jButtonClienteCadastroAlterarActionPerformed

    private void jButtonClienteCadastroCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteCadastroCancelarActionPerformed
        if (jTextFieldContratoStatus.getText().equalsIgnoreCase("Ativo")) {
            jLabelMensalistaStatus.setText("O CONTRATO esta " + contratoArrayList.get(0).getStatus() + ". Deseja cancelar?");
        } else if (jTextFieldContratoStatus.getText().equalsIgnoreCase("Cancelado")) {
            jLabelMensalistaStatus.setText("O CONTRATO foi cancelado em " + contratoArrayList.get(0).getDataCancelamento());
        }
        jButtonContratoConsultaFatura.setEnabled(false);
        jButtonClienteCadastroAlterar.setEnabled(false);
        jButtonClienteCadastroCancelar.setEnabled(false);
        jButtonClienteCadastroSim.setEnabled(true);
        jButtonClienteCadastroNao.setEnabled(true);
        contratoStatus = "Cancelamento";
    }//GEN-LAST:event_jButtonClienteCadastroCancelarActionPerformed

    private void jButtonClienteCadastroNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteCadastroNaoActionPerformed
        switch (contratoStatus) {
            case "Inclusão":
                JOptionPane.showMessageDialog(this, "Inclusão de mensalista cancelada!!!");
                jTabbedPaneClienteContrato.setEnabledAt(0, true);
                jTabbedPaneClienteContrato.setEnabledAt(1, false);
                jTabbedPaneClienteContrato.setEnabledAt(2, false);
                jTabbedPaneClienteContrato.setSelectedIndex(0);
                break;
            case "Alteração":
                contratoJTextFieldEditable(false);
                contratoJTextFieldConteudo(null);
                contratoConsultaPreencherJTextField(contratoArrayList.get(0));
                clienteJTextFieldEditable(false);
                clienteJTextFieldConteudo(null);
                clientePreencherJTextField(contratoArrayList.get(0).getIdClienteFk());
                jButtonClienteCadastroAlterar.setEnabled(true);
                jButtonClienteCadastroCancelar.setEnabled(true);
                jButtonContratoConsultaFatura.setEnabled(true);
                jButtonClienteCadastroSim.setEnabled(false);
                jButtonClienteCadastroNao.setEnabled(false);
                contratoStatus = "Consulta";
                jLabelMensalistaStatus.setText("Consulta dados CONTRATO!!!");
                JOptionPane.showMessageDialog(this, "Alteração do CONTRATO cancelada!!!");
                break;
            case "Cancelamento":
                jButtonClienteCadastroAlterar.setEnabled(true);
                jButtonClienteCadastroCancelar.setEnabled(true);
                jButtonClienteCadastroSim.setEnabled(false);
                jButtonClienteCadastroNao.setEnabled(false);
                contratoStatus = "Consulta";
                jLabelMensalistaStatus.setText("Consulta dados CONTRATO!!!");
                JOptionPane.showMessageDialog(this, "O CONTRATO não foi CANCELADO!!!");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonClienteCadastroNaoActionPerformed

    private void jButtonClienteCadastroSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClienteCadastroSimActionPerformed
        switch (contratoStatus) {
            case "Inclusão":
                if (contratoVerificaCamposValidos()) {
                    contrato.setIdClienteFk(clienteService.clienteIncluir(clientePopularObjeto()));
                    contrato = contratoService.contratoIncluir(contratoPopularObjeto());
                    contratoVerificaVeiculosCadastrados(contrato);
                    jTextFieldContratoNumero.setText(String.valueOf(contrato.getIdContrato()));
                    jTextFieldClienteIdCliente.setText(String.valueOf(cliente.getIdCliente()));
                    JOptionPane.showMessageDialog(this, "Inclusão de contrato efetuada com sucesso!!!\n\n"
                            + "NOME[ " + contrato.getIdClienteFk().getNome() + " ]\n"
                            + "N. CONTRATO[ " + contrato.getIdContrato() + " ]");
                    jLabelMensalistaStatus.setText("Consultando dados do contrato!!!");
                }
                break;
            case "Alteração":
                if (contratoVerificaCamposValidos()) {
                    SimpleDateFormat dataAlteracao = new SimpleDateFormat("ddMMyyyy");
                    jFormattedTextFieldContratoDataCancelamento.setText(dataAlteracao.format(new Date()));
                    contrato.setIdClienteFk(clienteService.clienteAlterar(clientePopularObjeto()));
                    contrato = contratoService.contratoAlterar(contratoPopularObjeto());
                    contratoVerificaVeiculosCadastrados(contrato);
                    JOptionPane.showMessageDialog(this, "Alteração efetuada com sucesso!!!\n\n"
                            + "NOME[ " + contrato.getIdClienteFk().getNome() + " ]\n"
                            + "N. CONTRATO[ " + contrato.getIdContrato() + " ]\n\n"
                            + "Ultima alteração realizada em[ " + jFormattedTextFieldContratoDataCancelamento.getText() + " ]");
                    jLabelMensalistaStatus.setText("Consultando dados do contrato!!!");
                }
                break;
            case "Cancelamento":
                SimpleDateFormat dataCancelamento = new SimpleDateFormat("dd/MM/yyyy");
                jButtonClienteCadastroCancelar.setEnabled(false);
                contratoArrayList = contratoService.contratoList("%", "%", "%", String.valueOf(contrato.getIdContrato()));
                contrato = contratoArrayList.get(0);
                contrato.setStatus("Cancelado");
                jTextFieldContratoStatus.setText(contrato.getStatus());
                contrato.setDataCancelamento(dataCancelamento.format(new Date()));
                jFormattedTextFieldContratoDataCancelamento.setText(contrato.getDataCancelamento());
                contrato = contratoService.contratoCancelar(contrato);
                jButtonClienteCadastroAlterar.setEnabled(false);
                jButtonClienteCadastroSim.setEnabled(false);
                jButtonClienteCadastroNao.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Cancelamento efetuado com sucesso!!!\n\n"
                        + "NOME[ " + contrato.getIdClienteFk().getNome() + " ]\n"
                        + "N. CONTRATO[ " + contrato.getIdContrato() + " ]\n\n"
                        + "Data Cancelamento realizado em[ " + jFormattedTextFieldContratoDataCancelamento.getText() + " ]\n\n"
                        + "O contrato agora está: " + contrato.getStatus());
                jLabelMensalistaStatus.setText("Consultando dados do contrato!!!");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonClienteCadastroSimActionPerformed

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

    private void jButtonClientePesquisaCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientePesquisaCancelarActionPerformed
        Contrato contrato = new Contrato();
        if (jTableClienteContrato.getRowCount() != 0 && jTableClienteContrato.getSelectedRowCount() != 0) {
            contrato.setIdContrato(Integer.parseInt((String) jTableClienteContrato.getModel().getValueAt(jTableClienteContrato.getSelectedRow(), 0)));
            contratoArrayList = contratoService.contratoList("%", "%", "%", String.valueOf(contrato.getIdContrato()));
            if (contratoArrayList.get(0).getIdContrato() != 0) {
                contratoConsultaPreencherJTextField(contratoArrayList.get(0));
                contratoJTextFieldEditable(false);
                clientePreencherJTextField(contratoArrayList.get(0).getIdClienteFk());
                clienteJTextFieldEditable(false);
                if (jTextFieldContratoStatus.getText().equalsIgnoreCase("Cancelado")) {
                    jLabelMensalistaStatus.setText("O CONTRATO foi " + contratoArrayList.get(0).getStatus() + " em " + contratoArrayList.get(0).getDataCancelamento());
                    jButtonClienteCadastroSim.setEnabled(false);
                    jButtonClienteCadastroNao.setEnabled(false);
                } else if (jTextFieldContratoStatus.getText().equalsIgnoreCase("Ativo")) {
                    jLabelMensalistaStatus.setText("Contrato " + contratoArrayList.get(0).getStatus() + ". Deseja CANCELAR?");
                    jButtonClienteCadastroSim.setEnabled(true);
                    jButtonClienteCadastroNao.setEnabled(true);
                }
                jTabbedPaneClienteContrato.setEnabledAt(0, false);
                jTabbedPaneClienteContrato.setEnabledAt(1, true);
                jTabbedPaneClienteContrato.setEnabledAt(2, false);
                jTabbedPaneClienteContrato.setSelectedIndex(1);
                jButtonContratoConsultaFatura.setEnabled(true);
                jButtonClienteCadastroCancelar.setEnabled(false);
                jButtonClienteCadastroAlterar.setEnabled(false);
                contratoStatus = "Cancelamento";
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado!!!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Cliente!!!");
        }
    }//GEN-LAST:event_jButtonClientePesquisaCancelarActionPerformed

    private void jButtonClientePesquisaAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientePesquisaAlterarActionPerformed
        Contrato contrato = new Contrato();
        if (jTableClienteContrato.getRowCount() != 0 && jTableClienteContrato.getSelectedRowCount() != 0) {
            contrato.setIdContrato(Integer.parseInt((String) jTableClienteContrato.getModel().getValueAt(jTableClienteContrato.getSelectedRow(), 0)));
            contratoArrayList = contratoService.contratoList("%", "%", "%", String.valueOf(contrato.getIdContrato()));
            if (contratoArrayList.get(0).getIdContrato() != 0) {
                contratoJTextFieldConteudo(null);
                contratoConsultaPreencherJTextField(contratoArrayList.get(0));
                contratoJTextFieldEditable(true);
                clienteJTextFieldConteudo(null);
                clientePreencherJTextField(contratoArrayList.get(0).getIdClienteFk());
                clienteJTextFieldEditable(true);
                if (jTextFieldContratoStatus.getText().equalsIgnoreCase("Ativo")) {
                    jButtonClienteCadastroCancelar.setText("Inativar");
                } else if (jTextFieldContratoStatus.getText().equalsIgnoreCase("Inativo")) {
                    jButtonClienteCadastroCancelar.setText("Ativar");
                }
                jTabbedPaneClienteContrato.setEnabledAt(0, false);
                jTabbedPaneClienteContrato.setEnabledAt(1, true);
                jTabbedPaneClienteContrato.setEnabledAt(2, false);
                jTabbedPaneClienteContrato.setSelectedIndex(1);
                jButtonContratoConsultaFatura.setEnabled(false);
                jButtonClienteCadastroAlterar.setEnabled(false);
                jButtonClienteCadastroCancelar.setEnabled(false);
                jButtonClienteCadastroSim.setEnabled(true);
                jButtonClienteCadastroNao.setEnabled(true);
                contratoStatus = "Alteração";
                jLabelMensalistaStatus.setText("Alteração de CONTRATO!!!");
            } else {
                JOptionPane.showMessageDialog(this, "Contrato não encontrado!!!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Cliente!!!");
        }
    }//GEN-LAST:event_jButtonClientePesquisaAlterarActionPerformed

    private void jButtonClientePesquisaExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientePesquisaExibirActionPerformed
        Contrato contrato = new Contrato();
        if (jTableClienteContrato.getRowCount() != 0 && jTableClienteContrato.getSelectedRowCount() != 0) {
            contrato.setIdContrato(Integer.parseInt((String) jTableClienteContrato.getModel().getValueAt(jTableClienteContrato.getSelectedRow(), 0)));
            contratoArrayList = contratoService.contratoList("%", "%", "%", String.valueOf(contrato.getIdContrato()));
            if (contratoArrayList.get(0).getIdContrato() != 0) {
                clienteJTextFieldConteudo(null);
                clientePreencherJTextField(contratoArrayList.get(0).getIdClienteFk());
                contratoConsultaPreencherJTextField(contratoArrayList.get(0));
                clienteJTextFieldEditable(false);
                contratoJTextFieldEditable(false);
                if (jTextFieldContratoStatus.getText().equalsIgnoreCase("Ativo")) {
                    jButtonClienteCadastroCancelar.setEnabled(true);
                    jButtonClienteCadastroAlterar.setEnabled(true);
                } else if (jTextFieldContratoStatus.getText().equalsIgnoreCase("Cancelado")) {
                    jButtonClienteCadastroCancelar.setEnabled(false);
                    jButtonClienteCadastroAlterar.setEnabled(false);
                }
                jTabbedPaneClienteContrato.setEnabledAt(0, false);
                jTabbedPaneClienteContrato.setEnabledAt(1, true);
                jTabbedPaneClienteContrato.setEnabledAt(2, false);
                jTabbedPaneClienteContrato.setSelectedIndex(1);
                jButtonContratoConsultaFatura.setEnabled(true);
                jButtonClienteCadastroSim.setEnabled(false);
                jButtonClienteCadastroNao.setEnabled(false);
                contratoStatus = "Consulta";
                jLabelMensalistaStatus.setText("Consultando dados do Contrato!!!");
            } else {
                JOptionPane.showMessageDialog(this, "Contrato não encontrado!!!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um Contrato!!!");
        }
    }//GEN-LAST:event_jButtonClientePesquisaExibirActionPerformed

    private void jButtonClientePesquisaLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientePesquisaLocalizarActionPerformed
        clienteContratoLista();
    }//GEN-LAST:event_jButtonClientePesquisaLocalizarActionPerformed

    private void jTextFieldClienteNomePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldClienteNomePesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldClienteNomePesquisaActionPerformed

    private void jButtonClientePesquisaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientePesquisaSairActionPerformed
        menuPrincipalBotaoEnabledPainelEnabledAt(true);
    }//GEN-LAST:event_jButtonClientePesquisaSairActionPerformed

    private void jButtonClientePesquisaIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientePesquisaIncluirActionPerformed
        jTabbedPaneClienteContrato.setEnabledAt(0, false);
        jTabbedPaneClienteContrato.setEnabledAt(1, true);
        jTabbedPaneClienteContrato.setEnabledAt(2, false);
        jTabbedPaneClienteContrato.setSelectedIndex(1);
        jButtonContratoConsultaFatura.setEnabled(false);
        jButtonClienteCadastroAlterar.setEnabled(false);
        jButtonClienteCadastroCancelar.setEnabled(false);
        jButtonClienteCadastroCancelar.setText("Inativar");
        jButtonClienteCadastroSim.setEnabled(true);
        jButtonClienteCadastroNao.setEnabled(true);
        contratoStatus = "Inclusão";
        jLabelMensalistaStatus.setText("Inclusão de CONTRATO!");
        jRadioButtonContratoMensalista.setSelected(true);
        jRadioButtonContratoDias.setSelected(true);
        clienteJTextFieldEditable(true);
        contratoJTextFieldEditable(true);
        clienteJTextFieldConteudo(null);
        contratoJTextFieldConteudo(null);
        contratoEscolhaMensalistaPacote();
        jTextFieldContratoStatus.setText("Ativo");
    }//GEN-LAST:event_jButtonClientePesquisaIncluirActionPerformed

    private void jTableClienteContratoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableClienteContratoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableClienteContratoKeyPressed

    private void jButtonF10SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF10SairActionPerformed
        confirmaSaidaSistema();
    }//GEN-LAST:event_jButtonF10SairActionPerformed

    private void jButtonF8ConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF8ConfiguracoesActionPerformed
        menuPrincipal("configuracoes");
    }//GEN-LAST:event_jButtonF8ConfiguracoesActionPerformed

    private void jButtonF2MovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF2MovimentoActionPerformed
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        jFormattedTextFieldMovimentoData.setText(sdfData.format(new Date()));
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        jFormattedTextFieldMovimentoHora.setText(sdfHora.format(new Date()));
        movimentoListaVeiculo(jFormattedTextFieldMovimentoData.getText(), jFormattedTextFieldMovimentoHora.getText());
        movimentoListaFaturaPaga("%", "%", "%", jFormattedTextFieldMovimentoData.getText(), "%", "%");

    }//GEN-LAST:event_jButtonF2MovimentoActionPerformed

    private void jButtonF1PatioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF1PatioActionPerformed
        patioListaVeiculo("entrada");
    }//GEN-LAST:event_jButtonF1PatioActionPerformed

    private void jButtonF4RotativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF4RotativoActionPerformed
        menuPrincipal("rotativo");
    }//GEN-LAST:event_jButtonF4RotativoActionPerformed

    private void jButtonF5ContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonF5ContratoActionPerformed
        jTabbedPaneClienteContrato.setEnabledAt(0, true);
        jTabbedPaneClienteContrato.setEnabledAt(1, false);
        jTabbedPaneClienteContrato.setEnabledAt(2, false);
        jTabbedPaneClienteContrato.setSelectedIndex(0);
        menuPrincipal("contrato");
    }//GEN-LAST:event_jButtonF5ContratoActionPerformed

    private void jRadioButtonAtivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonAtivosMouseClicked
        clienteContratoLista();
    }//GEN-LAST:event_jRadioButtonAtivosMouseClicked

    private void jRadioButtonInativosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonInativosMouseClicked
        clienteContratoLista();
    }//GEN-LAST:event_jRadioButtonInativosMouseClicked

    private void jRadioButtonAtiInaTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonAtiInaTodosMouseClicked
        clienteContratoLista();
    }//GEN-LAST:event_jRadioButtonAtiInaTodosMouseClicked

    private void jRadioButtonMensalistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMensalistaMouseClicked
        clienteContratoLista();
    }//GEN-LAST:event_jRadioButtonMensalistaMouseClicked

    private void jRadioButtonPacoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonPacoteMouseClicked
        clienteContratoLista();
    }//GEN-LAST:event_jRadioButtonPacoteMouseClicked

    private void jRadioButtonMenPacTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMenPacTodosMouseClicked
        clienteContratoLista();
    }//GEN-LAST:event_jRadioButtonMenPacTodosMouseClicked

    private void jRadioButtonAtivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonAtivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonAtivosActionPerformed

    private void jRadioButtonInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonInativosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonInativosActionPerformed

    private void jRadioButtonMensalistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMensalistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMensalistaActionPerformed

    private void jTextFieldContratoDiaVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContratoDiaVencimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContratoDiaVencimentoActionPerformed

    private void jButtonClientePesquisaFaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientePesquisaFaturasActionPerformed
        Contrato contrato = new Contrato();
        if (jTableClienteContrato.getRowCount() != 0 && jTableClienteContrato.getSelectedRowCount() != 0) {
            contrato.setIdContrato(Integer.parseInt((String) jTableClienteContrato.getModel().getValueAt(jTableClienteContrato.getSelectedRow(), 0)));
            contratoArrayList = contratoService.contratoList("%", "%", "%", String.valueOf(contrato.getIdContrato()));
            contratoFaturaPreencherJTextField(contratoArrayList.get(0));
            contratoClienteFatura(contratoArrayList.get(0));
            jTabbedPaneClienteContrato.setEnabledAt(0, false);
            jTabbedPaneClienteContrato.setEnabledAt(1, false);
            jTabbedPaneClienteContrato.setEnabledAt(2, true);
            jTabbedPaneClienteContrato.setSelectedIndex(2);
            contratoStatus = "Pagamento";
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente!!!");
        }
    }//GEN-LAST:event_jButtonClientePesquisaFaturasActionPerformed

    private void jButtonContratoFaturaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContratoFaturaSairActionPerformed
        jTabbedPaneClienteContrato.setEnabledAt(0, true);
        jTabbedPaneClienteContrato.setEnabledAt(1, false);
        jTabbedPaneClienteContrato.setEnabledAt(2, false);
        jTabbedPaneClienteContrato.setSelectedIndex(0);
        clienteContratoLista();
    }//GEN-LAST:event_jButtonContratoFaturaSairActionPerformed

    private void jRadioButtonContratoMensalistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonContratoMensalistaMouseClicked
        if (jRadioButtonContratoMensalista.isEnabled()) {
            contratoEscolhaMensalistaPacote();
        }
    }//GEN-LAST:event_jRadioButtonContratoMensalistaMouseClicked

    private void jRadioButtonContratoPacoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonContratoPacoteMouseClicked
        if (jRadioButtonContratoPacote.isEnabled()) {
            contratoEscolhaMensalistaPacote();
        }
    }//GEN-LAST:event_jRadioButtonContratoPacoteMouseClicked

    private void jRadioButtonContratoDiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonContratoDiasMouseClicked
        if (jRadioButtonContratoDias.isEnabled()) {
            contratoEscolhaMensalistaPacote();
        }
    }//GEN-LAST:event_jRadioButtonContratoDiasMouseClicked

    private void jRadioButtonContratoUtilizacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonContratoUtilizacoesMouseClicked
        if (jRadioButtonContratoUtilizacoes.isEnabled()) {
            contratoEscolhaMensalistaPacote();
        }
    }//GEN-LAST:event_jRadioButtonContratoUtilizacoesMouseClicked

    private void jFormattedTextFieldContratoQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldContratoQuantidadeKeyPressed

    }//GEN-LAST:event_jFormattedTextFieldContratoQuantidadeKeyPressed

    private void jFormattedTextFieldContratoQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldContratoQuantidadeKeyReleased
        contratoValidaQuantidadeDiasUtilizacoes();
    }//GEN-LAST:event_jFormattedTextFieldContratoQuantidadeKeyReleased

    private void jTextFieldContratoFaturaDiaVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldContratoFaturaDiaVencimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldContratoFaturaDiaVencimentoActionPerformed

    private void jRadioButtonContratoFaturaDiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonContratoFaturaDiasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonContratoFaturaDiasMouseClicked

    private void jRadioButtonContratoFaturaUtilizacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonContratoFaturaUtilizacoesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonContratoFaturaUtilizacoesMouseClicked

    private void jRadioButtonContratoFaturaMensalistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonContratoFaturaMensalistaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonContratoFaturaMensalistaMouseClicked

    private void jRadioButtonContratoFaturaPacoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonContratoFaturaPacoteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonContratoFaturaPacoteMouseClicked

    private void jFormattedTextFieldContratoFaturaQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldContratoFaturaQuantidadeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldContratoFaturaQuantidadeKeyPressed

    private void jFormattedTextFieldContratoFaturaQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldContratoFaturaQuantidadeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldContratoFaturaQuantidadeKeyReleased

    private void jButtonContratoConsultaFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContratoConsultaFaturaActionPerformed
        Contrato contrato = new Contrato();
        contrato.setIdContrato(Integer.valueOf(jTextFieldContratoNumero.getText()));
        contratoArrayList = contratoService.contratoList("%", "%", "%", String.valueOf(contrato.getIdContrato()));
        jTabbedPaneClienteContrato.setEnabledAt(0, false);
        jTabbedPaneClienteContrato.setEnabledAt(1, false);
        jTabbedPaneClienteContrato.setEnabledAt(2, true);
        jTabbedPaneClienteContrato.setSelectedIndex(2);
        contratoFaturaPreencherJTextField(contratoArrayList.get(0));
        contratoClienteFatura(contratoArrayList.get(0));
        contratoStatus = "Pagamento";
    }//GEN-LAST:event_jButtonContratoConsultaFaturaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        contratoService.contratoGeraFatura();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonContratoFaturaPagarFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContratoFaturaPagarFaturaActionPerformed
        if (jTableContratoFatura.getRowCount() != 0 && jTableContratoFatura.getSelectedRowCount() != 0) {
            if (jTableContratoFatura.getModel().getValueAt(jTableContratoFatura.getSelectedRow(), 10).equals("Paga")) {
                JOptionPane.showMessageDialog(this, "A FATURA selecionada já está PAGA!!!");
            } else {
                fatura.setIdFatura(Integer.parseInt((String) jTableContratoFatura.getModel().getValueAt(jTableContratoFatura.getSelectedRow(), 1)));
                int resp = JOptionPane.showConfirmDialog(this, "Deseja pagar a fatura de número [" + fatura.getIdFatura() + "]", "Confirma pagamento?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    faturaService.faturaPagamento(fatura.getIdFatura());
                    contratoClienteFatura(contratoArrayList.get(0));
                    JOptionPane.showMessageDialog(this, "A FATURA foi paga com sucesso!!!");
                } else if (resp == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(this, "O pagamento da fatura foi cancelado!!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma Fatura!!!");
        }
    }//GEN-LAST:event_jButtonContratoFaturaPagarFaturaActionPerformed

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
    private javax.swing.ButtonGroup buttonGroupClienteAtivoInativo;
    private javax.swing.ButtonGroup buttonGroupClienteMensalistaPacote;
    private javax.swing.ButtonGroup buttonGroupContratoDiasUtilizacoes;
    private javax.swing.ButtonGroup buttonGroupContratoMensalistaPacote;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonClienteCadastroAlterar;
    private javax.swing.JButton jButtonClienteCadastroCancelar;
    private javax.swing.JButton jButtonClienteCadastroNao;
    private javax.swing.JButton jButtonClienteCadastroSair;
    private javax.swing.JButton jButtonClienteCadastroSim;
    private javax.swing.JButton jButtonClientePesquisaAlterar;
    private javax.swing.JButton jButtonClientePesquisaCancelar;
    private javax.swing.JButton jButtonClientePesquisaExibir;
    private javax.swing.JButton jButtonClientePesquisaFaturas;
    private javax.swing.JButton jButtonClientePesquisaIncluir;
    private javax.swing.JButton jButtonClientePesquisaLocalizar;
    private javax.swing.JButton jButtonClientePesquisaSair;
    private javax.swing.JButton jButtonConfiguracoesAlterarOk;
    private javax.swing.JButton jButtonConfiguracoesSairCancelar;
    private javax.swing.JButton jButtonContratoConsultaFatura;
    private javax.swing.JButton jButtonContratoFaturaPagarFatura;
    private javax.swing.JButton jButtonContratoFaturaSair;
    private javax.swing.JButton jButtonF10Sair;
    private javax.swing.JButton jButtonF1Patio;
    private javax.swing.JButton jButtonF2Movimento;
    private javax.swing.JButton jButtonF4Rotativo;
    private javax.swing.JButton jButtonF5Contrato;
    private javax.swing.JButton jButtonF8Configuracoes;
    private javax.swing.JButton jButtonMovimentoListar;
    private javax.swing.JButton jButtonMovimentoSair;
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
    private javax.swing.JDialog jDialogConfirmaSaidaSistema;
    private javax.swing.JFormattedTextField jFormattedTextFieldContratoDataCancelamento;
    private javax.swing.JFormattedTextField jFormattedTextFieldContratoDataInicio;
    private javax.swing.JFormattedTextField jFormattedTextFieldContratoDataTermino;
    private javax.swing.JFormattedTextField jFormattedTextFieldContratoFaturaCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldContratoFaturaDataInicio;
    private javax.swing.JFormattedTextField jFormattedTextFieldContratoFaturaDataTermino;
    private javax.swing.JFormattedTextField jFormattedTextFieldContratoFaturaQuantidade;
    private javax.swing.JFormattedTextField jFormattedTextFieldContratoFaturaUltimaAlteracao;
    private javax.swing.JFormattedTextField jFormattedTextFieldContratoQuantidade;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaCelularResi;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaCepCome;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaCepResi;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaCpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaDataNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaPlaca01;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaPlaca02;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaPlaca03;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaPlaca04;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaTelefoneCome;
    private javax.swing.JFormattedTextField jFormattedTextFieldMensalistaTelefoneResi;
    private javax.swing.JFormattedTextField jFormattedTextFieldMovimentoData;
    private javax.swing.JFormattedTextField jFormattedTextFieldMovimentoHora;
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
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
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
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
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
    private javax.swing.JPanel jPanelVeiculoEntrada;
    private javax.swing.JPanel jPanelVeiculoSaida;
    private javax.swing.JRadioButton jRadioButtonAtiInaTodos;
    private javax.swing.JRadioButton jRadioButtonAtivos;
    private javax.swing.JRadioButton jRadioButtonContratoDias;
    private javax.swing.JRadioButton jRadioButtonContratoFaturaDias;
    private javax.swing.JRadioButton jRadioButtonContratoFaturaMensalista;
    private javax.swing.JRadioButton jRadioButtonContratoFaturaPacote;
    private javax.swing.JRadioButton jRadioButtonContratoFaturaUtilizacoes;
    private javax.swing.JRadioButton jRadioButtonContratoMensalista;
    private javax.swing.JRadioButton jRadioButtonContratoPacote;
    private javax.swing.JRadioButton jRadioButtonContratoUtilizacoes;
    private javax.swing.JRadioButton jRadioButtonInativos;
    private javax.swing.JRadioButton jRadioButtonMenPacTodos;
    private javax.swing.JRadioButton jRadioButtonMensalista;
    private javax.swing.JRadioButton jRadioButtonPacote;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JScrollPane jScrollPaneMovimentacoes;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPaneClienteContrato;
    private javax.swing.JTabbedPane jTabbedPaneConfiguracoesItemAlteracao;
    private javax.swing.JTabbedPane jTabbedPaneEntradaSaida;
    private javax.swing.JTabbedPane jTabbedPaneOpcoes;
    private javax.swing.JTable jTableClienteContrato;
    private javax.swing.JTable jTableContratoFatura;
    private javax.swing.JTable jTableEntradaSaidaInformacoesRotativo;
    private javax.swing.JTable jTableEntradaSaidaMovimentacoesRotativo;
    private javax.swing.JTable jTableMovimentoRecebimentoMensalidadePacote;
    private javax.swing.JTable jTableMovimentoRecebimentoRotativoAtualFuturo;
    private javax.swing.JTable jTableMovimentoResumo;
    private javax.swing.JTable jTablePatio;
    private javax.swing.JTable jTablePatioResumo;
    private javax.swing.JTable jTableRotativo;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextFieldClienteIdCliente;
    private javax.swing.JTextField jTextFieldClienteNomePesquisa;
    private javax.swing.JTextField jTextFieldContratoDiaVencimento;
    private javax.swing.JTextField jTextFieldContratoFaturaCliente;
    private javax.swing.JTextField jTextFieldContratoFaturaDiaVencimento;
    private javax.swing.JTextField jTextFieldContratoFaturaNumero;
    private javax.swing.JTextField jTextFieldContratoFaturaStatus;
    private javax.swing.JTextField jTextFieldContratoFaturaValor;
    private javax.swing.JTextField jTextFieldContratoNumero;
    private javax.swing.JTextField jTextFieldContratoStatus;
    private javax.swing.JTextField jTextFieldContratoValor;
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
    private javax.swing.JTextField jTextFieldMensalistaCor01;
    private javax.swing.JTextField jTextFieldMensalistaCor02;
    private javax.swing.JTextField jTextFieldMensalistaCor03;
    private javax.swing.JTextField jTextFieldMensalistaCor04;
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
    private javax.swing.JTextField jTextFieldMensalistaNumeroCome;
    private javax.swing.JTextField jTextFieldMensalistaNumeroResi;
    private javax.swing.JTextField jTextFieldMensalistaRuaCome;
    private javax.swing.JTextField jTextFieldMensalistaRuaResi;
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
    // End of variables declaration//GEN-END:variables
    private void verificaDadoDigitado(String dadoEntrada) {
        dadoRetornoTipo = verificadorEntradaDado.verificaDadoTipo(dadoEntrada);
        switch (dadoRetornoTipo) {
            case "placa":
                veiculo.setPlaca(dadoEntrada);
                veiculo = veiculoService.veiculoIsCadastrado(veiculo.getPlaca());
                patio = patioService.veiculoIsEstacionado(veiculo.getPlaca());
                patio.setPlaca(veiculo.getPlaca());
                if (patio.getIdPatio() != 0) {
                    JOptionPane.showMessageDialog(this, "O Veiculo placa: [" + patio.getPlaca() + "] Já está no pátio!\nO número do prisma é: [" + patio.getPrisma() + "]", "Informação!!!", JOptionPane.INFORMATION_MESSAGE);
                    limparObjetosPatio();
                } else {
                    contrato = placaIsContratoCliente(veiculo.getPlaca());
                    patio.setIdContratoFk(contrato.getIdContrato());
                    if (contrato.getIdContrato() != 0) {
                        patio = patioService.contratoClienteVagaIsOcupada(contrato, patio);
                        if (patio.getPlaca().equalsIgnoreCase("VagaLivre")) {
                            patio.setPlaca(dadoEntrada);
                            patio.setTipo(contrato.getTipo());
                            jTextFieldEntradaPlaca.setText(veiculo.getPlaca());
                            jTextFieldRotativoTipo.setText(patio.getTipo());
                            jLabelPlacaOuPrisma.setText("Digite o prisma");
                            jTabbedPaneEntradaSaida.setEnabledAt(0, false);
                            jTabbedPaneEntradaSaida.setEnabledAt(1, true);
                            jTabbedPaneEntradaSaida.setSelectedIndex(1);
                            txtEntradaPlacaOuPrisma.setEditable(true);
                            txtEntradaPlacaOuPrisma.setFocusable(true);
                            txtEntradaPlacaOuPrisma.requestFocus();
                            txtEntradaPlacaOuPrisma.setText(null);
                            txtEntradaPlacaOuPrisma.setDocument(new EntradaDado(4, "[^0-9]"));
                        } else if (patio.getPlaca().equalsIgnoreCase(contrato.getVeiculo1().getPlaca())) {
                            JOptionPane.showMessageDialog(this, "VAGA OCUPADA!!!\n\n" + contrato.getIdClienteFk().getNome() + " já esta com a vaga ocupada pelo veículo:"
                                    + "\nPlaca: [01] " + contrato.getVeiculo1().getPlaca()
                                    + "\nPrisma:" + patio.getPrisma()
                                    + "\nModelo: " + contrato.getVeiculo1().getAnoModelo()
                                    + "\nCor: " + contrato.getVeiculo1().getCor());
                            limparObjetosPatio();
                        } else if (patio.getPlaca().equalsIgnoreCase(contrato.getVeiculo2().getPlaca())) {
                            JOptionPane.showMessageDialog(this, "VAGA OCUPADA!!!\n\n" + contrato.getIdClienteFk().getNome() + " já esta com a vaga ocupada pelo veículo:"
                                    + "\nPlaca: [02] " + contrato.getVeiculo2().getPlaca()
                                    + "\nPrisma:" + patio.getPrisma()
                                    + "\nModelo: " + contrato.getVeiculo2().getAnoModelo()
                                    + "\nCor: " + contrato.getVeiculo2().getCor());
                            limparObjetosPatio();
                        } else if (patio.getPlaca().equalsIgnoreCase(contrato.getVeiculo3().getPlaca())) {
                            JOptionPane.showMessageDialog(this, "VAGA OCUPADA!!!\n\n" + contrato.getIdClienteFk().getNome() + " já esta com a vaga ocupada pelo veículo:"
                                    + "\nPlaca: [03] " + contrato.getVeiculo3().getPlaca()
                                    + "\nPrisma:" + patio.getPrisma()
                                    + "\nModelo: " + contrato.getVeiculo3().getAnoModelo()
                                    + "\nCor: " + contrato.getVeiculo3().getCor());
                            limparObjetosPatio();
                        } else if (patio.getPlaca().equalsIgnoreCase(contrato.getVeiculo4().getPlaca())) {
                            JOptionPane.showMessageDialog(this, "VAGA OCUPADA!!!\n\n" + contrato.getIdClienteFk().getNome() + " já esta com a vaga ocupada pelo veículo:"
                                    + "\nPlaca: [04] " + contrato.getVeiculo4().getPlaca()
                                    + "\nPrisma:" + patio.getPrisma()
                                    + "\nModelo: " + contrato.getVeiculo4().getAnoModelo()
                                    + "\nCor: " + contrato.getVeiculo4().getCor());
                            limparObjetosPatio();
                        }
                    } else {
                        System.out.println("O veiculo Placa:" + veiculo.getPlaca() + " Não esta no Pátio!!!");
                        System.out.println("Registrar no Pátio");
                        jTextFieldEntradaPlaca.setText(veiculo.getPlaca());
                        patio.setPlaca(veiculo.getPlaca());
                        patio.setTipo("Rotativo");
                        patio = escolhaRotativoTipo(patio);
                        System.out.println("01 patio.getTipo(): " + patio.getTipo());
                    }
                    jTextFieldEntradaPlaca.setText(veiculo.getPlaca());
                }
                break;
            case "prisma":
                System.out.println("02 patio.getTipo(): " + patio.getTipo());
                patio.setPrisma(dadoEntrada);
                prismaNoPatio(patio, veiculo);
                System.out.println("03 patio.getTipo(): " + patio.getTipo());
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

    private void prismaNoPatio(Patio patio, Veiculo veiculo) {
        PatioService patioService = new PatioService();
        patio = patioService.verificarPrisma(patio);
        if (jLabelPlacaOuPrisma.getText().equalsIgnoreCase("Placa ou Prisma")) {
            if (patio.getEstacionado().equalsIgnoreCase("sim")) {
                prepararSaidaVeiculoDoPatio(patio);
            } else {
                JOptionPane.showMessageDialog(this, "O prisma: [" + patio.getPrisma() + "] Não está registrado!!! \nPara estacionar o veiculo no pátio digite a placa...");
                txtEntradaPlacaOuPrisma.setText(null);
            }
        } else if (jLabelPlacaOuPrisma.getText().equalsIgnoreCase("Digite o prisma")) {
            if (patio.getEstacionado().equalsIgnoreCase("sim")) {
                JOptionPane.showMessageDialog(this, "O Prisma: [" + patio.getPrisma() + "]  Já está sendo utilizado!\n Placa: [" + patio.getPlaca() + "]");
                txtEntradaPlacaOuPrisma.setText(null);
            } else {
                System.out.println("prepararEntradaVeiculoNoPatio");
                prepararEntradaVeiculoNoPatio(patio, veiculo);
            }
        }
    }

    private void limparObjetosPatio() {
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

        jListRotativoTipo.setFocusable(false);
        jListRotativoTipo.setEnabled(false);

        jTabbedPaneEntradaSaida.setEnabledAt(0, true);
        jTabbedPaneEntradaSaida.setEnabledAt(1, false);
        jTabbedPaneEntradaSaida.setEnabledAt(2, false);
        jTabbedPaneEntradaSaida.setSelectedIndex(0);
        txtEntradaPlacaOuPrisma.setDocument(new EntradaDado(7, "[^A-Z|^0-9]"));
        txtEntradaPlacaOuPrisma.setEditable(true);
        txtEntradaPlacaOuPrisma.setFocusable(true);
        txtEntradaPlacaOuPrisma.requestFocus();
    }

    private void prepararEntradaVeiculoNoPatio(Patio patio, Veiculo veiculo) {
        SimpleDateFormat rps = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        jTextFieldEntradaData.setText(dataAtual.format(new Date()));
        jTextFieldEntradaHora.setText(horaAtual.format(new Date()));
        jTextFieldEntradaPrisma.setText(patio.getPrisma());
        patio.setRps(rps.format(new Date()));
        patio.setRps(patio.getRps().replaceAll("[^0-9]", ""));

        if (patio.getTipo().equalsIgnoreCase("Rotativo")) {
            rotativo = rotativoService.rotativoCarregarAtributos(jTextFieldRotativoTipo.getText());
            patio.setNome(rotativo.getNome());
            patio.setPreco30Minutos(rotativo.getPreco30Minutos());
            patio.setPreco60Minutos(rotativo.getPreco60Minutos());
            patio.setPrecoDemaisFracoes(rotativo.getPrecoDemaisFracoes());
            patio.setPrecoDiaria(rotativo.getPrecoDiaria());
            patio.setPrecoPernoite(rotativo.getPrecoPernoite());
            patio.setToleranciaDesistencia(configuracoes.getToleranciaDesistencia());
            patio.setToleranciaEntreFracoes(configuracoes.getToleranciaFracoes());
            patio.setDiariaHoras(configuracoes.getDiariaHora());
            patio.setDiariaMinutos(configuracoes.getDiariaMinuto());
            patio.setPernoiteInicio(configuracoes.getPernoiteInicio());
            patio.setPernoiteTermino(configuracoes.getPernoiteTermino());
        } else {
            patio.setPreco30Minutos(0);
            patio.setPreco60Minutos(0);
            patio.setPrecoDemaisFracoes(0);
            patio.setPrecoDiaria(0);
            patio.setPrecoPernoite(0);
            patio.setToleranciaDesistencia(0);
            patio.setToleranciaEntreFracoes(0);
            patio.setDiariaHoras(0);
            patio.setDiariaMinutos(0);
            patio.setPernoiteInicio(null);
            patio.setPernoiteTermino(null);
        }
        patio.setPrisma(jTextFieldEntradaPrisma.getText());
        patio.setEstacionado("sim");
        patio.setDataEntrada(jTextFieldEntradaData.getText());
        patio.setHoraEntrada(jTextFieldEntradaHora.getText());

        int resposta = JOptionPane.showConfirmDialog(this, "Confirma entrada do VEÍCULO?", "CONFIRMAÇÃO DE ENTRADA", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            if (veiculo.getIdVeiculo() == 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                veiculo.setDataHoraCadastro(sdf.format(new Date()));
                veiculo.setDataHoraPrimeiraUtilizacao(veiculo.getDataHoraCadastro());
                veiculo = veiculoService.veiculoIncluir(veiculo);
            }
            if (veiculo.getDataHoraPrimeiraUtilizacao() == null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                veiculo.setDataHoraPrimeiraUtilizacao(sdf.format(new Date()));
                veiculo = veiculoService.veiculoIncluirDataHoraPrimeiraUtilizacao(veiculo);
            }
            PatioService patioService = new PatioService();
            patioService.estacionarVeiculo(patio);
            movimentacoesDefaultTableModel.addRow(new String[]{
                "ENTRADA",
                patio.getPlaca(),
                patio.getPrisma(),
                patio.getTipo(),
                patio.getDataEntrada(),
                patio.getHoraEntrada(),
                "-------------",
                "-------------",
                patio.getRps()
            });
            jTableEntradaSaidaMovimentacoesRotativo.changeSelection(jTableEntradaSaidaMovimentacoesRotativo.getRowCount() - 1, jTableEntradaSaidaMovimentacoesRotativo.getRowCount(), false, false);
            limparObjetosPatio();
        } else {
            limparObjetosPatio();
        }
    }

    private void prepararSaidaVeiculoDoPatio(Patio patio) {
        patio.setDataSaida(dataAtual.format(new Date()));
        patio.setHoraSaida(horaAtual.format(new Date()));
        jTextFieldSaidaData.setText(patio.getDataSaida());
        jTextFieldSaidaHora.setText(patio.getHoraSaida());
        jTabbedPaneEntradaSaida.setEnabledAt(0, false);
        jTabbedPaneEntradaSaida.setEnabledAt(1, false);
        jTabbedPaneEntradaSaida.setEnabledAt(2, true);
        jTabbedPaneEntradaSaida.setSelectedIndex(2);
        jTextFieldSaidaPlaca.setText(patio.getPlaca());
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

        int resposta = JOptionPane.showConfirmDialog(this, "Confirma saída do VEÍCULO?", "CONFIRMAÇÃO DE SAÍDA", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            PatioService patioService = new PatioService();
            patioService.retiraVeiculo(patio);
            movimentacoesDefaultTableModel.addRow(new String[]{
                "SAÍDA",
                patio.getPlaca(),
                patio.getPrisma(),
                patio.getTipo(),
                patio.getDataEntrada(),
                patio.getHoraEntrada(),
                patio.getDataSaida(),
                patio.getHoraSaida(),
                patio.getRps()
            });
            jTableEntradaSaidaMovimentacoesRotativo.changeSelection(jTableEntradaSaidaMovimentacoesRotativo.getRowCount() - 1, jTableEntradaSaidaMovimentacoesRotativo.getRowCount(), false, false);
            limparObjetosPatio();
        } else {
            limparObjetosPatio();
        }
    }

    private Patio escolhaRotativoTipo(Patio patio) {
        jTabbedPaneEntradaSaida.setEnabledAt(0, false);
        jTabbedPaneEntradaSaida.setEnabledAt(1, true);
        jTabbedPaneEntradaSaida.setSelectedIndex(1);
        txtEntradaPlacaOuPrisma.setEditable(false);
        txtEntradaPlacaOuPrisma.setFocusable(false);
        jListRotativoTipo.setEnabled(true);
        jListRotativoTipo.setFocusable(true);
        jListRotativoTipo.requestFocus();
        rotativoDefaultListModel.clear();
        rotativoDefaultListModel = rotativoService.rotativoCarregarLista(rotativoDefaultListModel);
        rotativoDefaultListModel.addElement("Cancelar entrada do veículo");
        jListRotativoTipo.setModel(rotativoDefaultListModel);
        jListRotativoTipo.setSelectedIndex(0);
        return patio;
    }

    private void patioListaVeiculo(String ordemLista) {
        menuPrincipalBotaoEnabledPainelEnabledAt(false);
        jTabbedPaneOpcoes.setEnabledAt(3, true);
        jTabbedPaneOpcoes.setSelectedIndex(3);
        patioArrayList.clear();
        ((DefaultTableModel) jTablePatio.getModel()).setRowCount(0);
        ((DefaultTableModel) jTablePatio.getModel()).setColumnCount(0);
        PatioService patioService = new PatioService();
        patioArrayList = patioService.patioLista(patioArrayList, ordemLista);
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
                patioArrayList.get(i).getPlaca(),
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

                setHorizontalAlignment(SwingConstants.RIGHT);

                if (row % 2 == 0) {
                    setBackground(new Color(220, 220, 220));
                    setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                } else {
                    setBackground(null);
                    setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
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
        patioListaVeiculoResumo(patioArrayList);
    }

    class Resumo {

        private String tipo;
        private int quantidade;
        private float valor;

        /**
         * @return the tipo
         */
        public String getTipo() {
            return tipo;
        }

        /**
         * @param tipo the tipo to set
         */
        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        /**
         * @return the quantidade
         */
        public int getQuantidade() {
            return quantidade;
        }

        /**
         * @param quantidade the quantidade to set
         */
        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        /**
         * @return the valor
         */
        public float getValor() {
            return valor;
        }

        /**
         * @param valor the valor to set
         */
        public void setValor(float valor) {
            this.valor = valor;
        }
    }

    private void patioListaVeiculoResumo(List<Patio> patioArrayList) {
        List<String> listaTipo = new ArrayList<>();
        List<Resumo> listaResumo = new ArrayList<>();
        Resumo resumo;
        for (int i = 0; i < patioArrayList.size(); i++) {
            if (!listaTipo.contains(patioArrayList.get(i).getTipo())) {
                listaTipo.add(patioArrayList.get(i).getTipo());
            }
        }

        for (int i = 0; i < listaTipo.size(); i++) {
            resumo = new Resumo();
            resumo.setTipo(listaTipo.get(i));
            listaResumo.add(resumo);
        }

        for (int i = 0; i < patioArrayList.size(); i++) {
            for (int j = 0; j < listaResumo.size(); j++) {
                if (listaResumo.get(j).getTipo().equalsIgnoreCase(patioArrayList.get(i).getTipo())) {
                    listaResumo.get(j).setQuantidade(listaResumo.get(j).getQuantidade() + 1);
                    listaResumo.get(j).setValor(listaResumo.get(j).getValor() + patioArrayList.get(i).getValorTotal());
                    break;
                }
            }
        }
        ((DefaultTableModel) jTablePatioResumo.getModel()).setRowCount(0);
        ((DefaultTableModel) jTablePatioResumo.getModel()).setColumnCount(0);
        DefaultTableModel patioResumoDefaultTableModel = new DefaultTableModel();
        patioResumoDefaultTableModel.addColumn("Veículo(s)");
        patioResumoDefaultTableModel.addColumn("Quant.");
        patioResumoDefaultTableModel.addColumn("Valor R$");
        int quantidadeTotal = 0;
        float valorTotal = 0;
        for (int i = 0; i < listaResumo.size(); i++) {
            quantidadeTotal += listaResumo.get(i).getQuantidade();
            valorTotal += listaResumo.get(i).getValor();
            patioResumoDefaultTableModel.addRow(new String[]{
                listaResumo.get(i).getTipo(),
                String.valueOf(listaResumo.get(i).getQuantidade()),
                new DecimalFormat("R$ #,##0.00").format(listaResumo.get(i).getValor())
            });
        }
        patioResumoDefaultTableModel.addRow(new String[]{
            "=====",
            "=====",
            "====="
        });
        patioResumoDefaultTableModel.addRow(new String[]{
            "Total",
            String.valueOf(quantidadeTotal),
            new DecimalFormat("R$ #,##0.00").format(valorTotal)
        });
        jTablePatioResumo.setModel(patioResumoDefaultTableModel);
        jTablePatioResumo.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTablePatioResumo.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTablePatioResumo.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTablePatioResumo.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Object colunaTipo = table.getValueAt(row, 0);//Coluna Status
                Object linhaTipo = table.getValueAt(row, column);//Linha Status

                if (linhaTipo.equals("=====")) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                } else {
                    setHorizontalAlignment(SwingConstants.RIGHT);
                }

                if (row % 2 == 0) {
                    setBackground(new Color(220, 220, 220));
                    setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                } else {
                    setBackground(null);
                    setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                }
                setFont(new Font("", Font.PLAIN, 16));//("Nome da fonte", estilo da fonte, tamanho da fonte)
                if (colunaTipo != null) {//Se existir a celula Tipo
                    if (colunaTipo.equals("Rotativo")) {
                        setForeground(new Color(0, 150, 0));//Fonte
                    } else if (colunaTipo.equals("Pacote")) {
                        setForeground(new Color(0, 0, 200));//Fonte
                    } else if (colunaTipo.equals("Mensalista")) {
                        setForeground(new Color(180, 140, 140));//Fonte
                    } else if (colunaTipo.equals("Total")) {
                        setForeground(new Color(0, 0, 0));//Fonte
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
                menuPrincipalBotaoEnabledPainelEnabledAt(true);
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
        menuPrincipalBotaoEnabledPainelEnabledAt(false);
        switch (menu) {
            case "rotativo":
                jTabbedPaneOpcoes.setEnabledAt(2, true);
                jTabbedPaneOpcoes.setSelectedIndex(2);
                break;
            case "contrato":
                jTabbedPaneOpcoes.setEnabledAt(1, true);
                jTabbedPaneOpcoes.setSelectedIndex(1);
                clienteContratoLista();
                break;
            case "configuracoes":
                jTabbedPaneOpcoes.setEnabledAt(5, true);
                jTabbedPaneOpcoes.setSelectedIndex(5);
                jListConfiguracoes.setFocusable(true);
                jListConfiguracoes.requestFocus();
                jListConfiguracoes.setSelectedIndex(0);
                configuracoesEscolhaTolerancia();
                break;
            default:
                break;
        }
    }

    private void menuPrincipalBotaoEnabledPainelEnabledAt(boolean status) {
        jTabbedPaneOpcoes.setEnabledAt(0, false);
        jTabbedPaneOpcoes.setEnabledAt(1, false);
        jTabbedPaneOpcoes.setEnabledAt(2, false);
        jTabbedPaneOpcoes.setEnabledAt(3, false);
        jTabbedPaneOpcoes.setEnabledAt(4, false);
        jTabbedPaneOpcoes.setEnabledAt(5, false);
        jTabbedPaneOpcoes.setEnabledAt(6, false);
        if (status) {
            jTabbedPaneOpcoes.setEnabledAt(0, true);
            jTabbedPaneOpcoes.setSelectedIndex(0);
        }
        jButtonF1Patio.setEnabled(status);
        jButtonF2Movimento.setEnabled(status);
        jButtonF4Rotativo.setEnabled(status);
        jButtonF5Contrato.setEnabled(status);
        jButtonF8Configuracoes.setEnabled(status);
        jButtonF10Sair.setEnabled(status);
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
            rotativo = rotativoService.rotativoCarregarAtributos(String.valueOf(jTableRotativo.getValueAt(jTableRotativo.getSelectedRow(), 0)));
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

    private void configuracaoMascaraEntradaJTextField() {
        //ROTATIVO**********************************************************************************
        txtRotativoPreco30minutos.setDocument(new EntradaValor(7, 2));
        txtRotativoPreco60minutos.setDocument(new EntradaValor(7, 2));
        txtRotativoPrecoDemaisFracoes.setDocument(new EntradaValor(7, 2));
        txtRotativoPrecoDiaria.setDocument(new EntradaValor(7, 2));
        txtRotativoPrecoPernoite.setDocument(new EntradaValor(7, 2));
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
        jTableEntradaSaidaInformacoesRotativo.setFocusable(false);
        jTableEntradaSaidaInformacoesRotativo.setEnabled(false);
    }

    private void movimentoListaVeiculo(String movimentoData, String movimentoHora) {
        if (movimentoData.replaceAll("/", "").replaceAll(" ", "").equalsIgnoreCase("")) {
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            jFormattedTextFieldMovimentoData.setText(sdfData.format(new Date()));
            movimentoData = jFormattedTextFieldMovimentoData.getText();
        }
        if (movimentoHora.replaceAll(":", "").replaceAll(" ", "").equalsIgnoreCase("")) {
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
            jFormattedTextFieldMovimentoHora.setText(sdfHora.format(new Date()));
            movimentoHora = jFormattedTextFieldMovimentoHora.getText();
        }
        menuPrincipalBotaoEnabledPainelEnabledAt(false);
        jTabbedPaneOpcoes.setEnabledAt(4, true);
        jTabbedPaneOpcoes.setSelectedIndex(4);
        List<Patio> movimentoArrayList = new ArrayList<>();
        PatioService patioService = new PatioService();
        movimentoArrayList = patioService.movimentoListaNew(movimentoArrayList, movimentoData, movimentoHora);
        if (movimentoArrayList.size() == 0) {
            jPanel25.setBorder(BorderFactory.createTitledBorder("Movimento do dia pesquisado: Não encontrado!!!"));
            ((DefaultTableModel) jTableMovimentoRecebimentoRotativoAtualFuturo.getModel()).setRowCount(0);
            ((DefaultTableModel) jTableMovimentoRecebimentoRotativoAtualFuturo.getModel()).setColumnCount(0);
            JOptionPane.showMessageDialog(this, "Não foi encontrado movimento para data pesquisada!!!");
        } else {
            jPanel25.setBorder(BorderFactory.createTitledBorder("Movimento do dia: " + jFormattedTextFieldMovimentoData.getText()));
            ((DefaultTableModel) jTableMovimentoRecebimentoRotativoAtualFuturo.getModel()).setRowCount(0);
            ((DefaultTableModel) jTableMovimentoRecebimentoRotativoAtualFuturo.getModel()).setColumnCount(0);
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
                    movimentoArrayList.get(i).getPlaca(),
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

            jTableMovimentoRecebimentoRotativoAtualFuturo.setModel(movimentoDefaultTableModel);
            jTableMovimentoRecebimentoRotativoAtualFuturo.getColumnModel().getColumn(0).setPreferredWidth(8);
            jTableMovimentoRecebimentoRotativoAtualFuturo.getColumnModel().getColumn(1).setPreferredWidth(8);
            jTableMovimentoRecebimentoRotativoAtualFuturo.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTableMovimentoRecebimentoRotativoAtualFuturo.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableMovimentoRecebimentoRotativoAtualFuturo.getColumnModel().getColumn(4).setPreferredWidth(22);
            jTableMovimentoRecebimentoRotativoAtualFuturo.getColumnModel().getColumn(5).setPreferredWidth(20);
            jTableMovimentoRecebimentoRotativoAtualFuturo.getColumnModel().getColumn(6).setPreferredWidth(22);
            jTableMovimentoRecebimentoRotativoAtualFuturo.getColumnModel().getColumn(7).setPreferredWidth(20);
            jTableMovimentoRecebimentoRotativoAtualFuturo.getColumnModel().getColumn(8).setPreferredWidth(65);
            jTableMovimentoRecebimentoRotativoAtualFuturo.getColumnModel().getColumn(9).setPreferredWidth(50);
            jTableMovimentoRecebimentoRotativoAtualFuturo.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(
                        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    Object colunaTipo = table.getValueAt(row, 2);//Coluna
                    Object colunaDataSaida = table.getValueAt(row, 6);//Coluna

                    if (row % 2 == 0) {
                        setBackground(new Color(220, 220, 220));
                        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                    } else {
                        setBackground(null);
                        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
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
            movimentoListaVeiculoResumo(movimentoArrayList);
        }
    }

    private void movimentoListaVeiculoResumo(List<Patio> movimentoArrayList) {
        List<String> listaTipo = new ArrayList<>();
        List<Resumo> listaResumoRecebidos = new ArrayList<>();
        List<Resumo> listaResumoAReceber = new ArrayList<>();
        Resumo teste;
        listaTipo.clear();
        listaResumoRecebidos.clear();
        listaResumoAReceber.clear();
        Resumo resumoRecebidos, resumoAReceber;

        //Criando o List com os tipos de veiculos que estam no pátio
        for (int i = 0; i < movimentoArrayList.size(); i++) {
            if (!listaTipo.contains(movimentoArrayList.get(i).getTipo())) {
                listaTipo.add(movimentoArrayList.get(i).getTipo());
            }
        }

        for (int i = 0; i < listaTipo.size(); i++) {
            resumoRecebidos = new Resumo();
            resumoAReceber = new Resumo();
            resumoRecebidos.setTipo(listaTipo.get(i));
            resumoAReceber.setTipo(listaTipo.get(i));
            listaResumoRecebidos.add(resumoRecebidos);
            listaResumoAReceber.add(resumoAReceber);
        }

        for (int i = 0; i < movimentoArrayList.size(); i++) {
            for (int j = 0; j < listaTipo.size(); j++) {
                if (listaResumoRecebidos.get(j).getTipo().equalsIgnoreCase(movimentoArrayList.get(i).getTipo()) && !movimentoArrayList.get(i).getDataSaida().equalsIgnoreCase("Veículo no")) {
                    listaResumoRecebidos.get(j).setQuantidade(listaResumoRecebidos.get(j).getQuantidade() + 1);
                    listaResumoRecebidos.get(j).setValor(listaResumoRecebidos.get(j).getValor() + movimentoArrayList.get(i).getValorTotal());
                    break;
                } else if (listaResumoAReceber.get(j).getTipo().equalsIgnoreCase(movimentoArrayList.get(i).getTipo()) && movimentoArrayList.get(i).getDataSaida().equalsIgnoreCase("Veículo no")) {
                    listaResumoAReceber.get(j).setQuantidade(listaResumoAReceber.get(j).getQuantidade() + 1);
                    listaResumoAReceber.get(j).setValor(listaResumoAReceber.get(j).getValor() + movimentoArrayList.get(i).getValorTotal());
                    break;
                }
            }
        }

        for (int i = listaResumoRecebidos.size() - 1 ; i > 0 ; i--) {
            if (listaResumoRecebidos.get(i).quantidade == 0) {
                listaResumoRecebidos.remove(i);
            }
        }
      
        for (int i = listaResumoAReceber.size() - 1; i > 0 ; i--) {
            if (listaResumoAReceber.get(i).quantidade == 0) {
                listaResumoAReceber.remove(i);
            }
        }
        
        ((DefaultTableModel) jTableMovimentoResumo.getModel()).setRowCount(0);
        ((DefaultTableModel) jTableMovimentoResumo.getModel()).setColumnCount(0);
        DefaultTableModel movimentoResumoDefaultTableModel = new DefaultTableModel();
        movimentoResumoDefaultTableModel.addColumn("Status");
        movimentoResumoDefaultTableModel.addColumn("Veículo(s)");
        movimentoResumoDefaultTableModel.addColumn("Quant.");
        movimentoResumoDefaultTableModel.addColumn("Valor R$");

        int quantidadeTotalRecebidos = 0;
        float valorTotalRecebidos = 0;

        if (!listaResumoRecebidos.isEmpty()) {
            for (int i = 0; i < listaResumoRecebidos.size(); i++) {
                quantidadeTotalRecebidos += listaResumoRecebidos.get(i).getQuantidade();
                valorTotalRecebidos += listaResumoRecebidos.get(i).getValor();
                movimentoResumoDefaultTableModel.addRow(new String[]{
                    "Recebidos",
                    listaResumoRecebidos.get(i).getTipo(),
                    String.valueOf(listaResumoRecebidos.get(i).getQuantidade()),
                    new DecimalFormat("R$ #,##0.00").format(listaResumoRecebidos.get(i).getValor())
                });
            }
        }
        movimentoResumoDefaultTableModel.addRow(new String[]{
            "Recebidos",
            "Total",
            String.valueOf(quantidadeTotalRecebidos),
            new DecimalFormat("R$ #,##0.00").format(valorTotalRecebidos)
        });

        movimentoResumoDefaultTableModel.addRow(new String[]{
            "",
            "",
            "",
            "",});

        int quantidadeTotalAReceber = 0;
        float valorTotalAReceber = 0;
        if (!listaResumoAReceber.isEmpty()) {
            for (int i = 0; i < listaResumoAReceber.size(); i++) {
                quantidadeTotalAReceber += listaResumoAReceber.get(i).getQuantidade();
                valorTotalAReceber += listaResumoAReceber.get(i).getValor();
                movimentoResumoDefaultTableModel.addRow(new String[]{
                    "A Receber",
                    listaResumoAReceber.get(i).getTipo(),
                    String.valueOf(listaResumoAReceber.get(i).getQuantidade()),
                    new DecimalFormat("R$ #,##0.00").format(listaResumoAReceber.get(i).getValor())
                });
            }
        }
        movimentoResumoDefaultTableModel.addRow(new String[]{
            "A Receber",
            "Total",
            String.valueOf(quantidadeTotalAReceber),
            new DecimalFormat("R$ #,##0.00").format(valorTotalAReceber)
        });

        jTableMovimentoResumo.setModel(movimentoResumoDefaultTableModel);
        jTableMovimentoResumo.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableMovimentoResumo.getColumnModel().getColumn(1).setPreferredWidth(92);
        jTableMovimentoResumo.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTableMovimentoResumo.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableMovimentoResumo.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Object colunaTipo = table.getValueAt(row, 1);//Coluna Status
                Object linhaTipo = table.getValueAt(row, column);//Linha Status

                if (row % 2 == 0) {
                    setBackground(new Color(220, 220, 220));
                    setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                } else {
                    setBackground(null);
                    setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                }
                setFont(new Font("", Font.PLAIN, 16));//("Nome da fonte", estilo da fonte, tamanho da fonte)
                if (colunaTipo != null) {//Se existir a celula Tipo
                    if (colunaTipo.equals("Rotativo")) {
                        setForeground(new Color(0, 150, 0));//Fonte
                        setFont(new Font(null, Font.PLAIN, 14));
                    } else if (colunaTipo.equals("Pacote")) {
                        setForeground(new Color(0, 0, 200));//Fonte
                        setFont(new Font(null, Font.PLAIN, 14));
                    } else if (colunaTipo.equals("Mensalista")) {
                        setForeground(new Color(180, 140, 140));//Fonte
                        setFont(new Font(null, Font.PLAIN, 14));
                    } else if (colunaTipo.equals("Total")) {
                        setForeground(new Color(0, 0, 0));//Fonte
                        setFont(new Font(null, Font.BOLD, 16));
                    }
                }

                if (isSelected) {
                    setBackground(new Color(205, 179, 139));
                }

                if (linhaTipo.equals("")) {
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setBackground(new Color(55, 55, 55));

                } else {
                    setHorizontalAlignment(SwingConstants.RIGHT);
                }
                return this;
            }
        });
    }

    private void clienteContratoLista() {
        String clienteNome = "", clienteTipo = "", clienteStatus = "", numeroContrato = "";

        clienteNome = jTextFieldClienteNomePesquisa.getText();

        if (jRadioButtonMensalista.isSelected()) {
            clienteTipo = "Mensalista";
        }
        if (jRadioButtonPacote.isSelected()) {
            clienteTipo = "Pacote";
        }
        if (jRadioButtonMenPacTodos.isSelected()) {
            clienteTipo = "%";
        }

        if (jRadioButtonAtivos.isSelected()) {
            clienteStatus = "Ativo";
        }
        if (jRadioButtonInativos.isSelected()) {
            clienteStatus = "Cancelado";
        }
        if (jRadioButtonAtiInaTodos.isSelected()) {
            clienteStatus = "%";
        }

        numeroContrato = "%";

        ((DefaultTableModel) jTableClienteContrato.getModel()).setRowCount(0);
        ((DefaultTableModel) jTableClienteContrato.getModel()).setColumnCount(0);
        contratoArrayList.clear();
        contratoArrayList = contratoService.contratoList(clienteNome, clienteTipo, clienteStatus, numeroContrato);
        contratoDefaultTableModel.addColumn("N. Contrato");
        contratoDefaultTableModel.addColumn("Nome");
        contratoDefaultTableModel.addColumn("CPF");
        contratoDefaultTableModel.addColumn("Tipo");
        contratoDefaultTableModel.addColumn("Modo");
        contratoDefaultTableModel.addColumn("Quant.");
        contratoDefaultTableModel.addColumn("Status");
        contratoDefaultTableModel.addColumn("Venc.");
        contratoDefaultTableModel.addColumn("Telefone");
        contratoDefaultTableModel.addColumn("Celular");
        contratoDefaultTableModel.addColumn("E-mail");

        for (int i = 0; i < contratoArrayList.size(); i++) {
            if (contratoArrayList.get(i).getIdClienteFk().getCpf() == null || contratoArrayList.get(i).getIdClienteFk().getCpf().equalsIgnoreCase("")) {
                contratoArrayList.get(i).getIdClienteFk().setCpf("0");
            }
            contratoArrayList.get(i).getIdClienteFk().setCpf(String.format("%011d", Long.parseLong(contratoArrayList.get(i).getIdClienteFk().getCpf())));
            if (contratoArrayList.get(i).getDiaVencimento() == null || contratoArrayList.get(i).getDiaVencimento().equalsIgnoreCase("")) {
                contratoArrayList.get(i).setDiaVencimento("0");
            }
            contratoArrayList.get(i).setDiaVencimento(String.format("%02d", Long.parseLong(contratoArrayList.get(i).getDiaVencimento())));
            if (contratoArrayList.get(i).getIdClienteFk().getIdentidade() == null || contratoArrayList.get(i).getIdClienteFk().getIdentidade().equalsIgnoreCase("")) {
                contratoArrayList.get(i).getIdClienteFk().setIdentidade("0");
            }
            contratoArrayList.get(i).getIdClienteFk().setIdentidade(String.format("%010d", Long.parseLong(contratoArrayList.get(i).getIdClienteFk().getIdentidade())));
            if (contratoArrayList.get(i).getIdClienteFk().getTelefone() == null || contratoArrayList.get(i).getIdClienteFk().getTelefone().equalsIgnoreCase("")) {
                contratoArrayList.get(i).getIdClienteFk().setTelefone("0");
            }
            contratoArrayList.get(i).getIdClienteFk().setTelefone(String.format("%010d", Long.parseLong(contratoArrayList.get(i).getIdClienteFk().getTelefone())));
            if (contratoArrayList.get(i).getIdClienteFk().getCelular() == null || contratoArrayList.get(i).getIdClienteFk().getCelular().equalsIgnoreCase("")) {
                contratoArrayList.get(i).getIdClienteFk().setCelular("0");
            }
            contratoArrayList.get(i).getIdClienteFk().setCelular(String.format("%011d", Long.parseLong(contratoArrayList.get(i).getIdClienteFk().getCelular())));
            if (contratoArrayList.get(i).getIdClienteFk().getCepResidencia() == null || contratoArrayList.get(i).getIdClienteFk().getCepResidencia().equalsIgnoreCase("")) {
                contratoArrayList.get(i).getIdClienteFk().setCepResidencia("0");
            }
            contratoArrayList.get(i).getIdClienteFk().setCepResidencia(String.format("%08d", Long.parseLong(contratoArrayList.get(i).getIdClienteFk().getCepResidencia())));
            if (contratoArrayList.get(i).getIdClienteFk().getCepComercial() == null || contratoArrayList.get(i).getIdClienteFk().getCepComercial().equalsIgnoreCase("")) {
                contratoArrayList.get(i).getIdClienteFk().setCepComercial("0");
            }
            contratoArrayList.get(i).getIdClienteFk().setCepComercial(String.format("%08d", Long.parseLong(contratoArrayList.get(i).getIdClienteFk().getCepComercial())));
            if (contratoArrayList.get(i).getIdClienteFk().getTelefoneComercial() == null || contratoArrayList.get(i).getIdClienteFk().getTelefoneComercial().equalsIgnoreCase("")) {
                contratoArrayList.get(i).getIdClienteFk().setTelefoneComercial("0");
            }
            contratoArrayList.get(i).getIdClienteFk().setTelefoneComercial(String.format("%010d", Long.parseLong(contratoArrayList.get(i).getIdClienteFk().getTelefoneComercial())));
            contratoDefaultTableModel.addRow(new String[]{
                String.valueOf(contratoArrayList.get(i).getIdContrato()),
                contratoArrayList.get(i).getIdClienteFk().getNome(),
                contratoArrayList.get(i).getIdClienteFk().getCpf().substring(0, 3) + "." + contratoArrayList.get(i).getIdClienteFk().getCpf().substring(3, 6) + "." + contratoArrayList.get(i).getIdClienteFk().getCpf().substring(6, 9) + "-" + contratoArrayList.get(i).getIdClienteFk().getCpf().substring(9, 11),
                contratoArrayList.get(i).getTipo(),
                contratoArrayList.get(i).getModo(),
                String.format("%02d", Integer.parseInt(String.valueOf(contratoArrayList.get(i).getQuantidade()))),
                contratoArrayList.get(i).getStatus(),
                contratoArrayList.get(i).getDiaVencimento(),
                "(" + contratoArrayList.get(i).getIdClienteFk().getTelefone().substring(0, 2) + ")" + contratoArrayList.get(i).getIdClienteFk().getTelefone().substring(2, 6) + "-" + contratoArrayList.get(i).getIdClienteFk().getTelefone().substring(6, 10),
                "(" + contratoArrayList.get(i).getIdClienteFk().getCelular().substring(0, 2) + ")" + contratoArrayList.get(i).getIdClienteFk().getCelular().substring(2, 3) + "." + contratoArrayList.get(i).getIdClienteFk().getCelular().substring(3, 7) + "-" + contratoArrayList.get(i).getIdClienteFk().getCelular().substring(7, 11),
                contratoArrayList.get(i).getIdClienteFk().getEmail()
            });
        }

        jTableClienteContrato.setModel(contratoDefaultTableModel);
        jTableClienteContrato.getColumnModel().getColumn(0).setPreferredWidth(75);
        jTableClienteContrato.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTableClienteContrato.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTableClienteContrato.getColumnModel().getColumn(3).setPreferredWidth(95);
        jTableClienteContrato.getColumnModel().getColumn(4).setPreferredWidth(95);
        jTableClienteContrato.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTableClienteContrato.getColumnModel().getColumn(6).setPreferredWidth(90);
        jTableClienteContrato.getColumnModel().getColumn(7).setPreferredWidth(45);
        jTableClienteContrato.getColumnModel().getColumn(8).setPreferredWidth(130);
        jTableClienteContrato.getColumnModel().getColumn(9).setPreferredWidth(140);
        jTableClienteContrato.getColumnModel().getColumn(10).setPreferredWidth(240);
        jTableClienteContrato.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Object colunaStatus = table.getValueAt(row, 6);//Coluna Status

                if (row % 2 == 0) {
                    setBackground(new Color(255, 255, 255));
                } else {
                    setBackground(new Color(230, 230, 230));
                }
                setFont(new Font("", Font.PLAIN, 16));//("Nome da fonte", estilo da fonte, tamanho da fonte)
                if (colunaStatus != null) {//Se existir a celula Tipo
                    if (colunaStatus.equals("Ativo")) {
                        setForeground(new Color(0, 150, 0));//Fonte
                    } else if (colunaStatus.equals("Cancelado")) {
                        setForeground(new Color(150, 0, 0));//Fonte
                    }
                }

                if (isSelected) {
                    setBackground(new Color(205, 179, 139));
                }
                return this;
            }
        });
    }

    private boolean contratoVerificaCamposValidos() {
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
                            jButtonContratoConsultaFatura.setEnabled(true);
                            jButtonClienteCadastroAlterar.setEnabled(true);
                            jButtonClienteCadastroCancelar.setEnabled(true);
                            jButtonClienteCadastroSim.setEnabled(false);
                            jButtonClienteCadastroNao.setEnabled(false);
                            clienteJTextFieldEditable(false);
                            contratoJTextFieldEditable(false);
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

    private Contrato contratoPopularObjeto() {
        if (jRadioButtonContratoMensalista.isSelected()) {
            contrato.setTipo("Mensalista");
        } else if (jRadioButtonContratoPacote.isSelected()) {
            contrato.setTipo("Pacote");
        }
        if (jRadioButtonContratoDias.isSelected()) {
            contrato.setModo("Dias");
        } else if (jRadioButtonContratoUtilizacoes.isSelected()) {
            contrato.setModo("Utilizações");
        }
        contrato.setQuantidade(Integer.valueOf(jFormattedTextFieldContratoQuantidade.getText().replaceAll(" ", "")));
        contrato.setDataInicio(jFormattedTextFieldContratoDataInicio.getText());
        contrato.setDataTermino(jFormattedTextFieldContratoDataTermino.getText());
        contrato.setValor(Float.valueOf(jTextFieldContratoValor.getText().replaceAll("\\.", "").replaceAll(",", "\\.")));
        contrato.setDiaVencimento(jTextFieldContratoDiaVencimento.getText().replaceAll(" ", ""));
        contrato.setDataCancelamento(jFormattedTextFieldContratoDataCancelamento.getText());
        contrato.setStatus(jTextFieldContratoStatus.getText().replaceAll(" ", ""));
        //Populando Objeto (Veículos)
        contrato.getVeiculo1().setPlaca(jFormattedTextFieldMensalistaPlaca01.getText());
        contrato.getVeiculo1().setMarca(jTextFieldMensalistaMontadora01.getText());
        contrato.getVeiculo1().setModelo(jTextFieldMensalistaModelo01.getText());
        contrato.getVeiculo1().setCor(jTextFieldMensalistaCor01.getText());
        contrato.getVeiculo1().setAnoModelo(jTextFieldMensalistaAno01.getText());

        contrato.getVeiculo2().setPlaca(jFormattedTextFieldMensalistaPlaca02.getText());
        contrato.getVeiculo2().setMarca(jTextFieldMensalistaMontadora02.getText());
        contrato.getVeiculo2().setModelo(jTextFieldMensalistaModelo02.getText());
        contrato.getVeiculo2().setCor(jTextFieldMensalistaCor02.getText());
        contrato.getVeiculo2().setAnoModelo(jTextFieldMensalistaAno02.getText());

        contrato.getVeiculo3().setPlaca(jFormattedTextFieldMensalistaPlaca03.getText());
        contrato.getVeiculo3().setMarca(jTextFieldMensalistaMontadora03.getText());
        contrato.getVeiculo3().setModelo(jTextFieldMensalistaModelo03.getText());
        contrato.getVeiculo3().setCor(jTextFieldMensalistaCor03.getText());
        contrato.getVeiculo3().setAnoModelo(jTextFieldMensalistaAno03.getText());

        contrato.getVeiculo4().setPlaca(jFormattedTextFieldMensalistaPlaca04.getText());
        contrato.getVeiculo4().setMarca(jTextFieldMensalistaMontadora04.getText());
        contrato.getVeiculo4().setModelo(jTextFieldMensalistaModelo04.getText());
        contrato.getVeiculo4().setCor(jTextFieldMensalistaCor04.getText());
        contrato.getVeiculo4().setAnoModelo(jTextFieldMensalistaAno04.getText());
        return contrato;
    }

    private Cliente clientePopularObjeto() {
        //cliente.setIdCliente(Integer.valueOf(jTextFieldClienteIdCliente.getText()));
        cliente.setDataInclusao(jFormattedTextFieldContratoDataInicio.getText());
        cliente.setDataUltimaAlteracao(jFormattedTextFieldContratoDataCancelamento.getText());
        cliente.setNome(jTextFieldMensalistaNome.getText());
        cliente.setCpf(jFormattedTextFieldMensalistaCpf.getText().replaceAll("\\.", "").replaceAll("-", "").replaceAll(" ", ""));
        cliente.setDataNascimento(jFormattedTextFieldMensalistaDataNascimento.getText());
        cliente.setIdentidade(jTextFieldMensalistaIdentidade.getText());
        cliente.setTelefone(jFormattedTextFieldMensalistaTelefoneResi.getText().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "").replaceAll(" ", ""));
        cliente.setCelular(jFormattedTextFieldMensalistaCelularResi.getText().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\.", "").replaceAll("-", "").replaceAll(" ", ""));
        cliente.setEmail(jTextFieldMensalistaEmail.getText());
        cliente.setCepResidencia(jFormattedTextFieldMensalistaCepResi.getText().replaceAll("\\.", "").replaceAll("-", "").replaceAll(" ", ""));
        cliente.setRuaResidencia(jTextFieldMensalistaRuaResi.getText());
        cliente.setNumeroResidencia(jTextFieldMensalistaNumeroResi.getText());
        cliente.setComplementoResidencia(jTextFieldMensalistaComplementoResi.getText());
        cliente.setBairroResidencia(jTextFieldMensalistaBairroResi.getText());
        cliente.setCidadeResidencia(jTextFieldMensalistaCidadeResi.getText());
        cliente.setEstadoResidencia(jTextFieldMensalistaEstadoResi.getText());
        //Populando Objeto Cliente (Dados Profissionais)
        cliente.setEmpresa(jTextFieldMensalistaEmpresa.getText());
        cliente.setCepComercial(jFormattedTextFieldMensalistaCepCome.getText().replaceAll("\\.", "").replaceAll("-", "").replaceAll(" ", ""));
        cliente.setRuaComercial(jTextFieldMensalistaRuaCome.getText());
        cliente.setNumeroComercial(jTextFieldMensalistaNumeroCome.getText());
        cliente.setComplementoComercial(jTextFieldMensalistaComplementoCome.getText());
        cliente.setBairroComercial(jTextFieldMensalistaBairroCome.getText());
        cliente.setCidadeComercial(jTextFieldMensalistaCidadeCome.getText());
        cliente.setEstadoComercial(jTextFieldMensalistaEstadoCome.getText());
        cliente.setTelefoneComercial(jFormattedTextFieldMensalistaTelefoneCome.getText().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "").replaceAll(" ", ""));
        return cliente;
    }

    private void contratoJTextFieldConteudo(String conteudo) {
        jTextFieldContratoNumero.setText(conteudo);
        jTextFieldContratoDiaVencimento.setText(conteudo);
        jFormattedTextFieldContratoDataCancelamento.setText(conteudo);
        jRadioButtonContratoMensalista.setSelected(true);
        jRadioButtonContratoDias.setSelected(true);
        jTextFieldContratoValor.setText(conteudo);

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

    private void clienteJTextFieldConteudo(String conteudo) {
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
    }

    private void contratoJTextFieldEditable(boolean status) {
        jRadioButtonContratoMensalista.setEnabled(status);
        jRadioButtonContratoPacote.setEnabled(status);
        jRadioButtonContratoDias.setEnabled(status);
        jRadioButtonContratoUtilizacoes.setEnabled(status);
        jFormattedTextFieldContratoQuantidade.setEditable(status);
        jFormattedTextFieldContratoDataInicio.setEditable(status);
        jTextFieldContratoValor.setEditable(status);
        jTextFieldContratoDiaVencimento.setEditable(status);

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

    private void clienteJTextFieldEditable(boolean status) {

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
    }

    private void contratoConsultaPreencherJTextField(Contrato contrato) {
        if (contrato.getTipo().equalsIgnoreCase("Mensalista")) {
            jRadioButtonContratoMensalista.setSelected(true);
        } else if (contrato.getTipo().equalsIgnoreCase("Pacote")) {
            jRadioButtonContratoPacote.setSelected(true);
        }

        if (contrato.getModo().equalsIgnoreCase("Dias")) {
            jRadioButtonContratoDias.setSelected(true);
        } else if (contrato.getModo().equalsIgnoreCase("Utilizações")) {
            jRadioButtonContratoUtilizacoes.setSelected(true);
        }

        jTextFieldContratoNumero.setText(String.valueOf(contrato.getIdContrato()));
        jFormattedTextFieldContratoQuantidade.setText(String.valueOf(contrato.getQuantidade()));
        jFormattedTextFieldContratoDataInicio.setText(contrato.getDataInicio());
        jFormattedTextFieldContratoDataTermino.setText(contrato.getDataTermino());
        jTextFieldContratoValor.setText(new DecimalFormat("#,##0.00").format(contrato.getValor()));
        jTextFieldContratoDiaVencimento.setText(contrato.getDiaVencimento());
        jFormattedTextFieldContratoDataCancelamento.setText(contrato.getDataCancelamento());
        jTextFieldContratoStatus.setText(contrato.getStatus());

        jFormattedTextFieldMensalistaPlaca01.setText(contrato.getVeiculo1().getPlaca());
        jTextFieldMensalistaMontadora01.setText(contrato.getVeiculo1().getMarca());
        jTextFieldMensalistaModelo01.setText(contrato.getVeiculo1().getModelo());
        jTextFieldMensalistaCor01.setText(contrato.getVeiculo1().getCor());
        jTextFieldMensalistaAno01.setText(contrato.getVeiculo1().getAnoModelo());
        jFormattedTextFieldMensalistaPlaca02.setText(contrato.getVeiculo2().getPlaca());
        jTextFieldMensalistaMontadora02.setText(contrato.getVeiculo2().getMarca());
        jTextFieldMensalistaModelo02.setText(contrato.getVeiculo2().getModelo());
        jTextFieldMensalistaCor02.setText(contrato.getVeiculo2().getCor());
        jTextFieldMensalistaAno02.setText(contrato.getVeiculo2().getAnoModelo());
        jFormattedTextFieldMensalistaPlaca03.setText(contrato.getVeiculo3().getPlaca());
        jTextFieldMensalistaMontadora03.setText(contrato.getVeiculo3().getMarca());
        jTextFieldMensalistaModelo03.setText(contrato.getVeiculo3().getModelo());
        jTextFieldMensalistaCor03.setText(contrato.getVeiculo3().getCor());
        jTextFieldMensalistaAno03.setText(contrato.getVeiculo3().getAnoModelo());
        jFormattedTextFieldMensalistaPlaca04.setText(contrato.getVeiculo4().getPlaca());
        jTextFieldMensalistaMontadora04.setText(contrato.getVeiculo4().getMarca());
        jTextFieldMensalistaModelo04.setText(contrato.getVeiculo4().getModelo());
        jTextFieldMensalistaCor04.setText(contrato.getVeiculo4().getCor());
        jTextFieldMensalistaAno04.setText(contrato.getVeiculo4().getAnoModelo());
    }

    private void clientePreencherJTextField(Cliente cliente) {
        jTextFieldMensalistaNome.setText(cliente.getNome());
        jTextFieldClienteIdCliente.setText(String.valueOf(cliente.getIdCliente()));
        jFormattedTextFieldMensalistaCpf.setText(cliente.getCpf());
        jTextFieldMensalistaIdentidade.setText(cliente.getIdentidade());
        jFormattedTextFieldMensalistaTelefoneResi.setText(cliente.getTelefone());
        jFormattedTextFieldMensalistaCelularResi.setText(cliente.getCelular());
        jTextFieldMensalistaEmail.setText(cliente.getEmail());
        jFormattedTextFieldMensalistaCepResi.setText(cliente.getCepResidencia());
        jTextFieldMensalistaRuaResi.setText(cliente.getRuaResidencia());
        jTextFieldMensalistaNumeroResi.setText(cliente.getNumeroResidencia());
        jTextFieldMensalistaComplementoResi.setText(cliente.getComplementoResidencia());
        jTextFieldMensalistaBairroResi.setText(cliente.getBairroResidencia());
        jTextFieldMensalistaCidadeResi.setText(cliente.getCidadeResidencia());
        jTextFieldMensalistaEstadoResi.setText(cliente.getEstadoResidencia());
        //Preenchendo JTextField com dados cadastrais Profissionais
        jTextFieldMensalistaEmpresa.setText(cliente.getEmpresa());
        jFormattedTextFieldMensalistaCepCome.setText(cliente.getCepComercial());
        jTextFieldMensalistaRuaCome.setText(cliente.getRuaComercial());
        jTextFieldMensalistaNumeroCome.setText(cliente.getNumeroComercial());
        jTextFieldMensalistaComplementoCome.setText(cliente.getComplementoComercial());
        jTextFieldMensalistaBairroCome.setText(cliente.getBairroComercial());
        jTextFieldMensalistaCidadeCome.setText(cliente.getCidadeComercial());
        jTextFieldMensalistaEstadoCome.setText(cliente.getEstadoComercial());
        jFormattedTextFieldMensalistaTelefoneCome.setText(cliente.getTelefoneComercial());
    }

    private Contrato placaIsContratoCliente(String placa) {
        Contrato contrato = new Contrato();
        contrato = contratoService.contratoPlacaIsCliente(placa);
        System.out.println("Contrato Placa 01 " + contrato.getVeiculo1().getPlaca());
        System.out.println("Contrato Placa 02 " + contrato.getVeiculo2().getPlaca());
        System.out.println("Contrato Placa 03 " + contrato.getVeiculo3().getPlaca());
        System.out.println("Contrato Placa 04 " + contrato.getVeiculo4().getPlaca());
        String marca = null, modelo = null, cor = null, ano = null;
        if (contrato.getIdContrato() != 0) {
            if (contrato.getVeiculo1().getPlaca().equalsIgnoreCase(placa)) {
                placa = "[01] " + contrato.getVeiculo1().getPlaca();
                marca = contrato.getVeiculo1().getMarca();
                modelo = contrato.getVeiculo1().getModelo();
                cor = contrato.getVeiculo1().getCor();
                ano = contrato.getVeiculo1().getAnoModelo();
            } else if (contrato.getVeiculo2().getPlaca().equalsIgnoreCase(placa)) {
                placa = "[02] " + contrato.getVeiculo2().getPlaca();
                marca = contrato.getVeiculo2().getMarca();
                modelo = contrato.getVeiculo2().getModelo();
                cor = contrato.getVeiculo2().getCor();
                ano = contrato.getVeiculo2().getAnoModelo();
            } else if (contrato.getVeiculo3().getPlaca().equalsIgnoreCase(placa)) {
                placa = "[03] " + contrato.getVeiculo3().getPlaca();
                marca = contrato.getVeiculo3().getMarca();
                modelo = contrato.getVeiculo3().getModelo();
                cor = contrato.getVeiculo3().getCor();
                ano = contrato.getVeiculo3().getAnoModelo();
            } else if (contrato.getVeiculo4().getPlaca().equalsIgnoreCase(placa)) {
                placa = "[04] " + contrato.getVeiculo4().getPlaca();
                marca = contrato.getVeiculo4().getMarca();
                modelo = contrato.getVeiculo4().getModelo();
                cor = contrato.getVeiculo4().getCor();
                ano = contrato.getVeiculo4().getAnoModelo();
            }
            JOptionPane.showMessageDialog(this, "Veículo de cliente!!!\n"
                    + "\nN. Contrato: " + contrato.getIdContrato()
                    + "\nNome: " + contrato.getIdClienteFk().getNome()
                    + "\nPlaca: " + placa
                    + "\nMontadora: " + marca
                    + "\nModelo: " + modelo
                    + "\nCor: " + cor
                    + "\nAno: " + ano);
        }
        return contrato;
    }

    private void contratoFaturaPreencherJTextField(Contrato contrato) {
        if (contrato.getTipo().equalsIgnoreCase("Mensalista")) {
            jRadioButtonContratoFaturaMensalista.setSelected(true);
        } else if (contrato.getTipo().equalsIgnoreCase("Pacote")) {
            jRadioButtonContratoFaturaPacote.setSelected(true);
        }

        if (contrato.getModo().equalsIgnoreCase("Dias")) {
            jRadioButtonContratoFaturaDias.setSelected(true);
        } else if (contrato.getModo().equalsIgnoreCase("Utilizações")) {
            jRadioButtonContratoFaturaUtilizacoes.setSelected(true);
        }

        jTextFieldContratoFaturaNumero.setText(String.valueOf(contrato.getIdContrato()));
        jFormattedTextFieldContratoFaturaQuantidade.setText(String.valueOf(contrato.getQuantidade()));
        jFormattedTextFieldContratoFaturaDataInicio.setText(contrato.getDataInicio());
        jFormattedTextFieldContratoFaturaDataTermino.setText(contrato.getDataTermino());
        jTextFieldContratoFaturaValor.setText(new DecimalFormat("#,##0.00").format(contrato.getValor()));
        jTextFieldContratoFaturaDiaVencimento.setText(contrato.getDiaVencimento());
        jFormattedTextFieldContratoFaturaUltimaAlteracao.setText(contrato.getDataCancelamento());
        jTextFieldContratoFaturaStatus.setText(contrato.getStatus());

        jTextFieldContratoFaturaCliente.setText(contrato.getIdClienteFk().getNome());
        jFormattedTextFieldContratoFaturaCPF.setText(contrato.getIdClienteFk().getCpf());
    }

    private void contratoClienteFatura(Contrato contrato) {
        ((DefaultTableModel) jTableContratoFatura.getModel()).setRowCount(0);
        ((DefaultTableModel) jTableContratoFatura.getModel()).setColumnCount(0);
        faturaArrayList.clear();
        faturaArrayList = faturaService.faturasContratoCliente(contrato.getIdContrato());
        DefaultTableModel faturaDefaultTableModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        faturaDefaultTableModel.addColumn("N.Contrato");
        faturaDefaultTableModel.addColumn("N.Fatura");
        faturaDefaultTableModel.addColumn("Tipo");
        faturaDefaultTableModel.addColumn("Modo");
        faturaDefaultTableModel.addColumn("Quant.");
        faturaDefaultTableModel.addColumn("Mês Referência");
        faturaDefaultTableModel.addColumn("Período");
        faturaDefaultTableModel.addColumn("Vencimento");
        faturaDefaultTableModel.addColumn("Valor R$");
        faturaDefaultTableModel.addColumn("Data Pagamento");
        faturaDefaultTableModel.addColumn("Status");

        for (int i = 0; i < faturaArrayList.size(); i++) {
            //clienteArrayList.get(i).setCpf(String.format("%011d", Long.parseLong(clienteArrayList.get(i).getCpf())));
            faturaDefaultTableModel.addRow(new String[]{
                String.valueOf(faturaArrayList.get(i).getIdContratoFK()),
                String.valueOf(faturaArrayList.get(i).getIdFatura()),
                contrato.getTipo(),
                contrato.getModo(),
                String.format("%02d", Integer.parseInt(String.valueOf(contrato.getQuantidade()))),
                faturaArrayList.get(i).getMesReferencia(),
                faturaArrayList.get(i).getPeriodo(),
                faturaArrayList.get(i).getVencimento(),
                new DecimalFormat("#,##0.00").format(faturaArrayList.get(i).getValor()),
                faturaArrayList.get(i).getDataPagamento(),
                faturaArrayList.get(i).getStatus()});
        }

        jTableContratoFatura.setModel(faturaDefaultTableModel);
        jTableContratoFatura.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTableContratoFatura.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTableContratoFatura.getColumnModel().getColumn(2).setPreferredWidth(95);
        jTableContratoFatura.getColumnModel().getColumn(3).setPreferredWidth(95);
        jTableContratoFatura.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTableContratoFatura.getColumnModel().getColumn(5).setPreferredWidth(95);
        jTableContratoFatura.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTableContratoFatura.getColumnModel().getColumn(7).setPreferredWidth(95);
        jTableContratoFatura.getColumnModel().getColumn(8).setPreferredWidth(75);
        jTableContratoFatura.getColumnModel().getColumn(9).setPreferredWidth(95);
        jTableContratoFatura.getColumnModel().getColumn(10).setPreferredWidth(75);
        jTableContratoFatura.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Object colunaStatus = table.getValueAt(row, 10);//Coluna Status

                if (row % 2 == 0) {
                    setBackground(new Color(255, 255, 255));
                } else {
                    setBackground(new Color(230, 230, 230));
                }
                setFont(new Font("", Font.PLAIN, 16));//("Nome da fonte", estilo da fonte, tamanho da fonte)
                if (colunaStatus != null) {//Se existir a celula Tipo
                    if (!colunaStatus.equals("Paga")) {
                        setForeground(new Color(255, 0, 0));//Fonte
                    } else {
                        setForeground(new Color(34, 139, 34));//Fonte
                    }
                }

                if (isSelected) {
                    setBackground(new Color(205, 179, 139));
                }
                return this;
            }
        });
    }

    private void movimentoListaFaturaPaga(String idContrato, String mesReferencia, String vencimento, String dataPagamento, String valor, String status) {
        if (dataPagamento.replaceAll("/", "").replaceAll(" ", "").equalsIgnoreCase("")) {
            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
            jFormattedTextFieldMovimentoData.setText(sdfData.format(new Date()));
            dataPagamento = jFormattedTextFieldMovimentoData.getText();
        }
        ((DefaultTableModel) jTableMovimentoRecebimentoMensalidadePacote.getModel()).setRowCount(0);
        ((DefaultTableModel) jTableMovimentoRecebimentoMensalidadePacote.getModel()).setColumnCount(0);
        List<Fatura> faturaArrayList = new ArrayList<>();
        faturaArrayList.clear();
        faturaArrayList = faturaService.faturaPesquisaList(idContrato, mesReferencia, vencimento, dataPagamento, valor, status);

        List<Contrato> contratoArrayList = new ArrayList<>();
        ContratoService contratoService = new ContratoService();
        contratoArrayList.clear();

        for (int i = 0; i < faturaArrayList.size(); i++) {
            contratoArrayList.add(contratoService.contratoList("", "", "", String.valueOf(faturaArrayList.get(i).getIdContratoFK())).get(0));
            contratoArrayList.get(i).setIdFaturaFk(faturaArrayList.get(i));

        }
        DefaultTableModel faturaDefaultTableModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        faturaDefaultTableModel.addColumn("N.Contrato");
        faturaDefaultTableModel.addColumn("N.Fatura");
        faturaDefaultTableModel.addColumn("Tipo");
        faturaDefaultTableModel.addColumn("Cliente");
        faturaDefaultTableModel.addColumn("Mês Referência");
        faturaDefaultTableModel.addColumn("Vencimento");
        faturaDefaultTableModel.addColumn("Valor R$");
        faturaDefaultTableModel.addColumn("Data Paga...");

        for (int i = 0; i < contratoArrayList.size(); i++) {
            //clienteArrayList.get(i).setCpf(String.format("%011d", Long.parseLong(clienteArrayList.get(i).getCpf())));
            faturaDefaultTableModel.addRow(new String[]{
                String.valueOf(contratoArrayList.get(i).getIdFaturaFk().getIdContratoFK()),
                String.valueOf(contratoArrayList.get(i).getIdFaturaFk().getIdFatura()),
                contratoArrayList.get(i).getTipo(),
                contratoArrayList.get(i).getIdClienteFk().getNome(),
                contratoArrayList.get(i).getIdFaturaFk().getMesReferencia(),
                contratoArrayList.get(i).getIdFaturaFk().getVencimento(),
                new DecimalFormat("#,##0.00").format(contratoArrayList.get(i).getIdFaturaFk().getValor()),
                contratoArrayList.get(i).getIdFaturaFk().getDataPagamento(),});
        }

        jTableMovimentoRecebimentoMensalidadePacote.setModel(faturaDefaultTableModel);
        jTableMovimentoRecebimentoMensalidadePacote.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTableMovimentoRecebimentoMensalidadePacote.getColumnModel().getColumn(1).setPreferredWidth(65);
        jTableMovimentoRecebimentoMensalidadePacote.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTableMovimentoRecebimentoMensalidadePacote.getColumnModel().getColumn(3).setPreferredWidth(190);
        jTableMovimentoRecebimentoMensalidadePacote.getColumnModel().getColumn(4).setPreferredWidth(95);
        jTableMovimentoRecebimentoMensalidadePacote.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTableMovimentoRecebimentoMensalidadePacote.getColumnModel().getColumn(6).setPreferredWidth(65);
        jTableMovimentoRecebimentoMensalidadePacote.getColumnModel().getColumn(7).setPreferredWidth(90);
        /*jTableMovimentoRecebimentoMensalidadePacote.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                Object colunaStatus = table.getValueAt(row, 10);//Coluna Status

                if (row % 2 == 0) {
                    setBackground(new Color(255, 255, 255));
                } else {
                    setBackground(new Color(230, 230, 230));
                }
                setFont(new Font("", Font.PLAIN, 16));//("Nome da fonte", estilo da fonte, tamanho da fonte)
                if (colunaStatus != null) {//Se existir a celula Tipo
                    if (!colunaStatus.equals("Paga")) {
                        setForeground(new Color(255, 0, 0));//Fonte
                    } else {
                        setForeground(new Color(34, 139, 34));//Fonte
                    }
                }

                if (isSelected) {
                    setBackground(new Color(205, 179, 139));
                }
                return this;
            }
        });*/
    }

    private void contratoEscolhaMensalistaPacote() {
        SimpleDateFormat dataInicio = new SimpleDateFormat("ddMMyyyy");
        jFormattedTextFieldContratoDataInicio.setText(dataInicio.format(new Date()));
        jFormattedTextFieldContratoDataTermino.setText("01012020");
        if (jRadioButtonContratoMensalista.isSelected()) {
            jRadioButtonContratoUtilizacoes.setEnabled(true);
        } else {
            jRadioButtonContratoUtilizacoes.setEnabled(false);
        }
        if (jRadioButtonContratoMensalista.isSelected() && jRadioButtonContratoDias.isSelected()) {
            jFormattedTextFieldContratoQuantidade.setEditable(false);
            jFormattedTextFieldContratoQuantidade.setText("30");
            jFormattedTextFieldContratoDataInicio.setEditable(true);
            jFormattedTextFieldContratoDataTermino.setEditable(false);
        } else if (jRadioButtonContratoMensalista.isSelected() && jRadioButtonContratoUtilizacoes.isSelected()) {
            jFormattedTextFieldContratoQuantidade.setEditable(true);
            jFormattedTextFieldContratoQuantidade.setText("");
            jFormattedTextFieldContratoDataInicio.setEditable(true);
            jFormattedTextFieldContratoDataTermino.setEditable(false);
        } else if (jRadioButtonContratoPacote.isSelected()) {
            jFormattedTextFieldContratoQuantidade.setEditable(true);
            jFormattedTextFieldContratoQuantidade.setText("");
            jRadioButtonContratoDias.setSelected(true);
            jRadioButtonContratoUtilizacoes.setEnabled(false);
            jFormattedTextFieldContratoDataInicio.setEditable(true);
            jFormattedTextFieldContratoDataTermino.setEditable(false);
            contratoValidaQuantidadeDiasUtilizacoes();
        }
    }

    private void contratoValidaQuantidadeDiasUtilizacoes() {
        if (jFormattedTextFieldContratoQuantidade.getText().replaceAll(" ", "").equalsIgnoreCase("")) {
            if (jRadioButtonContratoMensalista.isSelected()) {
                jFormattedTextFieldContratoDataTermino.setText("01/01/2020");
            } else {
                jFormattedTextFieldContratoDataTermino.setText(jFormattedTextFieldContratoDataInicio.getText());
            }
        } else {
            if (Integer.valueOf(jFormattedTextFieldContratoQuantidade.getText().replaceAll(" ", "")) > 30) {
                jFormattedTextFieldContratoQuantidade.setText("30");
            } else if (Integer.valueOf(jFormattedTextFieldContratoQuantidade.getText().replaceAll(" ", "")) < 1) {
                jFormattedTextFieldContratoQuantidade.setText("1");
            }
            if (jRadioButtonContratoPacote.isSelected()) {
                contratoPreencherDataTermino();
            }
        }
    }

    private void contratoPreencherDataTermino() {
        Calendar contratoCalendario = Calendar.getInstance();
        Date contratoDataInicio, contratoDataTermino;
        SimpleDateFormat sdfContratoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            contratoDataInicio = sdfContratoData.parse(jFormattedTextFieldContratoDataInicio.getText().replaceAll(" ", ""));
            contratoCalendario.setTime(contratoDataInicio);
            int quantidade = Integer.valueOf(jFormattedTextFieldContratoQuantidade.getText().replaceAll(" ", "")) - 1;
            contratoCalendario.add(Calendar.DATE, +quantidade);
            contratoDataTermino = contratoCalendario.getTime();
            jFormattedTextFieldContratoDataTermino.setText(sdfContratoData.format(contratoDataTermino));
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void contratoVerificaVeiculosCadastrados(Contrato contrato) {
        SimpleDateFormat dataHoraAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        if (verificadorEntradaDado.verificaDadoTipo(jFormattedTextFieldMensalistaPlaca01.getText()).equalsIgnoreCase("placa")) {
            if (veiculoService.veiculoIsCadastrado(jFormattedTextFieldMensalistaPlaca01.getText()).getIdVeiculo() == 0) {
                contrato.getVeiculo1().setDataHoraCadastro(dataHoraAtual.format(new Date()));
                veiculoService.veiculoIncluir(contrato.getVeiculo1());
            } else {
                contrato.getVeiculo1().setDataHoraUltimaAlteracao(dataHoraAtual.format(new Date()));
                veiculoService.veiculoAlterar(contrato.getVeiculo1());
            }
        }

        if (verificadorEntradaDado.verificaDadoTipo(jFormattedTextFieldMensalistaPlaca02.getText()).equalsIgnoreCase("placa")) {
            if (veiculoService.veiculoIsCadastrado(jFormattedTextFieldMensalistaPlaca02.getText()).getIdVeiculo() == 0) {
                contrato.getVeiculo2().setDataHoraCadastro(dataHoraAtual.format(new Date()));
                veiculoService.veiculoIncluir(contrato.getVeiculo2());
            } else {
                contrato.getVeiculo2().setDataHoraUltimaAlteracao(dataHoraAtual.format(new Date()));
                veiculoService.veiculoAlterar(contrato.getVeiculo2());
            }
        }

        if (verificadorEntradaDado.verificaDadoTipo(jFormattedTextFieldMensalistaPlaca03.getText()).equalsIgnoreCase("placa")) {
            if (veiculoService.veiculoIsCadastrado(jFormattedTextFieldMensalistaPlaca03.getText()).getIdVeiculo() == 0) {
                contrato.getVeiculo3().setDataHoraCadastro(dataHoraAtual.format(new Date()));
                veiculoService.veiculoIncluir(contrato.getVeiculo3());
            } else {
                contrato.getVeiculo3().setDataHoraUltimaAlteracao(dataHoraAtual.format(new Date()));
                veiculoService.veiculoAlterar(contrato.getVeiculo3());
            }
        }
        if (verificadorEntradaDado.verificaDadoTipo(jFormattedTextFieldMensalistaPlaca04.getText()).equalsIgnoreCase("placa")) {
            if (veiculoService.veiculoIsCadastrado(jFormattedTextFieldMensalistaPlaca04.getText()).getIdVeiculo() == 0) {
                contrato.getVeiculo4().setDataHoraCadastro(dataHoraAtual.format(new Date()));
                veiculoService.veiculoIncluir(contrato.getVeiculo4());
            } else {
                contrato.getVeiculo4().setDataHoraUltimaAlteracao(dataHoraAtual.format(new Date()));
                veiculoService.veiculoAlterar(contrato.getVeiculo4());
            }
        }
    }
}
