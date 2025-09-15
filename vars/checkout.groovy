def call(String branch = "master") {
    git branch: branch,
        credentialsId: "wsltobitbucket",
        url: "ssh://git@bitbucket.temenos.com:7999/tc/tbac-registry.git"
}
