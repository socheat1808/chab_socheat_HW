
package com.example.loginscreen;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.loginscreen.R;
import com.example.loginscreen.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        // Sign Up -> go to Register Fragment
        binding.tvSignUp.setOnClickListener(v ->
                Navigation.findNavController(v)
                        .navigate(R.id.action_first_to_second)
        );

        // Login button
        binding.BLogin.setOnClickListener(v -> {

            hideKeyboard();

            String message = "";

            message += "Username: "
                    + binding.TInputUsername.getText().toString();

            message += "\nPassword: "
                    + binding.TInputPassword.getText().toString();

            Snackbar.make(
                    binding.getRoot(),
                    message,
                    Snackbar.LENGTH_INDEFINITE
            ).setAction("OK", view -> {

            }).show();
        });

        // Listen for text changes
        addTextInputListener();

        // Check button when Fragment starts
        validateButtonLogin();

        return binding.getRoot();
    }


    // Enable / Disable Login button
    private void validateButtonLogin() {

        if (binding.TInputUsername.getText().toString().isEmpty()
                || binding.TInputPassword.getText().toString().isEmpty()) {

            binding.BLogin.setEnabled(false);

        } else {

            binding.BLogin.setEnabled(true);
        }
    }


    // Watch username and password
    private void addTextInputListener() {

        TextWatcher handleTextChange = new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                // Nothing here
            }

            @Override
            public void beforeTextChanged(
                    CharSequence s,
                    int start,
                    int count,
                    int after) {
                // Nothing here
            }

            @Override
            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count) {

                validateButtonLogin();
            }
        };

        binding.TInputUsername.addTextChangedListener(handleTextChange);
        binding.TInputPassword.addTextChangedListener(handleTextChange);
    }


    // Hide keyboard
    private void hideKeyboard() {

        View view = requireActivity().getCurrentFocus();

        if (view == null) {
            view = new View(requireContext());
        }

        InputMethodManager imm =
                (InputMethodManager) requireContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);

        if (imm != null) {
            imm.hideSoftInputFromWindow(
                    view.getWindowToken(),
                    0
            );
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
}

