package com.example.assign22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String style=getClass().getResource("/Style.css").toExternalForm();
        BorderPane root=new BorderPane();
        Label menu=new Label("MENU");
        menu.setId("menu");
        VBox.setMargin(menu,new  Insets(5, 10, 5,40));

        VBox menu_content=new VBox();
        menu_content.setPrefSize(150,600);
        menu_content.setId("menu_content");
        root.setLeft(menu_content);

        VBox body=new VBox();
        body.setAlignment(Pos.CENTER);
        body.setPrefSize(200,600);
        body.setId("body");
        root.setCenter(body);


        Button head_text=new Button("Post Heading");
        TextField text=new TextField();
        text.setId("text");
        Label get_text=new Label();

        VBox.setMargin(head_text,new  Insets(5, 10, 5,50));
        head_text.setOnAction(actionEvent -> {
            get_text.setText(text.getText());
            get_text.setId("get_text");
            VBox.setMargin(get_text,new  Insets(5, 20, 5,0));
            body.getChildren().addAll(get_text);
            text.setText("");
        });

        RadioButton orange= new RadioButton("white");
        RadioButton Blue= new RadioButton("blue");
        ToggleGroup radioGroup = new ToggleGroup();

        orange.setToggleGroup(radioGroup);
        Blue.setToggleGroup(radioGroup);

        TilePane  colors= new TilePane();
        VBox.setMargin(colors,new  Insets(5, 0, 0,20));
        colors.getChildren().add(orange);
        colors.getChildren().add(Blue);

        orange.setOnAction(actionEvent -> {
            orange.setId("orange");
            get_text.setTextFill(Paint.valueOf("orange"));
        });
        Blue.setOnAction(actionEvent -> {
            Blue.setId("Blue");
            get_text.setTextFill(Paint.valueOf("blue"));
        });

        Button Make_Button=new Button("AddButton");
        VBox.setMargin(Make_Button,new  Insets(5, 10, 5,50));
        TextField Button_Name=new TextField();
        Button_Name.setPromptText("Type Button Name");
        Button_Name.setId("Button_Name");
        Button_Name.setPromptText("Enter Button Name");
        Make_Button.setOnAction(actionEvent -> {
            Button New=new Button(Button_Name.getText());
            body.getChildren().add(New);
            Button_Name.setText("");
        });

        Button ParagraphB=new Button("Post Text");
        TextField Paragraph=new TextField();
        Paragraph.setPromptText("Write paragraph");
        Paragraph.setId("Paragraph");
        Label dis_paragraph=new Label();

        VBox.setMargin(ParagraphB,new  Insets(5, 10, 5,50));
        ParagraphB.setOnAction(actionEvent -> {
            dis_paragraph.setText(Paragraph.getText());
            dis_paragraph.setId("paragraph");
            dis_paragraph.setWrapText(true);
            dis_paragraph.setMaxWidth(800);
            dis_paragraph.setAlignment(Pos.CENTER);
            VBox.setMargin(dis_paragraph,new  Insets(5, 20, 5,0));
            body.getChildren().addAll(dis_paragraph);
            text.setText("");
        });

        Button get_img=new Button("File Img");
        get_img.setId("get_img");
        VBox.setMargin(get_img,new  Insets(5, 10, 5,50));

        ImageView imageView=new ImageView();
        get_img.setOnAction(actionEvent -> {
            FileChooser chooser=new FileChooser();
            var file=chooser.showOpenDialog(stage);
            var imgU = new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png");
            chooser.getExtensionFilters().add(imgU);
            Image img=new Image(file.getAbsolutePath());
            imageView.setImage(img);
            imageView.setFitHeight(100);
            imageView.setFitWidth(120);
            body.getChildren().addAll(imageView);
        });

        menu_content.getChildren().addAll(menu,text,head_text,colors,Paragraph,ParagraphB,Button_Name,Make_Button,get_img);


        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(style);
        stage.setTitle("Assignment 2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}