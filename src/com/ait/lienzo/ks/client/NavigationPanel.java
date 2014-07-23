/*
   Copyright (c) 2014 Ahome' Innovation Technologies. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.ait.lienzo.ks.client;

import com.ait.lienzo.ks.client.ui.components.KSPanel;
import com.ait.toolkit.data.client.BaseTreeModel;
import com.ait.toolkit.sencha.ext.client.events.view.ItemClickEvent;
import com.ait.toolkit.sencha.ext.client.events.view.ItemClickHandler;
import com.ait.toolkit.sencha.ext.client.layout.BorderRegion;
import com.ait.toolkit.sencha.ext.client.layout.Layout;
import com.ait.toolkit.sencha.ext.client.ui.TreePanel;
import com.google.gwt.user.client.History;

public class NavigationPanel extends KSPanel
{
    public NavigationPanel()
    {
        setTitle("Examples");

        setLayout(Layout.FIT);

        setRegion(BorderRegion.WEST);

        setWidth(250);

        setMinWidth(100);

        setHeight(200);

        setCollapsible(true);

        setSplit(true);

        TreePanel tree = new TreePanel();

        tree.setLines(false);

        tree.setUseArrows(true);

        tree.setRootVisible(false);

        BaseTreeModel m = new BaseTreeModel();

        m.setChildren(Example.getExamples());

        tree.setRootNode(m);

        tree.addItemClickHandler(new ItemClickHandler()
        {
            @Override
            public void onItemClick(ItemClickEvent event)
            {
                String link = Example.getLinkByText(event.getRecord().get(Example.TEXT_FIELD));

                if ((link != null) && (false == (link = link.trim()).isEmpty()))
                {
                    History.newItem(link);
                }
            }
        });
        add(tree);
    }
}