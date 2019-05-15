package com.example.litho.picasso.Litho.Components;


import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;
import com.example.litho.picasso.Model.DataModel;

import java.util.List;

@GroupSectionSpec
public class ListSectionSpec {

    @OnCreateChildren
    static Children onCreateChildren(final SectionContext c, @Prop List<DataModel> dataModels) {
        Children.Builder builder = Children.create();

        if (dataModels != null && dataModels.size() > 0) {

            for (int i = 0; i < dataModels.size(); i++) {
                builder.child(
                        SingleComponentSection.create(c)
                                .key(String.valueOf(i))
                                .component(ListItem.create(c).dataModel(dataModels.get(i)).imageUrl("").build()));
            }
        }

        return builder.build();
    }
}