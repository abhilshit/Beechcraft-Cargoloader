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

import cargoplanner.envelope.Envelope;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.effect.GlowBuilder;
import javafx.scene.effect.ShadowBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

/**
 * panel containing a weight vs center-of-gravity graph.
 * @author Abhilshit Soni
 */
public class GraphPanel extends Pane {
    
    public Node anotherChart = null;
    public boolean isBig = false;
    public Envelope envelope = new Envelope();
    
    public GraphPanel(String id) {
        this.setId(id);
        envelope.setId("envelope");
        envelope.setCacheHint(CacheHint.SCALE_AND_ROTATE);
        envelope.setTranslateX(Properties.startX+310);
        envelope.setTranslateY(Properties.leftStartY+Properties.height+95);
        this.setCache(true);
        
        Rectangle envelopeBG = RectangleBuilder.create().cache(true).
                x(envelope.getTranslateX() + 12).
                y(envelope.getTranslateY() - 6).
                fill(Color.rgb(50, 50, 50)).
                id("envelopeBG").
                width(405).
                height(392).
                arcWidth(5).
                arcHeight(5).
                build();
        isBig = true;
        Group tempGroup = new Group(envelopeBG, envelope);
        this.getChildren().
                add(tempGroup);
        
    }
//    public var enlargedEnvelope = EnLargedEnvelope {
//                envelope: bind this.envelope
//            };
//    init {
//        cache = true;
//
//        onMouseClicked = function (e: MouseEvent): Void {
//                    delete envelope from scene.content;
//                    envelope.scaleX = 1.2;
//                    envelope.scaleY = 1.2;
//                    envelope.translateX = 200;
//                    envelope.translateY = 80;
//                    delete envelope from enlargedEnvelope.finalGroup.content;
//                    insert envelope into scene.content;
//                    insert enlargedEnvelope into scene.content;
//                    for (i in scene.content) {
//                        //println("id's {id}");
//                        if (i.id.equals("envelope")) {
//                            i.toFront();
//                            break;
//                        }
//
//                    }
//
//                }
//    }
}
