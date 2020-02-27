<template id="dyrepark">
    <ul>
        <li v-for="dyr in dyreListe">
            <a :href="`/dyrepark/${parkNavn}/dyr/${dyr.navn}`">
                <h1>{{dyr.id + " - " + dyr.navn}}</h1>
            </a>
        </li>
    </ul>

</template>
<script>
    Vue.component("dyrepark-detail", {
        template: "#dyrepark",
        data: () => ({
            dyreListe: [],
            parkNavn: null,
        }),
        created() {
            const parkNavnParam = this.$javalin.pathParams["dyrepark-id"];

            fetch (`/api/dyrepark/${parkNavnParam}`)
                .then(res => res.json())
                .then(res => {
                    this.dyreListe = res
                    this.parkNavn = parkNavnParam
                })
                .catch(() => alert("Feil ved uthenting av dyr i parken " + parkNavnParam));
        }
    });
</script>
<style>
    .hello-world {
        color: aquamarine;
    }
</style>