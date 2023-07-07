## Dependencies

This solution requires docker, which may, for instance, be installed on some distributions with:

```
$ sudo apt install docker.io
```

If you do not want to run this solution using an administrator (i.e., root) account, you may need to add your user account to the docker group ([see the corresponding docker documentation page](https://docs.docker.com/engine/install/linux-postinstall/)).

Before running this solution, you must login to the GitHub docker registry, for instance using a [GitHub classic token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-personal-access-token-classic):

```
$ docker login ghcr.io
```

## Troubleshooting

### Cheptre keeps on using 100% CPU

Transforming big models (e.g., scale200 & scale2000) may not work. If you terminate the execution with Ctrl+C, the docker container may continue running in the background. You may then terminate it with:

```
$ docker kill <container-id>
```

where `<container-id>` can be obtained by looking at the output of:

```
$ docker ps
```
