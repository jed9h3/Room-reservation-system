import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.sql.*;

public class Driver extends Application {
	int flag;
	int rented, nonprivate;

	@Override
	public void start(Stage primaryStage) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BZU", "root", "1234");
			System.out.println("Database connected");
			Statement statement = connection.createStatement();
			// ------------------------------------------------------------------------------------------------------
			// PRIMARYSTAGE START
			// ---------------------------------------
			// ====================================================================================================
			// INITIALIZATIN SECTION
			Pane mainp = new Pane();
			Scene scene1 = new Scene(mainp, 1000, 1000);
			StackPane adstack = new StackPane();
			Rectangle adrectangle = new Rectangle();
			ImageView adimg = new ImageView(new Image("file:images/main_image.jpg"));
			Label logol = new Label("BZU Residential System");
			StackPane mainstack = new StackPane();
			VBox mainmvbox = new VBox(70);
			Button customerb = new Button("Students");
			ImageView customerimg = new ImageView(new Image("file:images/customer.png"));
			Button mediab = new Button("payment");
			ImageView mediaimg = new ImageView(new Image("file:images/rent.png"));
			Button rentb = new Button("Rent");
			ImageView rentimg = new ImageView(new Image("file:images/rent_t.png"));
			VBox mainvbox = new VBox(30);
			Button main5b = new Button("Print All Students Info");
			Button main4b = new Button("Search A Student By Id");
			Button main3b = new Button("Update Information\nAbout A Student");
			Button main2b = new Button("Delete A Student");
			Button main1b = new Button("Add A New Student");
			Button mainreturnb = new Button("Return To Main Menu");
			// ====================================================================================================
			// STYLING SECTION
			mainp.setStyle("-fx-background-color: #2c2c2c");
			adstack.setLayoutX(500);
			adstack.setLayoutY(150);
			adrectangle.setHeight(300);
			adrectangle.setWidth(760);
			adrectangle.setStroke(Color.WHITE);
			adrectangle.setFill(Color.TRANSPARENT);
			adimg.setFitHeight(250);
			adimg.setFitWidth(500);
			logol.setTextFill(Color.WHITE);
			logol.setLayoutX(700);
			logol.setLayoutY(490);
			logol.setFont(new Font("Arial", 25));
			logol.setAlignment(Pos.CENTER);
			logol.setPrefSize(350, 100);
			logol.setStyle("-fx-border-color: white; -fx-border-width: 2");
			mainstack.setAlignment(Pos.CENTER);
			mainreturnb.setFont(new Font("Arial", 20));
			mainreturnb.setPrefSize(300, 70);
			customerb.setFont(new Font("Arial", 20));
			customerb.setPrefSize(300, 100);
			customerb.setGraphic(customerimg);
			mediab.setFont(new Font("Arial", 20));
			mediab.setGraphic(mediaimg);
			mediab.setPrefSize(300, 100);
			rentb.setGraphic(rentimg);
			rentb.setFont(new Font("Arial", 20));
			rentb.setPrefSize(300, 100);
			customerimg.setFitHeight(50);
			customerimg.setFitWidth(50);
			mediaimg.setFitHeight(50);
			mediaimg.setFitWidth(50);
			rentimg.setFitHeight(50);
			rentimg.setFitWidth(50);
			main1b.setFont(new Font("Arial", 20));
			main1b.setPrefSize(300, 70);
			main2b.setFont(new Font("Arial", 20));
			main2b.setPrefSize(300, 70);
			main3b.setFont(new Font("Arial", 20));
			main3b.setPrefSize(300, 70);
			main4b.setFont(new Font("Arial", 20));
			main4b.setPrefSize(300, 70);
			main5b.setFont(new Font("Arial", 20));
			main5b.setPrefSize(300, 70);
			mainmvbox.setPadding(new Insets(100, 100, 100, 100));
			// ====================================================================================================
			// SORTING SECTION
			mainp.getChildren().addAll(mainstack, adstack, logol);
			mainstack.getChildren().addAll(mainmvbox, mainvbox);
			mainmvbox.getChildren().addAll(customerb, mediab, rentb);
			mainvbox.getChildren().addAll(main1b, main2b, main3b, main4b, main5b, mainreturnb);
			adstack.getChildren().addAll(adrectangle, adimg);
			mainstack.setPadding(new Insets(0, 0, 20, 0));// --
			primaryStage.setMaximized(true);
			mainvbox.setVisible(false);
			primaryStage.setScene(scene1);
			primaryStage.setTitle("BRS   MAIN-MENU");
			primaryStage.show();
			// ====================================================================================================
			// execution SECTION
			customerb.setOnAction(e -> {
				mainmvbox.setVisible(false);
				mainvbox.setVisible(true);
				mainstack.setPadding(new Insets(60, 100, 100, 100));
				main1b.setText("Add A New Student");
				main2b.setText("Delete A Student");
				main3b.setText("Update Information\nAbout A Student");
				main4b.setText("Search A Student By Id");
				main5b.setText("Print All Students Info");
				primaryStage.setTitle("BRS   CUSTOMER-MENU");
			});
			mediab.setOnAction(e -> {
				mainmvbox.setVisible(false);
				mainvbox.setVisible(true);
				mainvbox.getChildren().removeAll(main2b, main3b);
				mainstack.setPadding(new Insets(60, 100, 100, 100));
				main1b.setText("Add A New Payment");
				main4b.setText("Search A Payment By Id");
				main5b.setText("Print All Payment Info");
				primaryStage.setTitle("BRS   MEDIA-MENU");
			});
			rentb.setOnAction(e -> {
				mainmvbox.setVisible(false);
				mainvbox.setVisible(true);
				mainstack.setPadding(new Insets(60, 100, 100, 100));
				main1b.setText("Rent Form");
				main2b.setText("Financial Record");
				main3b.setText("Room status");
				main5b.setText("Change Rooms price");
				primaryStage.setTitle("BRS   RENT-MENU");
				mainvbox.getChildren().remove(main4b);
			});
			mainreturnb.setOnAction(e -> {
				mainmvbox.setVisible(true);
				mainvbox.setVisible(false);
				if (0 == main1b.getText().compareTo("Add A New Payment")) {
					mainvbox.getChildren().removeAll(mainreturnb, main4b, main5b);
					mainvbox.getChildren().addAll(main2b, main3b, main4b, main5b, mainreturnb);
				}
				if (0 == main1b.getText().compareTo("Rent Form")) {
					mainvbox.getChildren().removeAll(mainreturnb, main5b);
					mainvbox.getChildren().addAll(main4b, main5b, mainreturnb);
				}
				mainstack.setPadding(new Insets(0, 0, 0, 0));
				primaryStage.setTitle("BRS   MAIN-MENU");
			});
			// ------------------------------------------------------------------------------------------------------
			// SECONDARYSTAGE START
			// ---------------------------------------
			// ====================================================================================================
			// INITIALIZATIN SECTION
			Stage mainstage = new Stage();
			BorderPane root = new BorderPane();
			BorderPane root1 = new BorderPane();
			StackPane bigstack = new StackPane();
			Scene scene2 = new Scene(bigstack, 1000, 1000);
			StackPane secondarystack = new StackPane();
			GridPane customergrid = new GridPane();
			TextField custxt1 = new TextField();
			TextField custxt2 = new TextField();
			TextField custxt3 = new TextField();
			TextField custxt4 = new TextField();
			Label cusl1 = new Label("Student Id:");
			Label cusl2 = new Label("Student Name:");
			Label cusl3 = new Label("Student DOB:");
			Label cusl4 = new Label("Student Mobile:");
			GridPane mediagrid = new GridPane();
			TextField medtxt1 = new TextField();
			TextField medtxt2 = new TextField();
			//TextField medtxt3 = new TextField();
			TextField medtxt4 = new TextField();
			Label medl1 = new Label("Payment Date:");
			Label medl2 = new Label("Student Id:");
			//Label medl3 = new Label("Room Id:");
			Label medl4 = new Label("Amount:");
			TextArea printcusmedta = new TextArea();
			HBox downhbox = new HBox(10);
			Button backb = new Button("Back");
			ImageView backimg = new ImageView(new Image("file:images/back.png"));
			Button delb = new Button("Delete");
			ImageView delimg = new ImageView(new Image("file:images/delete.png"));
			Button addb = new Button("Add");
			ImageView addimg = new ImageView(new Image("file:images/add.png"));
			Button findb = new Button("Find");
			ImageView findimg = new ImageView(new Image("file:images/find.png"));
			Button saveb = new Button("Save");
			ImageView saveimg = new ImageView(new Image("file:images/save.png"));
			StackPane rightstack = new StackPane();
			VBox planvbox = new VBox(10);
			ToggleGroup plantg = new ToggleGroup();
			RadioButton limrb = new RadioButton("Private");
			RadioButton unlimrb = new RadioButton("Non-private");
			Label planl = new Label("Rent type\n----------------------------");
			Label planwl = new Label("---------------\nSELECT A Type");
			VBox typevbox = new VBox(10);
			Label typel = new Label("Payment Type\n----------------------------");
			// ---------------------------------------------------
			HBox renthbox = new HBox(550);
			HBox renthbox1 = new HBox(30);
			Button rentaddb = new Button("Rent");
			Button rentremoveb = new Button("Cancel Rent");
			//Button rentprocb = new Button("Process Cart");
			Button rentreturnb = new Button("Return Rented");
			Button rentbackb = new Button("Back");
			GridPane rentgrid = new GridPane();
			Label rentcusl = new Label("Student Id:");
			Label rentmedl = new Label("Room Id:");
			Label datel = new Label("Start Date:");
			Label datel1 = new Label("End:");
			TextField rentcustxt = new TextField();
			TextField rentmedtxt = new TextField();
			TextField datetxt = new TextField();
			TextField datetxt1 = new TextField();
			TextArea rentcusta = new TextArea();
			TextArea rentmedta = new TextArea();
			HBox shitHBox = new HBox(10);
			shitHBox.getChildren().addAll(datetxt, datel1, datetxt1);
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Stage planstage = new Stage();
			Pane planp = new Pane();
			Scene planscene = new Scene(planp, 600, 400);
			VBox planvbox1 = new VBox(30);
			// ====================================================================================================
			// STYLING SECTION
			root.setStyle("-fx-background-color: #2c2c2c");
			root1.setStyle("-fx-background-color: #2c2c2c");
			planp.setStyle("-fx-background-color: #2c2c2c");
			backimg.setFitHeight(50);
			backimg.setFitWidth(50);
			findimg.setFitHeight(50);
			findimg.setFitWidth(50);
			delimg.setFitHeight(50);
			delimg.setFitWidth(50);
			addimg.setFitHeight(50);
			addimg.setFitWidth(50);
			saveimg.setFitHeight(50);
			saveimg.setFitWidth(50);
			customergrid.setHgap(70);
			customergrid.setVgap(50);
			mediagrid.setHgap(30);
			mediagrid.setVgap(10);
			rentgrid.setHgap(30);
			rentgrid.setVgap(30);
			customergrid.setPadding(new Insets(200, 100, 100, 200));
			mediagrid.setPadding(new Insets(200, 100, 100, 200));
			rentgrid.setPadding(new Insets(50, 100, 30, 100));
			addb.setFont(new Font("Arial", 20));
			addb.setGraphic(addimg);
			addb.setPrefSize(200, 100);
			addb.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
			addb.setTextFill(Color.WHITE);
			delb.setFont(new Font("Arial", 20));
			delb.setGraphic(delimg);
			delb.setPrefSize(400, 100);
			delb.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
			delb.setTextFill(Color.WHITE);
			backb.setFont(new Font("Arial", 20));
			backb.setGraphic(backimg);
			backb.setPrefSize(200, 100);
			backb.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
			backb.setTextFill(Color.WHITE);
			findb.setFont(new Font("Arial", 20));
			findb.setGraphic(findimg);
			findb.setPrefSize(300, 100);
			findb.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
			findb.setTextFill(Color.WHITE);
			saveb.setFont(new Font("Arial", 20));
			saveb.setGraphic(saveimg);
			saveb.setPrefSize(300, 100);
			saveb.setStyle("-fx-background-color: rgba(255, 255, 255, 0)");
			saveb.setTextFill(Color.WHITE);
			cusl1.setTextFill(Color.WHITE);
			cusl2.setTextFill(Color.WHITE);
			cusl3.setTextFill(Color.WHITE);
			cusl4.setTextFill(Color.WHITE);
			cusl1.setFont(new Font("Arial", 25));
			cusl2.setFont(new Font("Arial", 25));
			cusl3.setFont(new Font("Arial", 25));
			cusl4.setFont(new Font("Arial", 25));
			custxt1.setPrefSize(400, 50);
			custxt2.setPrefSize(400, 50);
			custxt3.setPrefSize(400, 50);
			custxt4.setPrefSize(400, 50);
			custxt4.setFont(new Font("Arial", 25));
			custxt3.setFont(new Font("Arial", 25));
			custxt2.setFont(new Font("Arial", 25));
			custxt1.setFont(new Font("Arial", 25));
			medl1.setTextFill(Color.WHITE);
			medl2.setTextFill(Color.WHITE);
			//medl3.setTextFill(Color.WHITE);
			medl4.setTextFill(Color.WHITE);
			medl1.setMinSize(200, 50);
			medl1.setFont(new Font("Arial", 25));
			medl2.setFont(new Font("Arial", 25));
			//medl3.setFont(new Font("Arial", 25));
			medl4.setFont(new Font("Arial", 25));
			medtxt1.setMaxSize(400, 50);
			medtxt2.setPrefSize(400, 50);
			//medtxt3.setPrefSize(400, 50);
			medtxt4.setPrefSize(400, 50);
			medtxt4.setFont(new Font("Arial", 25));
			//medtxt3.setFont(new Font("Arial", 25));
			medtxt2.setFont(new Font("Arial", 25));
			medtxt1.setFont(new Font("Arial", 25));
			typel.setTextFill(Color.WHITE);
			typel.setFont(new Font("Arial", 22));
			downhbox.setAlignment(Pos.CENTER);
			limrb.setTextFill(Color.WHITE);
			limrb.setFont(new Font("Arial", 22));
			typevbox.setVisible(true);
			medtxt1.setDisable(false);
			medtxt2.setDisable(true);
			//medtxt3.setDisable(true);
			medtxt4.setDisable(true);
			unlimrb.setTextFill(Color.WHITE);
			unlimrb.setFont(new Font("Arial", 22));
			typevbox.setPadding(new Insets(200, 100, 100, 0));
			planl.setTextFill(Color.WHITE);
			planl.setFont(new Font("Arial", 25));
			planwl.setTextFill(Color.RED);
			planwl.setFont(new Font("Arial", 25));
			planwl.setVisible(false);
			printcusmedta.setMaxSize(1000, 400);
			printcusmedta.setFont(new Font("Arial", 25));
			printcusmedta.setPadding(new Insets(0, 0, 0, 0));
			renthbox.setAlignment(Pos.CENTER);
			rentcustxt.setMaxSize(350, 50);
			rentcustxt.setFont(new Font("Arial", 25));
			rentmedtxt.setMaxSize(350, 50);
			rentmedtxt.setFont(new Font("Arial", 25));
			datetxt.setMaxSize(350, 50);
			datetxt.setFont(new Font("Arial", 25));
			datetxt1.setMaxSize(350, 50);
			datetxt1.setFont(new Font("Arial", 25));
			rentcusl.setTextFill(Color.WHITE);
			rentcusl.setFont(new Font("Arial", 25));
			rentmedl.setTextFill(Color.WHITE);
			rentmedl.setFont(new Font("Arial", 25));
			datel.setTextFill(Color.WHITE);
			datel.setFont(new Font("Arial", 25));
			datel1.setTextFill(Color.WHITE);
			datel1.setFont(new Font("Arial", 25));
			rentcusta.setFont(new Font("Arial", 21));
			rentmedta.setFont(new Font("Arial", 21));
			rentcusta.setMaxSize(700, 200);
			rentmedta.setMaxSize(700, 200);
			rentbackb.setPrefSize(100, 50);
			rentaddb.setPrefSize(150, 50);
			rentremoveb.setPrefSize(200, 50);
			rentreturnb.setPrefSize(180, 50);
			rentbackb.setFont(new Font("Arial", 20));
			rentaddb.setFont(new Font("Arial", 20));
			rentremoveb.setFont(new Font("Arial", 20));
			rentreturnb.setFont(new Font("Arial", 20));
			renthbox.setPadding(new Insets(1, 0, 20, 0));
			rentcusta.setEditable(false);
			rentmedta.setEditable(false);
			datetxt.setText(format.format(date));
			planvbox1.setPadding(new Insets(100, 100, 100, 150));
			// ====================================================================================================
			// SORTING SECTION
			root.setCenter(secondarystack);
			root.setBottom(downhbox);
			root.setRight(rightstack);
			secondarystack.getChildren().addAll(customergrid, mediagrid, printcusmedta);
			customergrid.add(custxt1, 1, 0);
			customergrid.add(cusl1, 0, 0);
			customergrid.add(custxt2, 1, 1);
			customergrid.add(cusl2, 0, 1);
			customergrid.add(custxt3, 1, 2);
			customergrid.add(cusl3, 0, 2);
			customergrid.add(custxt4, 1, 3);
			customergrid.add(cusl4, 0, 3);
			mediagrid.add(medtxt1, 1, 0);
			mediagrid.add(medl1, 0, 0);
			mediagrid.add(medtxt2, 1, 1);
			mediagrid.add(medl2, 0, 1);
			mediagrid.add(medtxt4, 1, 2);
			mediagrid.add(medl4, 0, 2);
			customergrid.setVisible(false);
			mediagrid.setVisible(false);
			printcusmedta.setVisible(false);
			printcusmedta.setEditable(false);
			downhbox.setVisible(false);
			addb.setVisible(false);
			delb.setVisible(false);
			saveb.setVisible(false);
			findb.setVisible(false);
			planvbox.setVisible(false);
			typevbox.setVisible(false);
			root.setVisible(false);
			root1.setVisible(false);
			mainstage.setScene(scene2);
			planstage.setScene(planscene);
			planp.getChildren().add(planvbox1);
			planstage.setAlwaysOnTop(true);
			mainstage.setMaximized(true);
			planstage.setTitle("BRS   CHANGE-LIMIT");
			mainstage.hide();
			planstage.hide();
			limrb.setToggleGroup(plantg);
			unlimrb.setToggleGroup(plantg);
			planvbox.getChildren().addAll(planl, limrb, unlimrb, planwl);
			bigstack.getChildren().addAll(root, root1);
			root1.setBottom(renthbox);
			root1.setCenter(rentgrid);
			renthbox.getChildren().addAll(renthbox1, rentbackb);
			custxt1.textProperty().addListener(ov -> {
				if (true == addb.isVisible()) {
					if (false == custxt1.getText().isBlank()) {
						custxt2.setDisable(false);
						if (false == custxt2.getText().isBlank())
							custxt3.setDisable(false);
						if (false == custxt3.getText().isBlank())
							custxt4.setDisable(false);
					} else {
						custxt2.setDisable(true);
						custxt3.setDisable(true);
						custxt4.setDisable(true);
					}
				}
			});
			custxt2.textProperty().addListener(ov -> {
				if (true == addb.isVisible()) {
					if (false == custxt2.getText().isBlank()) {
						custxt3.setDisable(false);
						if (false == custxt3.getText().isBlank())
							custxt4.setDisable(false);
					} else {
						custxt3.setDisable(true);
						custxt4.setDisable(true);
					}
				}
			});
			custxt3.textProperty().addListener(ov -> {
				if (addb.isVisible()) {
					if (false == custxt3.getText().isBlank())
						custxt4.setDisable(false);
					else
						custxt4.setDisable(true);
				}
			});
			medtxt1.textProperty().addListener(ov -> {
				if (true == addb.isVisible()) {
					if (false == medtxt1.getText().isBlank()) {
						medtxt2.setDisable(false);
						if (false == medtxt2.getText().isBlank())
							medtxt4.setDisable(false);
					} else {
						medtxt2.setDisable(true);
						//medtxt3.setDisable(true);
						medtxt4.setDisable(true);
					}
				} else {
					try {
						ResultSet resultSet = statement
								.executeQuery("select * from Payments where Sid='" + medtxt1.getText() + "';");

						StringBuilder sb = new StringBuilder();
						sb.append("Payments List\n");
						while (resultSet.next())
							sb
									.append(resultSet.getString(1) + "\t\t\t" + resultSet.getInt(2) + "\t\t\t"
											+ resultSet.getInt(3) + "\n");

						printcusmedta.setText(sb.toString());
					} catch (SQLException ie) {
						printcusmedta.clear();
					}
				}
			});
			medtxt2.textProperty().addListener(ov -> {
				if (true == addb.isVisible()) {
					if (false == medtxt2.getText().isBlank()) {
						medtxt4.setDisable(false);
					} else {
						medtxt4.setDisable(true);
					}
				}
			});
			rentcustxt.textProperty().addListener(ov -> {
				if (0 == mainstage.getTitle().compareTo("BRS   RENT-FORM")) {
					try {
						Integer.parseInt(rentcustxt.getText());

						try {
							ResultSet resultSet = statement
									.executeQuery("select * from Students where Sid='" + rentcustxt.getText() + "';");
							resultSet.next();
							if (resultSet.getRow() == 0) {
								throw new SQLException();

							}
							rentcusta.clear();
							rentcusta.appendText(resultSet.getInt(1) + "\t\t\t" + resultSet.getString(2) + "\t\t\t"
									+ resultSet.getString(3) + "\n");

							rentcusta.setStyle("-fx-text-fill: #3c3c3c");
						} catch (SQLException ie) {
							rentcusta.setText("ID Doesnt EXIST");
							rentcusta.setStyle("-fx-text-fill: red");
							rentcustxt.setOnMouseClicked(b -> {
								if (0 == rentcusta.getStyle().compareTo("-fx-text-fill: red"))
									rentcusta.clear();
								rentcusta.setStyle("-fx-text-fill: #3c3c3c");
							});
						}
					} catch (Exception v) {
						rentcusta.setText("INVALID OR EMPTY ID");
						rentcusta.setStyle("-fx-text-fill: red");
						rentcustxt.setOnMouseClicked(b -> {
							if (0 == rentcusta.getStyle().compareTo("-fx-text-fill: red"))
								rentcusta.clear();
							rentcusta.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
				} else if (mainstage.getTitle().compareTo("BRS   FINANCIAL-RECORD") == 0) {
					System.out.println("check");
					try {
						Integer.parseInt(rentcustxt.getText());
						System.out.println("check");
						try {
							ResultSet resultSet = statement
									.executeQuery("select * from Students where Sid='" + rentcustxt.getText() + "';");
							resultSet.next();
							if (resultSet.getRow() == 0) {
								throw new SQLException();

							}
							rentcusta.clear();
							System.out.println("check");
							rentcusta.appendText(resultSet.getInt(1) + "\t\t\t" + resultSet.getString(2) + "\t\t\t"
									+ resultSet.getString(3) + "\n");
							System.out.println("check");
							try {
								ResultSet resultSet1 = statement
										.executeQuery("select * from Rent where Sid='" + rentcustxt.getText() + "';");
								resultSet1.next();
								System.out.println("check1");
								if (resultSet1.getRow() == 0) {
									throw new SQLException();
								}
								System.out.println("chec2");
								int dd = Integer.parseInt(resultSet1.getString(6));
								rentcusta.appendText("Requiered amount: " + resultSet1.getString(6) + "\t\t\t");
								// std.getTime()-endd.getTime();
								ResultSet resultSet2 = statement
										.executeQuery(
												"select * from Payments where Sid='" + rentcustxt.getText() + "';");
								// resultSet2.next();
								if (resultSet2.getRow() == 0) {
									System.out.println("idk");
								}
								int payed = 0;
								while (resultSet2.next()) {
									payed += resultSet2.getInt(3);
								}
								rentcusta.appendText("Student balane: " + Integer.toString(payed) + "\nDue Amount:"
										+ Integer.toString(dd - payed));
							} catch (SQLException od) {
								rentcusta.setText("Student didnt rent yet");
								rentcusta.setStyle("-fx-text-fill: red");
								rentcustxt.setOnMouseClicked(b -> {
									if (0 == rentcusta.getStyle().compareTo("-fx-text-fill: red"))
										rentcusta.clear();
									rentcusta.setStyle("-fx-text-fill: #3c3c3c");
								});
							}

							rentcusta.setStyle("-fx-text-fill: #3c3c3c");
						} catch (SQLException ie) {
							rentcusta.setText("ID Doesnt EXIST");
							rentcusta.setStyle("-fx-text-fill: red");
							rentcustxt.setOnMouseClicked(b -> {
								if (0 == rentcusta.getStyle().compareTo("-fx-text-fill: red"))
									rentcusta.clear();
								rentcusta.setStyle("-fx-text-fill: #3c3c3c");
							});
						}
					} catch (Exception v) {
						rentcusta.setText("INVALID OR EMPTY ID");
						rentcusta.setStyle("-fx-text-fill: red");
						rentcustxt.setOnMouseClicked(b -> {
							if (0 == rentcusta.getStyle().compareTo("-fx-text-fill: red"))
								rentcusta.clear();
							rentcusta.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
				} else if (mainstage.getTitle().compareTo("BRS   ROOM-STATUS") == 0) {
					try {
						Integer.parseInt(rentcustxt.getText());

						try {
							ResultSet resultSet = statement
									.executeQuery("select * from Rooms where Rid='" + rentcustxt.getText() + "';");
							resultSet.next();
							if (resultSet.getRow() == 0) {
								throw new SQLException();

							}
							rentcusta.clear();
							rentcusta.appendText(resultSet.getInt(1) + "\t\t\t" + resultSet.getString(3) + "\t\t\t"
									+ resultSet.getString(5) + "\n");
							if (resultSet.getInt(2) == 0) {
								rentcusta.appendText("the room is empty");
							} else if (resultSet.getInt(2) == 1) {
								if (resultSet.getInt(4) == 0) {
									rentcusta.appendText("the room is Private and rented");
								} else {
									rentcusta.appendText("the room is not private and rented by 1 student");
								}
							} else {
								rentcusta.appendText("the room is not private and rented by 2 student");
							}
							rentcusta.setStyle("-fx-text-fill: #3c3c3c");
						} catch (SQLException ie) {
							rentcusta.setText("ID Doesnt EXIST");
							rentcusta.setStyle("-fx-text-fill: red");
							rentcustxt.setOnMouseClicked(b -> {
								if (0 == rentcusta.getStyle().compareTo("-fx-text-fill: red"))
									rentcusta.clear();
								rentcusta.setStyle("-fx-text-fill: #3c3c3c");
							});
						}
					} catch (Exception v) {
						rentcusta.setText("INVALID OR EMPTY ID");
						rentcusta.setStyle("-fx-text-fill: red");
						rentcustxt.setOnMouseClicked(b -> {
							if (0 == rentcusta.getStyle().compareTo("-fx-text-fill: red"))
								rentcusta.clear();
							rentcusta.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
				}
			});
			rentmedtxt.textProperty().addListener(ov -> {
				if (true == rentaddb.isVisible() || true == rentreturnb.isVisible()) {
					try {
						Integer.parseInt(rentmedtxt.getText());
						try {
							ResultSet resultSet = statement
									.executeQuery("select * from Rooms where Rid='" + rentmedtxt.getText() + "';");
							resultSet.next();
							if (resultSet.getRow() == 0) {
								throw new SQLException();
							}
							rentmedta.clear();
							rentmedta.appendText(resultSet.getInt(1) + "\t\t\t"
									+ resultSet.getString(3) + "\t\t\t" + resultSet.getInt(5) + "\t\t\t" + "\n");
							rentmedta.setStyle("-fx-text-fill: #3c3c3c");
							rented = resultSet.getInt(2);
							nonprivate = resultSet.getInt(4);
							if (resultSet.getInt(2) == 0) {
								rentmedta.appendText(" Empty");
								limrb.setDisable(false);
								unlimrb.setDisable(false);
							} else if (resultSet.getInt(2) == 1) {
								if (resultSet.getInt(4) == 0) {
									limrb.setSelected(true);
									rentmedta.appendText(" Full");
									limrb.setDisable(true);
									unlimrb.setDisable(true);
								} else {
									unlimrb.setSelected(true);
									rentmedta.appendText(" 1 avalible");
									limrb.setDisable(true);
									unlimrb.setDisable(true);
								}
							} else {
								rentmedta.appendText("Full");
								if (resultSet.getInt(4) == 0) {
									limrb.setSelected(true);
									limrb.setDisable(true);
									unlimrb.setDisable(true);
								} else {
									unlimrb.setSelected(true);
									limrb.setDisable(true);
									unlimrb.setDisable(true);
								}
							}
						} catch (SQLException ie) {
							rentmedta.setText("ID Doesnt EXIST");
							rentmedta.setStyle("-fx-text-fill: red");
							rentmedtxt.setOnMouseClicked(b -> {
								if (0 == rentmedta.getStyle().compareTo("-fx-text-fill: red"))
									rentmedta.clear();
								rentmedta.setStyle("-fx-text-fill: #3c3c3c");
							});
						}
					} catch (Exception v) {
						rentmedta.setText("INVALID OR EMPTY ID");
						rentmedta.setStyle("-fx-text-fill: red");
						rentmedtxt.setOnMouseClicked(b -> {
							if (0 == rentmedta.getStyle().compareTo("-fx-text-fill: red"))
								rentmedta.clear();
							rentmedta.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
				}
			});
			// ====================================================================================================
			// execution SECTION
			main1b.setOnAction(e -> {
				mainstage.show();
				primaryStage.hide();
				if (0 == main1b.getText().compareTo("Add A New Student")) {
					root.setVisible(true);
					customergrid.setVisible(true);
					mediagrid.setVisible(false);
					downhbox.setVisible(true);
					addb.setVisible(true);
					custxt4.setDisable(true);
					custxt3.setDisable(true);
					custxt2.setDisable(true);
					custxt1.setDisable(false);
					downhbox.getChildren().addAll(addb, backb);
					downhbox.setPadding(new Insets(1, 200, 100, 200));
					mainstage.setTitle("BRS   ADD-NEW-Student");
				} else if (0 == main1b.getText().compareTo("Add A New Payment")) {
					root.setVisible(true);
					mediagrid.setVisible(true);
					downhbox.setVisible(true);
					addb.setVisible(true);
					secondarystack.getChildren().remove(printcusmedta);
					medtxt1.setText(format.format(date));
					downhbox.getChildren().addAll(addb, backb);
					downhbox.setPadding(new Insets(1, 200, 100, 200));
					mainstage.setTitle("BRS   ADD-NEW-Payment");
				} else {
					root1.setVisible(true);
					renthbox1.getChildren().addAll(rentaddb, rentremoveb);
					renthbox.setPadding(new Insets(1, 0, 20, 70));
					renthbox1.setPadding(new Insets(0, 0, 0, 0));
					rentcusta.setMaxSize(700, 500);
					rentgrid.add(rentcusl, 0, 0);
					rentgrid.add(rentcustxt, 1, 0);
					rentgrid.add(rentcusta, 1, 1);
					rentgrid.add(rentmedl, 0, 2);
					rentgrid.add(rentmedtxt, 1, 2);
					rentgrid.add(rentmedta, 1, 3);
					rentgrid.add(datel, 0, 4);
					rentgrid.add(shitHBox, 1, 4);
					planvbox.setVisible(true);
					rentgrid.add(planvbox, 2, 3);
					rentgrid.setPadding(new Insets(50, 100, 30, 100));
					mainstage.setTitle("BRS   RENT-FORM");
					rentcustxt.setEditable(true);
				}
			});
			main2b.setOnAction(e -> {
				if (0 == main1b.getText().compareTo("Add A New Student")) {
					mainstage.show();
					root.setVisible(true);
					customergrid.setVisible(true);
					downhbox.setVisible(true);
					mediagrid.setVisible(false);
					delb.setVisible(true);
					findb.setVisible(true);
					custxt1.setDisable(false);
					custxt2.setDisable(true);
					custxt3.setDisable(true);
					custxt4.setDisable(true);
					limrb.setDisable(true);
					unlimrb.setDisable(true);
					downhbox.getChildren().addAll(findb, delb, backb);
					downhbox.setPadding(new Insets(1, 460, 100, 200));
					primaryStage.hide();
					mainstage.setTitle("BRS   DELETE-A-Student");
				}  else {
					flag = 0;
					mainstage.show();
					primaryStage.hide();
					root1.setVisible(true);
					renthbox1.setPadding(new Insets(0, 0, 0, 0));
					rentgrid.add(rentcusl, 0, 0);
					rentgrid.add(rentcustxt, 1, 0);
					rentgrid.add(rentcusta, 1, 1);
					rentgrid.getChildren().removeAll(rentmedtxt, rentmedl, rentmedta, datetxt, datel, planvbox,
							shitHBox);
					rentcusta.setMaxSize(700, 700);
					rentgrid.setPadding(new Insets(100, 0, 0, 150));
					renthbox.setPadding(new Insets(1, 55, 70, 80));
					mainstage.setTitle("BRS   FINANCIAL-RECORD");
				}
			});
			main3b.setOnAction(e -> {
				if (0 == main1b.getText().compareTo("Add A New Student")) {
					mainstage.show();
					root.setVisible(true);
					mediagrid.setVisible(false);
					customergrid.setVisible(true);
					downhbox.setVisible(true);
					saveb.setVisible(true);
					findb.setVisible(true);
					custxt1.setDisable(false);
					custxt2.setDisable(true);
					custxt3.setDisable(true);
					custxt4.setDisable(true);
					limrb.setDisable(true);
					unlimrb.setDisable(true);
					downhbox.getChildren().addAll(findb, saveb, backb);
					downhbox.setPadding(new Insets(1, 460, 100, 200));
					primaryStage.hide();
					mainstage.setTitle("BRS   MODIFY-A-Student");
				}  else {
					flag = 1;
					mainstage.show();
					primaryStage.hide();
					root1.setVisible(true);
					renthbox1.setPadding(new Insets(0, 0, 0, 0));
					rentgrid.add(rentcusl, 0, 0);
					rentgrid.add(rentcustxt, 1, 0);
					rentgrid.add(rentcusta, 1, 1);
					rentcusl.setText("Room ID:");
					rentgrid.getChildren().removeAll(rentmedtxt, rentmedl, rentmedta, datetxt, datel, planvbox,
							shitHBox);
					rentcusta.setMaxSize(700, 700);
					rentgrid.setPadding(new Insets(100, 0, 0, 150));
					renthbox.setPadding(new Insets(1, 55, 70, 80));
					mainstage.setTitle("BRS   ROOM-STATUS");
				}
			});
			main4b.setOnAction(e -> {
				if (0 == main1b.getText().compareTo("Add A New Student")) {
					mainstage.show();
					root.setVisible(true);
					mediagrid.setVisible(false);
					customergrid.setVisible(true);
					downhbox.setVisible(true);
					findb.setVisible(true);
					custxt1.setDisable(false);
					custxt2.setDisable(true);
					custxt3.setDisable(true);
					custxt4.setDisable(true);
					limrb.setDisable(true);
					unlimrb.setDisable(true);
					downhbox.getChildren().addAll(findb, backb);
					downhbox.setPadding(new Insets(1, 200, 100, 200));
					primaryStage.hide();
					mainstage.setTitle("BRS   FIND-A-Student");
				} else if (0 == main1b.getText().compareTo("Add A New Payment")) {
					mainstage.show();
					root.setVisible(true);
					mediagrid.setVisible(true);
					downhbox.setVisible(true);
					findb.setVisible(true);
					medtxt1.setDisable(false);
					printcusmedta.clear();
					mediagrid.getChildren().removeAll(medl2, medtxt2, medl4, medtxt4);
					mediagrid.add(printcusmedta, 1, 1);
					printcusmedta.setVisible(true);
					downhbox.getChildren().addAll(backb);
					downhbox.setPadding(new Insets(1, 200, 100, 200));
					primaryStage.hide();
					mainstage.setTitle("BRS   FIND-A-Payment");
				} 
			});
			main5b.setOnAction(e -> {
				if (0 == main1b.getText().compareTo("Add A New Student")) {
					mainstage.show();
					root.setVisible(true);
					mediagrid.setVisible(false);
					customergrid.setVisible(false);
					downhbox.setVisible(true);
					printcusmedta.setVisible(true);
					downhbox.getChildren().addAll(backb);
					downhbox.setPadding(new Insets(1, 200, 100, 200));
					primaryStage.hide();
					mainstage.setTitle("BRS   PRINT-Students");
					printcusmedta.clear();
					try {
						ResultSet resultSet = statement.executeQuery("select * from Students");
						printcusmedta.appendText("Students List\n");
						while (resultSet.next())
							printcusmedta
									.appendText(resultSet.getString(1) + "\t\t\t" + resultSet.getString(2) + "\t\t\t"
											+ resultSet.getString(3) + "\n");
					} catch (SQLException ie) {

					}
					downhbox.setPadding(new Insets(1, 200, 100, 200));
					secondarystack.setPadding(new Insets(0, 0, 0, 220));
				} else if (0 == main1b.getText().compareTo("Add A New Payment")) {
					mainstage.show();
					root.setVisible(true);
					mediagrid.setVisible(false);
					customergrid.setVisible(false);
					downhbox.setVisible(true);
					//mediagrid.getChildren().add(printcusmedta);
					//secondarystack.getChildren().addAll(printcusmedta);
					printcusmedta.clear();
					printcusmedta.setVisible(true);
					downhbox.getChildren().addAll(backb);
					downhbox.setPadding(new Insets(1, 200, 100, 200));
					primaryStage.hide();
					//secondarystack.getChildren().add(printcusmedta);
					try {
						ResultSet resultSet = statement.executeQuery("select * from Payments");
						printcusmedta.appendText("Students List\n");
						while (resultSet.next())
							printcusmedta
									.appendText(resultSet.getString(1) + "\t\t\t" + resultSet.getInt(2) + "\t\t\t"
											+ resultSet.getInt(3) + "\n");
					} catch (SQLException ie) {

					}
					mainstage.setTitle("BRS   PRINT-Payment");
					downhbox.setPadding(new Insets(1, 200, 100, 200));
					secondarystack.setPadding(new Insets(0, 0, 0, 220));
				} else {
					primaryStage.hide();
					planstage.show();
					planvbox1.getChildren().addAll(rentcusl, rentcustxt, rentbackb);
					rentcusl.setText("Enter A New Room price");
					flag = 4;
				}
			});
			backb.setOnAction(e -> {
				if (0 == main1b.getText().compareTo("Add A New Student")) {
					downhbox.getChildren().clear();
					customergrid.setVisible(false);
					printcusmedta.setVisible(false);
					downhbox.setVisible(false);
					addb.setVisible(false);
					delb.setVisible(false);
					findb.setVisible(false);
					saveb.setVisible(false);
					planvbox.setVisible(false);
					printcusmedta.setVisible(false);
					custxt1.clear();
					custxt2.clear();
					custxt3.clear();
					custxt4.clear();
					root.setVisible(false);
					mainstage.hide();
					primaryStage.show();
					secondarystack.setPadding(new Insets(0, 0, 0, 0));
				} else {
					downhbox.getChildren().clear();
					mediagrid.setVisible(false);
					downhbox.setVisible(false);
					typevbox.setVisible(false);
					addb.setVisible(false);
					delb.setVisible(false);
					findb.setVisible(false);
					saveb.setVisible(false);
					medtxt1.clear();
					medtxt2.clear();
					//medtxt3.clear();
					medtxt4.clear();
					if (0 == mainstage.getTitle().compareTo("BRS   ADD-NEW-Payment")) {
						secondarystack.getChildren().add(printcusmedta);
						//mediagrid.getChildren().remove(printcusmedta);
						
					}
					if (0 == mainstage.getTitle().compareTo("BRS   FIND-A-Payment")) {
						printcusmedta.setVisible(false);
						mediagrid.getChildren().remove(printcusmedta);
						mediagrid.add(medl2, 0, 1);
						mediagrid.add(medtxt2, 1, 1);
						//mediagrid.add(medl3, 0, 2);
						//mediagrid.add(medtxt3, 1, 2);
						mediagrid.add(medl4, 0, 3);
						mediagrid.add(medtxt4, 1, 3);
						secondarystack.getChildren().add(printcusmedta);
					}
					root.setVisible(false);
					mainstage.hide();
					primaryStage.show();
					secondarystack.setPadding(new Insets(0, 0, 0, 0));
				}
			});
			rentbackb.setOnAction(e -> {
				if (flag == 4) {
					try {
						Integer.parseInt(rentcustxt.getText());
					} catch (Exception v) {
						rentcustxt.setText("INVALID OR EMPTY ID");
						rentcustxt.setStyle("-fx-text-fill: red");
						rentcustxt.setOnMouseClicked(b -> {
							if (0 == rentcustxt.getStyle().compareTo("-fx-text-fill: red"))
								rentcustxt.clear();
							rentcustxt.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
					rentcusl.setText("Student Id:");
					String query = "UPDATE Rooms SET Rprice = '" + rentcustxt.getText() + "' ;";
					try {
						PreparedStatement pstmt = connection.prepareStatement(query);
						pstmt.execute();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					// ChangingLimit(database, Integer.parseInt(rentcustxt.getText()));
					planvbox.getChildren().removeAll(rentcusl, rentcustxt, rentbackb);
					renthbox.getChildren().add(rentbackb);
					planstage.hide();
					primaryStage.show();
				}
				renthbox1.getChildren().clear();
				root1.setVisible(false);
				mainstage.hide();
				rentcusl.setText("Student id:");
				primaryStage.show();
				rentcustxt.clear();
				rentmedtxt.clear();
				rentcusta.clear();
				rentmedta.clear();
				planvbox1.getChildren().clear();
				rentgrid.getChildren().removeAll(rentmedtxt, rentmedl, rentmedta, datetxt, datel, rentcustxt, rentcusta,
						rentcusl);
				flag = 5;
			});
			addb.setOnAction(e -> {
				if (0 == main1b.getText().compareTo("Add A New Student")) {
					try {
						Integer.parseInt(custxt1.getText());
					} catch (Exception v) {
						custxt1.setText("INVALID OR EMPTY ID");
						custxt1.setStyle("-fx-text-fill: red");
						custxt1.setOnMouseClicked(b -> {
							if (0 == custxt1.getStyle().compareTo("-fx-text-fill: red"))
								custxt1.clear();
							custxt1.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
					try {
						if (custxt2.getText().isBlank())
							throw new Exception();
					} catch (Exception v) {
						custxt2.setText("EMPTY NAME");
						custxt2.setStyle("-fx-text-fill: red");
						custxt2.setOnMouseClicked(b -> {
							if (0 == custxt2.getStyle().compareTo("-fx-text-fill: red"))
								custxt2.clear();
							custxt2.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
					try {
						String temp = custxt4.getText().replaceAll(",", "");
						Long.parseLong(temp);
					} catch (Exception vx) {
						custxt4.setText("INVALID OR EMPTY NUMBER");
						custxt4.setStyle("-fx-text-fill: red");
						custxt4.setOnMouseClicked(b -> {
							if (0 == custxt4.getStyle().compareTo("-fx-text-fill: red"))
								custxt4.clear();
							custxt4.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
					if (0 != custxt1.getStyle().compareTo("-fx-text-fill: red")
							&& 0 != custxt2.getStyle().compareTo("-fx-text-fill: red")
							&& (0 != custxt4.getStyle().compareTo("-fx-text-fill:red"))) {
						try {
							String query = "INSERT INTO Students(Sid, Sname,Sdob) VALUES (?, ?, ?)";
							PreparedStatement pstmt = connection.prepareStatement(query);
							pstmt.setInt(1, Integer.parseInt(custxt1.getText()));
							pstmt.setString(2, custxt2.getText());
							java.util.Date date1;
							try {
								date1 = format.parse(custxt3.getText());
								java.sql.Date sqldate = new java.sql.Date(date1.getTime());
								pstmt.setDate(3, sqldate);
								pstmt.execute();
							} catch (ParseException e1) {
								custxt3.setText("INVALID OR EMPTY DATE");
								custxt3.setStyle("-fx-text-fill: red");
								custxt3.setOnMouseClicked(b -> {
									if (0 == custxt3.getStyle().compareTo("-fx-text-fill: red"))
										custxt3.clear();
									custxt3.setStyle("-fx-text-fill: #3c3c3c");
								});
							}
							String[] temp = custxt4.getText().split(",");
							for (int i = 0; i < temp.length; i++) {
								String query1 = "INSERT INTO Students_phones(Sid, Sphone) VALUES (?, ?)";
								PreparedStatement pstmt1 = connection.prepareStatement(query1);
								pstmt1.setInt(1, Integer.parseInt(custxt1.getText()));
								pstmt1.setLong(2, Long.parseLong(temp[i]));
								pstmt1.execute();
							}
						} catch (SQLException es) {
							System.out.println("error1");
						}
						custxt1.clear();
						custxt2.clear();
						custxt3.clear();
						custxt4.clear();
					}
				} else {
					try {
						Integer.parseInt(medtxt2.getText());
						try {
							ResultSet resultSet = statement
									.executeQuery("select * from Students where Sid='" + medtxt2.getText() + "';");
							resultSet.next();
							if (resultSet.getRow() == 0) {
								throw new SQLException();
							}
						} catch (SQLException oq) {
							medtxt2.setText("Student Id doesnt exist");
							medtxt2.setStyle("-fx-text-fill: red");
							medtxt2.setOnMouseClicked(b -> {
								if (0 == medtxt2.getStyle().compareTo("-fx-text-fill: red"))
									medtxt2.clear();
								medtxt2.setStyle("-fx-text-fill: #3c3c3c");
							});
						}
					} catch (Exception v) {
						medtxt2.setText("INVALID OR EMPTY Students Id");
						medtxt2.setStyle("-fx-text-fill: red");
						medtxt2.setOnMouseClicked(b -> {
							if (0 == medtxt2.getStyle().compareTo("-fx-text-fill: red"))
								medtxt2.clear();
							medtxt2.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
					
					try {
						Integer.parseInt(medtxt4.getText());
					} catch (Exception v) {
						medtxt2.setText("INVALID OR EMPTY Amount");
						medtxt2.setStyle("-fx-text-fill: red");
						medtxt2.setOnMouseClicked(b -> {
							if (0 == medtxt2.getStyle().compareTo("-fx-text-fill: red"))
								medtxt2.clear();
							medtxt2.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
					if ((0 != medtxt1.getStyle().compareTo("-fx-text-fill: red")
							&& 0 != medtxt2.getStyle().compareTo("-fx-text-fill: red")
							)
							&& ((0 != medtxt4.getStyle().compareTo("-fx-text-fill: red")
									&& false == medtxt4.isDisable()))) {
						try {
							String query = "INSERT INTO Payments(Pay_date,Sid,Payed_amount) VALUES (?, ?, ?)";
							PreparedStatement pstmt = connection.prepareStatement(query);
							pstmt.setInt(2, Integer.parseInt(medtxt2.getText()));
							pstmt.setInt(3, Integer.parseInt(medtxt4.getText()));
							java.util.Date date1;
							try {
								date1 = format.parse(medtxt1.getText());
								java.sql.Date sqldate = new java.sql.Date(date1.getTime());
								pstmt.setDate(1, sqldate);
								pstmt.execute();
							} catch (ParseException e1) {
								custxt1.setText("INVALID OR EMPTY DATE");
								custxt1.setStyle("-fx-text-fill: red");
								custxt1.setOnMouseClicked(b -> {
									if (0 == custxt1.getStyle().compareTo("-fx-text-fill: red"))
										custxt1.clear();
									custxt1.setStyle("-fx-text-fill: #3c3c3c");
								});
							}
						} catch (SQLException es) {
							System.out.println(" error2");
						}
						medtxt2.clear();
						//medtxt3.clear();
						medtxt4.clear();
					}
				}
			});
			findb.setOnAction(e -> {
				if (0 == main1b.getText().compareTo("Add A New Student")) {
					try {
						Integer.parseInt(custxt1.getText());
						try {
							String query = "select * from Students where Sid = " + custxt1.getText() + ";";
							ResultSet resultSet = statement.executeQuery(query);
							resultSet.next();
							custxt2.setText(resultSet.getString(2));
							custxt3.setText(resultSet.getString(3));

							String query1 = "select * from Students_phones where Sid = " + custxt1.getText() + ";";
							ResultSet resultSet1 = statement.executeQuery(query1);
							// resultSet1.next();
							StringBuilder sb = new StringBuilder();
							while (resultSet1.next()) {
								sb.append(resultSet1.getString(2) + ",");
							}
							custxt4.setText(sb.toString());
							if (true == saveb.isVisible()) {
								custxt2.setDisable(false);
								custxt3.setDisable(false);
								custxt4.setDisable(false);
							}
						} catch (SQLException e1) {
							custxt2.setDisable(true);
							custxt3.setDisable(true);
							custxt4.setDisable(true);
							custxt1.clear();
							custxt2.clear();
							custxt3.clear();
							custxt4.clear();
							custxt1.setText("ID DOESNT EXIST");
							custxt1.setStyle("-fx-text-fill: red");
							custxt1.setOnMouseClicked(b -> {
								if (0 == custxt1.getStyle().compareTo("-fx-text-fill: red"))
									custxt1.clear();
								custxt1.setStyle("-fx-text-fill: #3c3c3c");
							});
							e1.printStackTrace();
						}
					} catch (Exception v) {
						custxt2.setDisable(true);
						custxt3.setDisable(true);
						custxt4.setDisable(true);
						custxt1.clear();
						custxt2.clear();
						custxt3.clear();
						custxt4.clear();
						custxt1.setText("INVALID OR EMPTY ID");
						custxt1.setStyle("-fx-text-fill: red");
						custxt1.setOnMouseClicked(b -> {
							if (0 == custxt1.getStyle().compareTo("-fx-text-fill: red"))
								custxt1.clear();
							custxt1.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
				} else {
					try {
						Integer.parseInt(medtxt1.getText());
					} catch (Exception v) {
						medtxt1.clear();
						medtxt2.clear();
						//medtxt3.clear();
						medtxt4.clear();
						medtxt1.setText("INVALID OR EMPTY ID");
						medtxt1.setStyle("-fx-text-fill: red");
						medtxt1.setOnMouseClicked(b -> {
							if (0 == medtxt1.getStyle().compareTo("-fx-text-fill: red"))
								medtxt1.clear();
							medtxt1.setStyle("-fx-text-fill: #3c3c3c");
						});
					}
				}
			});

			delb.setOnAction(e -> {
				if (0 == main1b.getText().compareTo("Add A New Student")) {
					String query = "delete from Students where Sid = " + custxt1.getText() + ";";
					try {
						PreparedStatement pstmt = connection.prepareStatement(query);
						pstmt.execute();
						custxt1.clear();
						custxt2.clear();
						custxt3.clear();
						custxt4.clear();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			saveb.setOnAction(e -> {
				if (0 == main1b.getText().compareTo("Add A New Student")) {
					String query = "UPDATE Students SET Sname = '" + custxt2.getText() + "', Sdob='" + custxt3.getText()
							+ "'  WHERE Sid =" + custxt1.getText() + " ;";
					try {
						PreparedStatement pstmt = connection.prepareStatement(query);
						pstmt.execute();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			rentaddb.setOnAction(e -> {
				try {
					if (false == limrb.isSelected() && false == unlimrb.isSelected())
						throw new Exception();
				} catch (Exception vx) {
					planwl.setVisible(true);
					limrb.setOnMouseClicked(b -> {
						planwl.setVisible(false);
					});
					unlimrb.setOnMouseClicked(b -> {
						planwl.setVisible(false);
					});
				}try{
					if(datetxt1.getText().isBlank()==true){
						throw new Exception();
					}
				}
				catch (Exception e1) {
					datetxt1.setText("INVALID OR EMPTY DATE");
					datetxt1.setStyle("-fx-text-fill: red");
					datetxt1.setOnMouseClicked(b -> {
						if (0 == datetxt1.getStyle().compareTo("-fx-text-fill: red"))
							datetxt1.clear();
						datetxt1.setStyle("-fx-text-fill: #3c3c3c");
					});
				}
				if (0 != rentcusta.getStyle().compareTo("-fx-text-fill: red") && false == rentcustxt.getText().isBlank()
						&& false == rentmedtxt.getText().isBlank()
						&& 0 != rentmedta.getStyle().compareTo("-fx-text-fill: red")
						&& false == datetxt.getText().isBlank() && false == datetxt1.getText().isBlank()
						&& (rented == 0 || (rented == 1 && nonprivate != 0))
						&& (limrb.isSelected() == true || unlimrb.isSelected() == true)) {
					try {
						String query = "INSERT INTO Rent(Sid, Rid,Start_date,Eid,End_date,Req_amount) VALUES (?,?, ?, ?, ?,?)";
						PreparedStatement pstmt = connection.prepareStatement(query);
						pstmt.setInt(1, Integer.parseInt(rentcustxt.getText()));
						pstmt.setInt(2, Integer.parseInt(rentmedtxt.getText()));
						ResultSet resultSet0 = statement
								.executeQuery("SELECT Eid FROM Employees ORDER BY RAND() LIMIT 1;");
						resultSet0.next();
						pstmt.setInt(4, resultSet0.getInt(1));
						try {
							ResultSet resultSet = statement
									.executeQuery("select Rprice from Rooms where Rid='" + rentmedtxt.getText() + "';");
							resultSet.next();
							String[] temp = datetxt.getText().split("-");
							LocalDate std = LocalDate.of(Integer.parseInt(temp[0]), Month.of(Integer.parseInt(temp[1])),
									Integer.parseInt(temp[2]));
							temp = datetxt1.getText().split("-");
							LocalDate endd = LocalDate.of(Integer.parseInt(temp[0]),
									Month.of(Integer.parseInt(temp[1])), Integer.parseInt(temp[2]));
							Period per = Period.between(std, endd);
							int period = per.getMonths() + per.getYears() * 12;
							if (per.getDays() > 0) {
								period += 1;
							}
							if(limrb.isSelected()==true){
								pstmt.setInt(6, period * resultSet.getInt(1));
							}
							else{
								pstmt.setInt(6, period * resultSet.getInt(1)/2);
							}
						} catch (SQLException oq) {

						}
						java.util.Date date1;
						try {
							date1 = format.parse(datetxt.getText());
							java.sql.Date sqldate = new java.sql.Date(date1.getTime());
							pstmt.setDate(3, sqldate);

						} catch (ParseException e1) {
							datetxt.setText("INVALID OR EMPTY DATE");
							datetxt.setStyle("-fx-text-fill: red");
							datetxt.setOnMouseClicked(b -> {
								if (0 == datetxt.getStyle().compareTo("-fx-text-fill: red"))
									datetxt.clear();
								datetxt.setStyle("-fx-text-fill: #3c3c3c");
							});
						}
						try {
							date1 = format.parse(datetxt1.getText());
							java.sql.Date sqldate = new java.sql.Date(date1.getTime());
							pstmt.setDate(5, sqldate);
						} catch (ParseException e1) {
							datetxt1.setText("INVALID OR EMPTY DATE");
							datetxt1.setStyle("-fx-text-fill: red");
							datetxt1.setOnMouseClicked(b -> {
								if (0 == datetxt1.getStyle().compareTo("-fx-text-fill: red"))
									datetxt1.clear();
								datetxt1.setStyle("-fx-text-fill: #3c3c3c");
							});
						}
						pstmt.execute();
						int temp = rented + 1;
					int choose;
					if (limrb.isSelected() == true) {
						choose = 0;
					} else {
						choose = 1;
					}
					String query1 = "UPDATE Rooms SET Rstatus = " + temp + ", Rtype=" + choose
							+ "  WHERE Rid =" + Integer.parseInt(rentmedtxt.getText()) + " ;";
					try {
						PreparedStatement pstmt1 = connection.prepareStatement(query1);
						pstmt1.execute();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					rentcustxt.clear();
					rentmedtxt.clear();
					datetxt1.clear();
					rentcusta.clear();
					rentmedta.clear();
					limrb.setSelected(false);
					unlimrb.setSelected(false);
					limrb.setDisable(false);
					unlimrb.setDisable(false);
					} catch (SQLException ie) {
					}
					

				}
			});
			rentremoveb.setOnAction(e -> {
				if (0 != rentcusta.getStyle().compareTo("-fx-text-fill: red")
						&& false == rentcustxt.getText().isBlank()&&0 != rentmedta.getStyle().compareTo("-fx-text-fill: red")
						&& false == rentmedtxt.getText().isBlank()) {
					try {
						ResultSet resultSet = statement
								.executeQuery("select * from Rooms where Rid='" + rentmedtxt.getText() + "';");
						resultSet.next();

						String query1 = "UPDATE Rooms SET Rstatus = '" + (resultSet.getInt(2) - 1)
								+ "'  WHERE Rid =" + rentcustxt.getText() + " ;";
						try {
							PreparedStatement pstmt = connection.prepareStatement(query1);
							pstmt.execute();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						if (resultSet.getInt(4) == 0) {
							String query = "delete from Rent where Sid = " + rentcustxt.getText() + ";";
							try {
								PreparedStatement pstmt = connection.prepareStatement(query);
								pstmt.execute();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					} catch (SQLException ie) {

					}
				}
			});
			// ===================================================================================================
			// ---------------------------------------
			// SECONDARYSTAGE END
			// ---------------------------------------------------------------------------------------------------
			// ===================================================================================================
		}
		// END OF TRY STATEMENT
		// =======================================================================================================
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ====================================================================================================
	// MAIN
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		launch(args);
	}
}
