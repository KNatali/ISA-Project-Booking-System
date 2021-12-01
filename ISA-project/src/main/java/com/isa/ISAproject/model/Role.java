package com.isa.ISAproject.model;


public enum Role{
	
	SysAdmin(Values.SysAdmin),Admin(Values.Admin), Instructor(Values.Instructor), CottageOwner(Values.CottageOwner), BoatOwner(Values.BoatOwner),Client(Values.Client);

    Role(String value) {
        if (!this.name().equals(value))
            throw new IllegalArgumentException("Incorrect use of Role!");
    }

    public static class Values {
        public static final String Instructor = "Instructor";
        public static final String CottageOwner = "CottageOwner";
        public static final String BoatOwner = "BoatOwner";
        public static final String SysAdmin = "SysAdmin";
        public static final String Admin = "Admin";
        public static final String Client = "Client";
    }

}
