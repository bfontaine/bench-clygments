#! /bin/bash
mkdir -p code && pushd code
for gh in git/git jython/jython3 jneen/rouge; do
  [[ ! -d "${gh#*/}" ]] && \
    git clone --depth=1 "git@github.com:$gh.git"
done
