backend "inmem" {
}

listener "tcp" {
 address = "127.0.0.1:8200"
 disable_mlock = 1 
 tls_disable = 1
}
