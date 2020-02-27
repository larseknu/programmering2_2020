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
            sorting: name
        }),
        created() {
            const parkNavnParam = this.$javalin.pathParams["dyrepark-id"];
            var sort = this.$javalin.queryParams["sort_by"];
            if (typeof sort != 'undefined')
                this.sorting = sort;

            fetch (`/api/dyrepark/${parkNavnParam}?sort_by=${this.sorting}`)
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