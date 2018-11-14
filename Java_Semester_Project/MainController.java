package edu.uh.tech.cis3368.projectstarter;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import org.springframework.stereotype.Component;

@Component
public class MainController {
    public Label srcLabel;
    public TextField target;
    public void onDragDetected(MouseEvent mouseEvent) {
        System.out.println("detected drag.");
        Dragboard dragboard = srcLabel.startDragAndDrop(TransferMode.COPY_OR_MOVE);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString("Dragged from label.");
        dragboard.setContent(clipboardContent);
        mouseEvent.consume();
    }

    public void onDragOver(DragEvent dragEvent) {
        System.out.println("drag over.");
        Dragboard dragboard = dragEvent.getDragboard();
        dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        dragEvent.consume();

    }

    public void dragDropped(DragEvent dragEvent) {
        Dragboard dragboard = dragEvent.getDragboard();
        String s = dragboard.getString();
        target.setText(s);
    }
}
