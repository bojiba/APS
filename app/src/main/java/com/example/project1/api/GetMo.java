package com.example.project1.api;

import java.io.Serializable;

public class GetMo implements Serializable {
    public int id;
    public String online_date;
    public String item_name;
    public String mo_id;
    public String so_id;
    public String customer;
    public int qty;
    public String complete_date;
    public String item_id;
    public Related_tech_route related_tech_route;
    public Related_parent_part related_parent_part;
    public class Related_tech_route implements Serializable{
        public String tech_routing_name;
    }
    public class Related_parent_part implements Serializable{
        public String unit_id;
    }
}
