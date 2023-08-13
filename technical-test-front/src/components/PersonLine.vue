<template>
  <h4>Person List</h4>
  <ul class="list-group">
    <li
        class="list-group-item"

        v-for="(person, index) in persons"
        :key="index"
    >
      {{ person.personNumber }} --
      {{ person.name }} --
      {{ person.email}}
    </li>
  </ul>
</template>

<script lang="ts">
import { defineComponent } from 'vue'

import PersonService from "@/services/PersonService";
import Person from '@/types/Person';
import ResponseData from '@/types/ResponseData';


export default defineComponent({
  name: "person-line",
  data() {
    return {
      persons: [] as Person[],
    };
  },
  methods: {
    retrievePersons() {
      PersonService.getAll()
          .then((response: ResponseData) => {
            this.persons = response.data;
          })
          .catch((e: Error) => {
            console.log(e);
          });
    }

  },
  mounted() {
    this.retrievePersons();
  }
})

</script>
