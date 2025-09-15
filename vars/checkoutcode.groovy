def call(String branch = "master" , String url = "ssh://git@bitbucket.temenos.com:7999/tc/tbac-registry.git") {
    git branch: branch,
        credentialsId: "wsltobitbucket",
        url: url
}
