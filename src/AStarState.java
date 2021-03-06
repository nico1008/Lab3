import java.util.HashMap;
public class AStarState {
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;

    public HashMap<Location, Waypoint> openNode = new HashMap<Location, Waypoint>();
    public HashMap<Location, Waypoint> closeNode = new HashMap<Location, Waypoint>();
    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        if(openNode.size() == 0) {
            return null;
        }
        Waypoint perv = (Waypoint) openNode.values().toArray()[0];
        double min = perv.getTotalCost();

        for(Waypoint wp : openNode.values())
        {
            if (min >= wp.getTotalCost())
            {
                min = wp.getTotalCost();
                perv = wp;
            }
        }
        return perv;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // TODO:  Implement.
        if (openNode.get(newWP.getLocation()) == null) {
            openNode.put(newWP.getLocation(), newWP);
            return true;
        }
        else {
            if (openNode.get(newWP.getLocation()).getPreviousCost()>newWP.getPreviousCost()) {
                openNode.put(newWP.getLocation(),newWP);
                return true;
            }
        }
        return false;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        // TODO:  Implement.

        return openNode.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
        closeNode.put(loc,openNode.remove(loc));
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        // TODO:  Implement.
        if (closeNode.containsKey(loc)) {

            return true;

        }
        else {
            return false;
        }
    }
}
