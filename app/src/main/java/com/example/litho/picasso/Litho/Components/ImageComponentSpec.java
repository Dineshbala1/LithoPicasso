package com.example.litho.picasso.Litho.Components;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;

@LayoutSpec
public class ImageComponentSpec {

    @OnCreateLayout
    static Component OnCreateLayout(ComponentContext c, @Prop String imageUrl) {
        return PicassoImage.create(c)
                .imageUrl(imageUrl)
                .heightDip(250)
                .widthDip(250)
                .build();
    }
}
