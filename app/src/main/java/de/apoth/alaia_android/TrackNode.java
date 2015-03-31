package de.apoth.alaia_android;

import java.util.ArrayList;

/**
 * Created by apoth on 3/31/15.
 */
public class TrackNode {

    private TrackNode parent;
    private ArrayList<TrackNode> children;
    private String url;

    public TrackNode(TrackNode parent, String url)
    {
        this.parent = parent;
        this.url = url;
        this.children = new ArrayList<>();
    }


    /**
     * @return how many Nodes might have to be drawn in a column
     */
    public int getTreeWidth()
    {
        int retu = 0;
        for(TrackNode n : this.children)
        {
            retu += n.getTreeWidth();
        }
        if(retu == 0)
            return 1;
        else
            return retu;
    }

}
