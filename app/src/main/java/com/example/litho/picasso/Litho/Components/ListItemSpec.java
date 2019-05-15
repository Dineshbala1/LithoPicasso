package com.example.litho.picasso.Litho.Components;

import android.graphics.Color;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaJustify;
import com.example.litho.picasso.Model.DataModel;

import static com.facebook.yoga.YogaEdge.ALL;

@LayoutSpec
public class ListItemSpec {

    private final static String ImageUrl1 = "https://picsum.photos/id/1020/250/250";
    private final static String ImageUrl2 = "https://picsum.photos/id/1027/250/250";
    private final static String ImageUrl3 = "https://picsum.photos/id/1028/250/250";
    private final static String ImageUrl4 = "https://picsum.photos/id/1029/250/250";

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c, @Prop DataModel dataModel, @Prop String imageUrl) {

        if(dataModel.getId() %2 == 0)
        {
            imageUrl = ImageUrl1;
        }
        else if(dataModel.getId() %3 ==0)
        {
            imageUrl = ImageUrl2;
        }
        else if(dataModel.getId() %4 ==0)
        {
           imageUrl = ImageUrl3;
        }
        else{
            imageUrl = ImageUrl4;
        }
        return Card.create(c)
                .elevationDip(4)
                .marginDip(ALL,10)
                .cornerRadiusDip(5)
                .content(
                //Adding a flex row and column
                        Row.create(c)
                .paddingDip(ALL, 16)
                .backgroundColor(Color.WHITE)
                .alignContent(YogaAlign.CENTER)
                .child(
                        // Here is our Image component and this encapsulates the Picasso image loading
                        ImageComponent.create(c).imageUrl(imageUrl).build())
                .child(Column.create(c)
                        .paddingDip(ALL, 16)
                        .alignItems(YogaAlign.FLEX_END)
                        .justifyContent(YogaJustify.CENTER)
                        .child(
                        Text.create(c)
                                .text(dataModel.getTitle())
                                .textSizeSp(28)
                                .isSingleLine(true)
                                .alignSelf(YogaAlign.FLEX_START))
                        .child(
                                Text.create(c)
                                        .textSizeSp(22)
                                        .text(dataModel.getBody())
                                        .isSingleLine(true).alignSelf(YogaAlign.FLEX_START)).build()))
                .build();
    }
}

