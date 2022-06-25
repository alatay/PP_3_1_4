async function getResponse() {
    let res = await fetch('http://localhost:8080/api/user')
    let content = await res.json()


    let list = document.querySelector('.user-principal-table')
    let roles = "";
    for (let role in content.roleSet) {
        roles += `${content.roleSet[role].shortRole} `
    }

    list.innerHTML += `
 <td>${content.id}</td>
 <td>${content.name}</td>
 <td>${content.lastname}</td>
 <td>${content.age}</td>
 <td>${content.username}</td>
 <td>${roles}</td>
`

    $('#principalView').empty()
    $('#principalView').append(content.stringView)
}

getResponse()