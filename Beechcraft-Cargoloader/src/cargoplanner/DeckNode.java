 /*
 * Copyright (c) 2008-2010, JFXtras Group
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name of JFXtras nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package cargoplanner;

import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.effect.GlowBuilder;
import javafx.scene.effect.ShadowBuilder;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.Font;

/**
 *
 * node containing the aircraft deck background and scale showing distance from
 * the datum(nose of the aircraft)
 *
 * @author Abhilshit Soni
 */
public class DeckNode extends Parent {

    ImageView deckImage = ImageViewBuilder.create().cache(true).
            x(0).
            y(0).
            image(new Image(DeckNode.class.getResourceAsStream("images/FAA-H-8083-1B.png"))).
            visible(true).
            build();
    Rectangle deckImageBorder = RectangleBuilder.create().opacity(0.5).
            effect(GlowBuilder.create().level(1).
            input(ShadowBuilder.create().width(5).
            color(Color.CADETBLUE).
            radius(15).
            build()).
            build()).
            cache(true).
            x(-8).
            y(-8).
            fill(Color.CADETBLUE).
            width(deckImage.getImage().
            getWidth() + 12).
            height(deckImage.getImage().
            getHeight() + 49).
            build();
    Rectangle deckImageBg = RectangleBuilder.create().cache(true).
            x(-7).
            y(-7).
            fill(Color.BLACK).
            width(deckImage.getImage().
            getWidth() + 10).
            height(deckImage.getImage().
            getWidth() + 48).
            arcWidth(15).
            arcHeight(15).
            build();
    Rectangle deckImageHeader = RectangleBuilder.create().cache(true).
            x(37).
            y(-20).
            fill(Color.BLACK).
            width(deckImage.getImage().
            getWidth() - 80).
            height(20).
            arcHeight(5).
            arcWidth(5).
            opacity(1).
            effect(ShadowBuilder.create().radius(1).
            color(Color.BLACK).
            build()).
            build();
    Label header = LabelBuilder.create().cache(true).
            layoutX(123).
            layoutY(-20).
            textFill(Color.WHITE).
            font(new Font(15)).
            prefWidth(deckImage.getImage().
            getWidth() - 180).
            text("AIRCRAFT MODEL: BEECHCRAFT 1900C | MAIN DECK | NY CITY -> L.A").
            build();
    Line scaleBaseLine = LineBuilder.create().cache(true).
            startX(10).
            startY(160).
            endX(670).
            endY(160).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Line noseLine = LineBuilder.create().cache(true).
            startX(670).
            startY(155).
            endX(670).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label noseLabel = LabelBuilder.create().cache(true).
            layoutX(656).
            layoutY(166).
            text("0 Nose").
            wrapText(true).
            prefWidth(25).
            textFill(Color.WHITE).
            build();
    Line tailLine = LineBuilder.create().cache(true).
            startX(10).
            startY(155).
            endX(10).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label tailLabel = LabelBuilder.create().cache(true).
            layoutX(5).
            layoutY(166).
            text("533 Tail").
            wrapText(true).
            prefWidth(35).
            textFill(Color.WHITE).
            build();
    Line aLine = LineBuilder.create().cache(true).
            startX(595).
            startY(155).
            endX(595).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label aLabel = LabelBuilder.create().cache(true).
            layoutX(595).
            layoutY(166).
            text("225 Sec A").
            wrapText(true).
            prefWidth(35).
            textFill(Color.WHITE).
            build();
    Line bLine = LineBuilder.create().cache(true).
            startX(525).
            startY(155).
            endX(525).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label bLabel = LabelBuilder.create().cache(true).
            layoutX(525).
            layoutY(166).
            text("255 Sec B").
            wrapText(true).
            prefWidth(35).
            textFill(Color.WHITE).
            build();
    Line cLine = LineBuilder.create().cache(true).
            startX(465).
            startY(155).
            endX(465).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label cLabel = LabelBuilder.create().cache(true).
            layoutX(465).
            layoutY(166).
            text("285 Sec C").
            wrapText(true).
            prefWidth(35).
            textFill(Color.WHITE).
            build();
    Line dLine = LineBuilder.create().cache(true).
            startX(400).
            startY(155).
            endX(400).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label dLabel = LabelBuilder.create().cache(true).
            layoutX(400).
            layoutY(166).
            text("315 Sec D").
            wrapText(true).
            prefWidth(35).
            textFill(Color.WHITE).
            build();
    Line eLine = LineBuilder.create().cache(true).
            startX(335).
            startY(155).
            endX(335).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label eLabel = LabelBuilder.create().cache(true).
            layoutX(335).
            layoutY(166).
            text("345 Sec E").
            wrapText(true).
            prefWidth(35).
            textFill(Color.WHITE).
            build();
    Line fLine = LineBuilder.create().cache(true).
            startX(265).
            startY(155).
            endX(265).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label fLabel = LabelBuilder.create().cache(true).
            layoutX(265).
            layoutY(166).
            text("375 Sec F").
            wrapText(true).
            prefWidth(35).
            textFill(Color.WHITE).
            build();
    Line gLine = LineBuilder.create().cache(true).
            startX(195).
            startY(155).
            endX(195).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label gLabel = LabelBuilder.create().cache(true).
            layoutX(195).
            layoutY(166).
            text("405 Sec G").
            wrapText(true).
            prefWidth(35).
            textFill(Color.WHITE).
            build();
    Line hLine = LineBuilder.create().cache(true).
            startX(125).
            startY(155).
            endX(125).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label hLabel = LabelBuilder.create().cache(true).
            layoutX(125).
            layoutY(166).
            text("435 Sec H").
            wrapText(true).
            prefWidth(35).
            textFill(Color.WHITE).
            build();
    Line iLine = LineBuilder.create().cache(true).
            startX(55).
            startY(155).
            endX(55).
            endY(165).
            strokeWidth(1).
            stroke(Color.WHITE).
            build();
    Label iLabel = LabelBuilder.create().cache(true).
            layoutX(55).
            layoutY(166).
            text("365 Sec I").
            wrapText(true).
            prefWidth(35).
            textFill(Color.WHITE).
            build();
    Group scaleGroup = GroupBuilder.create().children(scaleBaseLine, noseLine,
            noseLabel, tailLine, tailLabel, aLine, aLabel, bLine, bLabel, cLine,
            cLabel, dLine, dLabel, eLine, eLabel, fLine, fLabel, gLine, gLabel,
            hLine, hLabel, iLine, iLabel).
            build();

    public DeckNode() {
        Group group = GroupBuilder.create().children(deckImageBorder, deckImageBg,
                deckImage, scaleGroup, deckImageHeader, header).
                build();
        getChildren().
                addAll(group);
    }
}
