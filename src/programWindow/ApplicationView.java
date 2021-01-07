package programWindow;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;

import help.Db;
import net.proteanit.sql.DbUtils;

public class ApplicationView {
	
	//Variavel do JFrame
	private JFrame frmGelaGuelaBar;
	
	//Conexao com banco de dados
	private Connection conexao;
	PreparedStatement statement;
	
	//Variaveis da tela de login
	private JTextField textLogin;
	private JPasswordField txtSenha;
	
	//Tables da seção de Produtos
	private JTable tableProdutosNaAdega, tableProdutosParaComprar, tableProdutosEmEstoque, tableTodosProdutos;
	
	//Variaveis da Lista de Produtos na Adega
	private JTextField textFieldIdProdutosNaAdega, textFieldNomeProdutosNaAdega, textFieldQuantidadeProdutosNaAdega, textFieldPrecoProdutosNaAdega;

	//Variaveis da Lista de Estoque
	private JTextField textFieldPrecoProdutosEmEstoque, textFieldNomeProdutosEmEstoque, textFieldIdProdutosEmEstoque;
	private JTable tableProdutosNoCarrinhoVendaAtacado;
	private JTable tableClientesVendaAtacado_1;
	private JTextField textFieldIdDoProdutoVendaAtacado;
	private JTextField textField_QuantidadeUnidadeVendaAtacado;
	private JTextField txtIdDoClienteVendaAtacado;
	private JTextField textField_NomeDoProdutoVendaAtacado;
	private JTextField textField_PrecoVendaAtacado;
	private JTable tableProdutosVendaAtacado;
	private JTextField textFieldNomeClienteCarrinhoVendaAtacado;
	private JTable tablePrecoTotal;
	private JTextField textFieldPrecoTotalVendaAtacado;
	private JTextField textFieldNomeDaEmpresaVendaAtacado;
	private JTextField textFieldUnidadesProdutosEmEstoque;
	private JTextField textField_DescontoVendaAtacado;
	private JTextField txt_NumeroDaVendaAtacado;
	private JTextField textField_PrecoParaOCarrinhoVendaAtacado;
	private JTextField textFieldNomeProdutoVendaPersonalizada;
	private JTextField textField_QuantidadeVendaPersonalizada;
	private JTextField textField_ValorProdutoVendaPersonalizada;
	private JTextField textField_PrecoVendaPersonalizada;
	private JTable tableProdutosVendaPersonalizada;
	private JTextField textFieldIDVendaPersonalizada;
	private JTextField textField_NomeClienteVendaPersonalizada;
	private JTextField textField_CPFRGVendaPersonalizada;
	private JTextField textField_EmailVendaPersonalizada;
	private JTable tableCarrinhoVendaPersonalizada;
	private JTextField textField_TelefoneVendaPersonalizada;
	private JTextField textField_EmpresaVendaPersonalizada;
	private JTextField txt_NmrVendaVendaPersonalizada;
	private Double valorCarrinhoVarejo =0.0;
	private Double valorCarrinhoPersonalizada = 0.0;
	private Double valorCarrinhoAtacado = 0.0;
	private JTextField txtValorTotal;
	private JTable table_ProdutoVendaVarejo;
	private JTextField textFieldProdutoVendaVarejo;
	private JTextField textField_PrecoVendaVarejo;
	private JTextField textField_QuantidadeVendaVarejo;
	private JTable table_CarrinhoVendaVarejo;
	private JTextField textField_ValorTotalVendaVarejo;
	private JTextField textField_ValorPagoVendaVarejo;
	private JTextField textField_TrocoVendaVarejo;
	private JTextField textFieldIDProdutoVendaVarejo;
	private JTextField textFieldVendaVendaVarejo;
	private JTable tableClientesClientes;
	private JTextField textFieldNmrDeCliente;
	private JTextField textField_NomeDoClienteCliente;
	private JTextField textField_EmpresaCliente;
	private JTextField textField_EmailCliente;
	private JTextField textField_Telefone1Cliente;
	private JTextField textField_Telefone2Cliente;
	private JTextField textField_CPFCliente;
	private JTextField textField_EnderecoCliente;
	private JTextField textField_NmrCliente;
	private JTextField textField_TelEmpresaCliente;
	private JTextField textField_CNPJCliente;
	private JTextField textField_BairroCliente;
	private JTextField textField_CidadeCliente;
	private JTextField textFieldIDCliente;
	private JTable tableNmrClientes;
	private JTable tableRelatorioDeVendas;
	private JTextField textFieldNumeroDaVendaRelatorioDeVendas;
	private JTextField textFieldDiaRelatorioDeVendas;
	private JTextField textFieldMesRelatorioDeVendas;
	private JTextField textFieldAnoRelatorioDeVendas;
	private JTable tableRelatorioDeProdutos;
	private JTable tableRelatorioDeProdutosAtacado;
	private JTextField textFieldNomeDoProdutoRelatorioDeProdutosAtacado;
	private JTextField textFieldIdDoProdutoRelatorioDeProdutosAtacado;
	private JTable tableListaDeProdutosRelatorioDeProdutos;
	private JTable tableListaDeProdutosRelatorioDeProdutosAtacado;
	private JTextField textFieldMesRelatorioRelatorioDeProdutosAtacado;
	private JTextField textFieldAnoRelatorioRelatorioDeProdutosAtacado;
	private JTextField textFieldPagarFuncionarioBancoFinanceiro;
	private JTextField txtQuantiaNoCofreBancoFinanceiro;
	private JTable tableListaDeFuncionariosBancoFinanceiro;
	private JTextField textField_RealizarRetiradaBancoFinanceiro;
	private JTextField textField_RealizarDepositoBancoFinanceiro;
	private JTextField textFieldIDFuncionarioBancoFinanceiro;
	private JTextField textFieldNomeFuncionarioBancoFinanceiro;
	private JTextField textFieldAteDiaRelatorioDeVendas;
	private JTextField textFieldAteMesRelatorioDeVendas;
	private JTextField textFieldAteAnoRelatorioDeVendas;
	private JTextField textFieldMesBancoFinanceiro;
	private JTextField textFieldAnoBancoFinanceiro;
	private JRadioButton rdbtnDetalharBancoFinanceiro;
	private JTextField textFieldIdProdutosParaComprar;
	private JTextField textFieldNomeProdutosParaComprar;
	private JTextField textFieldQuantidadeProdutosParaComprar;
	private JTextField textFieldPrecoProdutosParaComprar;
	private JTextField textFieldIdTodosOsProdutos;
	private JTextField textFieldNomeTodosOsProdutos;
	private JTextField textFieldPrecoTodosOsProdutos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 try {
	            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
	 
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationView window = new ApplicationView();
					window.frmGelaGuelaBar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationView() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String data = dtf.format(now);
		frmGelaGuelaBar = new JFrame();
		frmGelaGuelaBar.setResizable(false);
		frmGelaGuelaBar.setTitle("Gela Guela Bar & Adega - Application                                                                                                                                                    " + data);
		frmGelaGuelaBar.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\gelaimages.jpg"));
		frmGelaGuelaBar.setBackground(Color.BLACK);
		frmGelaGuelaBar.setBounds(100, 100, 798, 595);
		frmGelaGuelaBar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGelaGuelaBar.getContentPane().setLayout(new CardLayout(0, 0));
		frmGelaGuelaBar.setLocationRelativeTo(null);
		conexao = Db.getConnection();


		JPanel telaDeLogin = new JPanel();
		frmGelaGuelaBar.getContentPane().add(telaDeLogin, "name_6482692391000");
		telaDeLogin.setLayout(null);

		JPanel menuInicial = new JPanel();
		frmGelaGuelaBar.getContentPane().add(menuInicial, "name_6512104216800");
		menuInicial.setLayout(null);

		JPanel produtosNaAdega = new JPanel();
		produtosNaAdega.setFocusable(false);
		frmGelaGuelaBar.getContentPane().add(produtosNaAdega, "name_10148521687100");

		JPanel produtosEmEstoque = new JPanel();
		frmGelaGuelaBar.getContentPane().add(produtosEmEstoque, "name_10170212866500");
		produtosEmEstoque.setLayout(null);

		JPanel produtosParaComprar = new JPanel();
		frmGelaGuelaBar.getContentPane().add(produtosParaComprar, "name_10173299634900");
		produtosParaComprar.setLayout(null);

		JPanel todosProdutos = new JPanel();
		frmGelaGuelaBar.getContentPane().add(todosProdutos, "name_10175652732000");
		todosProdutos.setLayout(null);

		JPanel vendaVarejo = new JPanel();
		frmGelaGuelaBar.getContentPane().add(vendaVarejo, "name_10177535959400");
		vendaVarejo.setLayout(null);

		JPanel vendaAtacado = new JPanel();
		frmGelaGuelaBar.getContentPane().add(vendaAtacado, "name_10180454744300");

		JPanel vendaPersonalizada = new JPanel();
		frmGelaGuelaBar.getContentPane().add(vendaPersonalizada, "name_10251987733900");
		vendaPersonalizada.setLayout(null);
		
		JPanel clientesAtacado = new JPanel();
		frmGelaGuelaBar.getContentPane().add(clientesAtacado, "name_152240224685300");
		
		JPanel relatorioDeVendas = new JPanel();
		frmGelaGuelaBar.getContentPane().add(relatorioDeVendas, "name_1447314359100");

		JPanel relatorioDeProdutosAtacado = new JPanel();
		frmGelaGuelaBar.getContentPane().add(relatorioDeProdutosAtacado, "name_177844535578300");
		
		JPanel relatorioDeProdutosVarejo = new JPanel();
		frmGelaGuelaBar.getContentPane().add(relatorioDeProdutosVarejo, "name_156871579121900");
		relatorioDeProdutosVarejo.setLayout(null);
		
		JPanel bancoFinanceiro = new JPanel();
		frmGelaGuelaBar.getContentPane().add(bancoFinanceiro, "name_862446212671800");
		
		
		//
		//
		// Menu Inicial
		//
		//
		
		
		JMenuBar menuBarMenuInicial = new JMenuBar();
		menuBarMenuInicial.setBackground(Color.LIGHT_GRAY);
		menuBarMenuInicial.setBounds(0, 0, 934, 22);
		menuInicial.add(menuBarMenuInicial);

		JMenu mnProdutosMenuInicial = new JMenu("Produtos");
		mnProdutosMenuInicial.setToolTipText("");
		mnProdutosMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarMenuInicial.add(mnProdutosMenuInicial);

		JMenuItem mntmProdutosNaAdegaMenuInicial = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				produtosNaAdega.setVisible(true);
			}
		});
		mntmProdutosNaAdegaMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosMenuInicial.add(mntmProdutosNaAdegaMenuInicial);

		JMenuItem mntmProdutosEmEstoqueMenuInicial = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosMenuInicial.add(mntmProdutosEmEstoqueMenuInicial);

		JMenuItem mntmProdutosParaComprarMenuInicial = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosMenuInicial.add(mntmProdutosParaComprarMenuInicial);

		JMenuItem mntmTodosProdutosMenuInicial = new JMenuItem("Todos Produtos");
		mntmTodosProdutosMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				menuInicial.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosMenuInicial.add(mntmTodosProdutosMenuInicial);

		JMenu mnVenderMenuInicial = new JMenu("Vender");
		mnVenderMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarMenuInicial.add(mnVenderMenuInicial);

		JMenuItem mntmVendaVarejoMenuInicial = new JMenuItem("Venda Varejo");
		mntmVendaVarejoMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderMenuInicial.add(mntmVendaVarejoMenuInicial);

		JMenuItem mntmVendaAtacadoMenuInicial = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderMenuInicial.add(mntmVendaAtacadoMenuInicial);

		JMenuItem mntmVendaPersonalizadaMenuInicial = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaMenuInicial
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderMenuInicial.add(mntmVendaPersonalizadaMenuInicial);
		
		JMenu mnClientesMenuInicial = new JMenu("Clientes");
		mnClientesMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarMenuInicial.add(mnClientesMenuInicial);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				clientesAtacado.setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesMenuInicial.add(mntmNewMenuItem);

		JMenu mnFinanceiroMenuInicial = new JMenu("Financeiro");
		mnFinanceiroMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarMenuInicial.add(mnFinanceiroMenuInicial);
		
		JMenuItem mntmNewMenuRelatorioDeVendasMenuInicial = new JMenuItem("Relatorio De Vendas");
		mntmNewMenuRelatorioDeVendasMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				relatorioDeVendas.setVisible(true);
			}
		});
		mntmNewMenuRelatorioDeVendasMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroMenuInicial.add(mntmNewMenuRelatorioDeVendasMenuInicial);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu = new JMenu("Relatorio de Produtos");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroMenuInicial.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosMenuInicial = new JMenuItem("Atacado");
		mnNewMenu.add(mntmNewMenuItemRelatorioDeProdutosMenuInicial);
		mntmNewMenuItemRelatorioDeProdutosMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mntmNewMenuItemRelatorioDeProdutosMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Varejo");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItemBancoFinanceiroMenuUnicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroMenuInicial.add(mntmNewMenuItemBancoFinanceiroMenuUnicial);

		JMenu mnAjudaMenuInicial = new JMenu("Ajuda");
		mnAjudaMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarMenuInicial.add(mnAjudaMenuInicial);

		JMenuItem mntmDadosDaVersaoMenuInicial = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaMenuInicial.add(mntmDadosDaVersaoMenuInicial);

		JLabel lblNewLabelImagemDeFundoMenuInicial = new JLabel("");
		lblNewLabelImagemDeFundoMenuInicial
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\jw-portada.jpg"));
		lblNewLabelImagemDeFundoMenuInicial.setBounds(-140, 5, 941, 722);
		menuInicial.add(lblNewLabelImagemDeFundoMenuInicial);
		telaDeLogin.setLayout(null);
		produtosNaAdega.setLayout(null);

		//
		//
		// Produtos Na Adega
		//
		//

		JMenuBar menuBarProdutosNaAdega = new JMenuBar();
		menuBarProdutosNaAdega.setBounds(0, 0, 934, 22);
		menuBarProdutosNaAdega.setBackground(Color.LIGHT_GRAY);
		produtosNaAdega.add(menuBarProdutosNaAdega);

		JMenu mnProdutosProdutosNaAdega = new JMenu("Produtos");
		mnProdutosProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarProdutosNaAdega.add(mnProdutosProdutosNaAdega);

		JMenuItem mntmProdutosNaAdegaProdutosNaAdega = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmProdutosNaAdegaProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmProdutosNaAdegaProdutosNaAdega);

		JMenuItem mntmProdutosEmEstoqueProdutosNaAdega = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmProdutosEmEstoqueProdutosNaAdega);

		JMenuItem mntmProdutosParaComprarProdutosNaAdega = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmProdutosParaComprarProdutosNaAdega);

		JMenuItem mntmTodosProdutosProdutosNaAdega = new JMenuItem("Todos Produtos");
		mntmTodosProdutosProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmTodosProdutosProdutosNaAdega);

		JMenu mnVenderProdutosNaAdega = new JMenu("Vender");
		mnVenderProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarProdutosNaAdega.add(mnVenderProdutosNaAdega);

		JMenuItem mntmVendaVarejoProdutosNaAdega = new JMenuItem("Venda Varejo");
		mntmVendaVarejoProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderProdutosNaAdega.add(mntmVendaVarejoProdutosNaAdega);

		JMenuItem mntmVendaAtacadoProdutosNaAdega = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderProdutosNaAdega.add(mntmVendaAtacadoProdutosNaAdega);

		JMenuItem mntmVendaPersonalizadaProdutosNaAdega = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderProdutosNaAdega.add(mntmVendaPersonalizadaProdutosNaAdega);
		
		JMenu mnClientesProdutosNaAdega = new JMenu("Clientes");
		mnClientesProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarProdutosNaAdega.add(mnClientesProdutosNaAdega);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(true);
				produtosNaAdega.setVisible(false);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesProdutosNaAdega.add(mntmNewMenuItem_1);

		JMenu mnFinanceiroProdutosNaAdega = new JMenu("Financeiro");
		mnFinanceiroProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarProdutosNaAdega.add(mnFinanceiroProdutosNaAdega);
		
		JMenuItem mntmRelatorioDeVendasProdutosNaAdega = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendasProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				relatorioDeVendas.setVisible(true);
			}
		});
		mntmRelatorioDeVendasProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroProdutosNaAdega.add(mntmRelatorioDeVendasProdutosNaAdega);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial_1 = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroProdutosNaAdega.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosProdutosnaAdega = new JMenuItem("Atacado");
		mnNewMenu_1.add(mntmNewMenuItemRelatorioDeProdutosProdutosnaAdega);
		mntmNewMenuItemRelatorioDeProdutosProdutosnaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mntmNewMenuItemRelatorioDeProdutosProdutosnaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo = new JMenuItem("Varejo");
		mntmVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1.add(mntmVarejo);
		mntmNewMenuItemBancoFinanceiroMenuUnicial_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroProdutosNaAdega.add(mntmNewMenuItemBancoFinanceiroMenuUnicial_1);

		JMenu mnAjudaProdutosNaAdega = new JMenu("Ajuda");
		mnAjudaProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosNaAdega.add(mnAjudaProdutosNaAdega);

		JMenuItem mntmDadosDaVersaoProdutosNaAdega = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosNaAdega.add(mntmDadosDaVersaoProdutosNaAdega);

		JScrollPane scrollPaneProdutosNaAdega = new JScrollPane();
		scrollPaneProdutosNaAdega.setBounds(270, 77, 504, 471);
		produtosNaAdega.add(scrollPaneProdutosNaAdega);

		tableProdutosNaAdega = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableProdutosNaAdega.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosNaAdega.getSelectedRow();
				textFieldIdProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 0).toString());
				textFieldNomeProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 1).toString());
				textFieldQuantidadeProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 2).toString());
				textFieldPrecoProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 3).toString());
			}
		});
		scrollPaneProdutosNaAdega.setViewportView(tableProdutosNaAdega);

		JButton btnListarProdutosNaAdega = new JButton("Mostrar Produtos da Adega");
		btnListarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosNaAdega();
			}
		});
		btnListarProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-And-Pretzel-icon.png"));
		btnListarProdutosNaAdega.setBounds(402, 33, 252, 33);
		produtosNaAdega.add(btnListarProdutosNaAdega);

		JLabel lblIdProdutosNaAdega = new JLabel("ID do Produto : ");
		lblIdProdutosNaAdega.setForeground(Color.WHITE);
		lblIdProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosNaAdega.setBounds(39, 85, 97, 20);
		produtosNaAdega.add(lblIdProdutosNaAdega);

		JLabel lblNomeProdutosNaAdega = new JLabel("Nome :");
		lblNomeProdutosNaAdega.setForeground(Color.WHITE);
		lblNomeProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosNaAdega.setBounds(85, 115, 48, 20);
		produtosNaAdega.add(lblNomeProdutosNaAdega);

		JLabel lblQuantidadeProdutosNaAdega = new JLabel("Quantidade (UN) :");
		lblQuantidadeProdutosNaAdega.setForeground(Color.WHITE);
		lblQuantidadeProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeProdutosNaAdega.setBounds(25, 145, 109, 20);
		produtosNaAdega.add(lblQuantidadeProdutosNaAdega);

		JLabel lblPrecoProdutosNaAdega = new JLabel("Pre\u00E7o :");
		lblPrecoProdutosNaAdega.setForeground(Color.WHITE);
		lblPrecoProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosNaAdega.setBounds(86, 175, 48, 20);
		produtosNaAdega.add(lblPrecoProdutosNaAdega);

		textFieldIdProdutosNaAdega = new JTextField();
		textFieldIdProdutosNaAdega.setBounds(154, 85, 86, 20);
		produtosNaAdega.add(textFieldIdProdutosNaAdega);
		textFieldIdProdutosNaAdega.setColumns(10);

		textFieldNomeProdutosNaAdega = new JTextField();
		textFieldNomeProdutosNaAdega.setBounds(154, 115, 86, 20);
		produtosNaAdega.add(textFieldNomeProdutosNaAdega);
		textFieldNomeProdutosNaAdega.setColumns(10);

		textFieldQuantidadeProdutosNaAdega = new JTextField();
		textFieldQuantidadeProdutosNaAdega.setBounds(154, 145, 86, 20);
		produtosNaAdega.add(textFieldQuantidadeProdutosNaAdega);
		textFieldQuantidadeProdutosNaAdega.setColumns(10);

		textFieldPrecoProdutosNaAdega = new JTextField();
		textFieldPrecoProdutosNaAdega.setBounds(154, 175, 86, 20);
		produtosNaAdega.add(textFieldPrecoProdutosNaAdega);
		textFieldPrecoProdutosNaAdega.setColumns(10);

		JButton btnAdicionarProdutosNaAdega = new JButton("Adicionar");
		btnAdicionarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if(!textFieldNomeProdutosNaAdega.getText().equals("")) {
						if(!textFieldQuantidadeProdutosNaAdega.getText().equals("")) {
							if(!textFieldPrecoProdutosNaAdega.getText().equals("")) {	
								try {
									String query = "insert into lojaTatuape (Nome, Unidades, Preco) values (?, ?, ?)";
									PreparedStatement pst = conexao.prepareStatement(query);
									pst.setString(1, textFieldNomeProdutosNaAdega.getText());
									pst.setString(2, textFieldQuantidadeProdutosNaAdega.getText());
									pst.setString(3, textFieldPrecoProdutosNaAdega.getText());
										pst.execute();
									JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
				
									pst.close();
								} catch (Exception g) {
									JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!"); g.printStackTrace();
								}
								refreshtableProdutosNaAdega();
								limpadorDeDadosProdutosNaAdega();
	
							}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAdicionarProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosNaAdega.setBounds(85, 225, 113, 25);
		produtosNaAdega.add(btnAdicionarProdutosNaAdega);

		JButton btnAtualizarProdutosNaAdega = new JButton("Atualizar");
		btnAtualizarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (admSenha().equals("1996")){
		        	if(!textFieldIdProdutosNaAdega.getText().equals("")) {
			        	if(!textFieldNomeProdutosNaAdega.getText().equals("")) {
							if(!textFieldQuantidadeProdutosNaAdega.getText().equals("")) {
								if(!textFieldPrecoProdutosNaAdega.getText().equals("")) {	
									try {
									String query = "Update lojaTatuape set Id='" + textFieldIdProdutosNaAdega.getText() + "' ,Nome = '"
											+ textFieldNomeProdutosNaAdega.getText() + "' ,Unidades = '"
											+ textFieldQuantidadeProdutosNaAdega.getText() + "' ,Preco = '"
											+ textFieldPrecoProdutosNaAdega.getText() + "' where Id='"
											+ textFieldIdProdutosNaAdega.getText() + "'  ";
									PreparedStatement pst = conexao.prepareStatement(query);
									pst.execute();
									pst.close();
									JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
									
									} catch (Exception g) {
										JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!"); g.printStackTrace();
									}
									refreshtableProdutosNaAdega();
									limpadorDeDadosProdutosNaAdega();
								}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
							}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para atualizar!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
			      } else {
			       		JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
			    }
			}
		});
		btnAtualizarProdutosNaAdega.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosNaAdega.setBounds(85, 260, 113, 25);
		produtosNaAdega.add(btnAtualizarProdutosNaAdega);

		JButton btnDeletarProdutosNaAdega = new JButton("Deletar");
		btnDeletarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
						if(!textFieldIdProdutosNaAdega.getText().equals("")) {
							try {
							String query = "delete from lojaTatuape where Id='" + tableProdutosNaAdega.getValueAt(tableProdutosNaAdega.getSelectedRow(), 0) + "' ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.execute();
							JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
							pst.close();
							} catch (Exception g) {
								JOptionPane.showMessageDialog(null, "Selecione o Produto na tabela para deletar !"); g.printStackTrace();
							}
							refreshtableProdutosNaAdega();
							limpadorDeDadosProdutosNaAdega();
						}else JOptionPane.showMessageDialog(null, "Selecione o Produto na tabela para deletar !", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnDeletarProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarProdutosNaAdega.setBounds(85, 295, 113, 25);
		produtosNaAdega.add(btnDeletarProdutosNaAdega);
		
		

		JButton btnNewButtonExitProdutosNaAdega;
		btnNewButtonExitProdutosNaAdega = new JButton("");
		btnNewButtonExitProdutosNaAdega.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitProdutosNaAdega.setRequestFocusEnabled(false);
		btnNewButtonExitProdutosNaAdega.setFocusable(false);
		btnNewButtonExitProdutosNaAdega.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitProdutosNaAdega.setFocusPainted(false);
		btnNewButtonExitProdutosNaAdega.setBorderPainted(false);
		btnNewButtonExitProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				produtosNaAdega.setVisible(false);
			}
		});
		btnNewButtonExitProdutosNaAdega.setContentAreaFilled(false);
		btnNewButtonExitProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\BotaoVoltaPreto.png"));
		btnNewButtonExitProdutosNaAdega.setBounds(0, 23, 16, 16);
		produtosNaAdega.add(btnNewButtonExitProdutosNaAdega);
		telaDeLogin.setLayout(null);

		JLabel lblGelaGuelaImageProdutosNaAdega = new JLabel("");
		lblGelaGuelaImageProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\FundoAdega.jpg"));
		lblGelaGuelaImageProdutosNaAdega.setBounds(-300, 11, 753, 662);
		produtosNaAdega.add(lblGelaGuelaImageProdutosNaAdega);
		
		JLabel lblNewLabel_Fundo1 = new JLabel("");
		lblNewLabel_Fundo1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\fundo1Adega.jpg"));
		lblNewLabel_Fundo1.setBounds(363, 329, 439, 243);
		produtosNaAdega.add(lblNewLabel_Fundo1);
		
		JLabel lblNewLabel_Fundo2 = new JLabel("");
		lblNewLabel_Fundo2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\fundoAdega2.jpg"));
		lblNewLabel_Fundo2.setBounds(412, -66, 379, 402);
		produtosNaAdega.add(lblNewLabel_Fundo2);
		telaDeLogin.setLayout(null);
		
		textFieldUnidadesProdutosEmEstoque = new JTextField();
		textFieldUnidadesProdutosEmEstoque.setBounds(154, 145, 86, 20);
		produtosEmEstoque.add(textFieldUnidadesProdutosEmEstoque);
		textFieldUnidadesProdutosEmEstoque.setColumns(10);
		
		JLabel lblNewLabel_UnidadesProdutoEmEstoque = new JLabel("Unidades :");
		lblNewLabel_UnidadesProdutoEmEstoque.setForeground(Color.WHITE);
		lblNewLabel_UnidadesProdutoEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_UnidadesProdutoEmEstoque.setBounds(75, 145, 69, 20);
		produtosEmEstoque.add(lblNewLabel_UnidadesProdutoEmEstoque);


		//
		//
		// ProdutosEmEstoque
		//
		//

		JMenuBar menuBarProdutosEmEstoque = new JMenuBar();
		menuBarProdutosEmEstoque.setBounds(0, 0, 934, 22);
		menuBarProdutosEmEstoque.setBackground(Color.LIGHT_GRAY);
		produtosEmEstoque.add(menuBarProdutosEmEstoque);

		JMenu mnProdutosProdutosEmEstoque = new JMenu("Produtos");
		mnProdutosProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarProdutosEmEstoque.add(mnProdutosProdutosEmEstoque);

		JMenuItem mntmProdutosNaAdegaProdutosEmEstoque = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				produtosEmEstoque.setVisible(false);
			}
		});
		mntmProdutosNaAdegaProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmProdutosNaAdegaProdutosEmEstoque);

		JMenuItem mntmProdutosEmEstoqueProdutosEmEstoque = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmProdutosEmEstoqueProdutosEmEstoque);

		JMenuItem mntmProdutosParaComprarProdutosEmEstoque = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmProdutosParaComprarProdutosEmEstoque);

		JMenuItem mntmTodosProdutosProdutosEmEstoque = new JMenuItem("Todos Produtos");
		mntmTodosProdutosProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmTodosProdutosProdutosEmEstoque);

		JMenu mnVenderProdutosEmEstoque = new JMenu("Vender");
		mnVenderProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarProdutosEmEstoque.add(mnVenderProdutosEmEstoque);

		JMenuItem mntmVendaVarejoProdutosEmEstoque = new JMenuItem("Venda Varejo");
		mntmVendaVarejoProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderProdutosEmEstoque.add(mntmVendaVarejoProdutosEmEstoque);

		JMenuItem mntmVendaAtacadoProdutosEmEstoque = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderProdutosEmEstoque.add(mntmVendaAtacadoProdutosEmEstoque);

		JMenuItem mntmVendaPersonalizadaProdutosEmEstoque = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderProdutosEmEstoque.add(mntmVendaPersonalizadaProdutosEmEstoque);
		
		JMenu mnClientesProdutosEmEstoque = new JMenu("Clientes");
		mnClientesProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarProdutosEmEstoque.add(mnClientesProdutosEmEstoque);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(true);
				produtosEmEstoque.setVisible(false);
			}
		});
		mntmNewMenuItem_1_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesProdutosEmEstoque.add(mntmNewMenuItem_1_1);

		JMenu mnFinanceiroProdutosEmEstoque = new JMenu("Financeiro");
		mnFinanceiroProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarProdutosEmEstoque.add(mnFinanceiroProdutosEmEstoque);
		
		JMenuItem mntmRelatorioDeVendasProdutosEmEstoque = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendasProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				relatorioDeVendas.setVisible(true);
			}
		});
		mntmRelatorioDeVendasProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroProdutosEmEstoque.add(mntmRelatorioDeVendasProdutosEmEstoque);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial_2 = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1_1 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroProdutosEmEstoque.add(mnNewMenu_1_1);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosProdutosEmEstoque = new JMenuItem("Atacado");
		mnNewMenu_1_1.add(mntmNewMenuItemRelatorioDeProdutosProdutosEmEstoque);
		mntmNewMenuItemRelatorioDeProdutosProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mntmNewMenuItemRelatorioDeProdutosProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo_1 = new JMenuItem("Varejo");
		mntmVarejo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_1.add(mntmVarejo_1);
		mntmNewMenuItemBancoFinanceiroMenuUnicial_2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroProdutosEmEstoque.add(mntmNewMenuItemBancoFinanceiroMenuUnicial_2);

		JMenu mnAjudaProdutosEmEstoque = new JMenu("Ajuda");
		mnAjudaProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosEmEstoque.add(mnAjudaProdutosEmEstoque);

		JMenuItem mntmDadosDaVersaoProdutosEmEstoque = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosEmEstoque.add(mntmDadosDaVersaoProdutosEmEstoque);

		JScrollPane scrollPaneProdutosEmEstoque = new JScrollPane();
		scrollPaneProdutosEmEstoque.setBounds(270, 77, 504, 471);
		produtosEmEstoque.add(scrollPaneProdutosEmEstoque);

		tableProdutosEmEstoque = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableProdutosEmEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosEmEstoque.getSelectedRow();
				textFieldIdProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 0).toString());
				textFieldNomeProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 1).toString());
				textFieldUnidadesProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 2).toString());
				textFieldPrecoProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 3).toString());
				
			}
		});
		scrollPaneProdutosEmEstoque.setViewportView(tableProdutosEmEstoque);

		JButton btnListarProdutosEmEstoque = new JButton("Mostrar Produtos no Estoque");
		btnListarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosEmEstoque();
			}
		});
		btnListarProdutosEmEstoque.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\62894-package-icon.png"));
		btnListarProdutosEmEstoque.setBounds(388, 33, 252, 33);
		produtosEmEstoque.add(btnListarProdutosEmEstoque);

		JLabel lblIdProdutosEmEstoque = new JLabel("ID do Produto : ");
		lblIdProdutosEmEstoque.setForeground(Color.WHITE);
		lblIdProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosEmEstoque.setBounds(44, 84, 97, 20);
		produtosEmEstoque.add(lblIdProdutosEmEstoque);

		JLabel lblNomeProdutosEmEstoque = new JLabel("Nome :");
		lblNomeProdutosEmEstoque.setForeground(Color.WHITE);
		lblNomeProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosEmEstoque.setBounds(85, 115, 48, 20);
		produtosEmEstoque.add(lblNomeProdutosEmEstoque);

		JLabel lblPrecoProdutosEmEstoque = new JLabel("Pre\u00E7o (UN) :");
		lblPrecoProdutosEmEstoque.setForeground(Color.WHITE);
		lblPrecoProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosEmEstoque.setBounds(72, 175, 69, 20);
		produtosEmEstoque.add(lblPrecoProdutosEmEstoque);

		textFieldIdProdutosEmEstoque = new JTextField();
		textFieldIdProdutosEmEstoque.setBounds(154, 85, 86, 20);
		produtosEmEstoque.add(textFieldIdProdutosEmEstoque);
		textFieldIdProdutosEmEstoque.setColumns(10);

		textFieldNomeProdutosEmEstoque = new JTextField();
		textFieldNomeProdutosEmEstoque.setBounds(154, 115, 86, 20);
		produtosEmEstoque.add(textFieldNomeProdutosEmEstoque);
		textFieldNomeProdutosEmEstoque.setColumns(10);

		textFieldPrecoProdutosEmEstoque = new JTextField();
		textFieldPrecoProdutosEmEstoque.setBounds(154, 175, 86, 20);
		produtosEmEstoque.add(textFieldPrecoProdutosEmEstoque);
		textFieldPrecoProdutosEmEstoque.setColumns(10);
		telaDeLogin.setLayout(null);

		JButton btnAdicionarProdutosEmEstoque = new JButton("Adicionar");
		btnAdicionarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if(!textFieldNomeProdutosEmEstoque.getText().equals("")) {
						if(!textFieldUnidadesProdutosEmEstoque.getText().equals("")) {
									if(!textFieldPrecoProdutosEmEstoque.getText().equals("")) {
										try {
											String query = "insert into adegagelaguela.estoque (Produto, QuantidadeAtual, PrecoDeCusto) values (?, ?, ?)";
											PreparedStatement pst = conexao.prepareStatement(query);
											pst.setString(1, textFieldNomeProdutosEmEstoque.getText());;
											pst.setString(2, textFieldUnidadesProdutosEmEstoque.getText());
											pst.setString(3, textFieldPrecoProdutosEmEstoque.getText());
											pst.execute();
						
											JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
						
											pst.close();
										} catch (SQLException g) {
											JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!"); g.printStackTrace();
										}
										refreshtableProdutosEmEstoque();
										limpadorDeDadosProdutosEmEstoque();
									}else JOptionPane.showMessageDialog(null, "Preço vazio!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Unidades soltas vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Nome do produto vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAdicionarProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosEmEstoque.setBounds(85, 225, 113, 25);
		produtosEmEstoque.add(btnAdicionarProdutosEmEstoque);

		JButton btnAtualizarProdutosEmEstoque = new JButton("Atualizar");
		btnAtualizarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if(!textFieldIdProdutosEmEstoque.getText().equals("")) {
						if(!textFieldNomeProdutosEmEstoque.getText().equals("")) {
							if(!textFieldUnidadesProdutosEmEstoque.getText().equals("")) {
										if(!textFieldPrecoProdutosEmEstoque.getText().equals("")) {
											try {
									        	if(!textFieldNomeProdutosEmEstoque.getText().equals("")) {
														String query = "Update adegagelaguela.estoque set idEstoque='" + textFieldIdProdutosEmEstoque.getText() + "' ,Produto = '" + textFieldNomeProdutosEmEstoque.getText() + "' ,QuantidadeAtual = '" + textFieldUnidadesProdutosEmEstoque.getText() +"' ,PrecoDeCusto = '"+ textFieldPrecoProdutosEmEstoque.getText() + "' where idEstoque='"+ textFieldIdProdutosEmEstoque.getText() + "'  ";
														PreparedStatement pst = conexao.prepareStatement(query);  
													    pst.execute();
													    pst.close();
													    JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
													}else JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!", "ERRO!", JOptionPane.WARNING_MESSAGE);
														
												} catch (Exception g) {
													JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
												}
									        
											refreshtableProdutosEmEstoque();
											limpadorDeDadosProdutosEmEstoque();
										}else JOptionPane.showMessageDialog(null, "Preço vazio!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Unidades soltas vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Nome do produto vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para atualizar!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAtualizarProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosEmEstoque.setBounds(85, 260, 113, 25);
		produtosEmEstoque.add(btnAtualizarProdutosEmEstoque);

		JButton btnDeletarProdutosEmEstoque = new JButton("Deletar");
		btnDeletarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
						if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
							if(!textFieldIdProdutosEmEstoque.getText().equals("")) {	
								try {
									String query = "delete from adegagelaguela.estoque where idEstoque='" + tableProdutosEmEstoque.getValueAt(tableProdutosEmEstoque.getSelectedRow(), 0).toString() + "' ";
									PreparedStatement pst = conexao.prepareStatement(query);
									pst.execute();
									JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
									pst.close();
								} catch (Exception g) {
									JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para excluir!!", "ERRO!", JOptionPane.WARNING_MESSAGE); g.printStackTrace();
								}
								refreshtableProdutosEmEstoque();
								limpadorDeDadosProdutosEmEstoque();
							}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para excluir!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}
					}
			}
		});
		btnDeletarProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarProdutosEmEstoque.setBounds(85, 295, 113, 25);
		produtosEmEstoque.add(btnDeletarProdutosEmEstoque);
		
		JButton btnNewButtonExitProdutosNoEstoque = new JButton("");
		btnNewButtonExitProdutosNoEstoque.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitProdutosNoEstoque.setRequestFocusEnabled(false);
		btnNewButtonExitProdutosNoEstoque.setFocusable(false);
		btnNewButtonExitProdutosNoEstoque.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitProdutosNoEstoque.setFocusPainted(false);
		btnNewButtonExitProdutosNoEstoque.setBorderPainted(false);
		btnNewButtonExitProdutosNoEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				produtosEmEstoque.setVisible(false);
			}
		});
		btnNewButtonExitProdutosNoEstoque.setContentAreaFilled(false);
		btnNewButtonExitProdutosNoEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\BotaoVolta.png"));
		btnNewButtonExitProdutosNoEstoque.setBounds(0, 23, 16, 16);
		produtosEmEstoque.add(btnNewButtonExitProdutosNoEstoque);
		
		JLabel lblNewLabel_FundoProdutosNoEstoque = new JLabel("");
		lblNewLabel_FundoProdutosNoEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\minsk-bielorr\u00FAssia-de-julho-de-foto-editorial-da-garrafa-da-cerveja-de-corona-extra-no-fundo-de-madeira-uma-da-parte-superior-96219995.jpg"));
		lblNewLabel_FundoProdutosNoEstoque.setBounds(-129, -11, 1008, 621);
		produtosEmEstoque.add(lblNewLabel_FundoProdutosNoEstoque);
		telaDeLogin.setLayout(null);
		

		//
		//
		// ProdutosParaComprar
		//
		//

		JMenuBar menuBarProdutosParaComprar = new JMenuBar();
		menuBarProdutosParaComprar.setBounds(0, 0, 934, 22);
		menuBarProdutosParaComprar.setBackground(Color.LIGHT_GRAY);
		produtosParaComprar.add(menuBarProdutosParaComprar);

		JMenu mnProdutosProdutosParaComprar = new JMenu("Produtos");
		mnProdutosProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarProdutosParaComprar.add(mnProdutosProdutosParaComprar);

		JMenuItem mntmProdutosNaAdegaProdutosParaComprar = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				produtosParaComprar.setVisible(false);
			}
		});
		mntmProdutosNaAdegaProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmProdutosNaAdegaProdutosParaComprar);

		JMenuItem mntmProdutosParaComprarProdutosParaComprar = new JMenuItem("Produtos Em Estoque");
		mntmProdutosParaComprarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosParaComprarProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmProdutosParaComprarProdutosParaComprar);

		JMenuItem mntmTodosProdutosProdutosParaComprar = new JMenuItem("Todos Produtos");
		mntmTodosProdutosProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});

		JMenuItem mntmProdutosParaComprar = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmProdutosParaComprar);
		mntmTodosProdutosProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmTodosProdutosProdutosParaComprar);

		JMenu mnVenderProdutosParaComprar = new JMenu("Vender");
		mnVenderProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarProdutosParaComprar.add(mnVenderProdutosParaComprar);

		JMenuItem mntmVendaVarejoProdutosParaComprar = new JMenuItem("Venda Varejo");
		mntmVendaVarejoProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderProdutosParaComprar.add(mntmVendaVarejoProdutosParaComprar);

		JMenuItem mntmVendaAtacadoProdutosParaComprar = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderProdutosParaComprar.add(mntmVendaAtacadoProdutosParaComprar);

		JMenuItem mntmVendaPersonalizadaProdutosParaComprar = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderProdutosParaComprar.add(mntmVendaPersonalizadaProdutosParaComprar);
		
		JMenu mnClientesProdutosParaComprar = new JMenu("Clientes");
		mnClientesProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarProdutosParaComprar.add(mnClientesProdutosParaComprar);
		
		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(true);
				produtosParaComprar.setVisible(false);
			}
		});
		mntmNewMenuItem_1_1_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesProdutosParaComprar.add(mntmNewMenuItem_1_1_1);

		JMenu mnFinanceiroProdutosParaComprar = new JMenu("Financeiro");
		mnFinanceiroProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarProdutosParaComprar.add(mnFinanceiroProdutosParaComprar);
		
		JMenuItem mntmRelatorioDeVendasProdutosParaComprar = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendasProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				relatorioDeVendas.setVisible(true);
			}
		});
		mntmRelatorioDeVendasProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroProdutosParaComprar.add(mntmRelatorioDeVendasProdutosParaComprar);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial_3 = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1_2 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroProdutosParaComprar.add(mnNewMenu_1_2);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosProdutosParaComprar = new JMenuItem("Atacado");
		mnNewMenu_1_2.add(mntmNewMenuItemRelatorioDeProdutosProdutosParaComprar);
		mntmNewMenuItemRelatorioDeProdutosProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mntmNewMenuItemRelatorioDeProdutosProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo_2 = new JMenuItem("Varejo");
		mntmVarejo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo_2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_2.add(mntmVarejo_2);
		mntmNewMenuItemBancoFinanceiroMenuUnicial_3.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroProdutosParaComprar.add(mntmNewMenuItemBancoFinanceiroMenuUnicial_3);

		JMenu mnAjudaProdutosParaComprar = new JMenu("Ajuda");
		mnAjudaProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosParaComprar.add(mnAjudaProdutosParaComprar);

		JMenuItem mntmDadosDaVersaoProdutosParaComprar = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosParaComprar.add(mntmDadosDaVersaoProdutosParaComprar);

		
		JButton btnListarProdutosParaComprar = new JButton("Mostrar Lista de Compras");
		btnListarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosParaComprar();
			}
		});
		btnListarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-down-icon.png"));
		btnListarProdutosParaComprar.setBounds(402, 33, 252, 33);
		produtosParaComprar.add(btnListarProdutosParaComprar);

		JLabel lblIdProdutosParaComprar = new JLabel("ID para Compra : ");
		lblIdProdutosParaComprar.setVisible(false);
		lblIdProdutosParaComprar.setForeground(Color.WHITE);
		lblIdProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosParaComprar.setBounds(33, 85, 97, 20);
		produtosParaComprar.add(lblIdProdutosParaComprar);

		JLabel lblNomeProdutosParaComprar = new JLabel("Nome :");
		lblNomeProdutosParaComprar.setForeground(Color.WHITE);
		lblNomeProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosParaComprar.setBounds(85, 115, 48, 20);
		produtosParaComprar.add(lblNomeProdutosParaComprar);

		JLabel lblQuantidadeProdutosParaComprar = new JLabel("Quantidade (CX) :");
		lblQuantidadeProdutosParaComprar.setForeground(Color.WHITE);
		lblQuantidadeProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeProdutosParaComprar.setBounds(27, 145, 109, 20);
		produtosParaComprar.add(lblQuantidadeProdutosParaComprar);

		JLabel lblPrecoProdutosParaComprar = new JLabel("Pre\u00E7o :");
		lblPrecoProdutosParaComprar.setForeground(Color.WHITE);
		lblPrecoProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosParaComprar.setBounds(86, 175, 48, 20);
		produtosParaComprar.add(lblPrecoProdutosParaComprar);
		
		textFieldIdProdutosParaComprar= new JTextField();
		textFieldIdProdutosParaComprar.setVisible(false);
		textFieldIdProdutosParaComprar.setBounds(154, 85, 86, 20);
		produtosParaComprar.add(textFieldIdProdutosParaComprar);
		textFieldIdProdutosParaComprar.setColumns(10);
		
		textFieldNomeProdutosParaComprar = new JTextField();
		textFieldNomeProdutosParaComprar.setBounds(154, 115, 86, 20);
		produtosParaComprar.add(textFieldNomeProdutosParaComprar);
		textFieldNomeProdutosParaComprar.setColumns(10);

		textFieldQuantidadeProdutosParaComprar = new JTextField();
		textFieldQuantidadeProdutosParaComprar.setBounds(154, 145, 86, 20);
		produtosParaComprar.add(textFieldQuantidadeProdutosParaComprar);
		textFieldQuantidadeProdutosParaComprar.setColumns(10);

		textFieldPrecoProdutosParaComprar = new JTextField();
		textFieldPrecoProdutosParaComprar.setBounds(154, 175, 86, 20);
		produtosParaComprar.add(textFieldPrecoProdutosParaComprar);
		textFieldPrecoProdutosParaComprar.setColumns(10);
		
		JScrollPane scrollPaneProdutosParaComprar = new JScrollPane();
		scrollPaneProdutosParaComprar.setBounds(270, 77, 504, 471);
		produtosParaComprar.add(scrollPaneProdutosParaComprar);

		tableProdutosParaComprar =  new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableProdutosParaComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosParaComprar.getSelectedRow();
				textFieldIdProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 0).toString());
				textFieldNomeProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 1).toString());
				textFieldQuantidadeProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 2).toString());
				textFieldPrecoProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 3).toString());
			}
		});
		scrollPaneProdutosParaComprar.setViewportView(tableProdutosParaComprar);

		JButton btnAdicionarProdutosParaComprar = new JButton("Adicionar");
		btnAdicionarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					try {
						if(!textFieldNomeProdutosParaComprar.getText().equals("")) {
							if(!textFieldQuantidadeProdutosParaComprar.getText().equals("")) {
								if(!textFieldPrecoProdutosParaComprar.getText().equals("")) {
									String query = "insert into produtosparacomprar ( Nome, QuantidadeUn, Preco) values (?, ?, ?)";
									PreparedStatement pst = conexao.prepareStatement(query);
									pst.setString(1, textFieldNomeProdutosParaComprar.getText());
									pst.setString(2, textFieldQuantidadeProdutosParaComprar.getText());
									pst.setString(3, textFieldPrecoProdutosParaComprar.getText());
									pst.execute();
									JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
									refreshtableProdutosParaComprar();
									limpadorDeDadosProdutosParaComprar();
									pst.close();
								}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
							}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "Tente trocar a virgula pelo ponto!"); g.printStackTrace();
					}
				
				}else JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
			}
		});
		btnAdicionarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosParaComprar.setBounds(85, 225, 113, 25);
		produtosParaComprar.add(btnAdicionarProdutosParaComprar);

		JButton btnAtualizarProdutosParaComprar = new JButton("Atualizar");
		btnAtualizarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (admSenha().equals("1996")){
					try {
						if(!textFieldIdProdutosParaComprar.getText().equals("")) {
							if(!textFieldNomeProdutosParaComprar.getText().equals("")) {
								if(!textFieldQuantidadeProdutosParaComprar.getText().equals("")) {
									if(!textFieldPrecoProdutosParaComprar.getText().equals("")) {
										String query = "Update produtosparacomprar set IDParaCompra='" + textFieldIdProdutosParaComprar.getText()
												+ "' ,Nome = '" + textFieldNomeProdutosParaComprar.getText() + "' ,QuantidadeUn = '"
												+ textFieldQuantidadeProdutosParaComprar.getText() + "' ,Preco = '"
												+ textFieldPrecoProdutosParaComprar.getText() + "' where idParaCompra='"
												+ textFieldIdProdutosParaComprar.getText() + "'  ";
										PreparedStatement pst = conexao.prepareStatement(query);
										pst.execute();
										pst.close();
										JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
										refreshtableProdutosParaComprar();
										limpadorDeDadosProdutosParaComprar();
								
									}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
								}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
							}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para atualizar!!", "ERRO!", JOptionPane.WARNING_MESSAGE);		
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "Tente trocar a virgula pelo ponto!!"); g.printStackTrace();
					}
					refreshtableProdutosParaComprar();
					limpadorDeDadosProdutosParaComprar();
		        } else {
	        		JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
				}
		  }
		});
		btnAtualizarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosParaComprar.setBounds(85, 260, 113, 25);
		produtosParaComprar.add(btnAtualizarProdutosParaComprar);

		JButton btnDeletarProdutosParaComprar = new JButton("Deletar");
		btnDeletarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (admSenha().equals("1996")){
					 if(!textFieldIdProdutosParaComprar.getText().equals("")) {
						try {
							if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
								String query = "delete from produtosparacomprar where IdParaCompra='" + tableProdutosParaComprar.getValueAt(tableProdutosParaComprar.getSelectedRow(), 0) + "'";
								PreparedStatement pst = conexao.prepareStatement(query);
								pst.execute();
								JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
								pst.close();
								
								refreshtableProdutosParaComprar();
								limpadorDeDadosProdutosParaComprar();
							}
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Selecione um produto da lista para deletar !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}
						refreshtableProdutosParaComprar();
						limpadorDeDadosProdutosParaComprar();
					}else JOptionPane.showMessageDialog(null, "Selecione um produto da lista para deletar !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				} else {
		        		JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
					}
				}
		});
		btnDeletarProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarProdutosParaComprar.setBounds(85, 295, 113, 25);
		produtosParaComprar.add(btnDeletarProdutosParaComprar);
		
		JButton btnNewButtonExitProdutosParaComprar;
		btnNewButtonExitProdutosParaComprar = new JButton("");
		btnNewButtonExitProdutosParaComprar.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitProdutosParaComprar.setRequestFocusEnabled(false);
		btnNewButtonExitProdutosParaComprar.setFocusable(false);
		btnNewButtonExitProdutosParaComprar.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitProdutosParaComprar.setFocusPainted(false);
		btnNewButtonExitProdutosParaComprar.setBorderPainted(false);
		btnNewButtonExitProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				produtosParaComprar.setVisible(false);
			}
		});
		btnNewButtonExitProdutosParaComprar.setContentAreaFilled(false);
		btnNewButtonExitProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\BotaoVoltaPreto.png"));
		btnNewButtonExitProdutosParaComprar.setBounds(0, 23, 16, 16);
		produtosParaComprar.add(btnNewButtonExitProdutosParaComprar);
		telaDeLogin.setLayout(null);
		
		JLabel lblNewLabel_FundoProdutoCompra = new JLabel("");
		lblNewLabel_FundoProdutoCompra.setBounds(-70, 11, 865, 555);
		produtosParaComprar.add(lblNewLabel_FundoProdutoCompra);
		lblNewLabel_FundoProdutoCompra.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\19_Gin-Bombay-FundoListaDeCompras.jpg"));

		

		//
		// TodosOsProdutos
		//
		//

		JMenuBar menuBarTodosOsProdutos = new JMenuBar();
		menuBarTodosOsProdutos.setBounds(0, 0, 934, 22);
		menuBarTodosOsProdutos.setBackground(Color.LIGHT_GRAY);
		todosProdutos.add(menuBarTodosOsProdutos);

		JMenu mnProdutosTodosOsProdutos = new JMenu("Produtos");
		mnProdutosTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarTodosOsProdutos.add(mnProdutosTodosOsProdutos);

		JMenuItem mntmProdutosNaAdegaTodosOsProdutos = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				todosProdutos.setVisible(false);
			}
		});
		mntmProdutosNaAdegaTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmProdutosNaAdegaTodosOsProdutos);

		JMenuItem mntmTodosOsProdutosProdutosEmEstoque = new JMenuItem("Produtos Em Estoque");
		mntmTodosOsProdutosProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmTodosOsProdutosProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmTodosOsProdutosProdutosEmEstoque);

		JMenuItem mntmTodosProdutosTodosOsProdutos = new JMenuItem("Todos Produtos");
		mntmTodosProdutosTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JMenuItem mntmTodosOsProdutosProdutosParaComprar = new JMenuItem("Produtos para Comprar");
		mntmTodosOsProdutosProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmTodosOsProdutosProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmTodosOsProdutosProdutosParaComprar);
		mntmTodosProdutosTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmTodosProdutosTodosOsProdutos);

		JMenu mnVenderTodosOsProdutos = new JMenu("Vender");
		mnVenderTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarTodosOsProdutos.add(mnVenderTodosOsProdutos);

		JMenuItem mntmVendaVarejoTodosOsProdutos = new JMenuItem("Venda Varejo");
		mntmVendaVarejoTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderTodosOsProdutos.add(mntmVendaVarejoTodosOsProdutos);

		JMenuItem mntmVendaAtacadoTodosOsProdutos = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoTodosOsProdutos
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderTodosOsProdutos.add(mntmVendaAtacadoTodosOsProdutos);

		JMenuItem mntmVendaPersonalizadaTodosOsProdutos = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderTodosOsProdutos.add(mntmVendaPersonalizadaTodosOsProdutos);
		
		JMenu mnClientesTodosOsProdutos = new JMenu("Clientes");
		mnClientesTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarTodosOsProdutos.add(mnClientesTodosOsProdutos);
		
		JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(true);
				todosProdutos.setVisible(false);
			}
		});
		mntmNewMenuItem_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesTodosOsProdutos.add(mntmNewMenuItem_1_1_1_1);

		JMenu mnFinanceiroTodosOsProdutos = new JMenu("Financeiro");
		mnFinanceiroTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarTodosOsProdutos.add(mnFinanceiroTodosOsProdutos);
		
		JMenuItem mntmRelatorioDeVendasTodosProdutos = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendasTodosProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				relatorioDeVendas.setVisible(true);
			}
		});
		mntmRelatorioDeVendasTodosProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroTodosOsProdutos.add(mntmRelatorioDeVendasTodosProdutos);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial_4 = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1_3 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_3.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroTodosOsProdutos.add(mnNewMenu_1_3);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosTodosProdutos = new JMenuItem("Atacado");
		mnNewMenu_1_3.add(mntmNewMenuItemRelatorioDeProdutosTodosProdutos);
		mntmNewMenuItemRelatorioDeProdutosTodosProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mntmNewMenuItemRelatorioDeProdutosTodosProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo_3 = new JMenuItem("Varejo");
		mntmVarejo_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo_3.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_3.add(mntmVarejo_3);
		mntmNewMenuItemBancoFinanceiroMenuUnicial_4.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroTodosOsProdutos.add(mntmNewMenuItemBancoFinanceiroMenuUnicial_4);

		JMenu mnAjudaTodosOsProdutos = new JMenu("Ajuda");
		mnAjudaTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarTodosOsProdutos.add(mnAjudaTodosOsProdutos);

		JMenuItem mntmDadosDaVersaoTodosOsProdutos = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaTodosOsProdutos.add(mntmDadosDaVersaoTodosOsProdutos);

		JScrollPane scrollPaneTodosOsProdutos = new JScrollPane();
		scrollPaneTodosOsProdutos.setBounds(270, 77, 504, 471);
		todosProdutos.add(scrollPaneTodosOsProdutos);

		

		JButton btnListarTodosOsProdutos = new JButton("Mostrar Todos os Produtos");
		btnListarTodosOsProdutos.setBorder(UIManager.getBorder("CheckBox.border"));
		btnListarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM adegagelaguela.todosprodutos ORDER BY Produto";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableTodosProdutos.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\listcheck.png"));
		btnListarTodosOsProdutos.setBounds(402, 33, 252, 33);
		todosProdutos.add(btnListarTodosOsProdutos);

		JLabel lblIdTodosOsProdutos = new JLabel("ID do Produto : ");
		lblIdTodosOsProdutos.setVisible(false);
		lblIdTodosOsProdutos.setBorder(null);
		lblIdTodosOsProdutos.setForeground(Color.WHITE);
		lblIdTodosOsProdutos.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblIdTodosOsProdutos.setBackground(Color.WHITE);
		lblIdTodosOsProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdTodosOsProdutos.setBounds(49, 85, 97, 20);
		todosProdutos.add(lblIdTodosOsProdutos);

		JLabel lblNomeTodosOsProdutos = new JLabel("Nome :");
		lblNomeTodosOsProdutos.setForeground(Color.WHITE);
		lblNomeTodosOsProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeTodosOsProdutos.setBounds(96, 115, 48, 20);
		todosProdutos.add(lblNomeTodosOsProdutos);

		JLabel lblQuantidadeTodosOsProdutos = new JLabel("Pre\u00E7o por Unidade :");
		lblQuantidadeTodosOsProdutos.setForeground(Color.WHITE);
		lblQuantidadeTodosOsProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeTodosOsProdutos.setBounds(28, 145, 109, 20);
		todosProdutos.add(lblQuantidadeTodosOsProdutos);


		textFieldIdTodosOsProdutos = new JTextField();
		textFieldIdTodosOsProdutos.setVisible(false);
		textFieldIdTodosOsProdutos.setBounds(154, 85, 86, 20);
		todosProdutos.add(textFieldIdTodosOsProdutos);
		textFieldIdTodosOsProdutos.setColumns(10);

		textFieldNomeTodosOsProdutos = new JTextField();
		textFieldNomeTodosOsProdutos.setBounds(154, 115, 86, 20);
		todosProdutos.add(textFieldNomeTodosOsProdutos);
		textFieldNomeTodosOsProdutos.setColumns(10);

		textFieldPrecoTodosOsProdutos = new JTextField();
		textFieldPrecoTodosOsProdutos.setBounds(154, 145, 86, 20);
		todosProdutos.add(textFieldPrecoTodosOsProdutos);
		textFieldPrecoTodosOsProdutos.setColumns(10);

		
		JButton btnAdicionarTodosOsProdutos = new JButton("Adicionar");
		btnAdicionarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if(!textFieldNomeTodosOsProdutos.getText().equals("")) {
						if(!textFieldPrecoTodosOsProdutos.getText().equals("")) {
							try {
								String query = "insert into todosprodutos (Produto, PrecoUnidade) values (?, ?)";
								PreparedStatement pst = conexao.prepareStatement(query);
								pst.setString(1, textFieldNomeTodosOsProdutos.getText());
								pst.setString(2, textFieldPrecoTodosOsProdutos.getText());
								pst.execute();
			
								JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
			
								pst.close();
							} catch (Exception g) {
								JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!"); g.printStackTrace();
							}
							refreshtableTodosOsProdutos();
							limpadorDeDadosTodosProdutos();
						}else JOptionPane.showMessageDialog(null, "Preencha o Preço para adicionar");
					}else JOptionPane.showMessageDialog(null, "Preencha o Nome para adicionar");
				}
			}
		});
		btnAdicionarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarTodosOsProdutos.setBounds(85, 225, 113, 25);
		todosProdutos.add(btnAdicionarTodosOsProdutos);

		JButton btnAtualizarTodosOsProdutos = new JButton("Atualizar");
		btnAtualizarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (admSenha().equals("1996")){
					 try {
						 if(!textFieldIdTodosOsProdutos.getText().equals("")) {
							 
							String query = "Update todosprodutos set Id='" + textFieldIdTodosOsProdutos.getText()+ "' ,Produto = '" + textFieldNomeTodosOsProdutos.getText() + "' ,PrecoUnidade = '"+ textFieldPrecoTodosOsProdutos.getText() + "' where Id='"+ textFieldIdTodosOsProdutos.getText() + "'  ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.execute();
							pst.close();
							JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
							
						 }else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela ao lado", "ERRO!", JOptionPane.WARNING_MESSAGE);
								
					 } catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula !"); g.printStackTrace();
					 }	
					 refreshtableTodosOsProdutos();
						limpadorDeDadosTodosProdutos();
			    } else JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
			}
		});
		btnAtualizarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarTodosOsProdutos.setBounds(85, 260, 113, 25);
		todosProdutos.add(btnAtualizarTodosOsProdutos);

		JButton btnDeletarTodosOsProdutos = new JButton("Deletar");
		btnDeletarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
						try {
							String query = "delete from todosprodutos where Id='"+ tableTodosProdutos.getValueAt(tableTodosProdutos.getSelectedRow(), 0) + "' ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.execute();
							JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
							pst.close();
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "ERRO !"); g.printStackTrace();
						}
						refreshtableTodosOsProdutos();
						limpadorDeDadosTodosProdutos();
					}
				}
			}
		});
		btnDeletarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarTodosOsProdutos.setBounds(85, 295, 113, 25);
		todosProdutos.add(btnDeletarTodosOsProdutos);
		
		JButton btnNewButtonExitTodosOsProdutos;
		btnNewButtonExitTodosOsProdutos = new JButton("");
		btnNewButtonExitTodosOsProdutos.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitTodosOsProdutos.setRequestFocusEnabled(false);
		btnNewButtonExitTodosOsProdutos.setFocusable(false);
		btnNewButtonExitTodosOsProdutos.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitTodosOsProdutos.setFocusPainted(false);
		btnNewButtonExitTodosOsProdutos.setBorderPainted(false);
		btnNewButtonExitTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				todosProdutos.setVisible(false);
			}
		});
		btnNewButtonExitTodosOsProdutos.setContentAreaFilled(false);
		btnNewButtonExitTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\BotaoVoltaPreto.png"));
		btnNewButtonExitTodosOsProdutos.setBounds(0, 23, 16, 16);
		todosProdutos.add(btnNewButtonExitTodosOsProdutos);
		telaDeLogin.setLayout(null);
		
		tableTodosProdutos =  new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
	    tableTodosProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableTodosProdutos.getSelectedRow();
				textFieldIdTodosOsProdutos.setText(tableTodosProdutos.getValueAt(linha, 0).toString());
				textFieldNomeTodosOsProdutos.setText(tableTodosProdutos.getValueAt(linha, 1).toString());
				textFieldPrecoTodosOsProdutos.setText(tableTodosProdutos.getValueAt(linha, 2).toString());
			}
		});
		tableTodosProdutos.setOpaque(false);
		scrollPaneTodosOsProdutos.setViewportView(tableTodosProdutos);
		
		JLabel lblNewLabel_Fundo1TodosProdutos = new JLabel("");
		lblNewLabel_Fundo1TodosProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\fundoTodosProdutos.jpg"));
		lblNewLabel_Fundo1TodosProdutos.setBounds(-129, 77, 435, 493);
		todosProdutos.add(lblNewLabel_Fundo1TodosProdutos);
		
		JLabel lblNewLabel_Fundo2TodosProdutos = new JLabel("");
		lblNewLabel_Fundo2TodosProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\fundoTodosProtudos2.jpg"));
		lblNewLabel_Fundo2TodosProdutos.setBounds(0, 21, 782, 535);
		todosProdutos.add(lblNewLabel_Fundo2TodosProdutos);
		telaDeLogin.setLayout(null);
		vendaAtacado.setLayout(null);
		
		
		
		//
		//
		//VENDA VAREJO
		//
		//
		
		JMenuBar menuBarVendaVarejo = new JMenuBar();
		menuBarVendaVarejo.setBounds(0, 0, 934, 22);
		menuBarVendaVarejo.setBackground(Color.LIGHT_GRAY);
		vendaVarejo.add(menuBarVendaVarejo);

		JMenu mnProdutosVendaVarejo = new JMenu("Produtos");
		mnProdutosVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarVendaVarejo.add(mnProdutosVendaVarejo);

		JMenuItem mntmVendaVarejoVendaVarejo = new JMenuItem("Produtos na Adega");
		mntmVendaVarejoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				produtosNaAdega.setVisible(true);
			}
		});
		mntmVendaVarejoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosVendaVarejo.add(mntmVendaVarejoVendaVarejo);

		JMenuItem mntmProdutosEmEstoqueVendaVarejo = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosVendaVarejo.add(mntmProdutosEmEstoqueVendaVarejo);

		JMenuItem mntmProdutosParaComprarVendaVarejo = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosVendaVarejo.add(mntmProdutosParaComprarVendaVarejo);

		JMenuItem mntmTodosProdutosVendaVarejo = new JMenuItem("Todos Produtos");
		mntmTodosProdutosVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosVendaVarejo.add(mntmTodosProdutosVendaVarejo);

		JMenu mnVenderVendaVarejo = new JMenu("Vender");
		mnVenderVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarVendaVarejo.add(mnVenderVendaVarejo);

		JMenuItem mntmendaAtacadoVendaVarejo = new JMenuItem("Venda Varejo");
		mntmendaAtacadoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmendaAtacadoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderVendaVarejo.add(mntmendaAtacadoVendaVarejo);

		JMenuItem mntmVendaAtacadoVendaVarejo= new JMenuItem("Venda Atacado");
		mntmVendaAtacadoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderVendaVarejo.add(mntmVendaAtacadoVendaVarejo);

		JMenuItem mntmVendaPersonalizadaVendaVarejo = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderVendaVarejo.add(mntmVendaPersonalizadaVendaVarejo);
		
		JMenu mnClientesVendaVarejo = new JMenu("Clientes");
		mnClientesVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarVendaVarejo.add(mnClientesVendaVarejo);
		
		JMenuItem mntmNewMenuItem_ClienteVendaVarejo = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_ClienteVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(true);
				vendaVarejo.setVisible(false);
			}
		});
		mntmNewMenuItem_ClienteVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesVendaVarejo.add(mntmNewMenuItem_ClienteVendaVarejo);

		JMenu mnFinanceiroVendaVarejo = new JMenu("Financeiro");
		mnFinanceiroVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarVendaVarejo.add(mnFinanceiroVendaVarejo);
		
		JMenuItem mntmRelatorioDeVendasVendaVarejo = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendasVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				relatorioDeVendas.setVisible(true);
			}
		});
		mntmRelatorioDeVendasVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroVendaVarejo.add(mntmRelatorioDeVendasVendaVarejo);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial_5 = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1_4 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_4.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroVendaVarejo.add(mnNewMenu_1_4);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosVendaVarejo = new JMenuItem("Atacado");
		mnNewMenu_1_4.add(mntmNewMenuItemRelatorioDeProdutosVendaVarejo);
		mntmNewMenuItemRelatorioDeProdutosVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mntmNewMenuItemRelatorioDeProdutosVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo_4 = new JMenuItem("Varejo");
		mntmVarejo_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo_4.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_4.add(mntmVarejo_4);
		mntmNewMenuItemBancoFinanceiroMenuUnicial_5.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroVendaVarejo.add(mntmNewMenuItemBancoFinanceiroMenuUnicial_5);

		JMenu mnAjudaVendaVarejo = new JMenu("Ajuda");
		mnAjudaVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarVendaVarejo.add(mnAjudaVendaVarejo);
		
		JMenuItem mntmDadosDaVersaoVendaVarejo = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaVendaVarejo.add(mntmDadosDaVersaoVendaVarejo);
		
		JScrollPane scrollPaneProdutosVendaVarejo = new JScrollPane();
		scrollPaneProdutosVendaVarejo.setBounds(322, 68, 420, 156);
		vendaVarejo.add(scrollPaneProdutosVendaVarejo);
		
		table_ProdutoVendaVarejo =  new JTable(){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
		table_ProdutoVendaVarejo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = table_ProdutoVendaVarejo.getSelectedRow();
				textFieldIDProdutoVendaVarejo.setText(table_ProdutoVendaVarejo.getValueAt(linha, 0).toString());
				textFieldProdutoVendaVarejo.setText(table_ProdutoVendaVarejo.getValueAt(linha, 1).toString());
				textField_PrecoVendaVarejo.setText(table_ProdutoVendaVarejo.getValueAt(linha, 3).toString());
				
			}
		});
		scrollPaneProdutosVendaVarejo.setViewportView(table_ProdutoVendaVarejo);
		
		JLabel lblNewLabel_NomeDoProdutoVendaVarejo = new JLabel("Nome do Produto : ");
		lblNewLabel_NomeDoProdutoVendaVarejo.setBounds(32, 110, 125, 20);
		vendaVarejo.add(lblNewLabel_NomeDoProdutoVendaVarejo);
		
		JLabel lblNewLabel_QuantidadeVendaVarejo = new JLabel("Quantidade (UN) :");
		lblNewLabel_QuantidadeVendaVarejo.setBounds(34, 170, 102, 20);
		vendaVarejo.add(lblNewLabel_QuantidadeVendaVarejo);
		
		JLabel lblNewLabel_PrecoProdutoVendaVarejo = new JLabel("Pre\u00E7o por unidade :");
		lblNewLabel_PrecoProdutoVendaVarejo.setBounds(32, 140, 125, 20);
		vendaVarejo.add(lblNewLabel_PrecoProdutoVendaVarejo);
		
		JButton btnNewButtonProdutosVendaVarejo = new JButton("Produtos");
		btnNewButtonProdutosVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTableProdutoVendaVarejo();
			}
		});
		btnNewButtonProdutosVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-icon.png"));
		btnNewButtonProdutosVendaVarejo.setBounds(496, 34, 125, 20);
		vendaVarejo.add(btnNewButtonProdutosVendaVarejo);
		
		JLabel lblNewLabel_IDProdutoVendaVarejo = new JLabel("ID do Produto :");
		lblNewLabel_IDProdutoVendaVarejo.setBounds(32, 80, 104, 20);
		vendaVarejo.add(lblNewLabel_IDProdutoVendaVarejo);
		
		textFieldIDProdutoVendaVarejo = new JTextField();
		textFieldIDProdutoVendaVarejo.setEnabled(false);
		textFieldIDProdutoVendaVarejo.setBounds(167, 80, 113, 20);
		vendaVarejo.add(textFieldIDProdutoVendaVarejo);
		textFieldIDProdutoVendaVarejo.setColumns(10);
		
		textFieldProdutoVendaVarejo = new JTextField();
		textFieldProdutoVendaVarejo.setEditable(false);
		textFieldProdutoVendaVarejo.setBounds(167, 110, 113, 20);
		vendaVarejo.add(textFieldProdutoVendaVarejo);
		textFieldProdutoVendaVarejo.setColumns(10);
		
		textField_PrecoVendaVarejo = new JTextField();
		textField_PrecoVendaVarejo.setEditable(false);
		textField_PrecoVendaVarejo.setBounds(167, 140, 113, 20);
		vendaVarejo.add(textField_PrecoVendaVarejo);
		textField_PrecoVendaVarejo.setColumns(10);
		
		textField_QuantidadeVendaVarejo = new JTextField();
		textField_QuantidadeVendaVarejo.setBounds(167, 170, 113, 20);
		vendaVarejo.add(textField_QuantidadeVendaVarejo);
		textField_QuantidadeVendaVarejo.setColumns(10);
		
		JScrollPane scrollPane_CarrinhoVendaVarejo = new JScrollPane();
		scrollPane_CarrinhoVendaVarejo.setBounds(32, 248, 710, 131);
		vendaVarejo.add(scrollPane_CarrinhoVendaVarejo);
		
		table_CarrinhoVendaVarejo = new JTable(){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
	    DefaultTableModel carrinhoVendaVarejo = (DefaultTableModel) table_CarrinhoVendaVarejo.getModel();
	    carrinhoVendaVarejo.addColumn("ID");
	    carrinhoVendaVarejo.addColumn("Produto");
	    carrinhoVendaVarejo.addColumn("Preço");
	    carrinhoVendaVarejo.addColumn("Quantidade");
	    carrinhoVendaVarejo.addColumn("Valor do Produto");
	    scrollPane_CarrinhoVendaVarejo.setViewportView(table_CarrinhoVendaVarejo);
		
		JButton btnNewButtonAdicionarAoCarrinhoVendaVarejo = new JButton("Adicionar ao carrinho");
		btnNewButtonAdicionarAoCarrinhoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldIDProdutoVendaVarejo.getText().equals("")) {
					if(!textField_QuantidadeVendaVarejo.getText().equals("") && !textField_QuantidadeVendaVarejo.getText().equals("0")&& 
							!textField_QuantidadeVendaVarejo.getText().equals("00")&& !textField_QuantidadeVendaVarejo.getText().equals("000")) {
						if(!textField_PrecoVendaVarejo.getText().equals("")) {
							 double precovenda = Double.parseDouble(textField_PrecoVendaVarejo.getText().toString());
							 double quantiavenda = Double.parseDouble(textField_QuantidadeVendaVarejo.getText().toString());
							 String total = String.valueOf(precovenda * quantiavenda);
							 
							 valorCarrinhoVarejo = valorCarrinhoVarejo+ precovenda * quantiavenda;
							 carrinhoVendaVarejo.addRow(new String [] {textFieldIDProdutoVendaVarejo.getText(), textFieldProdutoVendaVarejo.getText(), textField_PrecoVendaVarejo.getText(), textField_QuantidadeVendaVarejo.getText(), total});
							 AttValorTotalVarejo();
						}else JOptionPane.showMessageDialog(null, "Adicione o valor personalizado!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Quantidade não pode estar vazia ou ser '0' !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela ao lado !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButtonAdicionarAoCarrinhoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnNewButtonAdicionarAoCarrinhoVendaVarejo.setBounds(154, 220, 158, 20);
		vendaVarejo.add(btnNewButtonAdicionarAoCarrinhoVendaVarejo);
		
	
		
		JButton btnNewButton_RemoverDoCarrinhoVendaVarejo = new JButton("Remover do carrinho");
		btnNewButton_RemoverDoCarrinhoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorCarrinhoVarejo = valorCarrinhoVarejo - Double.parseDouble(table_CarrinhoVendaVarejo.getValueAt(table_CarrinhoVendaVarejo.getSelectedRow(), 4).toString());
				table_CarrinhoVendaVarejo.getValueAt(table_CarrinhoVendaVarejo.getSelectedRow(), 4);
				carrinhoVendaVarejo.removeRow(table_CarrinhoVendaVarejo.getSelectedRow());
				AttValorTotalVarejo();
			}
		});
		btnNewButton_RemoverDoCarrinhoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButton_RemoverDoCarrinhoVendaVarejo.setBounds(584, 383, 158, 20);
		vendaVarejo.add(btnNewButton_RemoverDoCarrinhoVendaVarejo);
		
		JLabel lblNewLabel_ValorTotalVendaVarejo = new JLabel("Valor Total :");
		lblNewLabel_ValorTotalVendaVarejo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_ValorTotalVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon.png"));
		lblNewLabel_ValorTotalVendaVarejo.setBounds(45, 407, 143, 24);
		vendaVarejo.add(lblNewLabel_ValorTotalVendaVarejo);
		
		
		JRadioButton rdbtnDinheiroVendaVarejo = new JRadioButton("Dinheiro");
		rdbtnDinheiroVendaVarejo.setContentAreaFilled(false);
		rdbtnDinheiroVendaVarejo.setBounds(599, 425, 109, 23);
		vendaVarejo.add(rdbtnDinheiroVendaVarejo);
		
		JRadioButton rdbtnCartaoVendaVarejo = new JRadioButton("Cart\u00E3o");
		rdbtnCartaoVendaVarejo.setContentAreaFilled(false);
		rdbtnCartaoVendaVarejo.setBounds(599, 457, 109, 23);
		vendaVarejo.add(rdbtnCartaoVendaVarejo);
		
		textField_ValorTotalVendaVarejo = new JTextField();
		textField_ValorTotalVendaVarejo.setEditable(false);
		textField_ValorTotalVendaVarejo.setBounds(195, 410, 117, 20);
		vendaVarejo.add(textField_ValorTotalVendaVarejo);
		textField_ValorTotalVendaVarejo.setColumns(10);
		
		JButton btnNewButton_VenderVendaVarejo = new JButton("Vender");
		btnNewButton_VenderVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (JOptionPane.showConfirmDialog(null, "Venda no valor de R$: " + textField_ValorTotalVendaVarejo.getText().toString(), "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
						int contador = 0;
						if(rdbtnDinheiroVendaVarejo.isSelected() && rdbtnCartaoVendaVarejo.isSelected()) {
							JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
							}else if(!rdbtnDinheiroVendaVarejo.isSelected() && !rdbtnCartaoVendaVarejo.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(rdbtnDinheiroVendaVarejo.isSelected()) {
									while(table_CarrinhoVendaVarejo.getRowCount() != contador) {
										try {
											String query = "INSERT INTO adegagelaguela.vendavarejo (IDProduto, Produto, Quantidade, Preco, NumeroDaVenda, FormaDePagamento) VALUES (?, ?, ?, ?, ?, ?)";
											PreparedStatement pst = conexao.prepareStatement(query);
											pst.setString(1, table_CarrinhoVendaVarejo.getValueAt(contador, 0).toString());
											pst.setString(2, table_CarrinhoVendaVarejo.getValueAt(contador, 1).toString());
											pst.setString(3, table_CarrinhoVendaVarejo.getValueAt(contador, 3).toString());
											pst.setString(4, table_CarrinhoVendaVarejo.getValueAt(contador, 2).toString());
											pst.setString(5, textFieldVendaVendaVarejo.getText());
											pst.setString(6, "Dinheiro");
											pst.execute();
											pst.close();
											contador++;
										} catch (Exception g) {
											g.printStackTrace();
										}
								}	
									JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
									limpadorDeDadosVendaVarejo();
									while (carrinhoVendaVarejo.getRowCount() > 0) {
										carrinhoVendaVarejo.removeRow(carrinhoVendaVarejo.getRowCount()-1);
									}
								
									}else if(rdbtnCartaoVendaVarejo.isSelected()) {
										while(table_CarrinhoVendaVarejo.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.vendavarejo (IDProduto, Produto, Quantidade, Preco, NumeroDaVenda, FormaDePagamento) VALUES (?, ?, ?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, table_CarrinhoVendaVarejo.getValueAt(contador, 0).toString());
												pst.setString(2, table_CarrinhoVendaVarejo.getValueAt(contador, 1).toString());
												pst.setString(3, table_CarrinhoVendaVarejo.getValueAt(contador, 3).toString());
												pst.setString(4, table_CarrinhoVendaVarejo.getValueAt(contador, 2).toString());
												pst.setString(5, textFieldVendaVendaVarejo.getText());
												pst.setString(6, "Cartão");
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}
									}	
										while (carrinhoVendaVarejo.getRowCount() > 0) {
											carrinhoVendaVarejo.removeRow(carrinhoVendaVarejo.getRowCount()-1);
										}
										JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
										limpadorDeDadosVendaVarejo();
						}
					}
				NumeroDaVendaVarejo();
				AtualizarNumeroDaVenda();
				DocumentoVendaVarejo();
				refreshTableProdutoVendaVarejo();
			}
		});
		btnNewButton_VenderVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		btnNewButton_VenderVendaVarejo.setBounds(647, 522, 125, 23);
		vendaVarejo.add(btnNewButton_VenderVendaVarejo);
		
		JLabel lblNewLabel_ValorPagoVendaVarejo = new JLabel("Valor Pago :");
		lblNewLabel_ValorPagoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\money-delete-icon.png"));
		lblNewLabel_ValorPagoVendaVarejo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_ValorPagoVendaVarejo.setBounds(45, 442, 143, 24);
		vendaVarejo.add(lblNewLabel_ValorPagoVendaVarejo);
		
		textField_ValorPagoVendaVarejo = new JTextField();
		textField_ValorPagoVendaVarejo.setBounds(195, 442, 117, 20);
		vendaVarejo.add(textField_ValorPagoVendaVarejo);
		textField_ValorPagoVendaVarejo.setColumns(10);
		
		JButton btnNewButton_CalcTrocoVendaVarejo = new JButton("Calcular Valor do Troco");
		btnNewButton_CalcTrocoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double troco = 0.0;
				Double valortotal = Double.parseDouble(textField_ValorTotalVendaVarejo.getText().toString());
				Double valorPago = Double.parseDouble(textField_ValorPagoVendaVarejo.getText().toString());
				troco = valorPago-valortotal;
				
				textField_TrocoVendaVarejo.setText("R$: " +troco.toString());
			}
		});
		btnNewButton_CalcTrocoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cash-register-icon.png"));
		btnNewButton_CalcTrocoVendaVarejo.setBounds(83, 478, 229, 23);
		vendaVarejo.add(btnNewButton_CalcTrocoVendaVarejo);
		
		textField_TrocoVendaVarejo = new JTextField();
		textField_TrocoVendaVarejo.setEditable(false);
		textField_TrocoVendaVarejo.setBounds(421, 445, 86, 20);
		vendaVarejo.add(textField_TrocoVendaVarejo);
		textField_TrocoVendaVarejo.setColumns(10);
		
		JLabel lblNewLabel_TrocoVendaVarejo = new JLabel("Troco :");
		lblNewLabel_TrocoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\money-icon.png"));
		lblNewLabel_TrocoVendaVarejo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_TrocoVendaVarejo.setBounds(421, 424, 102, 22);
		vendaVarejo.add(lblNewLabel_TrocoVendaVarejo);

		
		JLabel lblNewLabel_VendaVendaVarejo = new JLabel("Venda :");
		lblNewLabel_VendaVendaVarejo.setBounds(474, 526, 46, 20);
		vendaVarejo.add(lblNewLabel_VendaVendaVarejo);
		
		textFieldVendaVendaVarejo = new JTextField();
		textFieldVendaVendaVarejo.setEditable(false);
		textFieldVendaVendaVarejo.setBounds(530, 526, 86, 20);
		vendaVarejo.add(textFieldVendaVendaVarejo);
		textFieldVendaVendaVarejo.setColumns(10);
		textFieldVendaVendaVarejo.setText(NumeroDaVendaVarejo().toString());
		
		JLabel lblNewLabel_9 = new JLabel("Dados dos Produtos :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-And-Pretzel-icon.png"));
		lblNewLabel_9.setBounds(32, 37, 200, 24);
		vendaVarejo.add(lblNewLabel_9);
		
		JButton btnNewButtonVoltarMenuVendaVarejo = new JButton("");
		btnNewButtonVoltarMenuVendaVarejo.setBorderPainted(false);
		btnNewButtonVoltarMenuVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				menuInicial.setVisible(true);
			}
		});
		btnNewButtonVoltarMenuVendaVarejo.setContentAreaFilled(false);
		btnNewButtonVoltarMenuVendaVarejo.setOpaque(false);
		btnNewButtonVoltarMenuVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\BotaoVolta.png"));
		btnNewButtonVoltarMenuVendaVarejo.setBounds(0, 22, 16, 16);
		vendaVarejo.add(btnNewButtonVoltarMenuVendaVarejo);
		
		JLabel lblNewLabel_FundoVendaVarejo = new JLabel("");
		lblNewLabel_FundoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\FundoVendaVarejo.jpg"));
		lblNewLabel_FundoVendaVarejo.setBounds(0, 0, 790, 565);
		vendaVarejo.add(lblNewLabel_FundoVendaVarejo);
		

		
		
		
		//
		//
		//VENDA ATACADO
		//
		//
		
		
		textFieldNomeDaEmpresaVendaAtacado = new JTextField();
		textFieldNomeDaEmpresaVendaAtacado.setEditable(false);
		textFieldNomeDaEmpresaVendaAtacado.setBounds(359, 452, 139, 20);
		vendaAtacado.add(textFieldNomeDaEmpresaVendaAtacado);
		textFieldNomeDaEmpresaVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_EmpresaVendaAtacado = new JLabel("Empresa :");
		lblNewLabel_EmpresaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		lblNewLabel_EmpresaVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_EmpresaVendaAtacado.setBounds(272, 452, 89, 20);
		vendaAtacado.add(lblNewLabel_EmpresaVendaAtacado);

		JMenuBar menuBarVendaAtacado = new JMenuBar();
		menuBarVendaAtacado.setBounds(0, 0, 934, 22);
		menuBarVendaAtacado.setBackground(Color.LIGHT_GRAY);
		vendaAtacado.add(menuBarVendaAtacado);

		JMenu mnProdutosVendaAtacado = new JMenu("Produtos");
		mnProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarVendaAtacado.add(mnProdutosVendaAtacado);

		JMenuItem mntmProdutosNaAdegaVendaAtacado = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				vendaAtacado.setVisible(false);
			}
		});
		mntmProdutosNaAdegaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosVendaAtacado.add(mntmProdutosNaAdegaVendaAtacado);

		JMenuItem mntmProdutosEmEstoqueVendaAtacado = new JMenuItem("Produtos Em Estoque");
		mntmProdutosEmEstoqueVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosVendaAtacado.add(mntmProdutosEmEstoqueVendaAtacado);

		JMenuItem mntmTodosOsProdutosVendaAtacado;
		mntmTodosOsProdutosVendaAtacado = new JMenuItem("Todos Produtos");
		mntmTodosOsProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		
				JMenuItem mntmProdutosParaComprarVendaAtacado = new JMenuItem("Produtos para Comprar");
				mntmProdutosParaComprarVendaAtacado.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vendaAtacado.setVisible(false);
						produtosParaComprar.setVisible(true);
					}
				});
				mntmProdutosParaComprarVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
				mnProdutosVendaAtacado.add(mntmProdutosParaComprarVendaAtacado);
		mntmTodosOsProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosVendaAtacado.add(mntmTodosOsProdutosVendaAtacado);

		JMenu mnVenderVendaAtacado = new JMenu("Vender");
		mnVenderVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarVendaAtacado.add(mnVenderVendaAtacado);

		JMenuItem mntmVendaVarejoVendaAtacado = new JMenuItem("Venda Varejo");
		mntmVendaVarejoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderVendaAtacado.add(mntmVendaVarejoVendaAtacado);

		JMenuItem mntmVendaPersonalizadaVendaAtacado = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		
		JMenuItem mntmVendaAtacadoVendaAtacado = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderVendaAtacado.add(mntmVendaAtacadoVendaAtacado);
		mntmVendaPersonalizadaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderVendaAtacado.add(mntmVendaPersonalizadaVendaAtacado);
		
		JMenu mnClientesVendaAtacado = new JMenu("Clientes");
		mnClientesVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarVendaAtacado.add(mnClientesVendaAtacado);
		
		JMenuItem mntmNewMenuItem_1_1_1_2 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				clientesAtacado.setVisible(true);
			}
		});
		mntmNewMenuItem_1_1_1_2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesVendaAtacado.add(mntmNewMenuItem_1_1_1_2);

		JMenu mnFinanceiroVendaAtacado = new JMenu("Financeiro");
		mnFinanceiroVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarVendaAtacado.add(mnFinanceiroVendaAtacado);
		
		JMenuItem mntmRelatorioDeVendasVendaAtacado = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendasVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				relatorioDeVendas.setVisible(true);
			}
		});
		mntmRelatorioDeVendasVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroVendaAtacado.add(mntmRelatorioDeVendasVendaAtacado);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial_6 = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1_5 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_5.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroVendaAtacado.add(mnNewMenu_1_5);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosVendaAtacado = new JMenuItem("Atacado");
		mntmNewMenuItemRelatorioDeProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mnNewMenu_1_5.add(mntmNewMenuItemRelatorioDeProdutosVendaAtacado);
		mntmNewMenuItemRelatorioDeProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo_5 = new JMenuItem("Varejo");
		mntmVarejo_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo_5.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_5.add(mntmVarejo_5);
		mntmNewMenuItemBancoFinanceiroMenuUnicial_6.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroVendaAtacado.add(mntmNewMenuItemBancoFinanceiroMenuUnicial_6);

		JMenu mnAjudaVendaAtacado = new JMenu("Ajuda");
		mnAjudaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarVendaAtacado.add(mnAjudaVendaAtacado);

		JMenuItem mntmDadosDaVersaoVendaAtacado = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaVendaAtacado.add(mntmDadosDaVersaoVendaAtacado);

		tableClientesVendaAtacado_1 = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
		tableClientesVendaAtacado_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnNewButton_ClientesVendaAtacado = new JButton("Clientes :");
		btnNewButton_ClientesVendaAtacado.setBounds(77, 389, 115, 23);
		btnNewButton_ClientesVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTableClientesVendaAtacado();
			}
		});
		btnNewButton_ClientesVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_ClientesVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-icon.png"));
		vendaAtacado.add(btnNewButton_ClientesVendaAtacado);
		
		JScrollPane scrollPane_ClientesVendaAtacado = new JScrollPane();
		scrollPane_ClientesVendaAtacado.setBounds(20, 423, 242, 122);
		vendaAtacado.add(scrollPane_ClientesVendaAtacado);
		
		tableClientesVendaAtacado_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableClientesVendaAtacado_1.getSelectedRow();
				txtIdDoClienteVendaAtacado.setText(tableClientesVendaAtacado_1.getValueAt(linha, 0).toString());
				textFieldNomeClienteCarrinhoVendaAtacado.setText(tableClientesVendaAtacado_1.getValueAt(linha, 1).toString());
				textFieldNomeDaEmpresaVendaAtacado.setText(tableClientesVendaAtacado_1.getValueAt(linha, 2).toString());
			}
		});
		scrollPane_ClientesVendaAtacado.setViewportView(tableClientesVendaAtacado_1);

		JButton btnNewButton_ProdutosVendaAtacado = new JButton("Produtos :");
		btnNewButton_ProdutosVendaAtacado.setBounds(489, 33, 115, 23);
		btnNewButton_ProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosVendaAtacado();
			}
		});
		btnNewButton_ProdutosVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_ProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-2-icon.png"));
		vendaAtacado.add(btnNewButton_ProdutosVendaAtacado);
		
		JLabel lblNewLabel_AddProdVendaAtacado = new JLabel("Venda de Produtos Atacado :");
		lblNewLabel_AddProdVendaAtacado.setBounds(75, 27, 242, 20);
		lblNewLabel_AddProdVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\money-icon.png"));
		lblNewLabel_AddProdVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 14));
		vendaAtacado.add(lblNewLabel_AddProdVendaAtacado);

		
		
		textFieldIdDoProdutoVendaAtacado = new JTextField();
		textFieldIdDoProdutoVendaAtacado.setVisible(false);
		textFieldIdDoProdutoVendaAtacado.setBounds(620, 37, 11, 14);
		textFieldIdDoProdutoVendaAtacado.setEditable(false);
		vendaAtacado.add(textFieldIdDoProdutoVendaAtacado);
		textFieldIdDoProdutoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_QuantiadeUnidadeVendaAtacado = new JLabel("Quantidade por Unidades :");
		lblNewLabel_QuantiadeUnidadeVendaAtacado.setBounds(20, 140, 157, 20);
		vendaAtacado.add(lblNewLabel_QuantiadeUnidadeVendaAtacado);
		
		textField_QuantidadeUnidadeVendaAtacado = new JTextField();
		textField_QuantidadeUnidadeVendaAtacado.setBounds(172, 140, 122, 20);
		vendaAtacado.add(textField_QuantidadeUnidadeVendaAtacado);
		textField_QuantidadeUnidadeVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_ClienteVendaVendaAtacado = new JLabel("Cliente :");
		lblNewLabel_ClienteVendaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		lblNewLabel_ClienteVendaVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_ClienteVendaVendaAtacado.setBounds(272, 421, 103, 20);
		vendaAtacado.add(lblNewLabel_ClienteVendaVendaAtacado);
		
		txtIdDoClienteVendaAtacado = new JTextField();
		txtIdDoClienteVendaAtacado.setVisible(false);
		txtIdDoClienteVendaAtacado.setBounds(0, 11, 31, 20);
		txtIdDoClienteVendaAtacado.setEditable(false);
		vendaAtacado.add(txtIdDoClienteVendaAtacado);
		txtIdDoClienteVendaAtacado.setColumns(10);
		
		JScrollPane scrollPaneCarrinhoVendaAtacado = new JScrollPane();
		scrollPaneCarrinhoVendaAtacado.setBounds(20, 220, 493, 132);
		vendaAtacado.add(scrollPaneCarrinhoVendaAtacado);
		
		tableProdutosNoCarrinhoVendaAtacado = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
	    DefaultTableModel carrinhoVendaAtacado = (DefaultTableModel) tableProdutosNoCarrinhoVendaAtacado.getModel();
	    carrinhoVendaAtacado.addColumn("ID");
		carrinhoVendaAtacado.addColumn("Produto");
		carrinhoVendaAtacado.addColumn("Preço");
		carrinhoVendaAtacado.addColumn("Quantidade");
		carrinhoVendaAtacado.addColumn("Valor Total");
		scrollPaneCarrinhoVendaAtacado.setViewportView(tableProdutosNoCarrinhoVendaAtacado);	
		
		textField_NomeDoProdutoVendaAtacado = new JTextField();
		textField_NomeDoProdutoVendaAtacado.setBounds(137, 60, 157, 20);
		textField_NomeDoProdutoVendaAtacado.setEditable(false);
		vendaAtacado.add(textField_NomeDoProdutoVendaAtacado);
		textField_NomeDoProdutoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_PrecoVendaAtacado = new JLabel("Pre\u00E7o por Unidade :");
		lblNewLabel_PrecoVendaAtacado.setBounds(20, 100, 120, 20);
		vendaAtacado.add(lblNewLabel_PrecoVendaAtacado);
		
		textField_PrecoVendaAtacado = new JTextField();
		textField_PrecoVendaAtacado.setBounds(137, 100, 157, 20);
		textField_PrecoVendaAtacado.setEditable(false);
		vendaAtacado.add(textField_PrecoVendaAtacado);
		textField_PrecoVendaAtacado.setColumns(10);
		
		JButton btnNewButton_AddCarrinhoVendaAtacado = new JButton("Adicionar  ao Carrinho");
		btnNewButton_AddCarrinhoVendaAtacado.setBounds(205, 189, 149, 23);
		btnNewButton_AddCarrinhoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldIdDoProdutoVendaAtacado.getText().equals("")) {
					if(!textField_QuantidadeUnidadeVendaAtacado.getText().equals("") && !textField_QuantidadeUnidadeVendaAtacado.getText().equals("0")&& 
							!textField_QuantidadeUnidadeVendaAtacado.getText().equals("00")&& !textField_QuantidadeUnidadeVendaAtacado.getText().equals("000")) {

						 double precovenda = Double.parseDouble(textField_PrecoVendaAtacado.getText().toString());
						 double quantiavenda = Double.parseDouble(textField_QuantidadeUnidadeVendaAtacado.getText().toString());
						 double valortotal = precovenda * quantiavenda;
						 
						valorCarrinhoAtacado = valorCarrinhoAtacado + precovenda * quantiavenda;
						carrinhoVendaAtacado.addRow(new String [] {textFieldIdDoProdutoVendaAtacado.getText(), textField_NomeDoProdutoVendaAtacado.getText(), textField_PrecoVendaAtacado.getText(), textField_QuantidadeUnidadeVendaAtacado.getText(), String.valueOf(valortotal)});
						textFieldPrecoTotalVendaAtacado.setText(String.valueOf(valorCarrinhoAtacado));
					}else JOptionPane.showMessageDialog(null, "Quantidade não pode estar vazia ou ser '0' !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela ao lado !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton_AddCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_AddCarrinhoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		vendaAtacado.add(btnNewButton_AddCarrinhoVendaAtacado);
		
		JButton btnNewButton_RemoverCarrinhoVendaAtacado = new JButton("Remover do Carrinho");
		btnNewButton_RemoverCarrinhoVendaAtacado.setBounds(364, 189, 149, 23);
		btnNewButton_RemoverCarrinhoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorCarrinhoAtacado =  valorCarrinhoAtacado - Double.parseDouble(tableProdutosNoCarrinhoVendaAtacado.getValueAt(tableProdutosNoCarrinhoVendaAtacado.getSelectedRow(), 4).toString());
				carrinhoVendaAtacado.removeRow(tableProdutosNoCarrinhoVendaAtacado.getSelectedRow());
				textFieldPrecoTotalVendaAtacado.setText(String.valueOf(valorCarrinhoAtacado));
			}
		});
		btnNewButton_RemoverCarrinhoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButton_RemoverCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		vendaAtacado.add(btnNewButton_RemoverCarrinhoVendaAtacado);
		
		
		JLabel lblNewLabel_ProdutosNoCarrinhoVendaAtacado = new JLabel("Produtos no carrinho :");
		lblNewLabel_ProdutosNoCarrinhoVendaAtacado.setBounds(20, 189, 142, 20);
		lblNewLabel_ProdutosNoCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 12));
		vendaAtacado.add(lblNewLabel_ProdutosNoCarrinhoVendaAtacado);
		
		
		JLabel lblNewLabelNomeDoProdutoVendaAtacado = new JLabel("Nome do Produto : ");
		lblNewLabelNomeDoProdutoVendaAtacado.setBounds(20, 60, 120, 20);
		vendaAtacado.add(lblNewLabelNomeDoProdutoVendaAtacado);
	
		
		JScrollPane scrollPane_ProdutosVendaAtacado = new JScrollPane();
		scrollPane_ProdutosVendaAtacado.setBounds(327, 56, 432, 122);
		vendaAtacado.add(scrollPane_ProdutosVendaAtacado);
		
		tableProdutosVendaAtacado = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		tableProdutosVendaAtacado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosVendaAtacado.getSelectedRow();
				textFieldIdDoProdutoVendaAtacado.setText(tableProdutosVendaAtacado.getValueAt(linha, 0).toString());
				textField_NomeDoProdutoVendaAtacado.setText(tableProdutosVendaAtacado.getValueAt(linha, 1).toString());
				textField_PrecoVendaAtacado.setText(tableProdutosVendaAtacado.getValueAt(linha, 3).toString());
				textField_PrecoParaOCarrinhoVendaAtacado.setText(tableProdutosVendaAtacado.getValueAt(linha, 3).toString());
			}
		});
		scrollPane_ProdutosVendaAtacado.setViewportView(tableProdutosVendaAtacado);
		
		textFieldNomeClienteCarrinhoVendaAtacado = new JTextField();
		textFieldNomeClienteCarrinhoVendaAtacado.setEditable(false);
		textFieldNomeClienteCarrinhoVendaAtacado.setBounds(359, 421, 139, 20);
		vendaAtacado.add(textFieldNomeClienteCarrinhoVendaAtacado);
		textFieldNomeClienteCarrinhoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_PrecoTotal = new JLabel("Pre\u00E7o Total :");
		lblNewLabel_PrecoTotal.setBounds(518, 207, 163, 41);
		lblNewLabel_PrecoTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_PrecoTotal.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon.png"));
		vendaAtacado.add(lblNewLabel_PrecoTotal);
		
		JScrollPane scrollPanePrecoTotal = new JScrollPane();
		scrollPanePrecoTotal.setBounds(0, 31, 11, 14);
		scrollPanePrecoTotal.setVisible(false);
		vendaAtacado.add(scrollPanePrecoTotal);
		
		tablePrecoTotal = new JTable();
		scrollPanePrecoTotal.setViewportView(tablePrecoTotal);
		
		textFieldPrecoTotalVendaAtacado = new JTextField();
		textFieldPrecoTotalVendaAtacado.setBounds(642, 218, 115, 20);
		textFieldPrecoTotalVendaAtacado.setEditable(false);
		vendaAtacado.add(textFieldPrecoTotalVendaAtacado);
		textFieldPrecoTotalVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_FormaDePgmVendaAtacado = new JLabel("Forma de Pagamento :");
		lblNewLabel_FormaDePgmVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_FormaDePgmVendaAtacado.setBounds(554, 390, 201, 20);
		vendaAtacado.add(lblNewLabel_FormaDePgmVendaAtacado);
		
		
		JCheckBox chckbxAPagarVendaAtacado = new JCheckBox("Pagamento futuro");
		chckbxAPagarVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxAPagarVendaAtacado.setOpaque(false);
		chckbxAPagarVendaAtacado.setBounds(272, 489, 157, 23);
		vendaAtacado.add(chckbxAPagarVendaAtacado);
		
		JCheckBox chckbxCartaoVendaAtacado = new JCheckBox("Cart\u00E3o");
		chckbxCartaoVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxCartaoVendaAtacado.setOpaque(false);
		chckbxCartaoVendaAtacado.setBounds(554, 451, 72, 23);
		vendaAtacado.add(chckbxCartaoVendaAtacado);
		
		JCheckBox chckbxDinheiroVendaAtacado = new JCheckBox("Dinheiro");
		chckbxDinheiroVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxDinheiroVendaAtacado.setOpaque(false);
		chckbxDinheiroVendaAtacado.setIcon(null);
		chckbxDinheiroVendaAtacado.setBounds(554, 420, 79, 23);
		vendaAtacado.add(chckbxDinheiroVendaAtacado);
		
		JLabel lblNewLabel_SelecioneClienteVendaAtacado = new JLabel("Selecione um cliente para venda :");
		lblNewLabel_SelecioneClienteVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_SelecioneClienteVendaAtacado.setBounds(20, 350, 310, 41);
		vendaAtacado.add(lblNewLabel_SelecioneClienteVendaAtacado);
		
		JButton btnNewButtonVenderVendaAtacado = new JButton("Vender");
		btnNewButtonVenderVendaAtacado.setBounds(614, 522, 158, 23);
		btnNewButtonVenderVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonVenderVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldNomeClienteCarrinhoVendaAtacado.getText().equals("")) {
					if(!chckbxAPagarVendaAtacado.isSelected()) {
						String ValorDaVenda = "Deseja finalizar a venda?\n Valor da venda " + textFieldPrecoTotalVendaAtacado.getText() + "\n Desconto de R$: " + textField_DescontoVendaAtacado.getText();
						if (JOptionPane.showConfirmDialog(null, ValorDaVenda, "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
							int contador = 0;
							if(chckbxDinheiroVendaAtacado.isSelected() && chckbxCartaoVendaAtacado.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(!chckbxDinheiroVendaAtacado.isSelected() && !chckbxCartaoVendaAtacado.isSelected()) {
									JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
									}else if(chckbxDinheiroVendaAtacado.isSelected()) {
										while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.vendaatacado (IDCliente, IDProduto, produto, quantidade, preco, NumeroDaVenda, FormaDePagamento, Desconto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, txtIdDoClienteVendaAtacado.getText());
												pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
												pst.setString(3, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 1).toString());
												pst.setString(4, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 2).toString());
												pst.setString(5, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 3).toString());
												pst.setString(6,  txt_NumeroDaVendaAtacado.getText());
												pst.setString(7, "Dinheiro");
												pst.setString(8,  textField_DescontoVendaAtacado.getText());
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}
									}	
									NumeroDaVenda();
									AtualizarNumeroDaVenda();
									NumeroDaVendaToPDF();
									DocumentoVendaAtacado();
									refreshtableProdutosVendaAtacado();
									limpadorDeDadosVendaAtacado();
									JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
									while (carrinhoVendaAtacado.getRowCount() > 0) {
										carrinhoVendaAtacado.removeRow(carrinhoVendaAtacado.getRowCount()-1);
									}
									
										}else if(chckbxCartaoVendaAtacado.isSelected()) {
											while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
												try {
													String query = "INSERT INTO adegagelaguela.vendaatacado (IDCliente, IDProduto, produto, quantidade, preco, NumeroDaVenda, FormaDePagamento, Desconto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
													PreparedStatement pst = conexao.prepareStatement(query);
													pst.setString(1, txtIdDoClienteVendaAtacado.getText());
													pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
													pst.setString(3, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 1).toString());
													pst.setString(4, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 2).toString());
													pst.setString(5, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 3).toString());
													pst.setString(6,  txt_NumeroDaVendaAtacado.getText());
													pst.setString(7, "Cartão");
													pst.setString(8,  textField_DescontoVendaAtacado.getText());
													pst.execute();
													pst.close();
													contador++;
												} catch (Exception g) {
													g.printStackTrace();
												}
										}	
										NumeroDaVenda();
										AtualizarNumeroDaVenda();
										NumeroDaVendaToPDF();
										DocumentoVendaAtacado();
										refreshtableProdutosVendaAtacado();
										limpadorDeDadosVendaAtacado();
										JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
										while (carrinhoVendaAtacado.getRowCount() > 0) {
											carrinhoVendaAtacado.removeRow(carrinhoVendaAtacado.getRowCount()-1);
										}
										}
							}	
					}else if (chckbxAPagarVendaAtacado.isSelected()) {
						if (JOptionPane.showConfirmDialog(null, "Deseja finalizar a venda?", "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
							int contador = 0;
							if(chckbxDinheiroVendaAtacado.isSelected() && chckbxCartaoVendaAtacado.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(!chckbxDinheiroVendaAtacado.isSelected() && !chckbxCartaoVendaAtacado.isSelected()) {
									JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
									}else if(chckbxDinheiroVendaAtacado.isSelected()) {
										while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.vendaatacado (IDCliente, IDProduto, produto, quantidade, preco, NumeroDaVenda, FormaDePagamento, Desconto, PagarFuturo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, txtIdDoClienteVendaAtacado.getText());
												pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
												pst.setString(3, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 1).toString());
												pst.setString(4, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 2).toString());
												pst.setString(5, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 3).toString());
												pst.setString(6,  txt_NumeroDaVendaAtacado.getText());
												pst.setString(7, "Dinheiro");
												pst.setString(8,  textField_DescontoVendaAtacado.getText());
												pst.setString(9,  "Sim");
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}
									}	
									NumeroDaVenda();
									AtualizarNumeroDaVenda();
									NumeroDaVendaToPDF();
									DocumentoVendaAtacado();
									refreshtableProdutosVendaAtacado();
									limpadorDeDadosVendaAtacado();
									JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
									while (carrinhoVendaAtacado.getRowCount() > 0) {
										carrinhoVendaAtacado.removeRow(carrinhoVendaAtacado.getRowCount()-1);
									}
										}else if(chckbxCartaoVendaAtacado.isSelected()) {
											while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
												try {
													String query = "INSERT INTO adegagelaguela.vendaatacado (IDCliente, IDProduto, produto, quantidade, preco, NumeroDaVenda, FormaDePagamento, Desconto, PagarFuturo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
													PreparedStatement pst = conexao.prepareStatement(query);
													pst.setString(1, txtIdDoClienteVendaAtacado.getText());
													pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
													pst.setString(3, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 1).toString());
													pst.setString(4, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 2).toString());
													pst.setString(5, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 3).toString());
													pst.setString(6,  txt_NumeroDaVendaAtacado.getText());
													pst.setString(7, "Cartão");
													pst.setString(8,  textField_DescontoVendaAtacado.getText());
													pst.setString(8,  "Sim");
													pst.execute();
													pst.close();
													contador++;
												} catch (Exception g) {
													g.printStackTrace();
												}
										}	
										NumeroDaVenda();
										AtualizarNumeroDaVenda();
										NumeroDaVendaToPDF();
										DocumentoVendaAtacado();
										refreshtableProdutosVendaAtacado();
										limpadorDeDadosVendaAtacado();
										JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
										while (carrinhoVendaAtacado.getRowCount() > 0) {
											carrinhoVendaAtacado.removeRow(carrinhoVendaAtacado.getRowCount()-1);
										}
							
							}
						}
					}
				}else {JOptionPane.showMessageDialog(null, "Selecione um cliente!", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButtonVenderVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		vendaAtacado.add(btnNewButtonVenderVendaAtacado);
		
		JLabel lblNewLabel_DescontoVendaAtacado = new JLabel("Desconto R$:");
		lblNewLabel_DescontoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\money-delete-icon.png"));
		lblNewLabel_DescontoVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_DescontoVendaAtacado.setBounds(518, 259, 115, 41);
		vendaAtacado.add(lblNewLabel_DescontoVendaAtacado);
		
		textField_DescontoVendaAtacado = new JTextField();
		textField_DescontoVendaAtacado.setText("0");
		textField_DescontoVendaAtacado.setBounds(642, 270, 117, 20);
		vendaAtacado.add(textField_DescontoVendaAtacado);
		textField_DescontoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_NumeroDeVendaAtacado = new JLabel("Venda :");
		lblNewLabel_NumeroDeVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_NumeroDeVendaAtacado.setBounds(446, 523, 52, 20);
		vendaAtacado.add(lblNewLabel_NumeroDeVendaAtacado);
		
		txt_NumeroDaVendaAtacado = new JTextField();
		txt_NumeroDaVendaAtacado.setText(NumeroDaVenda().toString());
		txt_NumeroDaVendaAtacado.setEditable(false);
		txt_NumeroDaVendaAtacado.setBounds(504, 523, 86, 20);
		vendaAtacado.add(txt_NumeroDaVendaAtacado);
		txt_NumeroDaVendaAtacado.setColumns(10);
		
		textField_PrecoParaOCarrinhoVendaAtacado = new JTextField();
		textField_PrecoParaOCarrinhoVendaAtacado.setVisible(false);
		textField_PrecoParaOCarrinhoVendaAtacado.setBounds(298, 99, 19, 20);
		vendaAtacado.add(textField_PrecoParaOCarrinhoVendaAtacado);
		textField_PrecoParaOCarrinhoVendaAtacado.setColumns(10);
		
		JButton btnNewButtonVoltarMenuVendaAtacado = new JButton("");
		btnNewButtonVoltarMenuVendaAtacado.setBorderPainted(false);
		btnNewButtonVoltarMenuVendaAtacado.setVerifyInputWhenFocusTarget(false);
		btnNewButtonVoltarMenuVendaAtacado.setRequestFocusEnabled(false);
		btnNewButtonVoltarMenuVendaAtacado.setFocusable(false);
		btnNewButtonVoltarMenuVendaAtacado.setFocusTraversalKeysEnabled(false);
		btnNewButtonVoltarMenuVendaAtacado.setFocusPainted(false);
		btnNewButtonVoltarMenuVendaAtacado.setBorderPainted(false);
		btnNewButtonVoltarMenuVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				vendaAtacado.setVisible(false);
			}
		});
		btnNewButtonVoltarMenuVendaAtacado.setOpaque(false);
		btnNewButtonVoltarMenuVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\BotaoVolta.png"));
		btnNewButtonVoltarMenuVendaAtacado.setBounds(0, 20, 25, 20);
		vendaAtacado.add(btnNewButtonVoltarMenuVendaAtacado);
		
		JLabel lblNewLabel_FundoVendaAtacado = new JLabel("");
		lblNewLabel_FundoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\FundoVendaAtacado.jpg"));
		lblNewLabel_FundoVendaAtacado.setBounds(0, 0, 790, 565);
		vendaAtacado.add(lblNewLabel_FundoVendaAtacado);


		//
		//
		//VENDA PERSONALIZADA
		//
		//

		JMenuBar menuBarVendaPersonalizada = new JMenuBar();
		menuBarVendaPersonalizada.setBounds(0, 0, 934, 22);
		menuBarVendaPersonalizada.setBackground(Color.LIGHT_GRAY);
		vendaPersonalizada.add(menuBarVendaPersonalizada);

		JMenu mnProdutosVendaPersonalizada = new JMenu("Produtos");
		mnProdutosVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarVendaPersonalizada.add(mnProdutosVendaPersonalizada);

		JMenuItem mntmProdutosNaAdegaVendaPersonalizada = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				vendaPersonalizada.setVisible(false);
			}
		});
		mntmProdutosNaAdegaVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmProdutosNaAdegaVendaPersonalizada);

		JMenuItem mntmProdutosEmEstoqueVendaPersonalizada = new JMenuItem("Produtos Em Estoque");
		mntmProdutosEmEstoqueVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmProdutosEmEstoqueVendaPersonalizada);

		JMenuItem mntmTodosOsProdutosVendaPersonalizada;

		JMenuItem mntmProdutosParaComprarVendaPersonalizada = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmProdutosParaComprarVendaPersonalizada);
		mntmTodosOsProdutosVendaPersonalizada = new JMenuItem("Todos Produtos");
		mntmTodosOsProdutosVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosOsProdutosVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmTodosOsProdutosVendaPersonalizada);

		JMenu mnVenderVendaPersonalizada = new JMenu("Vender");
		mnVenderVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarVendaPersonalizada.add(mnVenderVendaPersonalizada);

		JMenuItem mntmVendaVarejoVendaPersonalizada = new JMenuItem("Venda Varejo");
		mntmVendaVarejoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderVendaPersonalizada.add(mntmVendaVarejoVendaPersonalizada);

		
		JMenuItem mntmVendaAtacadoVendaPersonalizada = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderVendaPersonalizada.add(mntmVendaAtacadoVendaPersonalizada);
		
				JMenuItem mntmVendaPersonalizada = new JMenuItem("Venda Personalizada");
				mntmVendaPersonalizada.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				mntmVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
				mnVenderVendaPersonalizada.add(mntmVendaPersonalizada);
		
		JMenu mnClientesVendaPersonalizada = new JMenu("Clientes");
		mnClientesVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarVendaPersonalizada.add(mnClientesVendaPersonalizada);
		
		JMenuItem mntmNewMenuItemClientesAtacadoVendaPersonalizada = new JMenuItem("Clientes Atacado");
		mntmNewMenuItemClientesAtacadoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				clientesAtacado.setVisible(true);
			}
		});
		mntmNewMenuItemClientesAtacadoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesVendaPersonalizada.add(mntmNewMenuItemClientesAtacadoVendaPersonalizada);
		
		JMenu mnFinanceiroVendaPersonalizada = new JMenu("Financeiro");
		mnFinanceiroVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarVendaPersonalizada.add(mnFinanceiroVendaPersonalizada);
		
		JMenuItem mntmRelatorioDeVendasVendaPersonalizada = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendasVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				relatorioDeVendas.setVisible(true);
			}
		});
		mntmRelatorioDeVendasVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroVendaPersonalizada.add(mntmRelatorioDeVendasVendaPersonalizada);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial_7 = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1_6 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_6.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroVendaPersonalizada.add(mnNewMenu_1_6);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosProdutosnaAdega_6 = new JMenuItem("Atacado");
		mntmNewMenuItemRelatorioDeProdutosProdutosnaAdega_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mntmNewMenuItemRelatorioDeProdutosProdutosnaAdega_6.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnNewMenu_1_6.add(mntmNewMenuItemRelatorioDeProdutosProdutosnaAdega_6);
		
		JMenuItem mntmVarejo_6 = new JMenuItem("Varejo");
		mntmVarejo_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo_6.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_6.add(mntmVarejo_6);
		mntmNewMenuItemBancoFinanceiroMenuUnicial_7.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroVendaPersonalizada.add(mntmNewMenuItemBancoFinanceiroMenuUnicial_7);

		JMenu mnAjudaVendaPersonalizada = new JMenu("Ajuda");
		mnAjudaVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarVendaPersonalizada.add(mnAjudaVendaPersonalizada);

		JMenuItem mntmDadosDaVersaoVendaPersonalizada = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaVendaPersonalizada.add(mntmDadosDaVersaoVendaPersonalizada);
		
		JLabel lblNewLabel_EscolherProdutoVendaAtacado = new JLabel("Dados do Produto para Venda:");
		lblNewLabel_EscolherProdutoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-And-Pretzel-icon.png"));
		lblNewLabel_EscolherProdutoVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_EscolherProdutoVendaAtacado.setBounds(37, 43, 256, 24);
		vendaPersonalizada.add(lblNewLabel_EscolherProdutoVendaAtacado);
		
		textFieldNomeProdutoVendaPersonalizada = new JTextField();
		textFieldNomeProdutoVendaPersonalizada.setEditable(false);
		textFieldNomeProdutoVendaPersonalizada.setBounds(179, 80, 147, 20);
		vendaPersonalizada.add(textFieldNomeProdutoVendaPersonalizada);
		textFieldNomeProdutoVendaPersonalizada.setColumns(10);
		
		textField_QuantidadeVendaPersonalizada = new JTextField();
		textField_QuantidadeVendaPersonalizada.setBounds(211, 140, 115, 20);
		vendaPersonalizada.add(textField_QuantidadeVendaPersonalizada);
		textField_QuantidadeVendaPersonalizada.setColumns(10);
		
		textField_ValorProdutoVendaPersonalizada = new JTextField();
		textField_ValorProdutoVendaPersonalizada.setEditable(false);
		textField_ValorProdutoVendaPersonalizada.setBounds(211, 110, 115, 20);
		vendaPersonalizada.add(textField_ValorProdutoVendaPersonalizada);
		textField_ValorProdutoVendaPersonalizada.setColumns(10);
		
		textField_PrecoVendaPersonalizada = new JTextField();
		textField_PrecoVendaPersonalizada.setBounds(211, 170, 115, 20);
		vendaPersonalizada.add(textField_PrecoVendaPersonalizada);
		textField_PrecoVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_NomeProdutoVendaPersonalizada = new JLabel("Nome do Produto :");
		lblNewLabel_NomeProdutoVendaPersonalizada.setBounds(37, 80, 107, 20);
		vendaPersonalizada.add(lblNewLabel_NomeProdutoVendaPersonalizada);
		
		JLabel lblNewLabel_QuantidadeParaVendaVendaPersonalizada = new JLabel("Quantidade para Venda :");
		lblNewLabel_QuantidadeParaVendaVendaPersonalizada.setBounds(37, 140, 164, 20);
		vendaPersonalizada.add(lblNewLabel_QuantidadeParaVendaVendaPersonalizada);
		
		JLabel lblNewLabel_PrecoPersVendaPersonalizada = new JLabel("Valor Pre\u00E7o Personalizado :");
		lblNewLabel_PrecoPersVendaPersonalizada.setBounds(37, 170, 178, 20);
		vendaPersonalizada.add(lblNewLabel_PrecoPersVendaPersonalizada);
		
		JLabel lblNewLabel_ValorProdutoVendaPersonalizada = new JLabel("Valor Padr\u00E3o do Produto :");
		lblNewLabel_ValorProdutoVendaPersonalizada.setBounds(37, 110, 178, 20);
		vendaPersonalizada.add(lblNewLabel_ValorProdutoVendaPersonalizada);
		
		JScrollPane scrollPaneProdutosVendaPersonalizada = new JScrollPane();
		scrollPaneProdutosVendaPersonalizada.setBounds(356, 63, 390, 172);
		vendaPersonalizada.add(scrollPaneProdutosVendaPersonalizada);
		
		tableProdutosVendaPersonalizada = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
		tableProdutosVendaPersonalizada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosVendaPersonalizada.getSelectedRow();
				textFieldIDVendaPersonalizada.setText(tableProdutosVendaPersonalizada.getValueAt(linha, 0).toString());
				textFieldNomeProdutoVendaPersonalizada.setText(tableProdutosVendaPersonalizada.getValueAt(linha, 1).toString());
				textField_ValorProdutoVendaPersonalizada.setText("R$ :  " + tableProdutosVendaPersonalizada.getValueAt(linha, 3).toString() + "0");
			}
		});
		scrollPaneProdutosVendaPersonalizada.setViewportView(tableProdutosVendaPersonalizada);
		
		JButton btnNewButtonProdutosVendaPersonalizada = new JButton("Produtos");
		btnNewButtonProdutosVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT idEstoque 'ID', Produto, QuantidadeAtual 'Qnt disponível', PrecoDeCusto 'Preço' FROM adegagelaguela.estoque ORDER BY Produto";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableProdutosVendaPersonalizada.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButtonProdutosVendaPersonalizada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonProdutosVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-icon.png"));
		btnNewButtonProdutosVendaPersonalizada.setBounds(496, 32, 124, 20);
		vendaPersonalizada.add(btnNewButtonProdutosVendaPersonalizada);
		
		textFieldIDVendaPersonalizada = new JTextField();
		textFieldIDVendaPersonalizada.setVisible(false);
		textFieldIDVendaPersonalizada.setBounds(264, 58, 10, 11);
		vendaPersonalizada.add(textFieldIDVendaPersonalizada);
		textFieldIDVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_CompradorVendaAtacado = new JLabel("Dados do Comprador para Venda :");
		lblNewLabel_CompradorVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_CompradorVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\TV-Johny-Cash-icon.png"));
		lblNewLabel_CompradorVendaAtacado.setBounds(36, 240, 273, 24);
		vendaPersonalizada.add(lblNewLabel_CompradorVendaAtacado);
		
		JLabel lblNewLabel_NomeClienteVendaPersonalizada = new JLabel("Nome do Cliente :");
		lblNewLabel_NomeClienteVendaPersonalizada.setBounds(37, 275, 107, 20);
		vendaPersonalizada.add(lblNewLabel_NomeClienteVendaPersonalizada);
		
		textField_NomeClienteVendaPersonalizada = new JTextField();
		textField_NomeClienteVendaPersonalizada.setBounds(143, 275, 302, 20);
		vendaPersonalizada.add(textField_NomeClienteVendaPersonalizada);
		textField_NomeClienteVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_CPFRGVendaPersonalizada = new JLabel("CPF ou RG :");
		lblNewLabel_CPFRGVendaPersonalizada.setBounds(260, 306, 67, 20);
		vendaPersonalizada.add(lblNewLabel_CPFRGVendaPersonalizada);
		
		textField_CPFRGVendaPersonalizada = new JTextField();
		textField_CPFRGVendaPersonalizada.setBounds(330, 306, 115, 20);
		vendaPersonalizada.add(textField_CPFRGVendaPersonalizada);
		textField_CPFRGVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_EmailVendaPersonalizada = new JLabel("Email :");
		lblNewLabel_EmailVendaPersonalizada.setBounds(37, 304, 86, 20);
		vendaPersonalizada.add(lblNewLabel_EmailVendaPersonalizada);
		
		textField_EmailVendaPersonalizada = new JTextField();
		textField_EmailVendaPersonalizada.setBounds(81, 306, 164, 20);
		vendaPersonalizada.add(textField_EmailVendaPersonalizada);
		textField_EmailVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_Carrinho = new JLabel("Carrinho de Compras :");
		lblNewLabel_Carrinho.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-down-icon.png"));
		lblNewLabel_Carrinho.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_Carrinho.setBounds(37, 370, 178, 24);
		vendaPersonalizada.add(lblNewLabel_Carrinho);
		
		JScrollPane scrollPaneCarrinhoVendaPersonalizada = new JScrollPane();
		scrollPaneCarrinhoVendaPersonalizada.setBounds(37, 407, 529, 107);
		vendaPersonalizada.add(scrollPaneCarrinhoVendaPersonalizada);
	
		
		tableCarrinhoVendaPersonalizada = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
	    DefaultTableModel carrinhoVendaPersonalizada = (DefaultTableModel) tableCarrinhoVendaPersonalizada.getModel();
		carrinhoVendaPersonalizada.addColumn("ID");
		carrinhoVendaPersonalizada.addColumn("Produto");
		carrinhoVendaPersonalizada.addColumn("Preço");
		carrinhoVendaPersonalizada.addColumn("Quantidade");
		carrinhoVendaPersonalizada.addColumn("Valor do Produto");
		scrollPaneCarrinhoVendaPersonalizada.setViewportView(tableCarrinhoVendaPersonalizada);
	
		JButton btnNewButtonAddCarinhoVendaPersonalizada = new JButton("Adicionar ao Carrinho");
		btnNewButtonAddCarinhoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldIDVendaPersonalizada.getText().equals("")) {
					if(!textField_QuantidadeVendaPersonalizada.getText().equals("") && !textField_QuantidadeVendaPersonalizada.getText().equals("0")&& 
							!textField_QuantidadeVendaPersonalizada.getText().equals("00")&& !textField_QuantidadeVendaPersonalizada.getText().equals("000")) {
						if(!textField_PrecoVendaPersonalizada.getText().equals("")) {
							 double precovenda = Double.parseDouble(textField_PrecoVendaPersonalizada.getText().toString());
							 double quantiavenda = Double.parseDouble(textField_QuantidadeVendaPersonalizada.getText().toString());
							 String total = String.valueOf(precovenda * quantiavenda);
							 valorCarrinhoPersonalizada = valorCarrinhoPersonalizada+ precovenda * quantiavenda;
							carrinhoVendaPersonalizada.addRow(new String [] {textFieldIDVendaPersonalizada.getText(), textFieldNomeProdutoVendaPersonalizada.getText(), textField_PrecoVendaPersonalizada.getText(), textField_QuantidadeVendaPersonalizada.getText(), total});
						}else JOptionPane.showMessageDialog(null, "Adicione o valor personalizado!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Quantidade não pode estar vazia ou ser '0' !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela ao lado !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				AttValorTotalPersonalizada();
			}
		});
		btnNewButtonAddCarinhoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnNewButtonAddCarinhoVendaPersonalizada.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButtonAddCarinhoVendaPersonalizada.setBounds(179, 201, 149, 23);
		vendaPersonalizada.add(btnNewButtonAddCarinhoVendaPersonalizada);
		
		JButton btnRemoverDoCarrinhoVendaPersonalizada = new JButton("Remover do Carrinho");
		btnRemoverDoCarrinhoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorCarrinhoPersonalizada =  valorCarrinhoPersonalizada - Double.parseDouble(tableCarrinhoVendaPersonalizada.getValueAt(tableCarrinhoVendaPersonalizada.getSelectedRow(), 4).toString());
				carrinhoVendaPersonalizada.removeRow(tableCarrinhoVendaPersonalizada.getSelectedRow());
				AttValorTotalPersonalizada();
			}
		});
		btnRemoverDoCarrinhoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnRemoverDoCarrinhoVendaPersonalizada.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRemoverDoCarrinhoVendaPersonalizada.setBounds(39, 525, 149, 23);
		vendaPersonalizada.add(btnRemoverDoCarrinhoVendaPersonalizada);
		
		JLabel lblNewLabel_TelefoneVendaPersonalizada = new JLabel("Telefone :");
		lblNewLabel_TelefoneVendaPersonalizada.setBounds(37, 339, 107, 20);
		vendaPersonalizada.add(lblNewLabel_TelefoneVendaPersonalizada);
		
		textField_TelefoneVendaPersonalizada = new JTextField();
		textField_TelefoneVendaPersonalizada.setBounds(102, 339, 86, 20);
		vendaPersonalizada.add(textField_TelefoneVendaPersonalizada);
		textField_TelefoneVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_EmrpesaVendaPersonalizada = new JLabel("Empresa :");
		lblNewLabel_EmrpesaVendaPersonalizada.setBounds(212, 339, 81, 20);
		vendaPersonalizada.add(lblNewLabel_EmrpesaVendaPersonalizada);
		
		textField_EmpresaVendaPersonalizada = new JTextField();
		textField_EmpresaVendaPersonalizada.setBounds(281, 341, 164, 20);
		vendaPersonalizada.add(textField_EmpresaVendaPersonalizada);
		textField_EmpresaVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_NumeroDeVendaPersonalizada = new JLabel("Venda :");
		lblNewLabel_NumeroDeVendaPersonalizada.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_NumeroDeVendaPersonalizada.setBounds(482, 526, 52, 20);
		vendaPersonalizada.add(lblNewLabel_NumeroDeVendaPersonalizada);
		
		txt_NmrVendaVendaPersonalizada = new JTextField();
		txt_NmrVendaVendaPersonalizada.setText("a");
		txt_NmrVendaVendaPersonalizada.setEditable(false);
		txt_NmrVendaVendaPersonalizada.setColumns(10);
		txt_NmrVendaVendaPersonalizada.setBounds(534, 526, 86, 20);
		vendaPersonalizada.add(txt_NmrVendaVendaPersonalizada);
		txt_NmrVendaVendaPersonalizada.setText(NumeroDaVendaPersonalizada().toString());
		
		JLabel lblNewLabel_FormaDePagamentoVendaPersonalizada = new JLabel("Forma de Pagamento :");
		lblNewLabel_FormaDePagamentoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon.png"));
		lblNewLabel_FormaDePagamentoVendaPersonalizada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_FormaDePagamentoVendaPersonalizada.setBounds(556, 241, 216, 24);
		vendaPersonalizada.add(lblNewLabel_FormaDePagamentoVendaPersonalizada);
		
		JCheckBox chckbxNewCheckBoxDinheiroVendaPersonalizada = new JCheckBox("Dinheiro");
		chckbxNewCheckBoxDinheiroVendaPersonalizada.setContentAreaFilled(false);
		chckbxNewCheckBoxDinheiroVendaPersonalizada.setBounds(586, 274, 97, 23);
		vendaPersonalizada.add(chckbxNewCheckBoxDinheiroVendaPersonalizada);
		
		JCheckBox chckbxNewCheckBoxCartaoVendaPersonalizada = new JCheckBox("Cart\u00E3o");
		chckbxNewCheckBoxCartaoVendaPersonalizada.setContentAreaFilled(false);
		chckbxNewCheckBoxCartaoVendaPersonalizada.setBounds(586, 305, 97, 23);
		vendaPersonalizada.add(chckbxNewCheckBoxCartaoVendaPersonalizada);
		
		JCheckBox chckbxPagamentoFuturoVendaPersonalizada = new JCheckBox("Pagamento Futuro");
		chckbxPagamentoFuturoVendaPersonalizada.setContentAreaFilled(false);
		chckbxPagamentoFuturoVendaPersonalizada.setBounds(586, 338, 135, 23);
		vendaPersonalizada.add(chckbxPagamentoFuturoVendaPersonalizada);
		
		JButton btnNewButtonVenderVendaPersonalizada = new JButton("Vender");
		btnNewButtonVenderVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_NomeClienteVendaPersonalizada.getText().equals("")){
					if(!chckbxPagamentoFuturoVendaPersonalizada.isSelected()) {
						if (JOptionPane.showConfirmDialog(null, "Venda no valor de" + txtValorTotal.getText().toString(), "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
							int contador = 0;
							if(chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected() && chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(!chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected() && !chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
									JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
									}else if(chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected()) {
										while(tableCarrinhoVendaPersonalizada.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.vendapersonalizada (Produto_ID, NomeProduto, Preco, QuantidadeProduto, NomeCliente, Email, Telefone, Empresa, CPFouRG, NumeroDaVenda, FormaDePagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, tableCarrinhoVendaPersonalizada.getValueAt(contador, 0).toString());
												pst.setString(2, tableCarrinhoVendaPersonalizada.getValueAt(contador, 1).toString());
												pst.setString(3, tableCarrinhoVendaPersonalizada.getValueAt(contador, 2).toString());
												pst.setString(4, tableCarrinhoVendaPersonalizada.getValueAt(contador, 3).toString());
												pst.setString(5, textField_NomeClienteVendaPersonalizada.getText());
												pst.setString(6, textField_EmailVendaPersonalizada.getText());
												pst.setString(7, textField_TelefoneVendaPersonalizada.getText());
												pst.setString(8, textField_EmpresaVendaPersonalizada.getText());
												pst.setString(9, textField_CPFRGVendaPersonalizada.getText());
												pst.setString(10, txt_NmrVendaVendaPersonalizada.getText());
												pst.setString(11, "Dinheiro");
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}
									}	
										JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
										limpadorDeDadosVendaPersonalizada();
										DocumentoVendaPersonalizada();
										NumeroDaVenda();
										AtualizarNumeroDaVenda();
										while (carrinhoVendaPersonalizada.getRowCount() > 0) {
											carrinhoVendaPersonalizada.removeRow(carrinhoVendaPersonalizada.getRowCount()-1);
										}
										}else if(chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
											while(tableCarrinhoVendaPersonalizada.getRowCount() != contador) {
												try {
													String query = "INSERT INTO adegagelaguela.vendapersonalizada (Produto_ID, NomeProduto, Preco, QuantidadeProduto, NomeCliente, Email, Telefone, Empresa, CPFouRG, NumeroDaVenda, FormaDePagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
													PreparedStatement pst = conexao.prepareStatement(query);
													pst.setString(1, tableCarrinhoVendaPersonalizada.getValueAt(contador, 0).toString());
													pst.setString(2, tableCarrinhoVendaPersonalizada.getValueAt(contador, 1).toString());
													pst.setString(3, tableCarrinhoVendaPersonalizada.getValueAt(contador, 2).toString());
													pst.setString(4, tableCarrinhoVendaPersonalizada.getValueAt(contador, 3).toString());
													pst.setString(5, textField_NomeClienteVendaPersonalizada.getText());
													pst.setString(6, textField_EmailVendaPersonalizada.getText());
													pst.setString(7, textField_TelefoneVendaPersonalizada.getText());
													pst.setString(8, textField_EmpresaVendaPersonalizada.getText());
													pst.setString(9, textField_CPFRGVendaPersonalizada.getText());
													pst.setString(10, txt_NmrVendaVendaPersonalizada.getText());
													pst.setString(11, "Cartão");
													pst.execute();
													pst.close();
													contador++;
												} catch (Exception g) {
													g.printStackTrace();
												}
										}	
											while (carrinhoVendaPersonalizada.getRowCount() > 0) {
												carrinhoVendaPersonalizada.removeRow(carrinhoVendaPersonalizada.getRowCount()-1);
											}
											JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
											DocumentoVendaPersonalizada();
											NumeroDaVenda();
											AtualizarNumeroDaVenda();
											limpadorDeDadosVendaPersonalizada();
							}
						}	
					}else if (chckbxPagamentoFuturoVendaPersonalizada.isSelected()) {
						if (JOptionPane.showConfirmDialog(null, "Deseja finalizar a venda?", "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
							int contador = 0;
							if(chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected() && chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(!chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected() && !chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
									JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
									}else if(chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected()) {
										while(tableCarrinhoVendaPersonalizada.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.vendapersonalizada (Produto_ID, NomeProduto, Preco, QuantidadeProduto, NomeCliente, Email, Telefone, Empresa, CPFouRG, NumeroDaVenda, FormaDePagamento, PagamentoFuturo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, tableCarrinhoVendaPersonalizada.getValueAt(contador, 0).toString());
												pst.setString(2, tableCarrinhoVendaPersonalizada.getValueAt(contador, 1).toString());
												pst.setString(3, tableCarrinhoVendaPersonalizada.getValueAt(contador, 2).toString());
												pst.setString(4, tableCarrinhoVendaPersonalizada.getValueAt(contador, 3).toString());
												pst.setString(5, textField_NomeClienteVendaPersonalizada.getText());
												pst.setString(6, textField_EmailVendaPersonalizada.getText());
												pst.setString(7, textField_TelefoneVendaPersonalizada.getText());
												pst.setString(8, textField_EmpresaVendaPersonalizada.getText());
												pst.setString(9, textField_CPFRGVendaPersonalizada.getText());
												pst.setString(10, txt_NmrVendaVendaPersonalizada.getText());
												pst.setString(11, "Dinheiro");
												pst.setString(12, "Sim");
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}
									}	
									while (carrinhoVendaPersonalizada.getRowCount() > 0) {
										carrinhoVendaPersonalizada.removeRow(carrinhoVendaPersonalizada.getRowCount()-1);
									}
									DocumentoVendaPersonalizada();
									NumeroDaVenda();
									AtualizarNumeroDaVenda();
									limpadorDeDadosVendaPersonalizada();
									JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
										}else if(chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
											while(tableCarrinhoVendaPersonalizada.getRowCount() != contador) {
												try {
													String query = "INSERT INTO adegagelaguela.vendapersonalizada (Produto_ID, NomeProduto, Preco, QuantidadeProduto, NomeCliente, Email, Telefone, Empresa, CPFouRG, NumeroDaVenda, FormaDePagamento, PagamentoFuturo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
													PreparedStatement pst = conexao.prepareStatement(query);
													pst.setString(1, tableCarrinhoVendaPersonalizada.getValueAt(contador, 0).toString());
													pst.setString(2, tableCarrinhoVendaPersonalizada.getValueAt(contador, 1).toString());
													pst.setString(3, tableCarrinhoVendaPersonalizada.getValueAt(contador, 2).toString());
													pst.setString(4, tableCarrinhoVendaPersonalizada.getValueAt(contador, 3).toString());
													pst.setString(5, textField_NomeClienteVendaPersonalizada.getText());
													pst.setString(6, textField_EmailVendaPersonalizada.getText());
													pst.setString(7, textField_TelefoneVendaPersonalizada.getText());
													pst.setString(8, textField_EmpresaVendaPersonalizada.getText());
													pst.setString(9, textField_CPFRGVendaPersonalizada.getText());
													pst.setString(10, txt_NmrVendaVendaPersonalizada.getText());
													pst.setString(11, "Cartão");
													pst.setString(12, "Sim");
													pst.execute();
													pst.close();
													contador++;
												} catch (Exception g) {
													g.printStackTrace();
												}
											}
										while (carrinhoVendaPersonalizada.getRowCount() > 0) {
											carrinhoVendaPersonalizada.removeRow(carrinhoVendaPersonalizada.getRowCount()-1);
										}
										DocumentoVendaPersonalizada();
										NumeroDaVenda();
										AtualizarNumeroDaVenda();
										limpadorDeDadosVendaPersonalizada();
									JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
				}else 
					JOptionPane.showMessageDialog(null, "Digite ao menos o nome do cliente", "Erro!!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButtonVenderVendaPersonalizada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonVenderVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		btnNewButtonVenderVendaPersonalizada.setBounds(631, 525, 141, 22);
		vendaPersonalizada.add(btnNewButtonVenderVendaPersonalizada);
		
		JLabel lblNewLabel_8 = new JLabel("Valor Total do Carrinho :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Coin-us-dollar-icon.png"));
		lblNewLabel_8.setBounds(576, 402, 196, 24);
		vendaPersonalizada.add(lblNewLabel_8);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setText("R$: "+ valorCarrinhoPersonalizada.toString() +"0");
		txtValorTotal.setBounds(589, 429, 157, 20);
		vendaPersonalizada.add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		JButton btnNewButtonMenuInicialVendaPersonalizada = new JButton("");
		btnNewButtonMenuInicialVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				menuInicial.setVisible(true);
			}
		});
		btnNewButtonMenuInicialVendaPersonalizada.setContentAreaFilled(false);
		btnNewButtonMenuInicialVendaPersonalizada.setBorderPainted(false);
		btnNewButtonMenuInicialVendaPersonalizada.setOpaque(false);
		btnNewButtonMenuInicialVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\BotaoVolta.png"));
		btnNewButtonMenuInicialVendaPersonalizada.setBounds(0, 25, 16, 16);
		vendaPersonalizada.add(btnNewButtonMenuInicialVendaPersonalizada);
		
		JLabel lblNewLabel_FundoVendaPersonalizada = new JLabel("");
		lblNewLabel_FundoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\FundoVendaPersonalizada.jpg"));
		lblNewLabel_FundoVendaPersonalizada.setBounds(0, 0, 790, 565);
		vendaPersonalizada.add(lblNewLabel_FundoVendaPersonalizada);
		clientesAtacado.setLayout(null);
		
		
		
		
		//
		//
		//Clientes Atacado
		//
		//
		
		

		JMenuBar menuBarclientesAtacado = new JMenuBar();
		menuBarclientesAtacado.setBackground(Color.LIGHT_GRAY);
		menuBarclientesAtacado.setBounds(0, 0, 934, 22);
		clientesAtacado.add(menuBarclientesAtacado);

		JMenu mnProdutosclientesAtacado = new JMenu("Produtos");
		mnProdutosclientesAtacado.setToolTipText("");
		mnProdutosclientesAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarclientesAtacado.add(mnProdutosclientesAtacado);

		JMenuItem mntmProdutosNaAdegaclientesAtacado = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaclientesAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(false);
				produtosNaAdega.setVisible(true);
			}
		});
		mntmProdutosNaAdegaclientesAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosclientesAtacado.add(mntmProdutosNaAdegaclientesAtacado);

		JMenuItem mntmProdutosEmEstoqueclientesAtacado = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueclientesAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueclientesAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosclientesAtacado.add(mntmProdutosEmEstoqueclientesAtacado);

		JMenuItem mntmProdutosParaComprarclientesAtacado = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarclientesAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarclientesAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosclientesAtacado.add(mntmProdutosParaComprarclientesAtacado);

		JMenuItem mntmTodosProdutosclientesAtacado = new JMenuItem("Todos Produtos");
		mntmTodosProdutosclientesAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clientesAtacado.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosclientesAtacado.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosclientesAtacado.add(mntmTodosProdutosclientesAtacado);

		JMenu mnVenderclientesAtacado = new JMenu("Vender");
		mnVenderclientesAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarclientesAtacado.add(mnVenderclientesAtacado);

		JMenuItem mntmVendaVarejoclientesAtacado = new JMenuItem("Venda Varejo");
		mntmVendaVarejoclientesAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoclientesAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderclientesAtacado.add(mntmVendaVarejoclientesAtacado);

		JMenuItem mntmVendaAtacadoclientesAtacado = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoclientesAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoclientesAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderclientesAtacado.add(mntmVendaAtacadoclientesAtacado);

		JMenuItem mntmVendaPersonalizadaclientesAtacado = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaclientesAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaclientesAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderclientesAtacado.add(mntmVendaPersonalizadaclientesAtacado);
		
		JMenu mnClientesclientesAtacado = new JMenu("Clientes");
		mnClientesclientesAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarclientesAtacado.add(mnClientesclientesAtacado);
		
		JMenuItem mntmNewMenuItem1 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesclientesAtacado.add(mntmNewMenuItem1);

		JMenu mnFinanceiroclientesAtacado = new JMenu("Financeiro");
		mnFinanceiroclientesAtacado.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarclientesAtacado.add(mnFinanceiroclientesAtacado);
		
		JMenuItem mntmRelatorioDeVendasClientesAtacado = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendasClientesAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(false);
				relatorioDeVendas.setVisible(true);
			}
		});
		mntmRelatorioDeVendasClientesAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroclientesAtacado.add(mntmRelatorioDeVendasClientesAtacado);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial_8 = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1_7 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_7.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroclientesAtacado.add(mnNewMenu_1_7);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosClientes = new JMenuItem("Atacado");
		mnNewMenu_1_7.add(mntmNewMenuItemRelatorioDeProdutosClientes);
		mntmNewMenuItemRelatorioDeProdutosClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mntmNewMenuItemRelatorioDeProdutosClientes.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo_7 = new JMenuItem("Varejo");
		mntmVarejo_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo_7.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_7.add(mntmVarejo_7);
		mntmNewMenuItemBancoFinanceiroMenuUnicial_8.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroclientesAtacado.add(mntmNewMenuItemBancoFinanceiroMenuUnicial_8);

		JMenu mnAjudaclientesAtacado = new JMenu("Ajuda");
		mnAjudaclientesAtacado.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarclientesAtacado.add(mnAjudaclientesAtacado);

		JMenuItem mntmDadosDaVersaoclientesAtacado = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoclientesAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoclientesAtacado.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaclientesAtacado.add(mntmDadosDaVersaoclientesAtacado);
		
		JButton btnNewButtonClientesClientes = new JButton("Clientes");
		btnNewButtonClientesClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTableClientesClientes();
			}
		});
		btnNewButtonClientesClientes.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		btnNewButtonClientesClientes.setBounds(640, 337, 132, 20);
		clientesAtacado.add(btnNewButtonClientesClientes);
		
		textFieldNmrDeCliente = new JTextField();
		textFieldNmrDeCliente.setEditable(false);
		textFieldNmrDeCliente.setBounds(127, 525, 44, 20);
		clientesAtacado.add(textFieldNmrDeCliente);
		textFieldNmrDeCliente.setColumns(10);
		
		JLabel lblNewLabel_TotalDeClientesClientes = new JLabel("Total de Clientes :");
		lblNewLabel_TotalDeClientesClientes.setForeground(Color.WHITE);
		lblNewLabel_TotalDeClientesClientes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_TotalDeClientesClientes.setBounds(10, 525, 107, 20);
		clientesAtacado.add(lblNewLabel_TotalDeClientesClientes);
		
		JLabel lblNewLabel_AdicionarNovoClienteCliente = new JLabel("Dados do Cliente :");
		lblNewLabel_AdicionarNovoClienteCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_AdicionarNovoClienteCliente.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\TV-Johny-Cash-icon.png"));
		lblNewLabel_AdicionarNovoClienteCliente.setBounds(27, 30, 200, 24);
		clientesAtacado.add(lblNewLabel_AdicionarNovoClienteCliente);
		
		JLabel lblNewLabel_NomeCliente = new JLabel("Nome do cliente :");
		lblNewLabel_NomeCliente.setForeground(Color.WHITE);
		lblNewLabel_NomeCliente.setBounds(27, 70, 115, 20);
		clientesAtacado.add(lblNewLabel_NomeCliente);
		

		textFieldIDCliente = new JTextField();
		textFieldIDCliente.setVisible(false);
		textFieldIDCliente.setEditable(false);
		textFieldIDCliente.setBounds(178, 315, 60, 20);
		clientesAtacado.add(textFieldIDCliente);
		textFieldIDCliente.setColumns(10);
		
		textField_NomeDoClienteCliente = new JTextField();
		textField_NomeDoClienteCliente.setBounds(141, 70, 340, 20);
		clientesAtacado.add(textField_NomeDoClienteCliente);
		textField_NomeDoClienteCliente.setColumns(10);
		
		JLabel lblNewLabel_EmpresaCliente = new JLabel("Empresa :");
		lblNewLabel_EmpresaCliente.setBounds(27, 185, 83, 20);
		clientesAtacado.add(lblNewLabel_EmpresaCliente);
		
		textField_EmpresaCliente = new JTextField();
		textField_EmpresaCliente.setBounds(91, 185, 200, 20);
		clientesAtacado.add(textField_EmpresaCliente);
		textField_EmpresaCliente.setColumns(10);
		
		JLabel lblNewLabel_EmailCliente = new JLabel("Email :");
		lblNewLabel_EmailCliente.setForeground(Color.WHITE);
		lblNewLabel_EmailCliente.setBounds(27, 100, 60, 20);
		clientesAtacado.add(lblNewLabel_EmailCliente);
		
		textField_EmailCliente = new JTextField();
		textField_EmailCliente.setBounds(73, 100, 218, 20);
		clientesAtacado.add(textField_EmailCliente);
		textField_EmailCliente.setColumns(10);
		
		JLabel lblNewLabel_Telefone1Cliente = new JLabel("Telefone (1) :");
		lblNewLabel_Telefone1Cliente.setBounds(301, 100, 90, 20);
		clientesAtacado.add(lblNewLabel_Telefone1Cliente);
		
		textField_Telefone1Cliente = new JTextField();
		textField_Telefone1Cliente.setBounds(378, 100, 121, 20);
		clientesAtacado.add(textField_Telefone1Cliente);
		textField_Telefone1Cliente.setColumns(10);
		
		JLabel lblNewLabel_Telefone2Cliente = new JLabel("Telefone (2) :");
		lblNewLabel_Telefone2Cliente.setBounds(509, 100, 90, 20);
		clientesAtacado.add(lblNewLabel_Telefone2Cliente);
		
		textField_Telefone2Cliente = new JTextField();
		textField_Telefone2Cliente.setBounds(587, 100, 121, 20);
		clientesAtacado.add(textField_Telefone2Cliente);
		textField_Telefone2Cliente.setColumns(10);
		
		JLabel lblNewLabel_CPFCliente = new JLabel("CPF :");
		lblNewLabel_CPFCliente.setBounds(500, 70, 46, 20);
		clientesAtacado.add(lblNewLabel_CPFCliente);
		
		textField_CPFCliente = new JTextField();
		textField_CPFCliente.setBounds(542, 70, 166, 20);
		clientesAtacado.add(textField_CPFCliente);
		textField_CPFCliente.setColumns(10);
		
		JLabel lblNewLabel_EnderecoClientes = new JLabel("Endere\u00E7o :");
		lblNewLabel_EnderecoClientes.setBounds(27, 215, 90, 20);
		clientesAtacado.add(lblNewLabel_EnderecoClientes);
		
		textField_EnderecoCliente = new JTextField();
		textField_EnderecoCliente.setBounds(93, 215, 185, 20);
		clientesAtacado.add(textField_EnderecoCliente);
		textField_EnderecoCliente.setColumns(10);
		
		JLabel lblNewLabel_NmrCliente = new JLabel("N\u00BA :");
		lblNewLabel_NmrCliente.setBounds(288, 215, 34, 20);
		clientesAtacado.add(lblNewLabel_NmrCliente);
		
		textField_NmrCliente = new JTextField();
		textField_NmrCliente.setBounds(311, 215, 60, 20);
		clientesAtacado.add(textField_NmrCliente);
		textField_NmrCliente.setColumns(10);
		
		JLabel lblNewLabel_DadosDaEmpresaCliente = new JLabel("Dados da Empresa :");
		lblNewLabel_DadosDaEmpresaCliente.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\drink-4-icon.png"));
		lblNewLabel_DadosDaEmpresaCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_DadosDaEmpresaCliente.setBounds(27, 145, 200, 24);
		clientesAtacado.add(lblNewLabel_DadosDaEmpresaCliente);
		
		JLabel lblNewLabel_TelefoneEmpresa = new JLabel("Telefone da Empresa :");
		lblNewLabel_TelefoneEmpresa.setBounds(468, 185, 132, 20);
		clientesAtacado.add(lblNewLabel_TelefoneEmpresa);
		
		textField_TelEmpresaCliente = new JTextField();
		textField_TelEmpresaCliente.setBounds(601, 185, 107, 20);
		clientesAtacado.add(textField_TelEmpresaCliente);
		textField_TelEmpresaCliente.setColumns(10);
		
		JLabel lblNewLabel_CNPJClientes = new JLabel("CNPJ :");
		lblNewLabel_CNPJClientes.setBounds(301, 185, 46, 20);
		clientesAtacado.add(lblNewLabel_CNPJClientes);
		
		textField_CNPJCliente = new JTextField();
		textField_CNPJCliente.setBounds(351, 185, 107, 20);
		clientesAtacado.add(textField_CNPJCliente);
		textField_CNPJCliente.setColumns(10);
		
		JLabel lblNewLabel_BairroCliente = new JLabel("Bairro :");
		lblNewLabel_BairroCliente.setBounds(383, 215, 46, 20);
		clientesAtacado.add(lblNewLabel_BairroCliente);
		
		textField_BairroCliente = new JTextField();
		textField_BairroCliente.setBounds(431, 215, 115, 20);
		clientesAtacado.add(textField_BairroCliente);
		textField_BairroCliente.setColumns(10);
		
		JLabel lblNewLabel_CidadeClientes = new JLabel("Cidade :");
		lblNewLabel_CidadeClientes.setBounds(556, 215, 60, 20);
		clientesAtacado.add(lblNewLabel_CidadeClientes);
		
		textField_CidadeCliente = new JTextField();
		textField_CidadeCliente.setBounds(611, 215, 97, 20);
		clientesAtacado.add(textField_CidadeCliente);
		textField_CidadeCliente.setColumns(10);
		
		JButton btnNewButtonAdicionarCliente = new JButton("Adicionar Cliente");
		btnNewButtonAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_NomeDoClienteCliente.getText().equals("") || !textField_EmailCliente.getText().equals("") || !textField_CPFCliente.getText().equals("") || !textField_Telefone1Cliente.getText().equals(""))  {
					try {
						String query = "insert into adegagelaguela.cliente (Nome, Email, Empresa, Cidade, Bairro, CNPJ, TelefoneEmpresa, Numero, Endereco, CPF, Telefone1, Telefone2) values (?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?)";
						PreparedStatement pst = conexao.prepareStatement(query);
						pst.setString(1, textField_NomeDoClienteCliente.getText());;
						pst.setString(2, textField_EmailCliente.getText());
						pst.setString(3, textField_EmpresaCliente.getText());
						pst.setString(4, textField_CidadeCliente.getText());;
						pst.setString(5, textField_BairroCliente.getText());
						pst.setString(6, textField_CNPJCliente.getText());
						pst.setString(7, textField_TelEmpresaCliente.getText());;
						pst.setString(8, textField_NmrCliente.getText());
						pst.setString(9, textField_EnderecoCliente.getText());
						pst.setString(10, textField_CPFCliente.getText());;
						pst.setString(11, textField_Telefone1Cliente.getText());
						pst.setString(12, textField_Telefone2Cliente.getText());
						pst.execute();
	
						JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
						limpadorDeDadosClientes();
						refreshTableClientesClientes();
						pst.close();
					} catch (SQLException g) {
						JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!"); g.printStackTrace();
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Preencha os principais campos (*) para adicionar um novo cliente");
				}
				
			}
		});
		btnNewButtonAdicionarCliente.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnNewButtonAdicionarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonAdicionarCliente.setBounds(27, 265, 170, 24);
		clientesAtacado.add(btnNewButtonAdicionarCliente);
		
		JButton btnAtualizarCliente = new JButton("Atualizar Cliente");
		btnAtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_NomeDoClienteCliente.getText().equals("") || !textField_EmailCliente.getText().equals("") || !textField_CPFCliente.getText().equals("") || !textField_Telefone1Cliente.getText().equals(""))  {
					try {
						String query = "Update cliente set idCliente='" + textFieldIDCliente.getText()
						+ "' ,Nome = '" + textField_NomeDoClienteCliente.getText() + "' ,Email = '" + textField_EmailCliente.getText() + "' ,Empresa = '" + textField_EmpresaCliente.getText() 
						+ "' ,Cidade = '" + textField_CidadeCliente.getText() + "' ,Bairro = '" + textField_BairroCliente.getText() + "' ,CNPJ = '" + textField_CNPJCliente.getText()
						+ "' ,TelefoneEmpresa = '" + textField_TelEmpresaCliente.getText() + "' ,Numero = '" + textField_NmrCliente.getText() + "' ,Endereco = '" + textField_EnderecoCliente.getText() 
						+ "' ,CPF = '" + textField_CPFCliente.getText() + "' ,Telefone1 = '" + textField_Telefone1Cliente.getText() + "' ,Telefone2 = '" + textField_Telefone2Cliente.getText()
						+ "' where idCliente='" + textFieldIDCliente.getText() + "'  ";
						PreparedStatement pst = conexao.prepareStatement(query);
						pst.execute();
						pst.close();
						JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
						refreshTableClientesClientes();
						limpadorDeDadosClientes();
					} catch (SQLException g) {
						JOptionPane.showMessageDialog(null, "Erro !"); g.printStackTrace();
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Preencha os principais campos (*) para adicionar um novo cliente");
				}
				
			}
		});
		btnAtualizarCliente.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Import-icon.png"));
		btnAtualizarCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtualizarCliente.setBounds(221, 265, 170, 24);
		clientesAtacado.add(btnAtualizarCliente);
		
		JScrollPane scrollPaneClientesClientes = new JScrollPane();
		scrollPaneClientesClientes.setBounds(10, 359, 762, 155);
		clientesAtacado.add(scrollPaneClientesClientes);
		
		tableClientesClientes = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableClientesClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableClientesClientes.getSelectedRow();
				textFieldIDCliente.setText(tableClientesClientes.getValueAt(linha, 0).toString());
				textField_NomeDoClienteCliente.setText(tableClientesClientes.getValueAt(linha, 1).toString());
				textField_CPFCliente.setText(tableClientesClientes.getValueAt(linha, 2).toString());
				textField_EmailCliente.setText(tableClientesClientes.getValueAt(linha, 3).toString());
				textField_Telefone1Cliente.setText(tableClientesClientes.getValueAt(linha, 4).toString());
				textField_Telefone2Cliente.setText(tableClientesClientes.getValueAt(linha, 5).toString());
				textField_EmpresaCliente.setText(tableClientesClientes.getValueAt(linha, 6).toString());
				textField_CNPJCliente.setText(tableClientesClientes.getValueAt(linha, 7).toString());
				textField_TelEmpresaCliente.setText(tableClientesClientes.getValueAt(linha, 8).toString());
				textField_EnderecoCliente.setText(tableClientesClientes.getValueAt(linha, 9).toString());
				textField_NmrCliente.setText(tableClientesClientes.getValueAt(linha, 10).toString());
				textField_BairroCliente.setText(tableClientesClientes.getValueAt(linha, 11).toString());
				textField_CidadeCliente.setText(tableClientesClientes.getValueAt(linha, 12).toString());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				int linha = tableClientesClientes.getSelectedRow();
				textFieldIDCliente.setText(tableClientesClientes.getValueAt(linha, 0).toString());
				textField_NomeDoClienteCliente.setText(tableClientesClientes.getValueAt(linha, 1).toString());
				textField_CPFCliente.setText(tableClientesClientes.getValueAt(linha, 2).toString());
				textField_EmailCliente.setText(tableClientesClientes.getValueAt(linha, 3).toString());
				textField_Telefone1Cliente.setText(tableClientesClientes.getValueAt(linha, 4).toString());
				textField_Telefone2Cliente.setText(tableClientesClientes.getValueAt(linha, 5).toString());
				textField_EmpresaCliente.setText(tableClientesClientes.getValueAt(linha, 6).toString());
				textField_CNPJCliente.setText(tableClientesClientes.getValueAt(linha, 7).toString());
				textField_TelEmpresaCliente.setText(tableClientesClientes.getValueAt(linha, 8).toString());
				textField_EnderecoCliente.setText(tableClientesClientes.getValueAt(linha, 9).toString());
				textField_NmrCliente.setText(tableClientesClientes.getValueAt(linha, 10).toString());
				textField_BairroCliente.setText(tableClientesClientes.getValueAt(linha, 11).toString());
				textField_CidadeCliente.setText(tableClientesClientes.getValueAt(linha, 12).toString());
			}
		});
		scrollPaneClientesClientes.setViewportView(tableClientesClientes);
		
		JButton btnNewButtonRemoverClienteCliente = new JButton("Remover Cliente");
		btnNewButtonRemoverClienteCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deletar o Cliente?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
					if(!textFieldIDCliente.getText().equals("")) {
						try {
						String query = "delete from cliente where idCliente='" + tableClientesClientes.getValueAt(tableClientesClientes.getSelectedRow(), 0) + "' ";
						PreparedStatement pst = conexao.prepareStatement(query);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Cliente Apagado !", "", JOptionPane.ERROR_MESSAGE);
						pst.close();
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Selecione um cliente da tabela para deletar !"); g.printStackTrace();
						}
						refreshTableClientesClientes();
						limpadorDeDadosClientes();

					}else JOptionPane.showMessageDialog(null, "Selecione um cliente da tabela para deletar !", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButtonRemoverClienteCliente.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButtonRemoverClienteCliente.setBounds(587, 522, 185, 20);
		clientesAtacado.add(btnNewButtonRemoverClienteCliente);
		
		JLabel lblNewLabelNeedCPFCliente = new JLabel("*");
		lblNewLabelNeedCPFCliente.setForeground(Color.RED);
		lblNewLabelNeedCPFCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabelNeedCPFCliente.setBounds(491, 69, 19, 20);
		clientesAtacado.add(lblNewLabelNeedCPFCliente);
		
		JLabel lblNewLabelClienteNEEDCliente = new JLabel("*");
		lblNewLabelClienteNEEDCliente.setForeground(Color.RED);
		lblNewLabelClienteNEEDCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabelClienteNEEDCliente.setBounds(17, 70, 19, 20);
		clientesAtacado.add(lblNewLabelClienteNEEDCliente);
		
		JLabel lblNewLabelTelNeedCliente = new JLabel("*");
		lblNewLabelTelNeedCliente.setForeground(Color.RED);
		lblNewLabelTelNeedCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabelTelNeedCliente.setBounds(291, 99, 19, 20);
		clientesAtacado.add(lblNewLabelTelNeedCliente);
		
		JLabel lblNewLabelEmailNEEDCliente = new JLabel("*");
		lblNewLabelEmailNEEDCliente.setForeground(Color.RED);
		lblNewLabelEmailNEEDCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabelEmailNEEDCliente.setBounds(17, 100, 19, 20);
		clientesAtacado.add(lblNewLabelEmailNEEDCliente);
		
		JButton btnNewButtonVoltarMenuCliente = new JButton("");
		btnNewButtonVoltarMenuCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				clientesAtacado.setVisible(false);
			}
		});
		btnNewButtonVoltarMenuCliente.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\BotaoVolta.png"));
		btnNewButtonVoltarMenuCliente.setOpaque(false);
		btnNewButtonVoltarMenuCliente.setBorderPainted(false);
		btnNewButtonVoltarMenuCliente.setContentAreaFilled(false);
		btnNewButtonVoltarMenuCliente.setBounds(0, 23, 16, 16);
		clientesAtacado.add(btnNewButtonVoltarMenuCliente);
		
		JLabel lblNewLabel_PlanoDeFundoCliente = new JLabel("");
		lblNewLabel_PlanoDeFundoCliente.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\FundoClientes.jpg"));
		lblNewLabel_PlanoDeFundoCliente.setBounds(0, 0, 790, 565);
		clientesAtacado.add(lblNewLabel_PlanoDeFundoCliente);
		
		tableNmrClientes = new JTable();
		tableNmrClientes.setVisible(false);
		tableNmrClientes.setBounds(498, 295, 1, 1);
		clientesAtacado.add(tableNmrClientes);
		relatorioDeVendas.setLayout(null);
		
		
		//
		//
		//
		//RELATORIO DE VENDAS
		//
		//
		
		JMenuBar menuBarRelatorioDeVendas = new JMenuBar();
		menuBarRelatorioDeVendas.setBounds(0, 0, 934, 22);
		menuBarRelatorioDeVendas.setBackground(Color.LIGHT_GRAY);
		relatorioDeVendas.add(menuBarRelatorioDeVendas);

		JMenu mnProdutosRelatorioDeVendas = new JMenu("Produtos");
		mnProdutosRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarRelatorioDeVendas.add(mnProdutosRelatorioDeVendas);

		JMenuItem mntmProdutosNaAdegaRelatorioDeVendas = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(false);
				produtosNaAdega.setVisible(true);
			}
		});
		mntmProdutosNaAdegaRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosRelatorioDeVendas.add(mntmProdutosNaAdegaRelatorioDeVendas);

		JMenuItem mntmProdutosEmEstoqueRelatorioDeVendas = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosRelatorioDeVendas.add(mntmProdutosEmEstoqueRelatorioDeVendas);

		JMenuItem mntmProdutosParaComprarRelatorioDeVendas = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarRelatorioDeVendas
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosRelatorioDeVendas.add(mntmProdutosParaComprarRelatorioDeVendas);

		JMenuItem mntmTodosProdutosRelatorioDeVendas = new JMenuItem("Todos Produtos");
		mntmTodosProdutosRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosRelatorioDeVendas.add(mntmTodosProdutosRelatorioDeVendas);

		JMenu mnVenderRelatorioDeVendas = new JMenu("Vender");
		mnVenderRelatorioDeVendas
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarRelatorioDeVendas.add(mnVenderRelatorioDeVendas);

		JMenuItem mntmVendaVarejoRelatorioDeVendas = new JMenuItem("Venda Varejo");
		mntmVendaVarejoRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderRelatorioDeVendas.add(mntmVendaVarejoRelatorioDeVendas);

		JMenuItem mntmVendaAtacadoRelatorioDeVendas = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderRelatorioDeVendas.add(mntmVendaAtacadoRelatorioDeVendas);

		JMenuItem mntmVendaPersonalizadaRelatorioDeVendas = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderRelatorioDeVendas.add(mntmVendaPersonalizadaRelatorioDeVendas);
		
		JMenu mnClientesRelatorioDeVendas = new JMenu("Clientes");
		mnClientesRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarRelatorioDeVendas.add(mnClientesRelatorioDeVendas);
		
		JMenuItem mntmNewMenuClientesAtacadoRelatorioDeVendas = new JMenuItem("Clientes Atacado");
		mntmNewMenuClientesAtacadoRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(true);
				relatorioDeVendas.setVisible(false);
			}
		});
		mntmNewMenuClientesAtacadoRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesRelatorioDeVendas.add(mntmNewMenuClientesAtacadoRelatorioDeVendas);

		JMenu mnFinanceiroRelatorioDeVendas = new JMenu("Financeiro");
		mnFinanceiroRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarRelatorioDeVendas.add(mnFinanceiroRelatorioDeVendas);
		
		JMenuItem mntmRelatorioDeVendasRelatorioDeVendas = new JMenuItem("Relatorio de Vendas");
		mntmRelatorioDeVendasRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroRelatorioDeVendas.add(mntmRelatorioDeVendasRelatorioDeVendas);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial_9 = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1_8 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_8.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroRelatorioDeVendas.add(mnNewMenu_1_8);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Atacado");
		mnNewMenu_1_8.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosAtacado.setVisible(true);
				relatorioDeVendas.setVisible(false);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo_8 = new JMenuItem("Varejo");
		mntmVarejo_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo_8.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_8.add(mntmVarejo_8);
		mntmNewMenuItemBancoFinanceiroMenuUnicial_9.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroRelatorioDeVendas.add(mntmNewMenuItemBancoFinanceiroMenuUnicial_9);

		JMenu mnAjudaRelatorioDeVendas = new JMenu("Ajuda");
		mnAjudaRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarRelatorioDeVendas.add(mnAjudaRelatorioDeVendas);

		JMenuItem mntmDadosDaVersaoRelatorioDeVendas = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaRelatorioDeVendas.add(mntmDadosDaVersaoRelatorioDeVendas);
		
		
		JCalendar calendarioRelatorioDeVendas = new JCalendar();
		calendarioRelatorioDeVendas.setLocation(433, 54);
		calendarioRelatorioDeVendas.setSize(322, 200);
		relatorioDeVendas.add(calendarioRelatorioDeVendas);
		
		JScrollPane scrollPaneRelatorioDeVendas = new JScrollPane();
		scrollPaneRelatorioDeVendas.setBounds(10, 265, 762, 280);
		relatorioDeVendas.add(scrollPaneRelatorioDeVendas);
		
		tableRelatorioDeVendas = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		scrollPaneRelatorioDeVendas.setViewportView(tableRelatorioDeVendas);
		
		JButton btnVendaVarejoRelatorioDeVendas = new JButton("Relatorio Vendas Varejo");
		btnVendaVarejoRelatorioDeVendas.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textFieldNumeroDaVendaRelatorioDeVendas.getText().equals("")) {
					int ano = 1900 + calendarioRelatorioDeVendas.getDate().getYear();
					int dia = calendarioRelatorioDeVendas.getDate().getDate();
					int mes = 1 + calendarioRelatorioDeVendas.getDate().getMonth();
					if(!(dia > 9)) {
						try {
							String query = "SELECT NumeroDaVenda 'Nmr da Venda', Produto, Quantidade, PrecoTotal 'Preço', FormaDePagamento 'Pagamento', HoraDaVenda 'Dia da venda' FROM vendavarejo WHERE HoraDaVenda LIKE '"+ano+"-"+mes+"-"+"0"+dia+"%' ORDER BY NumeroDaVenda";
							PreparedStatement pst = conexao.prepareStatement(query);
							ResultSet rs = pst.executeQuery();
							tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));
							pst.close();
							rs.close();
									
						}catch (Exception g) {
							g.printStackTrace();
						}
					}else if(!(mes > 9)) {
						try {
							String query = "SELECT NumeroDaVenda 'Nmr da Venda', Produto, Quantidade, PrecoTotal 'Preço', FormaDePagamento 'Pagamento', HoraDaVenda 'Dia da venda' FROM vendavarejo WHERE HoraDaVenda LIKE '"+ano+"-0"+mes+"-"+dia+"%' ORDER BY NumeroDaVenda";
							PreparedStatement pst = conexao.prepareStatement(query);
							ResultSet rs = pst.executeQuery();
							tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));
							pst.close();
							rs.close();
									
						}catch (Exception g) {
							g.printStackTrace();
						} 
					}else {
						try {
							String query = "SELECT NumeroDaVenda 'Nmr da Venda', Produto, Quantidade, PrecoTotal 'Preço', FormaDePagamento 'Pagamento', HoraDaVenda 'Dia da venda' FROM vendavarejo WHERE HoraDaVenda LIKE '"+ano+"-"+mes+"-"+dia+"%' ORDER BY NumeroDaVenda";
							PreparedStatement pst = conexao.prepareStatement(query);
							ResultSet rs = pst.executeQuery();
							tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));
			
							pst.close();
							rs.close();
								
						}catch (Exception g) {
							g.printStackTrace();
						}
					}
				}else {
					try {
						String query = "SELECT NumeroDaVenda 'Nmr da Venda', Produto, Quantidade, PrecoTotal 'Preço',  FormaDePagamento 'Pagamento', HoraDaVenda 'Dia da venda' FROM vendavarejo WHERE NumeroDaVenda = " +textFieldNumeroDaVendaRelatorioDeVendas.getText().toString()+" ORDER BY NumeroDaVenda";
						PreparedStatement pst = conexao.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));

						pst.close();
						rs.close();
								
					}catch (Exception g) {
						g.printStackTrace();
					}
				}
			}
		});
		btnVendaVarejoRelatorioDeVendas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVendaVarejoRelatorioDeVendas.setBounds(20, 161, 265, 24);
		relatorioDeVendas.add(btnVendaVarejoRelatorioDeVendas);
		
		JButton btnVendaAtacadoRelatorioDeVendas = new JButton("Relatorio Vendas Atacado");
		btnVendaAtacadoRelatorioDeVendas.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textFieldNumeroDaVendaRelatorioDeVendas.getText().equals("")) {
					int ano = 1900 + calendarioRelatorioDeVendas.getDate().getYear();
					int dia = calendarioRelatorioDeVendas.getDate().getDate();
					int mes = 1 + calendarioRelatorioDeVendas.getDate().getMonth();
					if(!(dia > 9)) {
						try {
							String query = "SELECT vendaatacado.NumeroDaVenda 'Nmr da Venda', cliente.Nome, cliente.Empresa, estoque.Produto 'Produto', vendaatacado.quantidade 'Quantidade', format(vendaatacado.precoTotal ,2,'de_DE') 'Preço', vendaatacado.FormaDePagamento 'Pagamento', "
									+ "vendaatacado.PagarFuturo 'Pagar Futuro', format(vendaatacado.Desconto ,2,'de_DE') 'Desconto' FROM adegagelaguela.vendaatacado JOIN adegagelaguela.cliente ON vendaatacado.IDCliente = cliente.idCliente "
									+ "JOIN adegagelaguela.estoque ON adegagelaguela.vendaatacado.IDProduto = estoque.idEstoque WHERE HoraDaVenda LIKE '"+ ano + "-" +mes+"-0"+dia+"%' ORDER BY adegagelaguela.vendaatacado.NumeroDaVenda";
							PreparedStatement pst = conexao.prepareStatement(query);
							ResultSet rs = pst.executeQuery();
							tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));
							pst.close();
							rs.close();
									
						}catch (Exception g) {
							g.printStackTrace();
						}
					}else {
						try {
								String query = "SELECT vendaatacado.NumeroDaVenda 'Nmr da Venda', cliente.Nome, cliente.Empresa, estoque.Produto 'Produto', vendaatacado.quantidade 'Quantidade', format(vendaatacado.precoTotal ,2,'de_DE') 'Preço', vendaatacado.FormaDePagamento 'Pagamento', "
										+ "vendaatacado.PagarFuturo 'Pagar Futuro', format(vendaatacado.Desconto ,2,'de_DE') 'Desconto' FROM adegagelaguela.vendaatacado JOIN adegagelaguela.cliente ON vendaatacado.IDCliente = cliente.idCliente "
										+ "JOIN adegagelaguela.estoque ON adegagelaguela.vendaatacado.IDProduto = estoque.idEstoque WHERE HoraDaVenda LIKE '"+ ano + "-" +mes+"-"+dia+"%' ORDER BY adegagelaguela.vendaatacado.NumeroDaVenda";
							PreparedStatement pst = conexao.prepareStatement(query);		
							ResultSet rs = pst.executeQuery();
							tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));
							pst.close();
							rs.close();
						}catch (Exception g) {
							g.printStackTrace();
						}
					}
				}else {
					try {
						String query = "SELECT vendaatacado.NumeroDaVenda 'Nmr da Venda', cliente.Nome, cliente.Empresa, estoque.Produto 'Produto', vendaatacado.quantidade 'Quantidade', format(vendaatacado.precoTotal ,2,'de_DE') 'Preço', vendaatacado.FormaDePagamento 'Pagamento',"
								+ "vendaatacado.PagarFuturo 'Pagar Futuro', format(vendaatacado.Desconto ,2,'de_DE') 'Desconto' FROM adegagelaguela.vendaatacado JOIN adegagelaguela.cliente ON vendaatacado.IDCliente = cliente.idCliente "
								+ "JOIN adegagelaguela.estoque ON adegagelaguela.vendaatacado.IDProduto = estoque.idEstoque WHERE adegagelaguela.vendaatacado.NumeroDaVenda = "+textFieldNumeroDaVendaRelatorioDeVendas.getText().toString()+" ORDER BY adegagelaguela.estoque.Produto;";
						PreparedStatement pst = conexao.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
						rs.close();
								
					}catch (Exception g) {
						g.printStackTrace();
					}
				}
			}
		});
		btnVendaAtacadoRelatorioDeVendas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVendaAtacadoRelatorioDeVendas.setBounds(20, 197, 265, 24);
		relatorioDeVendas.add(btnVendaAtacadoRelatorioDeVendas);
		
		JButton btnVendaPersonalizadaRelatorioDeVendas = new JButton("Relatorio Vendas Personalizadas");
		btnVendaPersonalizadaRelatorioDeVendas.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textFieldNumeroDaVendaRelatorioDeVendas.getText().equals("")) {
					int ano = 1900 + calendarioRelatorioDeVendas.getDate().getYear();
					int dia = calendarioRelatorioDeVendas.getDate().getDate();
					int mes = 1 + calendarioRelatorioDeVendas.getDate().getMonth();
					if(!(dia > 9)) {
						try {
							String query = "SELECT NumeroDaVenda 'Nmr da Venda', NomeCliente 'Nome', Telefone, NomeProduto 'Produto', QuantidadeProduto 'Quantidade', Preco 'Preço (un)', FormaDePagamento 'Pagamento', PagamentoFuturo 'Futuro', HoraDaVenda 'Dia da Venda' FROM vendapersonalizada WHERE HoraDaVenda LIKE '"+ ano + "-" +mes+"-%0"+dia+"%' ORDER BY NumeroDaVenda";
							PreparedStatement pst = conexao.prepareStatement(query);
							ResultSet rs = pst.executeQuery();
							tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));
							pst.close();
							rs.close();
									
						}catch (Exception g) {
							g.printStackTrace();
						}
					}else if(!(mes > 9)) {
						try {
							String query = "SELECT NumeroDaVenda 'Nmr da Venda', NomeCliente 'Nome', Telefone, NomeProduto 'Produto', QuantidadeProduto 'Quantidade', Preco 'Preço (un)', FormaDePagamento 'Pagamento', PagamentoFuturo 'Futuro', HoraDaVenda 'Dia da Venda' FROM vendapersonalizada WHERE HoraDaVenda LIKE '"+ ano + "-0" +mes+"-%"+dia+"%' ORDER BY NumeroDaVenda";
							PreparedStatement pst = conexao.prepareStatement(query);
							ResultSet rs = pst.executeQuery();
							tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));
							pst.close();
							rs.close();
									
						}catch (Exception g) {
							g.printStackTrace();
						} 
					}else {
						try {
							String query = "SELECT NumeroDaVenda 'Nmr da Venda', NomeCliente 'Nome', Telefone, NomeProduto 'Produto', QuantidadeProduto 'Quantidade', Preco 'Preço (un)', FormaDePagamento 'Pagamento', PagamentoFuturo 'Futuro', HoraDaVenda 'Dia da Venda' FROM vendapersonalizada WHERE HoraDaVenda LIKE '"+ ano + "-" +mes+"-%"+dia+"%' ORDER BY NumeroDaVenda";
							PreparedStatement pst = conexao.prepareStatement(query);
							ResultSet rs = pst.executeQuery();
							tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));
							pst.close();
							rs.close();
									
						}catch (Exception g) {
							g.printStackTrace();
						}
					}
				}else {
					try {
						String query = "SELECT NumeroDaVenda 'Nmr da Venda', NomeCliente 'Nome', Telefone, NomeProduto 'Produto', QuantidadeProduto 'Quantidade', Preco 'Preço (un)', FormaDePagamento 'Pagamento', PagamentoFuturo 'Futuro', HoraDaVenda 'Dia da Venda' FROM vendapersonalizada WHERE NumeroDaVenda = " +textFieldNumeroDaVendaRelatorioDeVendas.getText().toString()+" ORDER BY NumeroDaVenda";
						PreparedStatement pst = conexao.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						tableRelatorioDeVendas.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
						rs.close();
								
					}catch (Exception g) {
						g.printStackTrace();
					}
				}
			}
		});
		btnVendaPersonalizadaRelatorioDeVendas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVendaPersonalizadaRelatorioDeVendas.setBounds(20, 231, 265, 24);
		relatorioDeVendas.add(btnVendaPersonalizadaRelatorioDeVendas);
		
		JLabel lblDadosDaVenda = new JLabel("Dados da Venda :");
		lblDadosDaVenda.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		lblDadosDaVenda.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDadosDaVenda.setBounds(10, 33, 205, 24);
		relatorioDeVendas.add(lblDadosDaVenda);
		
		JLabel lblNumeroDaVenda = new JLabel("Numero da venda :");
		lblNumeroDaVenda.setBounds(20, 80, 129, 20);
		relatorioDeVendas.add(lblNumeroDaVenda);
		
		textFieldNumeroDaVendaRelatorioDeVendas = new JTextField();
		textFieldNumeroDaVendaRelatorioDeVendas.setBounds(134, 80, 70, 20);
		relatorioDeVendas.add(textFieldNumeroDaVendaRelatorioDeVendas);
		textFieldNumeroDaVendaRelatorioDeVendas.setColumns(10);
		
		textFieldDiaRelatorioDeVendas = new JTextField();
		textFieldDiaRelatorioDeVendas.setBounds(93, 110, 20, 20);
		relatorioDeVendas.add(textFieldDiaRelatorioDeVendas);
		textFieldDiaRelatorioDeVendas.setColumns(10);
		
		JLabel lblDigitarDataRelatorioDeVendas = new JLabel("Digitar data :");
		lblDigitarDataRelatorioDeVendas.setBounds(20, 110, 104, 20);
		relatorioDeVendas.add(lblDigitarDataRelatorioDeVendas);
		
		textFieldMesRelatorioDeVendas = new JTextField();
		textFieldMesRelatorioDeVendas.setColumns(10);
		textFieldMesRelatorioDeVendas.setBounds(125, 110, 20, 20);
		relatorioDeVendas.add(textFieldMesRelatorioDeVendas);
		
		textFieldAnoRelatorioDeVendas = new JTextField();
		textFieldAnoRelatorioDeVendas.setColumns(10);
		textFieldAnoRelatorioDeVendas.setBounds(157, 110, 47, 20);
		relatorioDeVendas.add(textFieldAnoRelatorioDeVendas);
		
		
		JLabel lbldiaBARRAmesRelatorioDeVendas = new JLabel("/");
		lbldiaBARRAmesRelatorioDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldiaBARRAmesRelatorioDeVendas.setBounds(115, 108, 20, 20);
		relatorioDeVendas.add(lbldiaBARRAmesRelatorioDeVendas);
		
		JLabel lblmesBARRAanoRelatorioDeVendas = new JLabel("/");
		lblmesBARRAanoRelatorioDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblmesBARRAanoRelatorioDeVendas.setBounds(147, 108, 46, 20);
		relatorioDeVendas.add(lblmesBARRAanoRelatorioDeVendas);
		
		JLabel lblNewLabel_AteRelatorioDeVendas = new JLabel("At\u00E9 :");
		lblNewLabel_AteRelatorioDeVendas.setBounds(214, 113, 46, 14);
		relatorioDeVendas.add(lblNewLabel_AteRelatorioDeVendas);
		
		textFieldAteDiaRelatorioDeVendas = new JTextField();
		textFieldAteDiaRelatorioDeVendas.setColumns(10);
		textFieldAteDiaRelatorioDeVendas.setBounds(243, 110, 20, 20);
		relatorioDeVendas.add(textFieldAteDiaRelatorioDeVendas);
		
		textFieldAteMesRelatorioDeVendas = new JTextField();
		textFieldAteMesRelatorioDeVendas.setColumns(10);
		textFieldAteMesRelatorioDeVendas.setBounds(275, 110, 20, 20);
		relatorioDeVendas.add(textFieldAteMesRelatorioDeVendas);
		
		textFieldAteAnoRelatorioDeVendas = new JTextField();
		textFieldAteAnoRelatorioDeVendas.setColumns(10);
		textFieldAteAnoRelatorioDeVendas.setBounds(307, 110, 47, 20);
		relatorioDeVendas.add(textFieldAteAnoRelatorioDeVendas);
		
		JLabel lbldiaBARRAmesRelatorioDeVendasAte = new JLabel("/");
		lbldiaBARRAmesRelatorioDeVendasAte.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldiaBARRAmesRelatorioDeVendasAte.setBounds(265, 108, 20, 20);
		relatorioDeVendas.add(lbldiaBARRAmesRelatorioDeVendasAte);
		
		JLabel lbldiaBARRAanoRelatorioDeVendasAte = new JLabel("/");
		lbldiaBARRAanoRelatorioDeVendasAte.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldiaBARRAanoRelatorioDeVendasAte.setBounds(295, 108, 20, 20);
		relatorioDeVendas.add(lbldiaBARRAanoRelatorioDeVendasAte);
		
		JButton btnNewButtonImprimirVendaVarejoRelatorioDeVendas = new JButton("");
		btnNewButtonImprimirVendaVarejoRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentoRelatorioDeVendasVarejo();
			}
		});
		btnNewButtonImprimirVendaVarejoRelatorioDeVendas.setContentAreaFilled(false);
		btnNewButtonImprimirVendaVarejoRelatorioDeVendas.setBorderPainted(false);
		btnNewButtonImprimirVendaVarejoRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\bubble-jet-printer-icon.png"));
		btnNewButtonImprimirVendaVarejoRelatorioDeVendas.setBounds(290, 161, 24, 24);
		relatorioDeVendas.add(btnNewButtonImprimirVendaVarejoRelatorioDeVendas);
		
		JButton btnNewButtonImprimirVendaAtacadoRelatorioDeVendas = new JButton("");
		btnNewButtonImprimirVendaAtacadoRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentoRelatorioDeVendasAtacado();
			}
		});
		btnNewButtonImprimirVendaAtacadoRelatorioDeVendas.setBorderPainted(false);
		btnNewButtonImprimirVendaAtacadoRelatorioDeVendas.setContentAreaFilled(false);
		btnNewButtonImprimirVendaAtacadoRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\bubble-jet-printer-icon.png"));
		btnNewButtonImprimirVendaAtacadoRelatorioDeVendas.setBounds(290, 197, 24, 24);
		relatorioDeVendas.add(btnNewButtonImprimirVendaAtacadoRelatorioDeVendas);
		
		JButton btnNewButtonImprimirVendaPersoRelatorioDeVendas = new JButton("");
		btnNewButtonImprimirVendaPersoRelatorioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentoRelatorioDeVendasPersonalizada();
			}
		});
		btnNewButtonImprimirVendaPersoRelatorioDeVendas.setContentAreaFilled(false);
		btnNewButtonImprimirVendaPersoRelatorioDeVendas.setBorderPainted(false);
		btnNewButtonImprimirVendaPersoRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\bubble-jet-printer-icon.png"));
		btnNewButtonImprimirVendaPersoRelatorioDeVendas.setBounds(290, 231, 24, 24);
		relatorioDeVendas.add(btnNewButtonImprimirVendaPersoRelatorioDeVendas);
		
		JLabel lblPlanoDeFundoRelatorioDeVendas = new JLabel("");
		lblPlanoDeFundoRelatorioDeVendas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\budweiserfundovendaatacado.jpg"));
		lblPlanoDeFundoRelatorioDeVendas.setBounds(0, 0, 782, 545);
		relatorioDeVendas.add(lblPlanoDeFundoRelatorioDeVendas);
		relatorioDeProdutosAtacado.setLayout(null);
		
		
		//
		//
		// RELATORIO DE PRODUTOS
		//
		//
		
		JMenuBar menuBarRelatorioDeProdutosAtacado = new JMenuBar();
		menuBarRelatorioDeProdutosAtacado.setBounds(0, 0, 934, 22);
		menuBarRelatorioDeProdutosAtacado.setBackground(Color.LIGHT_GRAY);
		relatorioDeProdutosAtacado.add(menuBarRelatorioDeProdutosAtacado);

		JMenu mnProdutosRelatorioDeProdutosAtacado = new JMenu("Produtos");
		mnProdutosRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarRelatorioDeProdutosAtacado.add(mnProdutosRelatorioDeProdutosAtacado);

		JMenuItem mntmProdutosNaAdegaRelatorioDeProdutosAtacado = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosAtacado.setVisible(false);
				produtosNaAdega.setVisible(true);
			}
		});
		mntmProdutosNaAdegaRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosRelatorioDeProdutosAtacado.add(mntmProdutosNaAdegaRelatorioDeProdutosAtacado);

		JMenuItem mntmProdutosEmEstoqueRelatorioDeProdutosAtacado = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosAtacado.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosRelatorioDeProdutosAtacado.add(mntmProdutosEmEstoqueRelatorioDeProdutosAtacado);

		JMenuItem mntmProdutosParaComprarRelatorioDeProdutosAtacado = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosAtacado.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarRelatorioDeProdutosAtacado
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosRelatorioDeProdutosAtacado.add(mntmProdutosParaComprarRelatorioDeProdutosAtacado);

		JMenuItem mntmTodosProdutosRelatorioDeProdutosAtacado = new JMenuItem("Todos Produtos");
		mntmTodosProdutosRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosAtacado.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosRelatorioDeProdutosAtacado.add(mntmTodosProdutosRelatorioDeProdutosAtacado);

		JMenu mnVenderRelatorioDeProdutosAtacado = new JMenu("Vender");
		mnVenderRelatorioDeProdutosAtacado
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarRelatorioDeProdutosAtacado.add(mnVenderRelatorioDeProdutosAtacado);

		JMenuItem mntmVendaVarejoRelatorioDeProdutosAtacado = new JMenuItem("Venda Varejo");
		mntmVendaVarejoRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosAtacado.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderRelatorioDeProdutosAtacado.add(mntmVendaVarejoRelatorioDeProdutosAtacado);

		JMenuItem mntmVendaAtacadoRelatorioDeProdutosAtacado = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosAtacado.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderRelatorioDeProdutosAtacado.add(mntmVendaAtacadoRelatorioDeProdutosAtacado);

		JMenuItem mntmVendaPersonalizadaRelatorioDeProdutosAtacado = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosAtacado.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderRelatorioDeProdutosAtacado.add(mntmVendaPersonalizadaRelatorioDeProdutosAtacado);
		
		JMenu mnClientesRelatorioDeProdutosAtacado = new JMenu("Clientes");
		mnClientesRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarRelatorioDeProdutosAtacado.add(mnClientesRelatorioDeProdutosAtacado);
		
		JMenuItem mntmNewMenuClientesAtacadoRelatorioDeProdutosAtacado = new JMenuItem("Clientes Atacado");
		mntmNewMenuClientesAtacadoRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(true);
				relatorioDeProdutosAtacado.setVisible(false);
			}
		});
		mntmNewMenuClientesAtacadoRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesRelatorioDeProdutosAtacado.add(mntmNewMenuClientesAtacadoRelatorioDeProdutosAtacado);

		JMenu mnFinanceiroRelatorioDeProdutosAtacado = new JMenu("Financeiro");
		mnFinanceiroRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarRelatorioDeProdutosAtacado.add(mnFinanceiroRelatorioDeProdutosAtacado);
		
		JMenuItem mntmNewMenuItemRelatorioDeVendasRelatorioProdutosAtacado = new JMenuItem("Relatorio de Vendas");
		mntmNewMenuItemRelatorioDeVendasRelatorioProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(true);
				relatorioDeProdutosAtacado.setVisible(false);
			}
		});
		mntmNewMenuItemRelatorioDeVendasRelatorioProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroRelatorioDeProdutosAtacado.add(mntmNewMenuItemRelatorioDeVendasRelatorioProdutosAtacado);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroAtacado = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosAtacado.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1_9 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_9.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroRelatorioDeProdutosAtacado.add(mnNewMenu_1_9);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosAtacado = new JMenuItem("Atacado");
		mnNewMenu_1_9.add(mntmNewMenuItemRelatorioDeProdutosAtacado);
		mntmNewMenuItemRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo_9 = new JMenuItem("Varejo");
		mntmVarejo_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosAtacado.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo_9.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_9.add(mntmVarejo_9);
		mntmNewMenuItemBancoFinanceiroAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroRelatorioDeProdutosAtacado.add(mntmNewMenuItemBancoFinanceiroAtacado);

		JMenu mnAjudaRelatorioDeProdutosAtacado = new JMenu("Ajuda");
		mnAjudaRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarRelatorioDeProdutosAtacado.add(mnAjudaRelatorioDeProdutosAtacado);

		JMenuItem mntmDadosDaVersaoRelatorioDeProdutosAtacado = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaRelatorioDeProdutosAtacado.add(mntmDadosDaVersaoRelatorioDeProdutosAtacado);
		
		JScrollPane scrollPaneRelatorioDeProdutosRelatorioDeProdutosAtacado = new JScrollPane();
		scrollPaneRelatorioDeProdutosRelatorioDeProdutosAtacado.setBounds(10, 170, 388, 47);
		relatorioDeProdutosAtacado.add(scrollPaneRelatorioDeProdutosRelatorioDeProdutosAtacado);
		
		tableRelatorioDeProdutosAtacado = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		scrollPaneRelatorioDeProdutosRelatorioDeProdutosAtacado.setViewportView(tableRelatorioDeProdutosAtacado);
		
		
		JRadioButton rdbtnAtacadoRelatorioProdutoAtacado= new JRadioButton("Atacado");
		rdbtnAtacadoRelatorioProdutoAtacado.setOpaque(false);
		rdbtnAtacadoRelatorioProdutoAtacado.setFocusPainted(false);
		rdbtnAtacadoRelatorioProdutoAtacado.setBounds(214, 109, 109, 23);
		relatorioDeProdutosAtacado.add(rdbtnAtacadoRelatorioProdutoAtacado);
		
		JRadioButton rdbtnPersonalizadaRelatorioProdutoAtacado = new JRadioButton("Personalizada");
		rdbtnPersonalizadaRelatorioProdutoAtacado.setOpaque(false);
		rdbtnPersonalizadaRelatorioProdutoAtacado.setBounds(214, 79, 109, 23);
		relatorioDeProdutosAtacado.add(rdbtnPersonalizadaRelatorioProdutoAtacado);
		
		
		JButton btnRelatorioDoProdutoRelatorioDeProdutosAtacado = new JButton("Relatorio do Produto");
		btnRelatorioDoProdutoRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\balance-unbalance-icon.png"));
		btnRelatorioDoProdutoRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(!textFieldMesRelatorioRelatorioDeProdutosAtacado.getText().toString().equals("") && !textFieldAnoRelatorioRelatorioDeProdutosAtacado.getText().toString().equals("") && !textFieldIdDoProdutoRelatorioDeProdutosAtacado.getText().toString().equals("")) {
						int ano = Integer.parseInt(textFieldAnoRelatorioRelatorioDeProdutosAtacado.getText().toString());
						int mes = Integer.parseInt(textFieldMesRelatorioRelatorioDeProdutosAtacado.getText().toString());
							if(!(mes > 9) && !(textFieldAnoRelatorioRelatorioDeProdutosAtacado.getText().toString().charAt(0) == '0') ) {
								try {
									String query = "SELECT estoque.Produto, SUM(vendaatacado.quantidade + vendapersonalizada.QuantidadeProduto) as QuantidadeVendida, format(SUM(vendaatacado.precoTotal + vendapersonalizada.PrecoTotal),2,'de_DE') as ValorVendido FROM adegagelaguela.vendaatacado "
										+ "JOIN adegagelaguela.estoque ON estoque.idEstoque = vendaatacado.IDProduto JOIN adegagelaguela.vendapersonalizada ON vendapersonalizada.Produto_ID = vendaatacado.IDProduto "
										+ "WHERE estoque.idEstoque = "+textFieldIdDoProdutoRelatorioDeProdutosAtacado.getText().toString()+" and vendaatacado.HoraDaVenda LIKE '"+ano+"-0"+mes+"%'";
									PreparedStatement pst = conexao.prepareStatement(query);
									ResultSet rs = pst.executeQuery();
									tableRelatorioDeProdutosAtacado.setModel(DbUtils.resultSetToTableModel(rs));
									pst.close();
									rs.close();
										
								}catch (Exception g) {
									g.printStackTrace();
								}
							} else 
								try {
									String query = "SELECT estoque.Produto, SUM(vendaatacado.quantidade + vendapersonalizada.QuantidadeProduto) as QuantidadeVendida, format(SUM(vendaatacado.precoTotal + vendapersonalizada.PrecoTotal),2,'de_DE') as ValorVendido FROM adegagelaguela.vendaatacado "
										+ "JOIN adegagelaguela.estoque ON estoque.idEstoque = vendaatacado.IDProduto JOIN adegagelaguela.vendapersonalizada ON vendapersonalizada.Produto_ID = vendaatacado.IDProduto "
										+ "WHERE estoque.idEstoque = "+textFieldIdDoProdutoRelatorioDeProdutosAtacado.getText().toString()+" and vendaatacado.HoraDaVenda LIKE '"+ano+"-"+mes+"%'";
									PreparedStatement pst = conexao.prepareStatement(query);
									ResultSet rs = pst.executeQuery();
									tableRelatorioDeProdutosAtacado.setModel(DbUtils.resultSetToTableModel(rs));
									pst.close();
									rs.close();
									
								}catch (Exception g) {
									g.printStackTrace();
								}
					}else JOptionPane.showMessageDialog(null, "Preencher todos os campos para consulta", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnRelatorioDoProdutoRelatorioDeProdutosAtacado.setBounds(10, 140, 198, 21);
		relatorioDeProdutosAtacado.add(btnRelatorioDoProdutoRelatorioDeProdutosAtacado);
		
		JLabel lblNomeDoProdutoRelatorioDeProdutosAtacado = new JLabel("Produto :");
		lblNomeDoProdutoRelatorioDeProdutosAtacado.setBounds(10, 80, 130, 20);
		relatorioDeProdutosAtacado.add(lblNomeDoProdutoRelatorioDeProdutosAtacado);
		
		JLabel lblDadosDoProdutoRelatorioDeProdutosAtacado = new JLabel("Dados do Produto ATACADO + PERSONALIZADA:");
		lblDadosDoProdutoRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-And-Pretzel-icon.png"));
		lblDadosDoProdutoRelatorioDeProdutosAtacado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDadosDoProdutoRelatorioDeProdutosAtacado.setBounds(10, 33, 388, 24);
		relatorioDeProdutosAtacado.add(lblDadosDoProdutoRelatorioDeProdutosAtacado);
		
		textFieldNomeDoProdutoRelatorioDeProdutosAtacado = new JTextField();
		textFieldNomeDoProdutoRelatorioDeProdutosAtacado.setEditable(false);
		textFieldNomeDoProdutoRelatorioDeProdutosAtacado.setBounds(71, 80, 137, 20);
		relatorioDeProdutosAtacado.add(textFieldNomeDoProdutoRelatorioDeProdutosAtacado);
		textFieldNomeDoProdutoRelatorioDeProdutosAtacado.setColumns(10);
		
		textFieldIdDoProdutoRelatorioDeProdutosAtacado = new JTextField();
		textFieldIdDoProdutoRelatorioDeProdutosAtacado.setEditable(false);
		textFieldIdDoProdutoRelatorioDeProdutosAtacado.setVisible(false);
		textFieldIdDoProdutoRelatorioDeProdutosAtacado.setBounds(10, 427, 45, 20);
		relatorioDeProdutosAtacado.add(textFieldIdDoProdutoRelatorioDeProdutosAtacado);
		textFieldIdDoProdutoRelatorioDeProdutosAtacado.setColumns(10);
		
		JScrollPane scrollPaneListaDeProdutosRelatorioDeProdutosAtacado = new JScrollPane();
		scrollPaneListaDeProdutosRelatorioDeProdutosAtacado.setBounds(490, 60, 261, 485);
		relatorioDeProdutosAtacado.add(scrollPaneListaDeProdutosRelatorioDeProdutosAtacado);
		
		tableListaDeProdutosRelatorioDeProdutosAtacado = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableListaDeProdutosRelatorioDeProdutosAtacado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableListaDeProdutosRelatorioDeProdutosAtacado.getSelectedRow();
				textFieldIdDoProdutoRelatorioDeProdutosAtacado.setText(tableListaDeProdutosRelatorioDeProdutosAtacado.getValueAt(linha, 0).toString());
				textFieldNomeDoProdutoRelatorioDeProdutosAtacado.setText(tableListaDeProdutosRelatorioDeProdutosAtacado.getValueAt(linha, 1).toString());
			}
		});
		scrollPaneListaDeProdutosRelatorioDeProdutosAtacado.setViewportView(tableListaDeProdutosRelatorioDeProdutosAtacado);
		
		JButton btnListaDeProdutosRelatorioDeProdutosAtacado = new JButton("Lista de Produtos");
		btnListaDeProdutosRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-icon.png"));
		btnListaDeProdutosRelatorioDeProdutosAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT idEstoque 'Numero de ID', Produto 'Nome do Produto' from adegagelaguela.estoque ORDER BY Produto";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableListaDeProdutosRelatorioDeProdutosAtacado.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();
					
				}catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListaDeProdutosRelatorioDeProdutosAtacado.setBounds(490, 33, 148, 23);
		relatorioDeProdutosAtacado.add(btnListaDeProdutosRelatorioDeProdutosAtacado);
		
		JLabel lblMesRelatorioRelatorioDeProdutosAtacado = new JLabel("M\u00EAs :");
		lblMesRelatorioRelatorioDeProdutosAtacado.setBounds(10, 110, 46, 20);
		relatorioDeProdutosAtacado.add(lblMesRelatorioRelatorioDeProdutosAtacado);
		
		JLabel lblAnoRelatorioRelatorioDeProdutosAtacado = new JLabel("Ano :");
		lblAnoRelatorioRelatorioDeProdutosAtacado.setBounds(107, 110, 46, 20);
		relatorioDeProdutosAtacado.add(lblAnoRelatorioRelatorioDeProdutosAtacado);
		
		textFieldMesRelatorioRelatorioDeProdutosAtacado = new JTextField();
		textFieldMesRelatorioRelatorioDeProdutosAtacado.setBounds(52, 110, 45, 20);
		relatorioDeProdutosAtacado.add(textFieldMesRelatorioRelatorioDeProdutosAtacado);
		textFieldMesRelatorioRelatorioDeProdutosAtacado.setColumns(10);
		
		textFieldAnoRelatorioRelatorioDeProdutosAtacado = new JTextField();
		textFieldAnoRelatorioRelatorioDeProdutosAtacado.setColumns(10);
		textFieldAnoRelatorioRelatorioDeProdutosAtacado.setBounds(146, 110, 62, 20);
		relatorioDeProdutosAtacado.add(textFieldAnoRelatorioRelatorioDeProdutosAtacado);
		
		JButton btnNewButton_1 = new JButton("Detalhes do Protudo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document Relatorio = new Document();
				String mes = textFieldMesRelatorioRelatorioDeProdutosAtacado.getText().toString();
				String ano = textFieldAnoRelatorioRelatorioDeProdutosAtacado.getText().toString();
				String produto = textFieldNomeDoProdutoRelatorioDeProdutosAtacado.getText().toString();
				
				try {
					PdfWriter.getInstance(Relatorio, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\Produtos\\"+produto+"-"+mes+"-"+ano+".pdf"));
					Relatorio.open();
					Relatorio.setPageSize(PageSize.A4);
					Relatorio.add(new Paragraph("Relatorio de saida de "+produto+" na Venda Atacado:\n"));
					String query =  "SELECT estoque.Produto, vendaatacado.quantidade, cliente.Nome, cliente.Empresa, cliente.Telefone1, vendaatacado.HoraDaVenda,vendaatacado.preco FROM adegagelaguela.estoque JOIN adegagelaguela.vendaatacado ON idEstoque = IDProduto "
							+ "JOIN adegagelaguela.cliente ON vendaatacado.IDCliente = cliente.idCliente WHERE vendaatacado.HoraDaVenda Like '"+ano+"-"+mes+"%' AND estoque.Produto LIKE '"+produto+"' ORDER BY Nome;";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					rs.next();
					Paragraph Produto = new Paragraph("Nome: " + rs.getString("cliente.Nome") + "\nEmpresa: " + rs.getString("cliente.Empresa") + "\nTelefone: " + rs.getString("cliente.Telefone1") + "\n"+"Valor vendido (unidade): R$" +rs.getString("vendaatacado.preco")+"\n"
							+"Quantidade: "+rs.getString("vendaatacado.quantidade")+"\nDia da compra: " +rs.getString("vendaatacado.HoraDaVenda")+"\n\n");
					Relatorio.add(Produto);
					while (rs.next()) {
						Relatorio.add(new Paragraph("\n"));
						Paragraph Produto2 = new Paragraph("Nome: " + rs.getString("cliente.Nome") + "\nEmpresa: " + rs.getString("cliente.Empresa") + "\nTelefone: " + rs.getString("cliente.Telefone1") + "\n"+"Valor vendido (unidade): R$" +rs.getString("vendaatacado.preco")+"\n"
								+"Quantidade: "+rs.getString("vendaatacado.quantidade")+"\nDia da compra: " +rs.getString("vendaatacado.HoraDaVenda")+"\n\n");
						Relatorio.add(Produto2);
					}
					pst.close();
					rs.close();
					String query2 = "SELECT NomeCliente, Telefone, NomeProduto, QuantidadeProduto, vendapersonalizada.Preco, PrecoDeCusto, HoraDaVenda FROM adegagelaguela.vendapersonalizada "
							+ "JOIN adegagelaguela.estoque ON Produto_ID = idEstoque  WHERE HoraDaVenda LIKE '"+ano+"-"+mes+"%' and idEstoque LIKE '"+textFieldIdDoProdutoRelatorioDeProdutosAtacado.getText().toString()+"%' ORDER BY NomeCliente;";
					PreparedStatement pst2 = conexao.prepareStatement(query2);
					ResultSet rs2 = pst2.executeQuery();
					rs2.next();
					Relatorio.add(new Paragraph("\nMovimentação de "+produto+" com a Venda Personalizada:\n"));
					Paragraph Produto3 = new Paragraph("Nome de quem comprou: " + rs2.getString("NomeCliente") + "\nTelefone: " + rs2.getString("Telefone") +"\n"+"Quantidade: " +rs2.getString("QuantidadeProduto")+ "\n" + "Valor vendido (unidade): R$" +rs2.getString("vendapersonalizada.Preco")+"\n"
							+"Preço comum (atual): R$"+rs2.getString("PrecoDeCusto")+"\nDia da compra: " +rs2.getString("HoraDaVenda")+"\n\n");
					Relatorio.add(Produto3);
					while (rs2.next()) {
						Relatorio.add(new Paragraph("\n"));
						Paragraph Produto2 = new Paragraph("Nome de quem comprou: " + rs2.getString("NomeCliente") + "Telefone: " + rs2.getString("Telefone") +"\n"+"Quantidade: " +rs2.getString("QuantidadeProduto")+ "\n" + "Valor vendido (unidade): R$" +rs2.getString("vendapersonalizada.Preco")+"\n"
								+"Preço comum (atual): R$"+rs2.getString("PrecoDeCusto")+"\nDia da compra: " +rs2.getString("HoraDaVenda")+"\n\n");
						Relatorio.add(Produto2);
					}
					pst2.close();
					rs2.close();
					
				}catch (DocumentException de) {
					de.printStackTrace();
				}catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (SQLException e2) {
					e2.printStackTrace();
					try {
						String query2 = "SELECT NomeCliente, Telefone, NomeProduto, QuantidadeProduto, vendapersonalizada.Preco, PrecoDeCusto, HoraDaVenda FROM adegagelaguela.vendapersonalizada "
								+ "JOIN adegagelaguela.estoque ON Produto_ID = idEstoque  WHERE HoraDaVenda LIKE '"+ano+"-"+mes+"%' and idEstoque LIKE '"+textFieldIdDoProdutoRelatorioDeProdutosAtacado.getText().toString()+"%' ORDER BY NomeCliente;";
						PreparedStatement pst2 = conexao.prepareStatement(query2);
						ResultSet rs2 = pst2.executeQuery();
						rs2.next();
						Relatorio.add(new Paragraph("\nMovimentação de "+produto+" com a Venda Personalizada:\n"));
						Paragraph Produto3 = new Paragraph("Nome de quem comprou: " + rs2.getString("NomeCliente") + "\nTelefone: " + rs2.getString("Telefone") +"\n"+"Quantidade: " +rs2.getString("QuantidadeProduto")+ "\n" + "Valor vendido (unidade): R$" +rs2.getString("vendapersonalizada.Preco")+"\n"
								+"Preço comum (atual): R$"+rs2.getString("PrecoDeCusto")+"\nDia da compra: " +rs2.getString("HoraDaVenda")+"\n\n");
						Relatorio.add(Produto3);
						while (rs2.next()) {
							Relatorio.add(new Paragraph("\n"));
							Paragraph Produto2 = new Paragraph("Nome de quem comprou: " + rs2.getString("NomeCliente") + "Telefone: " + rs2.getString("Telefone") +"\n"+"Quantidade: " +rs2.getString("QuantidadeProduto")+ "\n" + "Valor vendido (unidade): R$" +rs2.getString("vendapersonalizada.Preco")+"\n"
									+"Preço comum (atual): R$"+rs2.getString("PrecoDeCusto")+"\nDia da compra: " +rs2.getString("HoraDaVenda")+"\n\n");
							Relatorio.add(Produto2);
						}
						pst2.close();
						rs2.close();
					}catch (SQLException e3) {
							e3.printStackTrace();
					} catch (DocumentException e1) {
						e1.printStackTrace();
					}
				}finally {
					Relatorio.close();
				}
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Inkjet-Printer-icon.png"));
		btnNewButton_1.setBounds(10, 228, 198, 23);
		relatorioDeProdutosAtacado.add(btnNewButton_1);
	
		JLabel lblImagemDeFundoRelatorioDeProdutosAtacado = new JLabel("");
		lblImagemDeFundoRelatorioDeProdutosAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\JackDanielsApple-TomasArthuzzi-DrinkGarrafa-Blended02-1.jpg"));
		lblImagemDeFundoRelatorioDeProdutosAtacado.setBounds(0, 0, 800, 573);
		relatorioDeProdutosAtacado.add(lblImagemDeFundoRelatorioDeProdutosAtacado);
		bancoFinanceiro.setLayout(null);
		
		JLabel lblNewLabel_ImagemDepositoBancoFinanceiro = new JLabel("");
		lblNewLabel_ImagemDepositoBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\money-add-icon.png"));
		lblNewLabel_ImagemDepositoBancoFinanceiro.setBounds(10, 330, 32, 32);
		bancoFinanceiro.add(lblNewLabel_ImagemDepositoBancoFinanceiro);
		
		//
		//
		// Relatorio De Produtos Varejo
		//
		//
		
		
		JMenuBar menuBarRelatorioDeProdutosVarejo = new JMenuBar();
		menuBarRelatorioDeProdutosVarejo.setBounds(0, 0, 934, 22);
		menuBarRelatorioDeProdutosVarejo.setBackground(Color.LIGHT_GRAY);
		relatorioDeProdutosVarejo.add(menuBarRelatorioDeProdutosVarejo);

		JMenu mnProdutosRelatorioDeProdutosVarejo = new JMenu("Produtos");
		mnProdutosRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarRelatorioDeProdutosVarejo.add(mnProdutosRelatorioDeProdutosVarejo);

		JMenuItem mntmProdutosNaAdegaRelatorioDeProdutosVarejo = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosVarejo.setVisible(false);
				produtosNaAdega.setVisible(true);
			}
		});
		mntmProdutosNaAdegaRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosRelatorioDeProdutosVarejo.add(mntmProdutosNaAdegaRelatorioDeProdutosVarejo);

		JMenuItem mntmProdutosEmEstoqueRelatorioDeProdutosVarejo = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosVarejo.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosRelatorioDeProdutosVarejo.add(mntmProdutosEmEstoqueRelatorioDeProdutosVarejo);

		JMenuItem mntmProdutosParaComprarRelatorioDeProdutosVarejo = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosVarejo.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarRelatorioDeProdutosVarejo
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosRelatorioDeProdutosVarejo.add(mntmProdutosParaComprarRelatorioDeProdutosVarejo);

		JMenuItem mntmTodosProdutosRelatorioDeProdutosVarejo = new JMenuItem("Todos Produtos");
		mntmTodosProdutosRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosVarejo.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosRelatorioDeProdutosVarejo.add(mntmTodosProdutosRelatorioDeProdutosVarejo);

		JMenu mnVenderRelatorioDeProdutosVarejo = new JMenu("Vender");
		mnVenderRelatorioDeProdutosVarejo
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarRelatorioDeProdutosVarejo.add(mnVenderRelatorioDeProdutosVarejo);

		JMenuItem mntmVendaVarejoRelatorioDeProdutosVarejo = new JMenuItem("Venda Varejo");
		mntmVendaVarejoRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosVarejo.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderRelatorioDeProdutosVarejo.add(mntmVendaVarejoRelatorioDeProdutosVarejo);

		JMenuItem mntmVendaAtacadoRelatorioDeProdutosVarejo = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosVarejo.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderRelatorioDeProdutosVarejo.add(mntmVendaAtacadoRelatorioDeProdutosVarejo);

		JMenuItem mntmVendaPersonalizadaRelatorioDeProdutosVarejo = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosVarejo.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderRelatorioDeProdutosVarejo.add(mntmVendaPersonalizadaRelatorioDeProdutosVarejo);
		
		JMenu mnClientesRelatorioDeProdutosVarejo = new JMenu("Clientes");
		mnClientesRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarRelatorioDeProdutosVarejo.add(mnClientesRelatorioDeProdutosVarejo);
		
		JMenuItem mntmNewMenuClientesVarejoRelatorioDeProdutosVarejo = new JMenuItem("Clientes Varejo");
		mntmNewMenuClientesVarejoRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(true);
				relatorioDeProdutosVarejo.setVisible(false);
			}
		});
		mntmNewMenuClientesVarejoRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesRelatorioDeProdutosVarejo.add(mntmNewMenuClientesVarejoRelatorioDeProdutosVarejo);

		JMenu mnFinanceiroRelatorioDeProdutosVarejo = new JMenu("Financeiro");
		mnFinanceiroRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarRelatorioDeProdutosVarejo.add(mnFinanceiroRelatorioDeProdutosVarejo);
		
		JMenuItem mntmNewMenuItemRelatorioDeVendasRelatorioProdutosVarejo = new JMenuItem("Relatorio de Vendas");
		mntmNewMenuItemRelatorioDeVendasRelatorioProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(true);
				relatorioDeProdutosVarejo.setVisible(false);
			}
		});
		mntmNewMenuItemRelatorioDeVendasRelatorioProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroRelatorioDeProdutosVarejo.add(mntmNewMenuItemRelatorioDeVendasRelatorioProdutosVarejo);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroVarejo = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosVarejo.setVisible(false);
				bancoFinanceiro.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1_10 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_10.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroRelatorioDeProdutosVarejo.add(mnNewMenu_1_10);
		
		JMenuItem mntmNewMenuItemRelatorioDeProdutosVarejo = new JMenuItem("Atacado");
		mntmNewMenuItemRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeProdutosVarejo.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mnNewMenu_1_10.add(mntmNewMenuItemRelatorioDeProdutosVarejo);
		mntmNewMenuItemRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo_10 = new JMenuItem("Varejo");
		mntmVarejo_10.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_10.add(mntmVarejo_10);
		mntmNewMenuItemBancoFinanceiroVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroRelatorioDeProdutosVarejo.add(mntmNewMenuItemBancoFinanceiroVarejo);

		JMenu mnAjudaRelatorioDeProdutosVarejo = new JMenu("Ajuda");
		mnAjudaRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarRelatorioDeProdutosVarejo.add(mnAjudaRelatorioDeProdutosVarejo);

		JMenuItem mntmDadosDaVersaoRelatorioDeProdutosVarejo = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaRelatorioDeProdutosVarejo.add(mntmDadosDaVersaoRelatorioDeProdutosVarejo);
		
		JScrollPane scrollPaneRelatorioDeProdutosRelatorioDeProdutosVarejo = new JScrollPane();
		scrollPaneRelatorioDeProdutosRelatorioDeProdutosVarejo.setBounds(10, 170, 388, 47);
		relatorioDeProdutosVarejo.add(scrollPaneRelatorioDeProdutosRelatorioDeProdutosVarejo);
		
		tableRelatorioDeProdutos = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		scrollPaneRelatorioDeProdutosRelatorioDeProdutosVarejo.setViewportView(tableRelatorioDeProdutos);
		
		
		
		JLabel lblNomeDoProdutoRelatorioDeProdutosVarejo = new JLabel("Produto :");
		lblNomeDoProdutoRelatorioDeProdutosVarejo.setBounds(10, 80, 130, 20);
		relatorioDeProdutosVarejo.add(lblNomeDoProdutoRelatorioDeProdutosVarejo);
		
		JLabel lblDadosDoProdutoRelatorioDeProdutosVarejo = new JLabel("Dados do Produto VAREJO :");
		lblDadosDoProdutoRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-And-Pretzel-icon.png"));
		lblDadosDoProdutoRelatorioDeProdutosVarejo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDadosDoProdutoRelatorioDeProdutosVarejo.setBounds(10, 33, 388, 24);
		relatorioDeProdutosVarejo.add(lblDadosDoProdutoRelatorioDeProdutosVarejo);
		
		
		JTextField textFieldMesRelatorioRelatorioDeProdutosVarejo = new JTextField();
		textFieldMesRelatorioRelatorioDeProdutosVarejo.setBounds(52, 110, 45, 20);
		relatorioDeProdutosVarejo.add(textFieldMesRelatorioRelatorioDeProdutosVarejo);
		textFieldMesRelatorioRelatorioDeProdutosVarejo.setColumns(10);
		
		JTextField textFieldAnoRelatorioRelatorioDeProdutosVarejo = new JTextField();
		textFieldAnoRelatorioRelatorioDeProdutosVarejo.setColumns(10);
		textFieldAnoRelatorioRelatorioDeProdutosVarejo.setBounds(146, 110, 62, 20);
		relatorioDeProdutosVarejo.add(textFieldAnoRelatorioRelatorioDeProdutosVarejo);
		
		JTextField textFieldNomeDoProdutoRelatorioDeProdutosVarejo = new JTextField();
		textFieldNomeDoProdutoRelatorioDeProdutosVarejo.setEditable(false);
		textFieldNomeDoProdutoRelatorioDeProdutosVarejo.setBounds(71, 80, 137, 20);
		relatorioDeProdutosVarejo.add(textFieldNomeDoProdutoRelatorioDeProdutosVarejo);
		textFieldNomeDoProdutoRelatorioDeProdutosVarejo.setColumns(10);
		
		JTextField textFieldIdDoProdutoRelatorioDeProdutosVarejo = new JTextField();
		textFieldIdDoProdutoRelatorioDeProdutosVarejo.setEditable(false);
		textFieldIdDoProdutoRelatorioDeProdutosVarejo.setVisible(false);
		textFieldIdDoProdutoRelatorioDeProdutosVarejo.setBounds(256, 80, 45, 20);
		relatorioDeProdutosVarejo.add(textFieldIdDoProdutoRelatorioDeProdutosVarejo);
		textFieldIdDoProdutoRelatorioDeProdutosVarejo.setColumns(10);
		
		JScrollPane scrollPaneListaDeProdutosRelatorioDeProdutosVarejo = new JScrollPane();
		scrollPaneListaDeProdutosRelatorioDeProdutosVarejo.setBounds(490, 60, 261, 485);
		relatorioDeProdutosVarejo.add(scrollPaneListaDeProdutosRelatorioDeProdutosVarejo);
		
		tableListaDeProdutosRelatorioDeProdutos = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableListaDeProdutosRelatorioDeProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableListaDeProdutosRelatorioDeProdutos.getSelectedRow();
				textFieldIdDoProdutoRelatorioDeProdutosVarejo.setText(tableListaDeProdutosRelatorioDeProdutos.getValueAt(linha, 0).toString());
				textFieldNomeDoProdutoRelatorioDeProdutosVarejo.setText(tableListaDeProdutosRelatorioDeProdutos.getValueAt(linha, 1).toString());
			}
		});
		scrollPaneListaDeProdutosRelatorioDeProdutosVarejo.setViewportView(tableListaDeProdutosRelatorioDeProdutos);
		
		JButton btnListaDeProdutosRelatorioDeProdutosVarejo = new JButton("Lista de Produtos");
		btnListaDeProdutosRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-icon.png"));
		btnListaDeProdutosRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT Id 'Numero de ID', Nome 'Nome do Produto' from adegagelaguela.lojatatuape ORDER BY Nome";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableListaDeProdutosRelatorioDeProdutos.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();
					
				}catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListaDeProdutosRelatorioDeProdutosVarejo.setBounds(490, 33, 148, 23);
		relatorioDeProdutosVarejo.add(btnListaDeProdutosRelatorioDeProdutosVarejo);
		
		JLabel lblMesRelatorioRelatorioDeProdutosVarejo = new JLabel("M\u00EAs :");
		lblMesRelatorioRelatorioDeProdutosVarejo.setBounds(10, 110, 46, 20);
		relatorioDeProdutosVarejo.add(lblMesRelatorioRelatorioDeProdutosVarejo);
		
		JLabel lblAnoRelatorioRelatorioDeProdutosVarejo = new JLabel("Ano :");
		lblAnoRelatorioRelatorioDeProdutosVarejo.setBounds(107, 110, 46, 20);
		relatorioDeProdutosVarejo.add(lblAnoRelatorioRelatorioDeProdutosVarejo);

		
		JButton btnRelatorioDoProdutoRelatorioDeProdutosVarejo = new JButton("Relatorio do Produto");
		btnRelatorioDoProdutoRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\balance-unbalance-icon.png"));
		btnRelatorioDoProdutoRelatorioDeProdutosVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldMesRelatorioRelatorioDeProdutosVarejo.getText().toString().equals("") && !textFieldAnoRelatorioRelatorioDeProdutosVarejo.getText().toString().equals("") && !textFieldIdDoProdutoRelatorioDeProdutosVarejo.getText().toString().equals("")) {
					int ano = Integer.parseInt(textFieldAnoRelatorioRelatorioDeProdutosVarejo.getText().toString());
					int mes = Integer.parseInt(textFieldMesRelatorioRelatorioDeProdutosVarejo.getText().toString());
						if(!(mes > 9) && !(textFieldAnoRelatorioRelatorioDeProdutosVarejo.getText().toString().charAt(0) == '0') ) {
							try {
								String query = "SELECT Produto, SUM(Quantidade) as QuantidadeVendida, format(SUM(PrecoTotal),2,'de_DE') as ValorVendido FROM adegagelaguela.vendavarejo WHERE IDProduto = (?) and vendavarejo.HoraDaVenda LIKE  '"+ano+"-0"+mes+"%'";
								PreparedStatement pst = conexao.prepareStatement(query);
								pst.setString(1, textFieldIdDoProdutoRelatorioDeProdutosVarejo.getText().toString());
								ResultSet rs = pst.executeQuery();
								tableRelatorioDeProdutos.setModel(DbUtils.resultSetToTableModel(rs));
			
								pst.close();
								rs.close();
								
							}catch (Exception g) {
								g.printStackTrace();
							}
						} else 
							try {
							String query = "SELECT Produto, SUM(Quantidade) as QuantidadeVendida, format(SUM(PrecoTotal),2,'de_DE') as ValorVendido FROM adegagelaguela.vendavarejo WHERE IDProduto = (?) and vendavarejo.HoraDaVenda LIKE '"+ano+"-"+mes+"%'";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.setString(1, textFieldIdDoProdutoRelatorioDeProdutosVarejo.getText().toString());
							ResultSet rs = pst.executeQuery();
							tableRelatorioDeProdutos.setModel(DbUtils.resultSetToTableModel(rs));
		
							pst.close();
							rs.close();
							
						}catch (Exception g) {
							g.printStackTrace();
						}
				}else JOptionPane.showMessageDialog(null, "Preencher todos os campos para consulta", "", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnRelatorioDoProdutoRelatorioDeProdutosVarejo.setBounds(10, 140, 198, 21);
		relatorioDeProdutosVarejo.add(btnRelatorioDoProdutoRelatorioDeProdutosVarejo);
		
		JLabel lblImagemDeFundoRelatorioDeProdutosVarejo = new JLabel("");
		lblImagemDeFundoRelatorioDeProdutosVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\FundoRelatorioVarejo.jpg"));
		lblImagemDeFundoRelatorioDeProdutosVarejo.setBounds(0, 0, 800, 573);
		relatorioDeProdutosVarejo.add(lblImagemDeFundoRelatorioDeProdutosVarejo);
		bancoFinanceiro.setLayout(null);

		
		
		
		
		
		
		//
		//
		// BANCO FINANCEIRO
		//
		//
		
		JMenuBar menuBarBancoFinanceiro = new JMenuBar();
		menuBarBancoFinanceiro.setBounds(0, 0, 934, 22);
		menuBarBancoFinanceiro.setBackground(Color.LIGHT_GRAY);
		bancoFinanceiro.add(menuBarBancoFinanceiro);

		JMenu mnProdutosBancoFinanceiro = new JMenu("Produtos");
		mnProdutosBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarBancoFinanceiro.add(mnProdutosBancoFinanceiro);

		JMenuItem mntmProdutosNaAdegaBancoFinanceiro = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancoFinanceiro.setVisible(false);
				produtosNaAdega.setVisible(true);
			}
		});
		mntmProdutosNaAdegaBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosBancoFinanceiro.add(mntmProdutosNaAdegaBancoFinanceiro);

		JMenuItem mntmProdutosEmEstoqueBancoFinanceiro = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancoFinanceiro.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosBancoFinanceiro.add(mntmProdutosEmEstoqueBancoFinanceiro);

		JMenuItem mntmProdutosParaComprarBancoFinanceiro = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancoFinanceiro.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarBancoFinanceiro
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosBancoFinanceiro.add(mntmProdutosParaComprarBancoFinanceiro);

		JMenuItem mntmTodosProdutosBancoFinanceiro = new JMenuItem("Todos Produtos");
		mntmTodosProdutosBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancoFinanceiro.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosBancoFinanceiro.add(mntmTodosProdutosBancoFinanceiro);

		JMenu mnVenderBancoFinanceiro = new JMenu("Vender");
		mnVenderBancoFinanceiro
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarBancoFinanceiro.add(mnVenderBancoFinanceiro);

		JMenuItem mntmVendaVarejoBancoFinanceiro = new JMenuItem("Venda Varejo");
		mntmVendaVarejoBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancoFinanceiro.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderBancoFinanceiro.add(mntmVendaVarejoBancoFinanceiro);

		JMenuItem mntmVendaAtacadoBancoFinanceiro = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancoFinanceiro.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderBancoFinanceiro.add(mntmVendaAtacadoBancoFinanceiro);

		JMenuItem mntmVendaPersonalizadaBancoFinanceiro = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancoFinanceiro.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderBancoFinanceiro.add(mntmVendaPersonalizadaBancoFinanceiro);
		
		JMenu mnClientesBancoFinanceiro = new JMenu("Clientes");
		mnClientesBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarBancoFinanceiro.add(mnClientesBancoFinanceiro);
		
		JMenuItem mntmNewMenuClientesAtacadoBancoFinanceiro = new JMenuItem("Clientes Atacado");
		mntmNewMenuClientesAtacadoBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientesAtacado.setVisible(true);
				bancoFinanceiro.setVisible(false);
			}
		});
		mntmNewMenuClientesAtacadoBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesBancoFinanceiro.add(mntmNewMenuClientesAtacadoBancoFinanceiro);

		JMenu mnFinanceiroBancoFinanceiro = new JMenu("Financeiro");
		mnFinanceiroBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarBancoFinanceiro.add(mnFinanceiroBancoFinanceiro);
		
		JMenuItem mntmNewMenuItemRelatorioDeVendasBancoFinanceiro = new JMenuItem("Relatorio de Vendas");
		mntmNewMenuItemRelatorioDeVendasBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioDeVendas.setVisible(true);
				bancoFinanceiro.setVisible(false);
			}
		});
		mntmNewMenuItemRelatorioDeVendasBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		mnFinanceiroBancoFinanceiro.add(mntmNewMenuItemRelatorioDeVendasBancoFinanceiro);
		
		JMenu mnNewMenu_1_11 = new JMenu("Relatorio de Produtos");
		mnNewMenu_1_11.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Globe-terrestre-2-icon.png"));
		mnFinanceiroBancoFinanceiro.add(mnNewMenu_1_11);
		
		JMenuItem mntmNewMenuItemBancoFinanceiro = new JMenuItem("Atacado");
		mntmNewMenuItemBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancoFinanceiro.setVisible(false);
				relatorioDeProdutosAtacado.setVisible(true);
			}
		});
		mnNewMenu_1_11.add(mntmNewMenuItemBancoFinanceiro);
		mntmNewMenuItemBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		
		JMenuItem mntmVarejo_11 = new JMenuItem("Varejo");
		mntmVarejo_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancoFinanceiro.setVisible(false);
				relatorioDeProdutosVarejo.setVisible(true);
			}
		});
		mntmVarejo_11.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		mnNewMenu_1_11.add(mntmVarejo_11);
		
		JMenuItem mntmNewMenuItemBancoFinanceiroMenuUnicial_11 = new JMenuItem("Banco Financeiro");
		mntmNewMenuItemBancoFinanceiroMenuUnicial_11.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon.png"));
		mnFinanceiroBancoFinanceiro.add(mntmNewMenuItemBancoFinanceiroMenuUnicial_11);

		JMenu mnAjudaBancoFinanceiro = new JMenu("Ajuda");
		mnAjudaBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarBancoFinanceiro.add(mnAjudaBancoFinanceiro);

		JMenuItem mntmDadosDaVersaoBancoFinanceiro = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaBancoFinanceiro.add(mntmDadosDaVersaoBancoFinanceiro);
		
		textFieldPagarFuncionarioBancoFinanceiro = new JTextField();
		textFieldPagarFuncionarioBancoFinanceiro.setEditable(false);
		textFieldPagarFuncionarioBancoFinanceiro.setBounds(652, 455, 98, 20);
		bancoFinanceiro.add(textFieldPagarFuncionarioBancoFinanceiro);
		textFieldPagarFuncionarioBancoFinanceiro.setColumns(10);
		
		JLabel lblNewLabelCofreBancoFinanceiro = new JLabel("");
		lblNewLabelCofreBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Strong-box-money-icon.png"));
		lblNewLabelCofreBancoFinanceiro.setBounds(20, 63, 128, 137);
		bancoFinanceiro.add(lblNewLabelCofreBancoFinanceiro);
		
		txtQuantiaNoCofreBancoFinanceiro = new JTextField();
		txtQuantiaNoCofreBancoFinanceiro.setText("");
		Cofre();
		txtQuantiaNoCofreBancoFinanceiro.setEditable(false);
		txtQuantiaNoCofreBancoFinanceiro.setBounds(20, 200, 120, 20);
		bancoFinanceiro.add(txtQuantiaNoCofreBancoFinanceiro);
		txtQuantiaNoCofreBancoFinanceiro.setColumns(10);
		
		textFieldIDFuncionarioBancoFinanceiro = new JTextField();
		textFieldIDFuncionarioBancoFinanceiro.setEditable(false);
		textFieldIDFuncionarioBancoFinanceiro.setVisible(false);
		textFieldIDFuncionarioBancoFinanceiro.setBounds(657, 512, 32, 22);
		bancoFinanceiro.add(textFieldIDFuncionarioBancoFinanceiro);
		textFieldIDFuncionarioBancoFinanceiro.setColumns(10);

		textFieldNomeFuncionarioBancoFinanceiro = new JTextField();
		textFieldNomeFuncionarioBancoFinanceiro.setEditable(false);
		textFieldNomeFuncionarioBancoFinanceiro.setBounds(652, 424, 98, 20);
		bancoFinanceiro.add(textFieldNomeFuncionarioBancoFinanceiro);
		textFieldNomeFuncionarioBancoFinanceiro.setColumns(10);
		
		JLabel lblNewLabel_ImagemPagarFuncionarioBancoFinanceiro = new JLabel("");
		lblNewLabel_ImagemPagarFuncionarioBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\payment-icon.png"));
		lblNewLabel_ImagemPagarFuncionarioBancoFinanceiro.setBounds(594, 427, 48, 48);
		bancoFinanceiro.add(lblNewLabel_ImagemPagarFuncionarioBancoFinanceiro);
		
		JButton btnNewButton_PagarFuncionarioBancoFinanceiro = new JButton("Pagar Funcionario");
		btnNewButton_PagarFuncionarioBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "INSERT INTO adegagelaguela.pagamentos (idFuncionario, ValorPago) VALUES (?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldIDFuncionarioBancoFinanceiro.getText());
					pst.setString(2, textFieldPagarFuncionarioBancoFinanceiro.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Funcionario Pago !");	
					pst.close();
					Cofre();
					textFieldIDFuncionarioBancoFinanceiro.setText("");
					textFieldPagarFuncionarioBancoFinanceiro.setText("");
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButton_PagarFuncionarioBancoFinanceiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_PagarFuncionarioBancoFinanceiro.setBounds(594, 484, 156, 17);
		bancoFinanceiro.add(btnNewButton_PagarFuncionarioBancoFinanceiro);
		
		JScrollPane scrollPaneListaDeFuncionariosBancoFinanceiro = new JScrollPane();
		scrollPaneListaDeFuncionariosBancoFinanceiro.setBounds(551, 124, 199, 280);
		bancoFinanceiro.add(scrollPaneListaDeFuncionariosBancoFinanceiro);
		
		tableListaDeFuncionariosBancoFinanceiro = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableListaDeFuncionariosBancoFinanceiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableListaDeFuncionariosBancoFinanceiro.getSelectedRow();
				textFieldIDFuncionarioBancoFinanceiro.setText(tableListaDeFuncionariosBancoFinanceiro.getValueAt(linha, 0).toString());
				textFieldNomeFuncionarioBancoFinanceiro.setText(tableListaDeFuncionariosBancoFinanceiro.getValueAt(linha, 1).toString());
				textFieldPagarFuncionarioBancoFinanceiro.setText(tableListaDeFuncionariosBancoFinanceiro.getValueAt(linha, 3).toString());
			}
		});
		scrollPaneListaDeFuncionariosBancoFinanceiro.setViewportView(tableListaDeFuncionariosBancoFinanceiro);
		
		JButton btnNewButton_ListaDeFuncionarioBancoFinanceiro = new JButton("Lista de funcionarios");
		btnNewButton_ListaDeFuncionarioBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT idfuncionarios 'ID', Nome, Funcao 'Cargo', Salario 'Salário' FROM adegagelaguela.funcionarios ORDER BY Nome";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableListaDeFuncionariosBancoFinanceiro.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButton_ListaDeFuncionarioBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		btnNewButton_ListaDeFuncionarioBancoFinanceiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_ListaDeFuncionarioBancoFinanceiro.setBounds(565, 99, 170, 20);
		bancoFinanceiro.add(btnNewButton_ListaDeFuncionarioBancoFinanceiro);
		
		JButton btnNewButton_RealizarRetiradaBancoFinanceiro = new JButton("Realizar Retirada");
		btnNewButton_RealizarRetiradaBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "UPDATE adegagelaguela.cofre SET QuantiaRetirada = (?) + QuantiaRetirada WHERE (idcofre = 1)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textField_RealizarRetiradaBancoFinanceiro.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Retirada realizada");
					pst.close();
					Cofre();
					textField_RealizarRetiradaBancoFinanceiro.setText("");
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButton_RealizarRetiradaBancoFinanceiro.setBounds(52, 439, 128, 23);
		bancoFinanceiro.add(btnNewButton_RealizarRetiradaBancoFinanceiro);
		
		textField_RealizarRetiradaBancoFinanceiro = new JTextField();
		textField_RealizarRetiradaBancoFinanceiro.setBounds(52, 410, 128, 20);
		bancoFinanceiro.add(textField_RealizarRetiradaBancoFinanceiro);
		textField_RealizarRetiradaBancoFinanceiro.setColumns(10);
		
		JLabel lblNewLabel_PagarFuncionarioBancoFinanceiro = new JLabel("Pagamento de Funcionarios :");
		lblNewLabel_PagarFuncionarioBancoFinanceiro.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_PagarFuncionarioBancoFinanceiro.setBounds(532, 63, 218, 24);
		bancoFinanceiro.add(lblNewLabel_PagarFuncionarioBancoFinanceiro);
		
		textField_RealizarDepositoBancoFinanceiro = new JTextField();
		textField_RealizarDepositoBancoFinanceiro.setBounds(52, 322, 128, 20);
		bancoFinanceiro.add(textField_RealizarDepositoBancoFinanceiro);
		textField_RealizarDepositoBancoFinanceiro.setColumns(10);
		
		JButton btnNewButton_RealizarDepositoBancoFinanceiro = new JButton("Realizar Deposito");
		btnNewButton_RealizarDepositoBancoFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "UPDATE adegagelaguela.cofre SET QuantiaTotal = (?) + QuantiaTotal WHERE (idcofre = 1)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textField_RealizarDepositoBancoFinanceiro.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Deposito realizado");
					pst.close();
					Cofre();
					textField_RealizarDepositoBancoFinanceiro.setText("");
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButton_RealizarDepositoBancoFinanceiro.setBounds(52, 350, 128, 23);
		bancoFinanceiro.add(btnNewButton_RealizarDepositoBancoFinanceiro);
		
		JLabel lblNewLabel_ImagemRetiradaBancoFinanceiro = new JLabel("");
		lblNewLabel_ImagemRetiradaBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\money-delete-icon.png"));
		lblNewLabel_ImagemRetiradaBancoFinanceiro.setBounds(10, 423, 32, 32);
		bancoFinanceiro.add(lblNewLabel_ImagemRetiradaBancoFinanceiro);
		
		textFieldMesBancoFinanceiro = new JTextField();
		textFieldMesBancoFinanceiro.setBounds(60, 495, 32, 20);
		bancoFinanceiro.add(textFieldMesBancoFinanceiro);
		textFieldMesBancoFinanceiro.setColumns(10);
		
		textFieldAnoBancoFinanceiro = new JTextField();
		textFieldAnoBancoFinanceiro.setBounds(134, 495, 46, 20);
		bancoFinanceiro.add(textFieldAnoBancoFinanceiro);
		textFieldAnoBancoFinanceiro.setColumns(10);
		
		JButton btnNewButton = new JButton("Baixar Movimenta\u00E7\u00E3o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentoRegistroBancario();
				textFieldMesBancoFinanceiro.setText("");
				textFieldAnoBancoFinanceiro.setText("");
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\printer-icon.png"));
		btnNewButton.setBounds(10, 523, 170, 24);
		bancoFinanceiro.add(btnNewButton);
		
		JLabel lblMesBancoFinanceiro = new JLabel("M\u00EAs :");
		lblMesBancoFinanceiro.setForeground(Color.WHITE);
		lblMesBancoFinanceiro.setBounds(23, 495, 46, 20);
		bancoFinanceiro.add(lblMesBancoFinanceiro);
		
		JLabel lblAnoBancoFinanceiro = new JLabel("Ano :");
		lblAnoBancoFinanceiro.setForeground(Color.WHITE);
		lblAnoBancoFinanceiro.setBounds(102, 495, 46, 20);
		bancoFinanceiro.add(lblAnoBancoFinanceiro);
		rdbtnDetalharBancoFinanceiro = new JRadioButton("Detalhada");
		rdbtnDetalharBancoFinanceiro.setRequestFocusEnabled(false);
		rdbtnDetalharBancoFinanceiro.setOpaque(false);
		rdbtnDetalharBancoFinanceiro.setFocusable(false);
		rdbtnDetalharBancoFinanceiro.setFocusPainted(false);
		rdbtnDetalharBancoFinanceiro.setBounds(10, 547, 98, 23);
		bancoFinanceiro.add(rdbtnDetalharBancoFinanceiro);
		
		
		JLabel lblNewLabel_ImagemDeFundoBancoFinanceiro = new JLabel("");
		lblNewLabel_ImagemDeFundoBancoFinanceiro.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\drink_pronto.jpg"));
		lblNewLabel_ImagemDeFundoBancoFinanceiro.setBounds(0, 0, 800, 570);
		bancoFinanceiro.add(lblNewLabel_ImagemDeFundoBancoFinanceiro);
		
		
		//
		//
		// TELA DE LOGIN
		//
		//
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(Color.DARK_GRAY);
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
					btnEntrar.addActionListener(new ActionListener() {
						@SuppressWarnings("deprecation")
						public void actionPerformed(ActionEvent e) {
							if (checkLogin(textLogin.getText(), new String(txtSenha.getText()))) {
								menuInicial.setVisible(true);
								telaDeLogin.setVisible(false);
								mntmProdutosEmEstoqueMenuInicial.setVisible(false);
								mntmProdutosParaComprarMenuInicial.setVisible(false);
								mntmProdutosEmEstoqueProdutosNaAdega.setVisible(false);
								mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
								mntmTodosOsProdutosProdutosEmEstoque.setVisible(false);
								mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
								mntmTodosOsProdutosProdutosParaComprar.setVisible(false);
								mnFinanceiroMenuInicial.setVisible(false);
								mntmVendaAtacadoMenuInicial.setVisible(false);
								mntmVendaPersonalizadaMenuInicial.setVisible(false);
								mnFinanceiroProdutosNaAdega.setVisible(false);
								mntmVendaAtacadoProdutosNaAdega.setVisible(false);
								mntmVendaPersonalizadaProdutosNaAdega.setVisible(false);
								mnFinanceiroTodosOsProdutos.setVisible(false);
								mntmVendaAtacadoTodosOsProdutos.setVisible(false);
								mntmVendaPersonalizadaTodosOsProdutos.setVisible(false);
								btnEntrar.getRootPane().setDefaultButton(btnEntrar);
							} else if (checkLoginADM(textLogin.getText(), new String(txtSenha.getText()))) {
								menuInicial.setVisible(true);
								telaDeLogin.setVisible(false);
								mntmProdutosNaAdegaMenuInicial.setVisible(false);
								btnEntrar.getRootPane().setDefaultButton(btnEntrar);
							} else {
								JOptionPane.showMessageDialog(null, "Dados inválidos!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
							}

						}
					});
				}
			}
		});
		btnEntrar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-dialog-ok-apply-icon.png"));
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (checkLogin(textLogin.getText(), new String(txtSenha.getText()))) {
					menuInicial.setVisible(true);
					telaDeLogin.setVisible(false);
					mntmProdutosEmEstoqueMenuInicial.setVisible(false);
					mntmProdutosParaComprarMenuInicial.setVisible(false);
					mntmProdutosEmEstoqueProdutosNaAdega.setVisible(false);
					mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
					mntmTodosOsProdutosProdutosEmEstoque.setVisible(false);
					mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
					mntmTodosOsProdutosProdutosParaComprar.setVisible(false);
					mnClientesMenuInicial.setVisible(false);
					mnFinanceiroMenuInicial.setVisible(false);
					mntmVendaAtacadoMenuInicial.setVisible(false);
					mntmVendaPersonalizadaMenuInicial.setVisible(false);
					mnFinanceiroProdutosNaAdega.setVisible(false);
					mntmVendaAtacadoProdutosNaAdega.setVisible(false);
					mntmVendaPersonalizadaProdutosNaAdega.setVisible(false);
					mnFinanceiroTodosOsProdutos.setVisible(false);
					mntmVendaAtacadoTodosOsProdutos.setVisible(false);
					mntmVendaPersonalizadaTodosOsProdutos.setVisible(false);
					mnClientesProdutosNaAdega.setVisible(false);
					mnClientesTodosOsProdutos.setVisible(false);
					mnClientesVendaVarejo.setVisible(false);
					mnFinanceiroVendaVarejo.setVisible(false);
					mntmVendaAtacadoVendaVarejo.setVisible(false);
					mntmVendaPersonalizadaVendaVarejo.setVisible(false);
					mntmProdutosEmEstoqueVendaVarejo.setVisible(false);
					mntmProdutosParaComprarVendaVarejo.setVisible(false);
					btnEntrar.getRootPane().setDefaultButton(btnEntrar);
				} else if (checkLoginADM(textLogin.getText(), new String(txtSenha.getText()))) {
					menuInicial.setVisible(true);
					telaDeLogin.setVisible(false);
					btnEntrar.getRootPane().setDefaultButton(btnEntrar);
					
				} else {
					JOptionPane.showMessageDialog(null, "Dados inválidos!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
				}

			}
			@SuppressWarnings("unused")
			public void keyPressed(KeyEvent e) {
				btnEntrar.getRootPane().setDefaultButton(btnEntrar);
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBounds(465, 221, 101, 20);
		telaDeLogin.add(btnEntrar);

		JLabel lblNewLabelLogin = new JLabel("Login");
		lblNewLabelLogin.setForeground(Color.WHITE);
		lblNewLabelLogin.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		lblNewLabelLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelLogin.setBounds(359, 150, 83, 23);
		telaDeLogin.add(lblNewLabelLogin);

		textLogin = new JTextField();
		textLogin.setSelectionColor(Color.WHITE);
		textLogin.setOpaque(false);
		textLogin.setBounds(444, 150, 145, 23);
		telaDeLogin.add(textLogin);
		textLogin.setColumns(10);

		JLabel lblNewLabelSenha = new JLabel("Senha");
		lblNewLabelSenha.setForeground(Color.WHITE);
		lblNewLabelSenha.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\key-icon (1).png"));
		lblNewLabelSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelSenha.setBounds(359, 190, 83, 20);
		telaDeLogin.add(lblNewLabelSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setOpaque(false);
		txtSenha.setForeground(Color.WHITE);
		txtSenha.setSelectionColor(Color.WHITE);
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtSenha.getRootPane().setDefaultButton(btnEntrar);
			}
		});
		txtSenha.setBackground(Color.WHITE);
		txtSenha.setEchoChar('*');
		txtSenha.setColumns(10);
		txtSenha.setBounds(444, 190, 145, 20);
		telaDeLogin.add(txtSenha);

		JLabel lblNewLabelImagemDeFundo = new JLabel("");
		lblNewLabelImagemDeFundo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Blue-Label-e1489370807665.jpg"));
		lblNewLabelImagemDeFundo.setBounds(0, -22, 789, 630);
		telaDeLogin.add(lblNewLabelImagemDeFundo);
		

		

	}

	public boolean checkLogin(String login, String senha) {
		return login.equals("user") && senha.equals("123");
	}
	public boolean checkLoginADM(String login, String senha) {
		return login.equals("1") && senha.equals("1");
	}
	
	@SuppressWarnings("deprecation")
	public String admSenha() {
		JPasswordField jpf = new JPasswordField(4);
		 jpf.setEchoChar('*');
		 JLabel jl = new JLabel("Digite a senha: ");
		 Box box = Box.createHorizontalBox();
		 box.add(jl);
		 box.add(jpf);
		JOptionPane.showConfirmDialog(null, box, "", JOptionPane.OK_CANCEL_OPTION);
		return jpf.getText().toString();
	}
	//
	//
	// RefreshTables & metodos
	//
	//
	public void refreshtableProdutosNaAdega() {
		try {
			String query = "SELECT Id 'ID', Nome 'Nome do Produto', Unidades, Preco 'Preço por Un', format(PrecoTotal,2,'de_DE') 'Valor total' FROM adegagelaguela.lojaTatuape ORDER BY Nome";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosNaAdega.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}

	public void refreshtableProdutosEmEstoque() {
		try {
			String query = "Select idEstoque 'ID',Produto, QuantidadeAtual 'Quantidade', PrecoDeCusto 'Preco Un',format(PrecoTotal,2,'de_DE') 'Valor Total' From estoque ORDER BY Produto";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosEmEstoque.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}

	public void refreshtableProdutosParaComprar() {
		try {
			String query = "SELECT IDParaCompra 'ID', Nome, QuantidadeUn 'Quantidade UN', Preco 'Preço', format(ValorDeCompra,2,'de_DE') 'Total da compra' FROM adegagelaguela.produtosparacomprar ORDER BY Nome";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosParaComprar.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshtableTodosOsProdutos() {
		try {
			String query = "SELECT * FROM adegagelaguela.todosprodutos ORDER BY Produto";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableTodosProdutos.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	
	public void refreshTableClientesClientes() {
		try {
			String query = "SELECT idCliente 'ID', Nome, CPF, Email, Telefone1, Telefone2, Empresa, CNPJ, TelefoneEmpresa 'Telefone da Empresa', Endereco 'Endereço', Numero 'Nº', Bairro, Cidade FROM adegagelaguela.cliente";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableClientesClientes.setModel(DbUtils.resultSetToTableModel(rs));
			somaClientes();
			pst.close();
			rs.close();
		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	
	public void somaClientes() {
		try { 
			String query = "SELECT COUNT(*) FROM adegagelaguela.cliente";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableNmrClientes.setModel(DbUtils.resultSetToTableModel(rs));
			textFieldNmrDeCliente.setText(tableNmrClientes.getValueAt(0, 0).toString());
			pst.close();
			rs.close();
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		
	}
	
	public void refreshTableClientesVendaAtacado() {
		try {
			String query = "SELECT idCliente 'ID', Nome 'Cliente', Empresa FROM adegagelaguela.cliente";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableClientesVendaAtacado_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshtableProdutosVendaAtacado() {
		try {
			String query = "SELECT idEstoque 'ID', Produto 'Nome do Produto', QuantidadeAtual 'Quantidade Disponivel', PrecoDeCusto 'Preço do Produto' FROM adegagelaguela.estoque ORDER BY Produto";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosVendaAtacado.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	
	public void refreshTableProdutoVendaVarejo() {
		try {
			String query = "SELECT Id 'ID', Nome 'Nome do Produto', Unidades, Preco 'Preço por Un' FROM adegagelaguela.lojaTatuape ORDER BY Nome";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table_ProdutoVendaVarejo.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	
	public void Cofre() {
		try {
			String query = "SELECT QuantiaAtual FROM adegagelaguela.cofre";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			rs.next();
			txtQuantiaNoCofreBancoFinanceiro.setText("R$: " + rs.getString(1));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	
	public void AttValorTotalPersonalizada() {
		txtValorTotal.setText("R$: "+ valorCarrinhoPersonalizada.toString());
	}
	public void AttValorTotalVarejo() {
		textField_ValorTotalVendaVarejo.setText(valorCarrinhoVarejo.toString());
	}
	
	public void AtualizarNumeroDaVenda() {
		txt_NumeroDaVendaAtacado.setText(NumeroDaVenda().toString());
		txt_NmrVendaVendaPersonalizada.setText(NumeroDaVendaPersonalizada().toString());
		textFieldVendaVendaVarejo.setText(NumeroDaVendaVarejo().toString());
	}
	public Integer NumeroDaVenda() {
		int quantidade =0;
		try{
			Statement stm = conexao.createStatement(); 
			ResultSet rs = stm.executeQuery("SELECT NumeroDaVenda FROM adegagelaguela.vendaatacado ORDER BY NumeroDaVenda DESC LIMIT 1");  
			if (rs.next()) {
				quantidade = rs.getInt(1);
			}
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		return quantidade +1;
	}
	
	public Integer NumeroDaVendaVarejo() {
		int quantidade =0;
		try{
			Statement stm = conexao.createStatement(); 
			ResultSet rs = stm.executeQuery("SELECT NumeroDaVenda FROM adegagelaguela.vendavarejo ORDER BY NumeroDaVenda DESC LIMIT 1");  
			if (rs.next()) {
				quantidade = rs.getInt(1);
			}
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		return quantidade +1;
	}
	public Integer NumeroDaVendaVarejoToPDF() {
		int quantidade =0;
		try{
			Statement stm = conexao.createStatement(); 
			ResultSet rs = stm.executeQuery("SELECT NumeroDaVenda FROM adegagelaguela.vendavarejo ORDER BY NumeroDaVenda DESC LIMIT 1");  
			if (rs.next()) {
				quantidade = rs.getInt(1);
			}
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		return quantidade;
	}
	
	public Integer NumeroDaVendaPersonalizada() {
		int quantidade =0;
		try{
			Statement stm = conexao.createStatement(); 
			ResultSet rs = stm.executeQuery("SELECT NumeroDaVenda FROM adegagelaguela.vendapersonalizada ORDER BY NumeroDaVenda DESC LIMIT 1");  
			if (rs.next()) {
				quantidade = rs.getInt(1);
			}
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		return quantidade +1;
	}
	
	public Integer NumeroDaVendaToPDF() {
		int quantidade =0;
		try{
			Statement stm = conexao.createStatement(); 
			ResultSet rs = stm.executeQuery("SELECT NumeroDaVenda FROM adegagelaguela.vendaatacado ORDER BY NumeroDaVenda DESC LIMIT 1;");  
			if (rs.next()) {
				quantidade = rs.getInt(1);
			}
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		return quantidade;
	}
	
	public void DocumentoRegistroBancario() {
		Document Relatorio = new Document();
		String mes = textFieldMesBancoFinanceiro.getText().toString();
		String ano = textFieldAnoBancoFinanceiro.getText().toString();
		
		if(!rdbtnDetalharBancoFinanceiro.isSelected()) {
			try {
				PdfWriter.getInstance(Relatorio, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\Banco\\MovimentaçãoBancaria-"+mes+"-"+ano+".pdf"));
				Relatorio.open();
				Relatorio.setPageSize(PageSize.A4);
				Relatorio.add(new Paragraph("Pagamentos a funcionarios:\n"));
				String query =  "SELECT Nome, Funcao, Salario ,PagamentoDeFuncionario, HoraDoRegistro FROM adegagelaguela.registrobancario JOIN adegagelaguela.funcionarios ON IDFuncionario = idfuncionarios WHERE HoraDoRegistro LIKE '"+ano+"-"+mes+"%' GROUP BY IDFuncionario";
				PreparedStatement pst = conexao.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				rs.next();
				Paragraph Funcionario = new Paragraph("Dados do Funcinario "+ ":\n"+"Nome: " + rs.getString("Nome") + "\n"+"Função: " +rs.getString("Funcao")+ "\n" + "Salário: R$" +rs.getString("Salario")+"\n"+"Hora do Pagamento: " +rs.getString("HoraDoRegistro")+ "\nValor Pago: R$" + rs.getString("PagamentoDeFuncionario")+ "\n\n\n");
				Relatorio.add(Funcionario);
				while (rs.next()) {
					Relatorio.add(new Paragraph("\n"));
					Paragraph Funcionario2 = new Paragraph("Dados do Funcinario "+ ":\n"+"Nome: " + rs.getString("Nome") + "\n"+"Função: " +rs.getString("Funcao")+ "\n" + "Salário: R$" +rs.getString("Salario")+"\n"+"Hora do Pagamento: " +rs.getString("HoraDoRegistro")+ "\nValor Pago: R$" + rs.getString("PagamentoDeFuncionario")+ "\n\n\n");
					Relatorio.add(Funcionario2);
				}
				pst.close();
				rs.close();
				Relatorio.add(new Paragraph("Movimentação Bancaria:\n"));
				String query2 =  "SELECT format(SUM(EntradaDeDinheiro),2,'de_DE') as EntradaDeDinheiro, format(SUM(SaidaDeDinheiro),2,'de_DE') as SaidaDeDinheiro FROM adegagelaguela.registrobancario Where HoraDoRegistro like '"+ano+"-"+mes+"%'";
				PreparedStatement pst2 = conexao.prepareStatement(query2);
				ResultSet rs2 = pst2.executeQuery();
				rs2.next();
				Paragraph Movimento = new Paragraph("Quantia que Entrou no mês "+mes+": R$" + rs2.getString("EntradaDeDinheiro") +"\nQuantia que Saiu no mês "+mes+": R$" +rs2.getString("SaidaDeDinheiro")+"");
				Relatorio.add(Movimento);
				rs2.close();
				pst2.close();
				
			}catch (DocumentException de) {
				de.printStackTrace();
			}catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Relatorio.close();
			}
		}else {
			try {
				PdfWriter.getInstance(Relatorio, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\Banco\\MovimentaçãoBancaria-"+mes+"-"+ano+"-DETALHADA.pdf"));
				Relatorio.open();
				Relatorio.setPageSize(PageSize.A4);
				Relatorio.add(new Paragraph("Pagamentos a funcionarios:\n"));
				String query =  "SELECT Nome, Funcao, Salario ,PagamentoDeFuncionario, HoraDoRegistro FROM adegagelaguela.registrobancario JOIN adegagelaguela.funcionarios ON IDFuncionario = idfuncionarios WHERE HoraDoRegistro LIKE '"+ano+"-"+mes+"%' GROUP BY IDFuncionario";
				PreparedStatement pst = conexao.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				rs.next();
				Paragraph Funcionario = new Paragraph("Dados do Funcinario "+ ":\n"+"Nome: " + rs.getString("Nome") + "\n"+"Função: " +rs.getString("Funcao")+ "\n" + "Salário: R$" +rs.getString("Salario")+"\n"+"Hora do Pagamento: " +rs.getString("HoraDoRegistro")+ "\nValor Pago: R$" + rs.getString("PagamentoDeFuncionario")+ "\n\n\n");
				Relatorio.add(Funcionario);
				while (rs.next()) {
					Relatorio.add(new Paragraph("\n"));
					Paragraph Funcionario2 = new Paragraph("Dados do Funcinario "+ ":\n"+"Nome: " + rs.getString("Nome") + "\n"+"Função: " +rs.getString("Funcao")+ "\n" + "Salário: R$" +rs.getString("Salario")+"\n"+"Hora do Pagamento: " +rs.getString("HoraDoRegistro")+ "\nValor Pago: R$" + rs.getString("PagamentoDeFuncionario")+ "\n\n\n");
					Relatorio.add(Funcionario2);
				}
				pst.close();
				rs.close();
				Relatorio.add(new Paragraph("Movimentação Bancaria:\n"));
				String query2 =  "SELECT idregistro, IDFuncionario, EntradaDeDinheiro,SaidaDeDinheiro,PagamentoDeFuncionario,HoraDoRegistro FROM adegagelaguela.registrobancario Where HoraDoRegistro like '"+ano+"-"+mes+"%'";
				PreparedStatement pst2 = conexao.prepareStatement(query2);
				ResultSet rs2 = pst2.executeQuery();
				rs2.next();
				Paragraph Movimento = new Paragraph("Quantia movimentada: \nEntrou: R$" + rs2.getString("EntradaDeDinheiro") +" \nSaiu: R$" +rs2.getString("SaidaDeDinheiro")+ "\nFoi pago: R$"+rs2.getString("PagamentoDeFuncionario")+"\n Hora do Registro: "+ rs2.getString("HoraDoRegistro")+"\n\n");
				Relatorio.add(Movimento);
				while(rs2.next()) {
					Paragraph Movimento2 = new Paragraph("Quantia movimentada: \nEntrou: R$" + rs2.getString("EntradaDeDinheiro") +"\nSaiu: R$" +rs2.getString("SaidaDeDinheiro")+ "\nFoi pago: R$"+rs2.getString("PagamentoDeFuncionario")+"\n Hora do Registro: "+ rs2.getString("HoraDoRegistro")+"\n\n");
					Relatorio.add(Movimento2);
				}
				rs2.close();
				pst2.close();
				
			}catch (DocumentException de) {
				de.printStackTrace();
			}catch (IOException ioe) {
				ioe.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Relatorio.close();
			}
		}
	}
	
	public void DocumentoVendaPersonalizada() {
		Document venda = new Document();
		String numeroDaVenda = NumeroDaVendaToPDF().toString();
		int contador =1;
		try{
			
			PdfWriter.getInstance(venda, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\VENDAS\\Venda-Personalizada-" + numeroDaVenda + ".pdf"));
			venda.open();
			venda.setPageSize(PageSize.A4);
			venda.add(new Paragraph("VENDA DE NUMERO " + numeroDaVenda +" :\n"));
			
			String query =  "SELECT NomeCliente 'Nome', Email, Telefone, Empresa, CPFouRG, NomeProduto 'Produto', QuantidadeProduto 'Quantidade', format(Preco,2,'de_DE') 'Valor',FormaDePagamento 'Forma de Pagamento', PagamentoFuturo 'Pagamento Futuro', HoraDaVenda 'Hora da Venda' "
					+ "FROM vendapersonalizada WHERE adegagelaguela.vendapersonalizada.NumeroDaVenda = (?)";
			PreparedStatement pst = conexao.prepareStatement(query);
			pst.setString(1, txt_NmrVendaVendaPersonalizada.getText().toString());
			ResultSet rs = pst.executeQuery();
			rs.next();
			Paragraph cliente = new Paragraph("Dados do cliente "+ ":\n"+"Nome: " + rs.getString("Nome") + "\n"+"Telefone: " +rs.getString("Telefone")+ "\n" + "Empresa: " +rs.getString("Empresa")+"\n"+"Hora da venda: " +rs.getString("Hora da Venda")+ "\n" + "Forma de Pagamento: " +rs.getString("Forma de Pagamento")+ "\n" + "Pagar no Futuro?: " 
					+rs.getString("Pagamento Futuro")+ "\n\n\n");
			venda.add(cliente);
			Paragraph produto1 = new Paragraph("Produto "+ contador +" :\nProduto: "+rs.getString("Produto")+ "\n" + "Valor R$:" +rs.getString("Valor")+ "\n" + "Quantidade: " +rs.getString("Quantidade")+"\n\n");
			venda.add(produto1);
			while(rs.next()){
				contador++;
				Paragraph produto = new Paragraph("Produto "+ contador +" :\nProduto: "+rs.getString("Produto")+ "\n" + "Valor R$:" +rs.getString("Valor")+ "\n" + "Quantidade: " +rs.getString("Quantidade")+"\n\n");
				venda.add(produto);
				venda.add(new Paragraph ("\n\n"));
			}
			rs.close();
			pst.close();
			
			String query2 =  "SELECT format(SUM(Preco),2,'de_DE') as soma FROM adegagelaguela.vendapersonalizada WHERE NumeroDaVenda = (?)";
			pst = conexao.prepareStatement(query2);
			pst.setString(1, txt_NmrVendaVendaPersonalizada.getText().toString());
			rs = pst.executeQuery();
			rs.next();
			Paragraph valortotal = new Paragraph("Valor total dos produtos R$:" + rs.getString("soma"));
			rs.close();
			pst.close();
			venda.add(new Paragraph ("Total de produtos: " + contador));
			venda.add(valortotal);
			venda.close();
			
		}catch (DocumentException de) {
			de.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			venda.close();
		}
	}
	
	
	public void DocumentoVendaVarejo() {
		Document venda = new Document();
		String numeroDaVenda = NumeroDaVendaVarejoToPDF().toString();
		int contador =1;
		try{
			
			PdfWriter.getInstance(venda, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\VENDAS\\Venda-Varejo-" + numeroDaVenda + ".pdf"));
			venda.open();
			venda.setPageSize(PageSize.B7);
			venda.add(new Paragraph("VENDA DE NUMERO " + numeroDaVenda +" :\n"));
			
			String query =  "SELECT Produto, Quantidade, format (Preco,2,'de_DE') 'Preco' , FormaDePagamento 'Pagamento', HoraDaVenda 'Hora Venda' FROM adegagelaguela.vendavarejo WHERE NumeroDaVenda = (?)";
			PreparedStatement pst = conexao.prepareStatement(query);
			pst.setString(1, numeroDaVenda);
			ResultSet rs = pst.executeQuery();
			rs.next();
			Paragraph varejo = new Paragraph("Forma de Pagamento: " +rs.getString("Pagamento")+ "\n" + "Hora da venda: "+rs.getString("Hora Venda") + "\n\n");
			venda.add(varejo);
			venda.add(new Paragraph ("\n\n"));
			
			Paragraph produto1 = new Paragraph("Produto "+ contador +" :\n"+rs.getString("Produto")+ "\n" + "Valor R$:" +rs.getString("Preco")+ "\n" + "Quantidade: " +rs.getString("Quantidade")+ "\n\n");
			venda.add(produto1);
			while(rs.next()){
				contador++;
				Paragraph produto =  new Paragraph("Produto "+ contador +" :\n"+rs.getString("Produto")+ "\n" + "Valor R$:" +rs.getString("Preco")+ "\n" + "Quantidade: " +rs.getString("Quantidade")+ "\n\n");
				venda.add(produto);
			}
			rs.close();
			pst.close();
			
			String query2 =  "SELECT format(SUM(Preco),2,'de_DE') as soma FROM adegagelaguela.vendavarejo WHERE NumeroDaVenda = (?)";
			pst = conexao.prepareStatement(query2);
			pst.setString(1, numeroDaVenda);
			rs = pst.executeQuery();
			rs.next();
			Paragraph valortotal = new Paragraph("Valor total dos produtos R$:" + rs.getString("soma"));
			rs.close();
			pst.close();
			venda.add(new Paragraph ("Total de produtos: " + contador));
			venda.add(valortotal);
			venda.close();
			
		}catch (DocumentException de) {
			de.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			venda.close();
		}
	}
	
	public void DocumentoVendaAtacado() {
		Document venda = new Document();
		String numeroDaVenda = NumeroDaVendaToPDF().toString();
		int contador =1;
		try{
			
			PdfWriter.getInstance(venda, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\VENDAS\\Venda-Atacado-" + numeroDaVenda + ".pdf"));
			venda.open();
			venda.setPageSize(PageSize.A4);
			venda.add(new Paragraph("VENDA DE NUMERO " + numeroDaVenda +" :\n"));
			
			String query =  "SELECT cliente.Nome, cliente.Empresa, produto 'Produto', format(preco,2,'de_DE') 'Valor', quantidade 'Quantidade', format(precoTotal ,2,'de_DE') 'PreçoT',"
					+ " HoraDaVenda 'Hora da Venda', FormaDePagamento 'Forma de Pagamento', PagarFuturo 'Pagamento Futuro', format(Desconto ,2,'de_DE') 'Desconto' FROM adegagelaguela.vendaatacado "
					+ "JOIN adegagelaguela.cliente ON adegagelaguela.cliente.idCliente = vendaatacado.IDCliente WHERE NumeroDaVenda = (?);";
			PreparedStatement pst = conexao.prepareStatement(query);
			pst.setString(1, numeroDaVenda);
			ResultSet rs = pst.executeQuery();
			rs.next();
			Paragraph cliente = new Paragraph("Dados do cliente "+ ":\n"+"Nome: " + rs.getString("Nome") + "\n" + "Empresa: " +rs.getString("Empresa")+"\n"+"Hora da venda: " +rs.getString("Hora da Venda")+ "\n" + "Forma de Pagamento: " +rs.getString("Forma de Pagamento")+ "\n" + "Pagar no Futuro?: " 
					+rs.getString("Pagamento Futuro")+ "\n" + "Desconto de R$:" +rs.getString("Desconto") +"\n\n\n");
			venda.add(cliente);
			Paragraph produto1 = new Paragraph("Produto "+ contador +" :\nProduto: "+rs.getString("Produto")+ "\n" + "Valor R$:" +rs.getString("Valor")+ "\n" + "Quantidade: " +rs.getString("Quantidade")+
					 "\n" + "Preço Total R$:" +rs.getString("PreçoT")+ "\n\n");
			venda.add(produto1);
			while(rs.next()){
				contador++;
				Paragraph produto = new Paragraph("Produto "+ contador +" :\nProduto: "+rs.getString("Produto")+ "\n" + "Valor R$:" +rs.getString("Valor")+ "\n" + "Quantidade: " +rs.getString("Quantidade")+
						 "\n" + "Preço Total R$:" +rs.getString("PreçoT")+ "\n\n");
				venda.add(produto);
				venda.add(new Paragraph ("\n\n"));
			}
			rs.close();
			pst.close();
			
			String query2 =  "SELECT format(SUM(precoTotal),2,'de_DE') as soma FROM adegagelaguela.vendaatacado WHERE NumeroDaVenda = (?)";
			pst = conexao.prepareStatement(query2);
			pst.setString(1, numeroDaVenda);
			rs = pst.executeQuery();
			rs.next();
			Paragraph valortotal = new Paragraph("Valor total dos produtos R$:" + rs.getString("soma"));
			rs.close();
			pst.close();
			venda.add(new Paragraph ("Total de produtos: " + contador));
			venda.add(valortotal);
			venda.close();
			
		}catch (DocumentException de) {
			de.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			venda.close();
		}
	}
	
	public void DocumentoRelatorioDeVendasVarejo() {
		Document relatorio = new Document();
		
		String dia = textFieldDiaRelatorioDeVendas.getText().toString();
		String mes = textFieldMesRelatorioDeVendas.getText().toString();
		String ano = textFieldAnoRelatorioDeVendas.getText().toString();
		String ateDia = textFieldAteDiaRelatorioDeVendas.getText().toString();
		String ateMes = textFieldAteMesRelatorioDeVendas.getText().toString();
		String ateAno = textFieldAteAnoRelatorioDeVendas.getText().toString();
		
		try{
			String contador;
			PdfWriter.getInstance(relatorio, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\Relatorio de Vendas\\Relatorio-Venda-Varejo-"+ dia +"-"+ mes +"-"+ ano+"_"+"ate" +"_"+ ateDia +"-"+ ateMes+"-"+ ateAno+".pdf"));
			relatorio.open();
			relatorio.setPageSize(PageSize.A4);
			relatorio.add(new Paragraph("RELATORIO VENDA VAREJO "+ano+"-"+mes+"-"+dia +" Ate "+ ateAno+"-"+ateMes+"-"+ateDia+"\n"));
			String query =  "SELECT format(SUM(PrecoTotal),2,'de_DE') as soma, NumeroDaVenda, FormaDePagamento, HoraDaVenda FROM adegagelaguela.vendavarejo WHERE HoraDaVenda BETWEEN '"+ano+"-"+mes+"-"+dia+"%' AND '"+ateAno+"-"+ateMes+"-"+ateDia+"%' GROUP BY HoraDaVenda";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			rs.next();
			Paragraph dadosVenda = new Paragraph("\n\nDados da Compra:\nNumeroDaVenda: " +rs.getString("NumeroDaVenda")+ "\n"+ "Forma de Pagamento : "+rs.getString("FormaDePagamento")+ "\n" + "Hora Da Venda : "+rs.getString("HoraDaVenda")+ "\n" + "Valor total da venda : " +rs.getString("soma")+"\nItens :\n");
			relatorio.add(dadosVenda);
			contador = rs.getString("NumeroDaVenda");
			String query2 = "SELECT Produto, Quantidade, Preco FROM adegagelaguela.vendavarejo WHERE NumeroDaVenda ="+ contador +"";
			PreparedStatement pst2 = conexao.prepareStatement(query2);
			ResultSet rs2 = pst2.executeQuery();
			rs2.next();
			Paragraph dadosProduto = new Paragraph("Produto : " +rs2.getString("Produto")+ "\n"+ "Quantidade : "+rs2.getString("Quantidade") + "\n"+"Preço :"+rs2.getString("Preco")+"\n");
			relatorio.add(dadosProduto);

			while(rs2.next()){
				Paragraph dadosProduto2 = new Paragraph("Produto : " +rs2.getString("Produto")+ "\n"+ "Quantidade : "+rs2.getString("Quantidade") + "\n"+"Preço :"+rs2.getString("Preco")+"\n");
				relatorio.add(dadosProduto2);
			}
			
			while(rs.next()){
				contador = rs.getString("NumeroDaVenda");
				String query3 = "SELECT Produto, Quantidade, Preco FROM adegagelaguela.vendavarejo WHERE NumeroDaVenda ="+ contador +"";
				PreparedStatement pst3 = conexao.prepareStatement(query3);
				ResultSet rs3 = pst3.executeQuery();
				rs3.next();
				Paragraph dadosVenda2 = new Paragraph("\n\nDados da Compra\nNumeroDaVenda: " +rs.getString("NumeroDaVenda")+ "\n"+ "Forma de Pagamento : "+rs.getString("FormaDePagamento")+ "\n" + "Hora Da Venda : "+rs.getString("HoraDaVenda")+ "\n" + "Valor total da venda : " +rs.getString("soma")+"\nItens :\n");
				relatorio.add(dadosVenda2);
				Paragraph dadosProduto2 = new Paragraph("Produto : " +rs3.getString("Produto")+ "\n"+ "Quantidade : "+rs3.getString("Quantidade") + "\n"+"Preço :"+rs3.getString("Preco")+"\n");
				relatorio.add(dadosProduto2);
					while(rs3.next()){
						Paragraph dadosProduto3 = new Paragraph("Produto : " +rs3.getString("Produto")+ "\n"+ "Quantidade : "+rs3.getString("Quantidade") + "\n"+"Preço :"+rs3.getString("Preco")+"\n");
						relatorio.add(dadosProduto3);
					}
				}
			rs.close();
			pst.close();
			
			relatorio.close();
			
		}catch (DocumentException de) {
			de.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			relatorio.close();
		}
	}
	public void DocumentoRelatorioDeVendasAtacado() {
		Document relatorio = new Document();
		
		String dia = textFieldDiaRelatorioDeVendas.getText().toString();
		String mes = textFieldMesRelatorioDeVendas.getText().toString();
		String ano = textFieldAnoRelatorioDeVendas.getText().toString();
		String ateDia = textFieldAteDiaRelatorioDeVendas.getText().toString();
		String ateMes = textFieldAteMesRelatorioDeVendas.getText().toString();
		String ateAno = textFieldAteAnoRelatorioDeVendas.getText().toString();
		
		try{

			PdfWriter.getInstance(relatorio, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\Relatorio de Vendas\\Relatorio-Venda-Atacado-"+ dia +"-"+ mes +"-"+ ano+"_"+"ate" +"_"+ ateDia +"-"+ ateMes+"-"+ ateAno+".pdf"));
			relatorio.open();
			relatorio.setPageSize(PageSize.A4);
			relatorio.add(new Paragraph("RELATORIO VENDA Atacado "+ano+"-"+mes+"-"+dia +" Ate "+ ateAno+"-"+ateMes+"-"+ateDia+"\n"));
			
			String query =  "SELECT cliente.Nome 'Cliente', cliente.Empresa 'Empresa', cliente.CPF 'CPF', cliente.Telefone1 'Telefone', vendaatacado.FormaDePagamento 'Forma de Pagamento', vendaatacado.Desconto 'Desconto', vendaatacado.NumeroDaVenda 'Numero da Venda', "
					+ "vendaatacado.PagarFuturo 'Pagar futuro', vendaatacado.HoraDaVenda 'HoraDaVenda', format(SUM(precoTotal),2,'de_DE') as soma FROM adegagelaguela.vendaatacado JOIN adegagelaguela.cliente ON vendaatacado.IDCliente = cliente.idCliente WHERE HoraDaVenda BETWEEN  '"+ano+"-"+mes+"-"+dia+"%' AND '"+ateAno+"-"+ateMes+"-"+ateDia+"%'  GROUP BY NumeroDaVenda";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			rs.next();
			Paragraph dados = new Paragraph("NumeroDaVenda: " +rs.getString("Numero da Venda")+ "\n"+ "Cliente: "+rs.getString("Cliente")+ "\n" + "Telefone : "+rs.getString("Telefone")+ "\n" + "Empresa : "+rs.getString("Empresa")+ "\n" +
					"CPF: "+rs.getString("CPF")+ "\n" +"Forma De Pagamento : "+rs.getString("Forma de Pagamento")+ "\n"+"Valor da Venda: "+rs.getString("soma")+ "\n" +"Pagar no Futuro: "+rs.getString("Pagar futuro")+ "\nDesconto:"+ rs.getString("Desconto")+"\n" + "HoraDaVenda: " +rs.getString("HoraDaVenda")+"\n\n");
			relatorio.add(dados);
			String query2 = "SELECT produto, quantidade, preco FROM adegagelaguela.vendaatacado WHERE NumeroDaVenda =" + rs.getString("Numero da Venda")+"";
			PreparedStatement pst2 = conexao.prepareStatement(query2);
			ResultSet rs2 = pst2.executeQuery();
			Paragraph produto = new Paragraph("Produtos vendidos:\n");
			relatorio.add(produto);
			while (rs2.next()) {
				Paragraph dadosp = new Paragraph("Produto: " + rs2.getString("produto") + "\n Quantidade: "+ rs2.getString("quantidade") + "\n Preço: R$"+ rs2.getString("preco") + "\n");
				relatorio.add(dadosp);
			}
			relatorio.add(new Paragraph ("\n\n"));
			while(rs.next()){
				Paragraph dados2 =new Paragraph("NumeroDaVenda: " +rs.getString("Numero da Venda")+ "\n"+ "Cliente: "+rs.getString("Cliente")+ "\n" + "Telefone : "+rs.getString("Telefone")+ "\n" + "Empresa : "+rs.getString("Empresa")+ "\n" +
						"CPF: "+rs.getString("CPF")+ "\n" +"Forma De Pagamento : "+rs.getString("Forma de Pagamento")+ "\n"+"Valor da Venda: "+rs.getString("soma")+ "\n" +"Pagar no Futuro: "+rs.getString("Pagar futuro")+ "\nDesconto:"+ rs.getString("Desconto")+"\n" + "HoraDaVenda: " +rs.getString("HoraDaVenda")+"\n\n");
				relatorio.add(dados2);
				String query3 = "SELECT produto, quantidade, preco FROM adegagelaguela.vendaatacado WHERE NumeroDaVenda =" + rs.getString("Numero da Venda")+"";
				PreparedStatement pst3 = conexao.prepareStatement(query3);
				ResultSet rs3= pst3.executeQuery();
				Paragraph produto2 = new Paragraph("Produtos vendidos:\n");
				relatorio.add(produto2);
				while (rs3.next()) {
					Paragraph dadosp = new Paragraph("Produto: " + rs3.getString("produto") + "\n Quantidade: "+ rs3.getString("quantidade") + "\n Preço: R$"+ rs3.getString("preco"));
					relatorio.add(dadosp);
				}
				relatorio.add(new Paragraph ("\n\n"));
				rs3.close();
				pst3.close();
			}
			rs.close();
			pst.close();
			rs2.close();
			pst2.close();
			relatorio.close();
			
		}catch (DocumentException de) {
			de.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			relatorio.close();
		}
	}
	public void DocumentoRelatorioDeVendasPersonalizada() {
		Document relatorio = new Document();
		
		String dia = textFieldDiaRelatorioDeVendas.getText().toString();
		String mes = textFieldMesRelatorioDeVendas.getText().toString();
		String ano = textFieldAnoRelatorioDeVendas.getText().toString();
		String ateDia = textFieldAteDiaRelatorioDeVendas.getText().toString();
		String ateMes = textFieldAteMesRelatorioDeVendas.getText().toString();
		String ateAno = textFieldAteAnoRelatorioDeVendas.getText().toString();
		
		try{

			PdfWriter.getInstance(relatorio, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\Relatorio de Vendas\\Relatorio-Venda-Personalizada-"+ dia +"-"+ mes +"-"+ ano+"_"+"ate" +"_"+ ateDia +"-"+ ateMes+"-"+ ateAno+".pdf"));
			relatorio.open();
			relatorio.setPageSize(PageSize.A4);
			relatorio.add(new Paragraph("RELATORIO VENDA Personalizada "+ano+"-"+mes+"-"+dia +" Ate "+ ateAno+"-"+ateMes+"-"+ateDia+"\n"));
			
			String query =  "SELECT NomeCliente 'Nome', Email,Telefone, Empresa, CPFouRG, NumeroDaVenda, FormaDePagamento, PagamentoFuturo, HoraDaVenda, format(SUM(precoTotal),2,'de_DE') as soma FROM adegagelaguela.vendapersonalizada WHERE HoraDaVenda BETWEEN '"+ano+"-"+mes+"-"+dia+"%' AND '"+ateAno+"-"+ateMes+"-"+ateDia+"%'  GROUP BY NumeroDaVenda";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			rs.next();
			Paragraph dados = new Paragraph("NumeroDaVenda: " +rs.getString("NumeroDaVenda")+ "\n"+ "Cliente: "+rs.getString("Nome")+ "\n" +"Email : "+rs.getString("Email")+ "\n" + "Telefone : "+rs.getString("Telefone")+ "\n" + "Empresa : "+rs.getString("Empresa")+ "\n" +
					"CPF ou RG : "+rs.getString("CPFouRG")+ "\n" +"Forma De Pagamento : "+rs.getString("FormaDePagamento")+ "\n"+"Valor da Venda: "+rs.getString("soma")+ "\n" +"Pagar no Futuro: "+rs.getString("PagamentoFuturo")+ "\n" + "HoraDaVenda: " +rs.getString("HoraDaVenda")+"\n\n");
			relatorio.add(dados);
			String query2 = "SELECT NomeProduto, QuantidadeProduto, Preco FROM adegagelaguela.vendapersonalizada WHERE NumeroDaVenda =" + rs.getString("NumeroDaVenda")+"";
			PreparedStatement pst2 = conexao.prepareStatement(query2);
			ResultSet rs2 = pst2.executeQuery();
			Paragraph produto = new Paragraph("Produtos vendidos:\n");
			relatorio.add(produto);
			while (rs2.next()) {
				Paragraph dadosp = new Paragraph("Produto: " + rs2.getString("NomeProduto") + "\n Quantidade: "+ rs2.getString("QuantidadeProduto") + "\n Preço: R$"+ rs2.getString("Preco") + "\n");
				relatorio.add(dadosp);
			}
			relatorio.add(new Paragraph ("\n\n"));
			while(rs.next()){
				Paragraph dados2 = new Paragraph("NumeroDaVenda: " +rs.getString("NumeroDaVenda")+ "\n"+ "Cliente: "+rs.getString("Nome")+ "\n" +"Email : "+rs.getString("Email")+ "\n" + "Telefone : "+rs.getString("Telefone")+ "\n" + "Empresa : "+rs.getString("Empresa")+ "\n" +
						"CPF ou RG : "+rs.getString("CPFouRG")+ "\n" +"Forma De Pagamento : "+rs.getString("FormaDePagamento")+ "\n"+"Valor da Venda: "+rs.getString("soma")+ "\n" +"Pagar no Futuro: "+rs.getString("PagamentoFuturo")+ "\n" + "HoraDaVenda: " +rs.getString("HoraDaVenda")+"\n\n");
				relatorio.add(dados2);
				String query3 = "SELECT NomeProduto, QuantidadeProduto, Preco FROM adegagelaguela.vendapersonalizada WHERE NumeroDaVenda =" + rs.getString("NumeroDaVenda")+"";
				PreparedStatement pst3 = conexao.prepareStatement(query3);
				ResultSet rs3= pst3.executeQuery();
				Paragraph produto2 = new Paragraph("Produtos vendidos:\n");
				relatorio.add(produto2);
				while (rs3.next()) {
					Paragraph dadosp = new Paragraph("Produto: " + rs3.getString("NomeProduto") + "\n Quantidade: "+ rs3.getString("QuantidadeProduto") + "\n Preço: R$"+ rs3.getString("Preco"));
					relatorio.add(dadosp);
				}
				relatorio.add(new Paragraph ("\n\n"));
				rs3.close();
				pst3.close();
			}
			rs.close();
			pst.close();
			rs2.close();
			pst2.close();
			relatorio.close();
			
		}catch (DocumentException de) {
			de.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			relatorio.close();
		}
	}
	
	public void limpadorDeDadosProdutosEmEstoque() {
		textFieldIdProdutosEmEstoque.setText("");
		textFieldNomeProdutosEmEstoque.setText("");
		textFieldUnidadesProdutosEmEstoque.setText("");
		textFieldPrecoProdutosEmEstoque.setText("");
		
	}

	public void limpadorDeDadosProdutosNaAdega() {
		textFieldIdProdutosNaAdega.setText("");
		textFieldNomeProdutosNaAdega.setText("");
		textFieldQuantidadeProdutosNaAdega.setText("");
		textFieldPrecoProdutosNaAdega.setText(null);
	}

	public void limpadorDeDadosProdutosParaComprar() {
		textFieldNomeProdutosParaComprar.setText("");
		textFieldIdProdutosParaComprar.setText("");
		textFieldQuantidadeProdutosParaComprar.setText("");
		textFieldPrecoProdutosParaComprar.setText("");
		
	}

	public void limpadorDeDadosTodosProdutos() {
		textFieldIdTodosOsProdutos.setText("");
		textFieldNomeTodosOsProdutos.setText("");
		textFieldPrecoTodosOsProdutos.setText("");
	}

	public void limpadorDeDadosVendaVarejo() {
		textFieldVendaVendaVarejo.setText("");
		textField_PrecoVendaVarejo.setText("");
		textField_QuantidadeVendaVarejo.setText("");
		textField_TrocoVendaVarejo.setText("");
		textField_ValorPagoVendaVarejo.setText("");
		textField_ValorTotalVendaVarejo.setText("");
		textFieldIDProdutoVendaVarejo.setText("");
		textFieldProdutoVendaVarejo.setText("");
		
	}

	public void limpadorDeDadosVendaAtacado() {
		textField_DescontoVendaAtacado.setText("");
		textField_NomeDoProdutoVendaAtacado.setText("");
		textField_PrecoParaOCarrinhoVendaAtacado.setText("");
		textField_PrecoVendaAtacado.setText("");
		textField_QuantidadeUnidadeVendaAtacado.setText("");
		textFieldIdDoProdutoVendaAtacado.setText("");
		textFieldNomeClienteCarrinhoVendaAtacado.setText("");
		textFieldNomeDaEmpresaVendaAtacado.setText("");
		textFieldPrecoTotalVendaAtacado.setText("");
		
	}

	public void limpadorDeDadosVendaPersonalizada() {
		textField_CPFRGVendaPersonalizada.setText("");
		textField_EmailVendaPersonalizada.setText("");
		textField_EmpresaVendaPersonalizada.setText("");
		textField_NomeClienteVendaPersonalizada.setText("");
		textField_PrecoVendaPersonalizada.setText("");
		textField_QuantidadeVendaPersonalizada.setText("");
		textField_TelefoneVendaPersonalizada.setText("");
		textField_ValorProdutoVendaPersonalizada.setText("");
		textFieldIDVendaPersonalizada.setText("");
		textFieldNomeProdutoVendaPersonalizada.setText("");
	}

	public void limpadorDeDadosClientes() {
		textField_Telefone1Cliente.setText(null);
		textField_Telefone2Cliente.setText(null);
		textField_BairroCliente.setText(null);
		textField_CidadeCliente.setText(null);
		textField_CNPJCliente.setText(null);
		textField_CPFCliente.setText(null);
		textField_EmailCliente.setText(null);
		textField_EmpresaCliente.setText(null);
		textField_EnderecoCliente.setText(null);
		textField_NmrCliente.setText(null);
		textField_NomeDoClienteCliente.setText(null);
		textField_TelEmpresaCliente.setText(null);
		
	}

	public void limpadorDeDadosProdutos() {
		
	}

	public void limpadorDeDadosRelatorioDeVendas() {
		
	}

	public void limpadorDeDadosRelatorioDeProdutosAtacado() {
		
	}

	public void limpadorDeDadosRelatorioDeProdutosVarejo() {
		
	}

	public void limpadorDeDadosBancoFinanceiro() {
		
	}
	
}